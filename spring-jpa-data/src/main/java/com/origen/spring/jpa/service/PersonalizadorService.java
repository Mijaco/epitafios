/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.origen.spring.jpa.service;

import com.origen.spring.jpa.beans.HTMLMain;

/**
 *
 * @author JuglarM
 */
public interface PersonalizadorService {
     public HTMLMain  obtenerHtmlPersonalizado(String distrito,String nameBussines);
}
