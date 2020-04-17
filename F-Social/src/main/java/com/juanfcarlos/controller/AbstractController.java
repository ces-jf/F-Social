/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.controller;

import com.juanfcarlos.util.JSFUtil;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */
public class AbstractController {
    
    public AbstractController() {
   
    }
    
    protected void displayInfoMessage(String title, String message) {
        JSFUtil jsfUtil = new JSFUtil();
        jsfUtil.sendInfoMessage(title, message);
    }
    
    protected void displayErrorMessage(String title, String message) {
        JSFUtil jsfUtil = new JSFUtil();
        jsfUtil.sendErrorMessage(title, message);
    }
    
    protected void displayWarnMessage(String title, String message) {
        JSFUtil jsfUtil = new JSFUtil();
        jsfUtil.sendWarnMessage(title, message);
    }
    
    protected void displayFatalMessage(String title, String message) {
        JSFUtil jsfUtil = new JSFUtil();
        jsfUtil.sendFatalMessage(title, message);
    }
    
}
