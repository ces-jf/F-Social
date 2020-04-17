/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.dao;

import com.juanfcarlos.model.Usuario;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */
public class UsuarioDao extends GenericDao<Usuario> {

    public UsuarioDao() {
        super(Usuario.class);
    }

    public Usuario findByLogin(String login) {
        Usuario usuario;
        try {
            usuario = createNamedQuery("Usuario.findByLogin").setParameter("login", login).getSingleResult();
            return usuario;
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario findByEmail(String email) {
        Usuario usuario;
        try {
            usuario = createNamedQuery("Usuario.findByEmail").setParameter("email", email).getSingleResult();
            return usuario;
        } catch (Exception e) {
            return null;
        }
    }
}
