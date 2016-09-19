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
        /*Implementar lo'gica con query para traer que'el nombre de la plantilla que le corresponde */
        String nombrePlantilla = "azulado"; // suponiendo que se encontro'  "azulado";
        
        /*Le enviamos el nombre de la plantilla y nombre del negocio en caso que se cree plantillas personalizadas */
        PersonalizadorSingleton personalizadorSingleton = (PersonalizadorSingleton) appContext.getBean("personalizadorSingleton");
        /*Lo'gica para traer el bean indicado*/
        
        Map<String,HTMLMain> mapaPlantillas = personalizadorSingleton.getPersonalizaciones();
        HTMLMain estilo= mapaPlantillas.get(nombrePlantilla);
        
        return estilo;
    }
    
}
