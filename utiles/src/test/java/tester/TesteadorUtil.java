/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import com.bytesw.util.program.Logger;
import static com.util.json.CadenasJson.validarRecursosPorProcesar;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author UserTBS1
 */
public class TesteadorUtil {

    @Test
    public void testearJsonVacio() {
        try {
            boolean b = validarRecursosPorProcesar("[]");

            System.out.println(">> " + b);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean validarRecursosPorProcesar(String recursosPorProcesar) {
        boolean existenRecursosPorProcesar = true;

        JSONArray recursosPorProcesarJson;
        Object valorPrimerRecurso;
        try {
            if (recursosPorProcesar != null && !recursosPorProcesar.isEmpty()) {
                recursosPorProcesarJson = new JSONArray(recursosPorProcesar);
                System.out.println(">> length" + recursosPorProcesarJson.length());
                System.out.println(">> toString" + recursosPorProcesarJson.toString());
                
                if (recursosPorProcesarJson.length() == 0) {
                    existenRecursosPorProcesar = false;
                }else{
                    valorPrimerRecurso = recursosPorProcesarJson.get(0);
                    System.out.println("::: valor primer recurso " + valorPrimerRecurso.toString());
                    existenRecursosPorProcesar = !valorPrimerRecurso.toString().isEmpty();
                   
                }
                
                
            }else{
                Logger.printDebug("", "El cadena-valor de los recursos por processar es vacio o null");
                existenRecursosPorProcesar = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            existenRecursosPorProcesar = false;
            Logger.printDebug("", "Se ha detectado un formato erroneo para el JSON de recursos-por-procesar");
        }finally{
            recursosPorProcesarJson = null;
        }

        return existenRecursosPorProcesar;
    }
}
