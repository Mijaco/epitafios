/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.service.impl;

import com.origen.spring.jpa.service.*;
import com.bytesw.coreweb.exceptions.NoRollbackException;
import com.origen.spring.jpa.dao.UsuarioDAO;
import com.origen.spring.jpa.model.UsuarioJPA;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mijail Aymara
 */

@Service(value = "seguridadService")
@Transactional(rollbackFor = SQLException.class, noRollbackFor = NoRollbackException.class)
public class SeguridadServiceImpl implements SeguridadService{
    @Autowired
    private UsuarioDAO usuarioDAOFacade;
    
    @Override
    public UsuarioJPA obtenerUsuario(String id) {
        return usuarioDAOFacade.findById(id);
    }

    
    
}
