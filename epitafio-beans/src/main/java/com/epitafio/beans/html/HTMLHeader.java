package com.epitafio.beans.html;
/**
 *
 * @author Mijail Aymara
 */
public class HTMLHeader {
    
    private String titulo;
    private String rutaLogo;
    private String medidaLogo;
    private String colorFondo;
    private String classMenu;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRutaLogo() {
        return rutaLogo;
    }

    public void setRutaLogo(String rutaLogo) {
        this.rutaLogo = rutaLogo;
    }

    public String getMedidaLogo() {
        return medidaLogo;
    }

    public void setMedidaLogo(String medidaLogo) {
        this.medidaLogo = medidaLogo;
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }

    public String getClassMenu() {
        return classMenu;
    }

    public void setClassMenu(String classMenu) {
        this.classMenu = classMenu;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("titulo:").append(titulo);
        cadena.append(";rutaLogo:").append(rutaLogo);
        cadena.append(";medidaLogo:").append(medidaLogo);
        cadena.append(";colorFondo:").append(colorFondo);
        cadena.append(";classMenu:").append(classMenu);

        return cadena.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        
}
