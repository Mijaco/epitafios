/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.test;

import com.origen.spring.jpa.model.UsuarioJPA;
import com.origen.spring.jpa.service.SeguridadService;
import com.origen.spring.jpa.singleton.PersonalizadorSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mijail Aymara
 */
public class TesteoJPA {

    @Autowired
    private ApplicationContext appContext;
    
    private SeguridadService seguridadService;

    public static void main(String[] args) {
        
            
        if (args != null && args.length > 0) {
            String id = args[0];
            TesteoJPA testeoJPA = new TesteoJPA();
            testeoJPA.prueba(id);
        }else{
            System.out.println("!!! INGRESE UN ID DE USUARIO COMO ARGUMENTO !!! ");
        }

    }

    @Transactional
    public void prueba(String id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-app-data.xml");// a nivel web, este contexto se carga en el Listener o serlvet-context de spring
        System.out.println("Instanciando al servicio seguridadService..");
        seguridadService = (SeguridadService) context.getBean("seguridadService");// cuando se injecta en xml
        System.out.println("Cargando datos DOM");
        
        PersonalizadorSingleton personalizadorSingleton = (PersonalizadorSingleton) context.getBean("personalizadorSingleton");
        String title = personalizadorSingleton.getHtmlm().getCabecera().getTitulo();
        System.out.println("title : " + title);
        
        

    }
}
