/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utiles.regex;

/**
 *
 * @author UserTBS1
 */
public class ExpresionesRegulares {
    
    
    public static void main(String[] args) {
        
        String cadenaPrueba = "333";
        String cadenaPrueba2 = "ñsdfsdfsdf;";
        String cadenaDate = "25/100/2015"; //dd-mm-yyyy | dd/mm/yyyy | dd.mm.yyyy
        String cadenaDateFormat = "yyyy-mm-dd hh"; //dd-mm-yyyy | dd/mm/yyyy | dd.mm.yyyy
        String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        String regexFormat = "(([dD]{2})[/-]([mM]{2})[/-]([yY]{4})([' '][hH]{2}))|(([yY]{4})[/-]([mM]{2})[/-]([dD]{2}))|(([yY]{4})[/-]([mM]{2})[/-]([dD]{2})([' '][hH]{2}))|(([dD]{2})[/-]([mM]{2})[/-]([yY]{4}))";
        String regexCaracteres = "^[a-zA-Z_áéíóúñ;\\\\s]*$";
        
        String format = "dd-mm-yyyy-hh";
        
        String cadenaChar= "ñfsdgdxghdfhjfhjfhá";
        
//        System.out.println(">> " + cadenaPrueba.matches("[0-9]+"));
//        System.out.println(">> " + cadenaPrueba.matches("/[a-z]"));
        
        
        
//        System.out.println(">> " + cadenaPrueba2.matches(regexCaracteres));
//        System.out.println(">> " + cadenaDateFormat.matches(regexFormat));
//        System.out.println("> " + );
        
//        validarCadenaConSeparadores(";S;S");
        
        System.out.println(validarParametrosContenidoCaracteristica(""));
    }
    
    
    public static void validarCadenaConSeparadores(String valoresValidador){
      
           
            if(valoresValidador.split(";").length>1){
                System.out.println("error contenido de caracteristicas");
            } 
        
    }
    
    
    
//    ^      # Start of string
//(?:        # Either match...
// .{0,2}    #  a string of up to two characters
//|          # or
// .*        #  any string
// (?!000)   #   (unless followed by three zeroes)
// .{3}      #  followed by three characters
//)          # End of alternation
//$          # End of string
    
    
      public static String validarParametrosContenidoCaracteristica(String valorCadena) {

        // parametrosLabel -> solo tiene un atributo
        // valoresValidador -> solo tiene un atributo -> Este atributo es una cadena separada de ";"  , validarla con regex (puedes terminar o no en ";"  )
        
        String regexCaracteristicas = "^[a-zA-Z_áéíóúñ;\\\\s]*$";
//        String valorCadena;
        String mensajeResultado = "OK";
        
        try {
       
//            valorCadena = valoresValidador[0];
            
            valorCadena = valorCadena.trim();
            
            
            if(valorCadena!=null && !valorCadena.isEmpty()){
            boolean validado = valorCadena.matches(regexCaracteristicas);
                if(!validado){
                    return "La cadena no posse formato";
                }
                
                if(valorCadena.startsWith(";") || valorCadena.contains(";;")){
                    return "Ingrese un cadena con valores correctos";
                }
            }else{
                return "Ingrese un cadena con valores correctos";
            }
            
       
            
            
            return mensajeResultado;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mensajeResultado;
    }
}
