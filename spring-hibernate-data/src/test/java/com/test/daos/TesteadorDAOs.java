/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.daos;

import com.origen.hibernate.model.Usuario;
import com.origen.hibernate.service.ServicioPrueba;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author UserTBS1
 */
public class TesteadorDAOs {
    
    ServicioPrueba usuarioService;
    
//    @Before
    public void setUp() {
       
    }
    
//    @Test
    public void testeDAO(){
     
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");// a nivel web, este contexto se carga en el Listener o serlvet-context de spring
        System.out.println("Instanciando al servicio..");
        usuarioService = (ServicioPrueba) context.getBean("usuarioService");// cuando se injecta en xml
        
        
        System.out.println("-----Obteniendo Usuario x Id-------");
        Usuario user = usuarioService.obtenerEntidadPrueba("maymara");
        System.out.println("user: " + user.getName());
    
    }
    
    
}
