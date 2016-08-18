/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.persistencia.exception;

/**
 *
 * @author Mijail Aymara
 */
    
public class ErrorDao {

    private int codigoError;

    private String mensaje;

    public ErrorDao(int codigoError, String mensaje) {
        this.codigoError = codigoError;
        this.mensaje = mensaje;
    }

    public ErrorDao() {
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}

