/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.cadena;

/**
 *
 * @author Mijail 
 */
public class CadenaHelper {
    public static String cad = "padre";
    public   CadenaHelper(){
         System.out.println(cad);
    }
        public static boolean esNullSinEspacios(String cadenaValida){
		boolean esVacioNull = true;
		if(cadenaValida!=null ){
			if(cadenaValida.trim().isEmpty()){
				return esVacioNull;
			}else{
				return false;
			}
		}else{
			return esVacioNull;
		}
                
	}
        
         public static String limpiarCorchetes(String cadena, char tipoCaracter) {
	    if (cadena.length() > 1 && cadena.charAt(cadena.length()-1)==tipoCaracter) {
	    	cadena = cadena.substring(1, cadena.length()-1);
	    }
	    return cadena;
          }
        
        public static void main(String[] args) {
//            String cadena = "[]";
//            try {
//                cadena = limpiarCorchetes(cadena, ']');
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("->>> cadena " + cadena);
            
            
            String comparar = "validarTama\u00f1o";
            String comparar2 = "validarTamaño";
            String enie = "\u00f1";
            String regx = "^\\d{0,9}$";
            
//            System.out.println("> " + comparar);
//            System.out.println("> " + comparar2);
//            System.out.println("> " + enie);
            System.out.println("> " + "01".matches(regx));
            
            System.out.println("tel\u00e9fono");
            
//            System.out.println(comparar.equals("validarTamaño"));
    }
        
        
        
       /*
        \u00e1 -> á
\u00e9 -> é
\u00ed -> í
\u00f3 -> ó
\u00fa -> ú
\u00c1 -> Á
\u00c9 -> É
\u00cd -> Í
\u00d3 -> Ó
\u00da -> Ú
\u00f1 -> ñ
\u00d1 -> Ñ
        
        */
}
