/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.task;

import com.configurador.estilos.loader.GeneradorEstilos;
import com.epitafio.beans.html.HTMLMain;
import com.origen.spring.jpa.singleton.PersonalizadorSingleton;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mijail
 */
@Component
public class CargadorEstilos {

    @Autowired
    private ApplicationContext appContext;

    /*Me'todo que se se ejecutara' cada n segundos*/
    public void cargarEstilos() {
        GeneradorEstilos generadorEstilos;
        Map<String,HTMLMain> mapaEstilos;
        PersonalizadorSingleton personalizadorSingleton;
        try {
            
            System.out.println("*********************************************************************");
            System.out.println("************** TIME CARGADOR DE PLANTILLAS DE ESTILOS ***************");
            System.out.println("*********************************************************************");
            
            generadorEstilos = new GeneradorEstilos();
            mapaEstilos = generadorEstilos.generadoreEstilosXml();
            personalizadorSingleton = (PersonalizadorSingleton) appContext.getBean("personalizadorSingleton");
            personalizadorSingleton.setPersonalizaciones(mapaEstilos);
            
        } catch (Exception e) {
            System.out.println("Error al cargar Estilos");
            e.printStackTrace();
        }
    }

}
