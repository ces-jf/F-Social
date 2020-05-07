/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */

@SessionScoped
@ManagedBean(name = "navigationController")
public class NavigationController extends AbstractController implements Serializable {
    
    public String bolsaConsulta() {
        return "bolsaConsulta";
    }
    
    public String index() {
        return "index";
    }
}
