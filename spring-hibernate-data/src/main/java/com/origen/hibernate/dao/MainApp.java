/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.hibernate.dao;

import com.origen.hibernate.service.ServicioPrueba;
import com.origen.hibernate.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class MainApp {
    

    private ServicioPrueba usuarioService; 
    

    @Transactional
    public void prueba() {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");// a nivel web, este contexto se carga en el Listener o serlvet-context de spring
        System.out.println("Instanciando al servicio..");
//        ServicioPrueba usuarioService = (ServicioPrueba) context.getBean("usuarioService");// cuando se injecta en xml
        usuarioService = (ServicioPrueba) context.getBean("seguridadService");// cuando se injecta en xml
        
        
        System.out.println("-----Obteniendo Usuario x Id-------");
        Usuario user = usuarioService.obtenerEntidadPrueba("maymara");
        System.out.println("nombre usuario : " + user.getName());
    }

    public static void main(String[] args) {

        MainApp ma = new MainApp();
        ma.prueba();
        
    }
        
        
        
    
    
}
