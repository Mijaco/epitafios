package com.epitafio.beans.html;

/**
 *
 * @author Mijail
 */
public class HTMLMain {
    
    private String id;
    private String nombre;
    
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
     @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("cabecera[").append(cabecera);
        cadena.append("]; cuerpo[").append(cuerpo);
        cadena.append("]");

        return cadena.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
