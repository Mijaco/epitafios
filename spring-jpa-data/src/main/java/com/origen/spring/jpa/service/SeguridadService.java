/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.service;

import com.bytesw.coreweb.exceptions.NoRollbackException;
import com.origen.spring.jpa.dao.UsuarioDAO;
import com.origen.spring.jpa.model.UsuarioJPA;
import com.origen.spring.jpa.service.impl.SeguridadServiceImpl;
import java.sql.SQLException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mijail Aymara
 */


public interface SeguridadService {
    
  public UsuarioJPA obtenerUsuario(String id);
}
