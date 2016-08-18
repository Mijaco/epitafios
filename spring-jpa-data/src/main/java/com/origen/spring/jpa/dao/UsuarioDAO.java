/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.dao;


import com.bytesw.coreweb.dao.BaseDAO;
import com.origen.spring.jpa.model.UsuarioJPA;
import java.util.List;

/**
 *
 * @author Mijail Aymara
 *
 */
public interface UsuarioDAO extends BaseDAO<UsuarioJPA, Long> {

    public UsuarioJPA findById(String id);

}
