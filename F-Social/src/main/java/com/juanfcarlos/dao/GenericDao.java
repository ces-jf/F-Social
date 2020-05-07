/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanfcarlos.dao;

import com.juanfcarlos.util.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

/**
 *
 * @author Juan Ferreira Carlos <juanfcarlos.93@gmail.com>
 * @param <T>
 */

@Transactional
public class GenericDao<T> implements Serializable {
    
    private final Class<T> entityClass;
    
    public GenericDao(Class<T> entity) {
        this.entityClass = entity;
    }
    
    public void save(T entity) {
        try {
            JPAUtil.getEntityManager().persist(entity);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public T update(T entity) {
        return JPAUtil.getEntityManager().merge(entity);
    }
    
    public void delete(Object id, Class<T> entity) {
        try {
            JPAUtil.getEntityManager().remove(JPAUtil.getEntityManager().getReference(entity, id));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public T findById(int entityId) {
        return JPAUtil.getEntityManager().find(entityClass, entityId);
    }
    
    public T findReferenceOnly(int entityId) {
        return JPAUtil.getEntityManager().getReference(entityClass, entityId);
    }
    
    public List<T> findAll() {
        CriteriaQuery<T> cq = (CriteriaQuery<T>) JPAUtil.getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return JPAUtil.getEntityManager().createQuery(cq).getResultList();
    }
    
    public TypedQuery<T> createNamedQuery(String query) {
        return JPAUtil.getEntityManager().createNamedQuery(query, entityClass);
    }
    
    public Query createNativeQuery(String query) {
        return JPAUtil.getEntityManager().createNativeQuery(query, entityClass);
    }
}
