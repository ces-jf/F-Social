/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.model;

import java.util.Date;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */
public class PagamentoBF {
    
    private Date mes_referencia;
    private Date mes_competencia;
    private String uf;
    private int codigo_municipio_siafi;
    private String nome_municipio;
    private Long nis_favorecido;
    private String nome_favorecido;
    private Double valor_parcela;

    public PagamentoBF() {
    }

    public PagamentoBF(Date mes_referencia, Date mes_competencia, String uf, int codigo_municipio_siafi, String nome_municipio, Long nis_favorecido, String nome_favorecido, Double valor_parcela) {
        this.mes_referencia = mes_referencia;
        this.mes_competencia = mes_competencia;
        this.uf = uf;
        this.codigo_municipio_siafi = codigo_municipio_siafi;
        this.nome_municipio = nome_municipio;
        this.nis_favorecido = nis_favorecido;
        this.nome_favorecido = nome_favorecido;
        this.valor_parcela = valor_parcela;
    }
    
    public Date getMes_referencia() {
        return mes_referencia;
    }

    public void setMes_referencia(Date mes_referencia) {
        this.mes_referencia = mes_referencia;
    }

    public Date getMes_competencia() {
        return mes_competencia;
    }

    public void setMes_competencia(Date mes_competencia) {
        this.mes_competencia = mes_competencia;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCodigo_municipio_siafi() {
        return codigo_municipio_siafi;
    }

    public void setCodigo_municipio_siafi(int codigo_municipio_siafi) {
        this.codigo_municipio_siafi = codigo_municipio_siafi;
    }

    public String getNome_municipio() {
        return nome_municipio;
    }

    public void setNome_municipio(String nome_municipio) {
        this.nome_municipio = nome_municipio;
    }

    public Long getNis_favorecido() {
        return nis_favorecido;
    }

    public void setNis_favorecido(Long nis_favorecido) {
        this.nis_favorecido = nis_favorecido;
    }

    public String getNome_favorecido() {
        return nome_favorecido;
    }

    public void setNome_favorecido(String nome_favorecido) {
        this.nome_favorecido = nome_favorecido;
    }

    public Double getValor_parcela() {
        return valor_parcela;
    }

    public void setValor_parcela(Double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }

    @Override
    public String toString() {
        return "PagamentoLineData{" + "mes_referencia=" + mes_referencia + ", mes_competencia=" + mes_competencia + ", uf=" + uf + ", codigo_municipio_siafi=" + codigo_municipio_siafi + ", nome_municipio=" + nome_municipio + ", nis_favorecido=" + nis_favorecido + ", nome_favorecido=" + nome_favorecido + ", valor_parcela=" + valor_parcela + '}';
    }
    
    
}
