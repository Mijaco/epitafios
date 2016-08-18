/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utiles.files;

/**
 *
 * @author UserTBS1
 */
public class ClasePrueba3 {
    public static void main(String[] args) {
        String cadena1 = " s" ;
        String cadena2 = null;
        
        if(cadena1.trim().isEmpty()){
            System.out.println("es vacio");
        }
        if(cadena1.equalsIgnoreCase(cadena2)){
            System.out.println("<>");
        }
    }
}
