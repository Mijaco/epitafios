/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author UserTBS1
 */
public class CadenasJson {

//    public static void main(String[] args) {
//        pruebaArrayJson();
//    }
    public static void pruebaArrayJson() {
        List<String> listaJson = new ArrayList<String>();
        try {
            System.out.println("listaJson : " + listaJson);

            JSONArray arrayVacio = new JSONArray();
            JSONArray array = new JSONArray("[]");

            System.out.println("arrayVacio : " + arrayVacio.toString());
            System.out.println("array : " + array.optString(0));

            JSONArray recursos = new JSONArray();

           
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void jsonLog() {
        JSONObject json = new JSONObject();
        Map<String,String> mapaLlaveEliminada=null;
        JSONObject registrosEliminados = new JSONObject();
        
        JSONObject llaveEliminada = new JSONObject();
        JSONObject camposInsertados = new JSONObject();
        JSONObject camposModificados = new JSONObject();
        try {
            llaveEliminada.put("PERF_ID", "root");
            llaveEliminada.put("USER_ID", "maymara");//INTPERFUSA_SEG
            
            camposInsertados.put("PERF_ID", "root");
            camposInsertados.put("USER_ID", "maymara");
            camposInsertados.put("PEUS_FEASI", "26/03/15 03:05:40,432000000 PM");
            
            /*se seobrentiende que son los valores nuevos*/
            camposModificados.put("PERF_ID", "root");
            camposModificados.put("USER_ID", "maymara");
            camposModificados.put("PEUS_FEASI", "26/03/15 04:05:40,432000000 PM");
            
            
            json.put("U", camposModificados);
            json.put("I", camposInsertados);
            json.put("D", llaveEliminada);
            
            System.out.println("campos modificados : " + json);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void jsonLog2() {
        JSONObject json = new JSONObject();
        Map<String,String> mapaLlaveEliminada=null;
           
        JSONObject valoresLLave = new JSONObject();
        
        JSONObject valoresNuevos = new JSONObject();
        JSONObject valoresAntiguos = new JSONObject();
        
        
        JSONObject registroInsertado = new JSONObject();
        JSONObject registroEliminado = new JSONObject();
        try {
            
            
            
//            json.put("USER_ID", "maymara");
//            json.put("USER_NOMBR", "Mijail");
//            json.put("USER_APELL", "Aymara");
//            json.put("USER_EMAIL", "maymara@gmail.com");
//            json.put("USER_EMAIL", "maymara@gmail.com");
//            json.put("USER_EMAIL", "maymara@gmail.com");
//            json.put("USER_PASSW", "0zQGdz1tYAA90SW394ZgAeufBOlavPXhVUJp8iTR");
            
            /*se seobrentiende que son los valores nuevos*/
            
            
            /*JSON DEL IDENTIFICADOR*/
            valoresLLave.put("USER_ID", "maymara");
            json.put("identificador-entidad", valoresLLave);
            /*INSERTAR*/
            
//            registroInsertado.put("USER_ID", "maymara");
//            registroInsertado.put("USER_NOMBR", "Mijail");
//            registroInsertado.put("USER_APELL", "Aymara");
//            registroInsertado.put("USER_EMAIL", "maymara@gmail.com");
//            registroInsertado.put("USER_EMAIL", "maymara@gmail.com");
//            registroInsertado.put("USER_EMAIL", "maymara@gmail.com");
//            registroInsertado.put("USER_PASSW", "0zQGdz1tYAA90SW394ZgAeufBOlavPXhVUJp8iTR");
//            json.put("valores-insertados", registroInsertado);
                   
            
//            /*ELIMINAR*/
//            registroEliminado.put("USER_ID", "maymara");
//            json.put("valores-eliminados", registroEliminado);
            
            
//            /*MODIFICAR*/
            valoresAntiguos.put("USER_NOMBR", "Mijail");
            valoresAntiguos.put("USER_APELL", "Aymara");
            valoresAntiguos.put("USER_EMAIL", "maymara@gmail.com");

            valoresNuevos.put("USER_NOMBR", "Mijail-II");
            valoresNuevos.put("USER_APELL", "Aymara-II");
            valoresNuevos.put("USER_EMAIL", "maymara-II@gmail.com");
            
            json.put("valores-anteriores", valoresAntiguos);
            json.put("valores-actuales", valoresNuevos);
       
            
            System.out.println("campos modificados : " + json);
            JSONObject jsonObjeto = json.getJSONObject("valores-anteriores");
            
            Iterator<String> iterador  = jsonObjeto.keys();
            
            while(iterador.hasNext()){
                String llave= iterador.next();
                System.out.println("llave : " + llave);
            }
           
            
            
//            jsonObjeto.o
            
            
            
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        JSONArray recursos = new JSONArray();
//
//        boolean b = validarRecursosPorProcesar(recursos);
//
//        System.out.println(">> " + b);
        
         jsonLog2();
    }

    public static boolean validarRecursosPorProcesar(JSONArray recursosPorProcesar) {
        boolean existenRecursosPorProcesar = true;
        try {
            if (recursosPorProcesar == null || recursosPorProcesar.length() == 0) {
                existenRecursosPorProcesar = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return existenRecursosPorProcesar;
    }
}
