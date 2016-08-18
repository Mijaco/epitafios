/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utiles.ramdom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author UserTBS1
 */
public class AleatoriosCatcher {

    public static void main(String[] args) {
        try {
            Map<Object, Object> mapa = new LinkedHashMap<Object, Object>();
            for (int i = 0; i < 10; i++) {
                mapa.put("Objeto-" + i, i);
            }
            System.out.println("objeto -> " + obtenerObjetoDeMapa(mapa));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Object obtenerObjetoDeMapa(Map<Object, Object> mapa) {
        Object obj = null;
        Set<Object> llaves;
        try {
            int i = 0;
            int nrAleatorio = numeroAleatorio(0, 9);
            llaves = mapa.keySet();
            System.out.println("numero -> " + nrAleatorio);
            for (Object llave : llaves) {

                if (i == nrAleatorio) {
                    return mapa.get(llave);
                }
                i++;
            }

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return obj;
        }
    }

    public static int numeroAleatorio(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
