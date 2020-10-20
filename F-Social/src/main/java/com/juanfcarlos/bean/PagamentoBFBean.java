/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.bean;

import com.juanfcarlos.lazymodel.PagamentoBFLazyList;
import com.juanfcarlos.model.PagamentoBF;
import com.juanfcarlos.util.Exportador;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */
@Named
@ViewScoped
@ManagedBean
public class PagamentoBFBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private LazyDataModel<PagamentoBF> pagamentos = null;
    private PagamentoBF pagamento;
    
    private Exporter<DataTable> exportador;
    
    @PostConstruct
    public void init() {
        exportador = new Exportador();
    }  
    
    public LazyDataModel<PagamentoBF> getTodosPagamentos() {
        if (pagamentos == null) {
            pagamentos = new PagamentoBFLazyList();
        }
 
        return pagamentos;
    }

    public PagamentoBF getPagamento() {
        if(pagamento == null){
            pagamento = new PagamentoBF();
        }
        
        return pagamento;
    }

    public void setPagamento(PagamentoBF pagamento) {
        this.pagamento = pagamento;
    }
    
    public Exporter<DataTable> getExportador() {
        return exportador;
    }
    
    public void setExportador(Exporter<DataTable> exportador) {
        this.exportador = exportador;
    }
    
}
