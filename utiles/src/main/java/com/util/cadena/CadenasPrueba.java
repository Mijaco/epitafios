

package com.util.cadena;

import java.util.Locale;

/**
 *
 * @author Mijail Aymara
 */


public class CadenasPrueba {

    public static void main(String[] args) {

//        String prueba = validarTelefonoAbonado("1234567890123");

//        System.out.println("prueba > " + generarNombreColumna("dfdfD"));
        
        System.out.println(":  >>> " + asignarFormatoServicio(""));
        
        System.out.println(":  >>> " + asignarFormatoAtributo("indicador-sms-saliente"));
    }
    
    
    public static String asignarFormatoServicio(String servicioAtr){
	        String valorFormateado = null;
	        String valorFormatear ;
	        int indiceNumeral;
	        try {
	            if(servicioAtr!=null){
	                valorFormatear = new String(servicioAtr);
	                indiceNumeral = valorFormatear.indexOf("#");
                        
                        System.out.println("indiceNumeral : " + indiceNumeral);
	                if(indiceNumeral<valorFormatear.length() && indiceNumeral>=0){
                            
//	                valorFormateado = valorFormatear.substring(indiceNumeral+1, valorFormatear.length());
	                valorFormateado = valorFormatear.substring(0, indiceNumeral);
	                }else{
                           return servicioAtr;
                        }
	            }
	            return valorFormateado;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return valorFormateado;
	        }finally{
	            valorFormateado = null;
	            valorFormatear = null;
	        }
	 }
    
      public static String asignarFormatoAtributo(String atributo){
	        String valorFormateado = null;
	        String valorFormatear ;
	        int indiceNumeral;
	        try {
	            if(atributo!=null){
	                valorFormatear = new String(atributo);
	                indiceNumeral = valorFormatear.indexOf("#");
	                if(indiceNumeral<valorFormatear.length() && indiceNumeral>=0){
                         valorFormateado = valorFormatear.substring(indiceNumeral+1, valorFormatear.length());
	                }else{
                            return "";
                        }
	            }
	            return valorFormateado;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return valorFormateado;
	        }finally{
	            valorFormateado = null;
	            valorFormatear = null;
	        }
	 }

    private static String generarNombreColumna(String variable) {
        String nombreColumna;
        String prefijo;
        String sufijo;
        try {

            if (variable != null) {
                for (int i = 0; i < variable.length(); i++) {
                    char caracter = variable.charAt(i);

                    if (Character.isUpperCase(caracter)) {
                        
                        prefijo = variable.substring(0, i).toUpperCase();
                        prefijo = prefijo.concat("_");
                        sufijo = variable.substring(i, variable.length());

                        nombreColumna = prefijo + sufijo.toUpperCase();
                        return nombreColumna;
                    }

                }
                return variable.toUpperCase();

            }

            return variable;
            
        } finally {
            nombreColumna = null;
            prefijo = null;
            sufijo = null;
        }

    }

    public static String limpiarCorchetes(String cadena, char tipoCaracter) {
        if (cadena.length() > 1 && cadena.charAt(cadena.length() - 1) == tipoCaracter) {
            cadena = cadena.substring(1, cadena.length() - 1);
        }
        return cadena;
    }

    public static String validarTelefonoAbonado(String valNumeroCompleto) {

        String mensajeValidacionTelefono = "OK";

        String regex = "\\d{9,12}";
        if (valNumeroCompleto == null) {
            mensajeValidacionTelefono = "El teléfono de la función son nulos o vacios";
        }

        try {

            if (!valNumeroCompleto.matches(regex)) {
                mensajeValidacionTelefono = "El valor del telefono no cumplen con el formato";
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            mensajeValidacionTelefono = "El Telefono no posee formato de valor numérico entero";

        } catch (NullPointerException e) {
            e.printStackTrace();
            mensajeValidacionTelefono = "El Telefono no posee formato de valor numérico entero";

        } catch (Exception e) {
            e.printStackTrace();
            mensajeValidacionTelefono = "El Telefono no posee formato de valor numérico entero";

        }

        return mensajeValidacionTelefono;

    }
}
