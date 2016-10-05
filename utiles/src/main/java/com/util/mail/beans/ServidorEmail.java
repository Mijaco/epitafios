/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.mail.beans;

/**
 *
 * @author JuglarM
 */
public class ServidorEmail {
    
    private String correoIdentificador;
    private String password;
    private String descripcion;
    private String tipoCorreo;

    public String getCorreoIdentificador() {
        return correoIdentificador;
    }

    public void setCorreoIdentificador(String correoIdentificador) {
        this.correoIdentificador = correoIdentificador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoCorreo() {
        return tipoCorreo;
    }

    public void setTipoCorreo(String tipoCorreo) {
        this.tipoCorreo = tipoCorreo;
    }
    
    
}
