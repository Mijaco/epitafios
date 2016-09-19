package com.origen.spring.jpa.singleton;

import com.configurador.estilos.loader.GeneradorEstilos;
import com.epitafio.beans.html.HTMLHeader;
import com.epitafio.beans.html.HTMLMain;
import com.origen.spring.jpa.model.Role;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/*
 * Copyright 2016 JuglarM.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author JuglarM
 */
@Component
public class PersonalizadorSingleton {
    
    private Map<String,HTMLMain> personalizaciones;
    
    
    public void init(){
        System.out.println("**************************************************");
        System.out.println("*********** INICIANDO PERSONALIZADOR ************");
        System.out.println("*************************************************");
             
        cargarEstilos();
        
//        HTMLMain htmlmain = new HTMLMain();
//        HTMLHeader cabecera = new HTMLHeader();
//        cabecera.setTitulo("OASIS");
//        cabecera.setColorFondo("green");
//        cabecera.setRutaLogo("logo/logo.jpg");
//        cabecera.setClassMenu("menu");
//        htmlmain.setCabecera(cabecera);
//        htmlm = htmlmain;
    }
    
     /*Me'todo que se se ejecutara' cada n segundos*/
    public void cargarEstilos() {
        GeneradorEstilos generadorEstilos;
        Map<String,HTMLMain> listaEstilos;
        try {
            
            System.out.println("*********************************************************************");
            System.out.println("************** TIME CARGADOR DE PLANTILLAS DE ESTILOS ***************");
            System.out.println("*********************************************************************");
            
            generadorEstilos = new GeneradorEstilos();
            listaEstilos = generadorEstilos.generadoreEstilosXml();
            personalizaciones.putAll(listaEstilos);
            
        } catch (Exception e) {
            System.out.println("Error al cargar Estilos");
            e.printStackTrace();
        }
    }

    public Map<String, HTMLMain> getPersonalizaciones() {
        return personalizaciones;
    }

    public void setPersonalizaciones(Map<String, HTMLMain> personalizaciones) {
        this.personalizaciones = personalizaciones;
    }

}
