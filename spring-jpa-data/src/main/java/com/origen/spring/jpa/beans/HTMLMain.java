package com.origen.spring.jpa.beans;

/**
 *
 * @author JuglarM
 */
public class HTMLMain {
    HTMLHeader cabecera;
    HTMLBody cuerpo;
    HTMLFooter pie;

    public HTMLHeader getCabecera() {
        return cabecera;
    }

    public void setCabecera(HTMLHeader cabecera) {
        this.cabecera = cabecera;
    }

    public HTMLBody getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(HTMLBody cuerpo) {
        this.cuerpo = cuerpo;
    }

    public HTMLFooter getPie() {
        return pie;
    }

    public void setPie(HTMLFooter pie) {
        this.pie = pie;
    }
    
    
    
}
