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

    /*Metodo que se se ejecutara' cada n segundos*/
    public void cargarEstilos() {
        GeneradorEstilos generadorEstilos;
        
        Map<String,HTMLMain> mapaEstilos;
        PersonalizadorSingleton personalizadorSingleton;
        try {
            System.out.println("*********** Timer cargador de de Estilos en el Singleton ************");
            generadorEstilos = new GeneradorEstilos();
            
            personalizadorSingleton = (PersonalizadorSingleton) appContext.getBean("personalizadorSingleton");
            mapaEstilos = generadorEstilos.generadoreEstilosXml();
            System.out.println("mapaEstilos: " + mapaEstilos);
            personalizadorSingleton.setPersonalizaciones(mapaEstilos);
        } catch (Exception e) {
            System.out.println("Error al cargar Estilos");
            e.printStackTrace();
        }

    }

}
