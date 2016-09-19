/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.configurador.estilos.loader;

import static com.configurador.estilos.constantes.ConstantesEstilos.DIRECTORIO_CONFIGURACIONES_WINDOWS;
import com.configurador.estilos.xml.XMLReader;
import com.epitafio.beans.html.HTMLMain;
import java.util.Map;

/**
 *
 * @author JuglarM
 */
public class GeneradorEstilos {
    
    public Map<String,HTMLMain> generadoreEstilosXml(){
        Map<String,HTMLMain>  listaEstilos = XMLReader.obtenerMapaConfiguracionesXML(DIRECTORIO_CONFIGURACIONES_WINDOWS);
        return listaEstilos;
    }
}
