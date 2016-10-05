/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.mail.beans;

import javax.mail.BodyPart;

/**
 *
 * @author JuglarM
 */
public class Email {
    private String correoIdentificador;
    private String nombreUsuario;
    private String direccionFisica;
    private String asunto;
    private String mensaje;
    private BodyPart adjunto;
    private String descripcion;

    public String getCorreoIdentificador() {
        return correoIdentificador;
    }

    public void setCorreoIdentificador(String correoIdentificador) {
        this.correoIdentificador = correoIdentificador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDireccionFisica() {
        return direccionFisica;
    }

    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BodyPart getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(BodyPart adjunto) {
        this.adjunto = adjunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
