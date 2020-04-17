/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.controller;

import com.juanfcarlos.dao.UsuarioDao;
import com.juanfcarlos.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */

@RequestScoped
@ManagedBean
public class LoginController extends AbstractController {
    
    @ManagedProperty(value = UsuarioController.INJECTION_NAME)
    private UsuarioController usuarioController;
    
    private String login;
    private String senha;

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
     
    private Usuario isValidLogin(String login, String senha) {
        Usuario usuario = new UsuarioDao().findByLogin(login);
        
        if(usuario == null || !senha.equals(usuario.getSenha())) {
            return null;
        }
        return usuario;
    }
    
    public String entrar() {
        Usuario usuario = isValidLogin(login, senha);
        
        if(usuario != null) {
            usuarioController.setUsuario(usuario);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.getSession().setAttribute("usuario", usuario);
            displayInfoMessage("Seja Bem-Vindo", usuario.getNome() + "!");
            return "index";
        }
        
        displayErrorMessage("Favor Verificar!","Usuario ou Senha Inválidos!");
        return null;
    } 
}
