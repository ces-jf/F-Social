/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.lazymodel;

import com.juanfcarlos.dao.PagamentoBFDao;
import com.juanfcarlos.model.PagamentoBF;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */
public class PagamentoBFLazyList extends LazyDataModel<PagamentoBF> {
    
    private static final long serialVersionUID = 1L;
    private ArrayList<PagamentoBF> pagamentos;
    private PagamentoBFDao pagamentoBFDao;

    @Override
    public List<PagamentoBF> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        try {
            pagamentoBFDao = new PagamentoBFDao();
            pagamentos = pagamentoBFDao.todosPagamentos();
            
        } catch (IOException e) {
        }
 
        // set the total of players
        if(getRowCount() <= 0){
            setRowCount(pagamentoBFDao.countTodosPagamentos());
        }
 
        // set the page dize
        setPageSize(pageSize);
 
        return pagamentos;
    }
 
    
}
