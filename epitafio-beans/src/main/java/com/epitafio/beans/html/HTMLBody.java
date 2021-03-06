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

package com.epitafio.beans.html;

import java.math.BigDecimal;

/**
 *
 * @author JuglarM
 */
public class HTMLBody {
    private String classBody;
    
    private BigDecimal longitud;
    private BigDecimal latitud;

    public String getClassBody() {
        return classBody;
    }

    public void setClassBody(String classBody) {
        this.classBody = classBody;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("classBody:").append(classBody);
        cadena.append(";longitud:").append(longitud);
        cadena.append(";latitud:").append(latitud);

        return cadena.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
