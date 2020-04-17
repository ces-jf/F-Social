/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.filter;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */
public class AbstractFilter {
    
    public AbstractFilter() {
    }
    
    protected void fazerLogin(ServletRequest request, ServletResponse response, HttpServletRequest httpReq) throws ServletException, IOException {
        RequestDispatcher dispatcher = httpReq.getRequestDispatcher("login.xhtml");
        dispatcher.forward(request, response);
    }
    
    protected void acessoNegado(ServletRequest request, ServletResponse response, HttpServletRequest httpReq) throws ServletException, IOException {
        RequestDispatcher dispatcher = httpReq.getRequestDispatcher("acessoNegado");
        dispatcher.forward(request, response);
    }
    
}
