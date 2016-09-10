/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.origen.spring.jpa.service.impl;

import com.epitafio.beans.html.HTMLMain;
import com.origen.spring.jpa.service.PersonalizadorService;
import com.origen.spring.jpa.singleton.PersonalizadorSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuglarM
 */
@Service(value = "personalizadorService")
public class PersonalizadorServiceImpl implements PersonalizadorService{
    
    @Autowired
    private ApplicationContext appContext;
    
    @Override
    public HTMLMain obtenerHtmlPersonalizado(String distrito,String nameBussines){
        HTMLMain hTMLMain;
        PersonalizadorSingleton personalizadorSingleton = (PersonalizadorSingleton) appContext.getBean("personalizadorSingleton");
        String title = personalizadorSingleton.getHtmlm().getCabecera().getTitulo();
        System.out.println("title : " + title);
        
        hTMLMain = personalizadorSingleton.getHtmlm();
        
        return hTMLMain;
    }
    
}
