/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.origen.spring.jpa.service.impl;

import com.epitafio.beans.html.HTMLMain;
import com.origen.spring.jpa.service.PersonalizadorService;
import com.origen.spring.jpa.singleton.PersonalizadorSingleton;
import java.util.Map;
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
        Map<String,HTMLMain> mapaEstilos;
        HTMLMain hTMLMain;
        PersonalizadorSingleton personalizadorSingleton = (PersonalizadorSingleton) appContext.getBean("personalizadorSingleton");
        System.out.println("personalizadorSingleton : " + personalizadorSingleton);
        String title = personalizadorSingleton.getHtmlm().getCabecera().getTitulo();
        
               
        
        mapaEstilos = personalizadorSingleton.getPersonalizaciones();
        System.out.println("mapaEstilos : " + mapaEstilos);
        
        hTMLMain = mapaEstilos.get("olivos");
        if(hTMLMain!=null){
            if(hTMLMain.getCabecera().isLogoPersonalizado()){
                hTMLMain.getCabecera().setRutaLogo("logo/logo-personalizado.jpg");
            };
        }
        
        return hTMLMain;
    }
    
}
