/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.time;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author UserTBS1
 */
public class Temporizador {
    
    public static void main(String[] args) {
        pintarFechas();
    }
    
    public static void pintarFechas(){
        Date[] historicoTramas = new Date[10];
        Date[] historicoResumen = new Date[10];
            Date fechaPivot1 = Calendar.getInstance().getTime();
            for (int i = 0; i < 10; i++) {
                fechaPivot1 = new Date();
                fechaPivot1.setMinutes((1+i)*3);

                historicoTramas[i] = fechaPivot1;
                historicoResumen[i] = fechaPivot1;

                System.out.println("historico : [ " + i + "] : "+ historicoTramas[i]);
//                dataTramas[i] = Double.parseDouble(String.valueOf(i));
//                dataResumen[i] = Double.parseDouble(String.valueOf(i * 2));

            }

            for (int i = 0; i < 10; i++) {
                System.out.println(" [ " + i + " ] : " +  historicoTramas[i]);
        }
            System.out.println("historicoTramas : " + historicoTramas.toString());
    }
}
