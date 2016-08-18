/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utiles.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mijail Aymara
 */
public class UtilFiles {
    
        public static void generarArchivo(String rutaNombreArchivo, String contenidoCadena){
         
        File archivoCrear;
        BufferedWriter output = null;
        
        try {
            archivoCrear = new File(rutaNombreArchivo);
            output = new BufferedWriter(new FileWriter(archivoCrear));
            output.write(contenidoCadena);
            
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                try {
                    output.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
                archivoCrear = null;
        }
     }
}
