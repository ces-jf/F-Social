/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.dao;

import com.juanfcarlos.elasticsearch.ElasticSearchConfig;
import com.juanfcarlos.model.PagamentoBF;
import static com.juanfcarlos.util.Constante.INDEX;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */

public class PagamentoBFDao {
    
    private static RestHighLevelClient restHighLevelClient;
    
    public ArrayList<PagamentoBF> todosPagamentos() throws IOException {
           
        restHighLevelClient = ElasticSearchConfig.initConnection();
        
        SearchRequest searchRequest = new SearchRequest(INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.size(5000); 
        searchRequest.source(searchSourceBuilder);
        searchRequest.scroll(TimeValue.timeValueMinutes(1L)); 
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        String scrollId = searchResponse.getScrollId(); 
       
        ArrayList<PagamentoBF> result = new ArrayList<>();
        
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            Map mapPag = new HashMap(hit.getSourceAsMap());
            
            PagamentoBF pag = new PagamentoBF();
            
            pag.setMes_competencia((String) mapPag.get("MES COMPETENCIA"));
            pag.setMes_referencia((String) mapPag.get("MES REFERENCIA"));
            pag.setNis_favorecido((Long) mapPag.get("NIS FAVORECIDO"));
            pag.setNome_favorecido((String) mapPag.get("NOME FAVORECIDO"));
            pag.setNome_municipio((String) mapPag.get("NOME MUNICIPIO"));
            pag.setCodigo_municipio_siafi((int) mapPag.get("CODIGO MUNICIPIO SIAFI"));
            pag.setUf((String) mapPag.get("UF"));
            pag.setValor_parcela((Double) mapPag.get("VALOR PARCELA"));
            
            result.add(pag);
        }
        
        ElasticSearchConfig.closeConnection();
        
        return result;
    } 
    
    public int countTodosPagamentos() {
         if (restHighLevelClient == null) {
            ElasticSearchConfig.initConnection();
            restHighLevelClient = ElasticSearchConfig.getRestHighLevelClient();
        }
        
        return 10000;
    }
}
