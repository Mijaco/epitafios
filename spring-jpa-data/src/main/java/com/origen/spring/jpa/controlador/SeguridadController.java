/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.controlador;

import com.origen.spring.jpa.model.UsuarioJPA;
import com.origen.spring.jpa.service.SeguridadService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mijail Aymara
 */
public class SeguridadController {

    @Autowired
    private SeguridadService seguridadService;

    public SeguridadController() {
    }

    public String obtenerNombreUsuario(String idUsuario) {
        UsuarioJPA usuarioJPA = null;
        try {
            usuarioJPA = seguridadService.obtenerUsuario(idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarioJPA != null ? usuarioJPA.getName() : null;

    }
}
