/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.controller;

import com.juanfcarlos.model.Usuario;
import com.juanfcarlos.util.Atribuicao;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */

@SessionScoped
@ManagedBean(name = "usuarioController")
public class UsuarioController extends AbstractController implements Serializable {
    
    public static final String INJECTION_NAME = "#{usuarioController}";
    
    private Usuario usuario;
    
    public boolean isAdmin() {
        return Atribuicao.ADMIN.equals(usuario.getAtribuicao());
    }
    
    public boolean isUser() {
        return Atribuicao.USER.equals(usuario.getAtribuicao());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String logOut() throws IOException {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        displayInfoMessage("Sessão Finalizada", usuario.getNome() + "!");
        return "login";
    }
    
}
