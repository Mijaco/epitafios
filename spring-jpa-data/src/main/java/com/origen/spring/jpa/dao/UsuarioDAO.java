/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.dao;


//import com.bytesw.coreweb.dao.BaseDAO;//modo tbs
//import com.origen.spring.jpa.general.BaseDaoSpringJPA;

import com.origen.spring.jpa.general.BaseDAONativeJPA;
import com.origen.spring.jpa.general.BaseDaoSpringJPA;
import com.origen.spring.jpa.model.UsuarioJPA;
//import com.util.persistencia.dao.interfaz.BaseDao;

/**
 *
 * @author Mijail Aymara
 *
 */

public interface UsuarioDAO extends BaseDaoSpringJPA<UsuarioJPA, Long> { 

    public UsuarioJPA findById(String id);

}
