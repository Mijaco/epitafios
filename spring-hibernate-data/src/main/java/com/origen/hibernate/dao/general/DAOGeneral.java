/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.hibernate.dao.general;

import com.origen.hibernate.model.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mijail Aymara
 */

public class DAOGeneral<T, PK extends Serializable> implements BaseDao<T, PK> {

    protected SessionFactory sessionFactory;
    private Class<T> referenciaEntidad;

    protected void setReferenciaEntidad(Class<T> referenciaEntidad) {
        this.referenciaEntidad = referenciaEntidad;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DAOGeneral(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        
    }
    
    public DAOGeneral(){
    }

    public void agregar(T p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);

    }

    public void actualizar(T p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    }

    public List<T> listar() {
        String hbmQuery = "from " + referenciaEntidad.getSimpleName();
        System.out.println("hbmQuery : " + hbmQuery);
        Session session = this.sessionFactory.openSession();
        List<T> listaEntidades = session.createQuery(hbmQuery).list();
        return listaEntidades;
    }

    public T getById(PK pk) {
        
        Session session = this.sessionFactory.openSession();
        T p = (T) session.load(referenciaEntidad, pk);

        return p;
    }

    public void remover(PK pk) {
        Session session = this.sessionFactory.getCurrentSession();
        
        T p = (T) session.load(referenciaEntidad, pk);
        if (null != p) {
            session.delete(p);
        }
    }
    
    public List<T> listarQueryNativo(String queryNativo){
        Session session = this.sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery(queryNativo);
        query.addEntity(referenciaEntidad);
        List<T> results = (List<T>)query.list();
        
        return results;
    } 

}
