/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.configurador.estilos.loader;

import static com.configurador.estilos.constantes.ConstantesEstilos.DIRECTORIO_CONFIGURACIONES_WINDOWS;
import static com.configurador.estilos.xml.XMLReader.leerConfiguracionesXML;
import com.epitafio.beans.html.HTMLMain;
import java.util.List;

/**
 *
 * @author JuglarM
 */
public class GeneradorEstilos {
    
    public List<HTMLMain> generadoreEstilosXml(){
        List<HTMLMain> listaEstilos = leerConfiguracionesXML(DIRECTORIO_CONFIGURACIONES_WINDOWS);
        return listaEstilos;
    }
}
