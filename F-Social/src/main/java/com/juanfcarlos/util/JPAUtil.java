/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 */
public class JPAUtil {
    
    private static final EntityManagerFactory em;
    private static EntityManager entityManager;
    
    static {
        em = Persistence.createEntityManagerFactory("FSOCIAL_PU");
    }
    
    public static EntityManager getEntityManager() {
        if(entityManager == null) {
            entityManager = em.createEntityManager();
        }
        return entityManager;
    }
}
