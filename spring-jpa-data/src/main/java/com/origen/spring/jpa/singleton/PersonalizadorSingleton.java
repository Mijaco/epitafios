package com.origen.spring.jpa.singleton;

import com.epitafio.beans.html.HTMLHeader;
import com.epitafio.beans.html.HTMLMain;
import com.origen.spring.jpa.model.Role;
import java.util.List;
import java.util.Map;
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
    
    private HTMLMain htmlm;
    private Map<String,HTMLMain> personalizaciones;
    
    private List<Role> rolesPosibles;
    
    public void init(){
        System.out.println("**************************************************");
        System.out.println("*********** INICIANDO PERSONALIZADOR ************");
        System.out.println("*************************************************");
   
        HTMLMain htmlmain = new HTMLMain();
        HTMLHeader cabecera = new HTMLHeader();
        cabecera.setTitulo("OASIS");
        cabecera.setColorFondo("green");
        cabecera.setRutaLogo("logo/logo.jpg");
        cabecera.setClassMenu("menu");
        htmlmain.setCabecera(cabecera);
        htmlm = htmlmain;
        
        
    }

    public HTMLMain getHtmlm() {
        return htmlm;
    }

    public void setHtmlm(HTMLMain htmlm) {
        this.htmlm = htmlm;
    }

    public Map<String, HTMLMain> getPersonalizaciones() {
        return personalizaciones;
    }

    public void setPersonalizaciones(Map<String, HTMLMain> personalizaciones) {
        this.personalizaciones = personalizaciones;
    }

    public List<Role> getRolesPosibles() {
        return rolesPosibles;
    }

    public void setRolesPosibles(List<Role> rolesPosibles) {
        this.rolesPosibles = rolesPosibles;
    }

    
}
