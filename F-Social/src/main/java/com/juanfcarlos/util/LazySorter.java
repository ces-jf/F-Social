/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.util;

import com.juanfcarlos.model.PagamentoBF;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */
public class LazySorter implements Comparator<PagamentoBF> {

    private String sortField;
    
    private SortOrder sortOrder;
    
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(PagamentoBF pag1, PagamentoBF pag2) {
        try {
            Object value1 = PagamentoBF.class.getField(this.sortField).get(pag1);
            Object value2 = PagamentoBF.class.getField(this.sortField).get(pag2);

            int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
    
}
