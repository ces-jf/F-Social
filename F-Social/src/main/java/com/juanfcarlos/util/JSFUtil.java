/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */
public class JSFUtil {
    
    public void sendInfoMessage(String title, String message) {
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, title, message);
        addMessageToJsfContext(facesMessage);
    }
    
    public void sendErrorMessage(String title, String message) {
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, title, message);
        addMessageToJsfContext(facesMessage);
    }
    
    public void sendWarnMessage(String title, String message) {
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_WARN, title, message);
        addMessageToJsfContext(facesMessage);
    }
    
    public void sendFatalMessage(String title, String message) {
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_FATAL, title, message);
        addMessageToJsfContext(facesMessage);
    }
    
    private FacesMessage createMessage(FacesMessage.Severity severity, String title, String message) {
        return new FacesMessage(severity, title, message);
    }
    
    private void addMessageToJsfContext(FacesMessage facesMessage) {
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
}
