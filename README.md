# F-Social
Uma Plataforma para identificação de fraudes em Programas Sociais

### Depêndencias necessárias
* ElasticSearch - V7.6.2 - https://www.elastic.co/pt/downloads/elasticsearch
* Kibana - V 7.6.2 - https://www.elastic.co/pt/products/kibana (Opcional)
* Logstash - V 7.6.2 - https://www.elastic.co/pt/downloads/logstash
* XAMMP - V 7.3.9 - https://www.apachefriends.org/pt_br/index.html
* NetBeans IDE - V 11.3 - https://netbeans.apache.org/download/index.html

### Configurando Ambiente
  Após realizadas às respectivas instalações das dependências acima citadas, abra um terminal e inicie os serviços: 
* ElasticSearch - Para armazenar os dados localmente 
  - Windows - `$ bin/elasticsearch`
  - Linux - `$ systemctl start elasticsearch.service`
  - [Iniciar ElasticSearch](http://localhost:9200)
  
* Kibana - Se desejar fazer a manipulação dos dados inseridos (Opcional)
  - Windows - `$ bin/kibana`
  - Linux - `$ systemctl start kibana.service`
  - [Iniciar Kibana](http://localhost:5601)

* Logstash - Utilizado para inserir os dados na base de dados locais
  - Faça o [Download dos Dados](http://www.portaltransparencia.gov.br/download-de-dados/bolsa-familia-pagamentos/202001) e descompacte o arquivo.
  - No mesmo local do arquivo CSV crie um arquivo chamado bolsalogstash.conf e insira o seguinte:
  ``` Config
  input {
    file {
      path => "202001_BolsaFamilia_Pagamentos.csv"
      start_position => "beginning"
      sincedb_path => "logstash.txt"
    }
  }

  filter {
    csv {
      separator => ";"
      columns => ["MES REFERENCIA",
                  "MES COMPETENCIA",
                  "UF",
                  "CODIGO MUNICIPIO SIAFI",
                  "NOME MUNICIPIO",
                  "NIS FAVORECIDO",
                  "NOME FAVORECIDO",
                  "VALOR PARCELA" ]
    }
    date {
      match => [ "MES REFERENCIA", "yyyymm" ]
    }
    date {
      match => [ "MES COMPETENCIA", "yyyymm" ]
    }
    mutate {
      convert => {
        "CODIGO MUNICIPIO SIAFI" => "integer"
      }
    }
    mutate {
      convert => {
        "NIS FAVORECIDO" => "integer"
      }
    }
    mutate {
      convert => {
        "VALOR PARCELA" => "float_eu"
      }
    }
  }

  output {
    elasticsearch {
      hosts => ["http://localhost:9200"]
      index => "bolsafamilia"
      document_type => "pagamentos_202001"
    }
    stdout {

    }
  }
  ```
  * Abra um Terminal na pasta do arquivo CSV e .Conf e:
    - Windows - `$ bin/logstash -f bolsalogstash.conf`
    - Linux - `$ systemctl start logstash.service && /usr/share/logstash/bin/logstash -f bolsalogstash.conf`
    
 * XAMMP - Rode a aplicação e importe o arquivo fsocial.sql
 
 * NetBeans IDE - Abra a aplicação e importe o projeto
   - Crie uma nova conexão do Tipo MySql para o Banco de Dados fsocial
   - No arquivo persistence substitua o JDBC Connection para a criada anteriormente
   
Após todas as etapas descritas rode o projeto. Se ocorrerem falhas no Maven dentro da pasta do projeto abra um terminal e rode: `$ mvn clean package`












