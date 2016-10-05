/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.mail.sender;

import com.util.mail.beans.Email;
import com.util.mail.beans.ServidorEmail;
import com.util.mail.generator.EmailGenerator;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author JuglarM
 */
public class MailSender {

    String correoServidor;
    String password;
    String nombre;
    String correoDestino;
    String direccion;
    ServidorEmail servidorEmail;
    Properties props;
    int cantidad;

    public MailSender() {
        // cargamos una vez el properties por cada envio masivo - desde un file

        props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.live.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.user", "casio.soe@gmail.com");
        props.setProperty("mail.smtp.auth", "true");

        // cargamos el servidor de correo;
        servidorEmail = new ServidorEmail();
        servidorEmail.setCorreoIdentificador("casio_soe@hotmail.com");
        servidorEmail.setPassword("@NDREI20");

    }

    public void enviarEmail(List<Email> correos) {

        try {
            for (Email correo : correos) {
                enviarEmail(correo, props, servidorEmail);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void enviarEmail(Email email, Properties props, ServidorEmail servidorEmail) {
        EmailGenerator emailGenerator;
        MimeMessage message;

        try {
            emailGenerator = new EmailGenerator();

            emailGenerator.setCorreo(email.getCorreoIdentificador());
            emailGenerator.setNombre(email.getNombreUsuario());
            emailGenerator.setDireccion(email.getDireccionFisica());
            emailGenerator.setMensaje(email.getMensaje());
            emailGenerator.setAsunto(email.getAsunto());
            emailGenerator.setAdjunto(email.getAdjunto());
            emailGenerator.setProps(props);
            message = emailGenerator.generarMensaje();

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(servidorEmail.getCorreoIdentificador(), servidorEmail.getPassword());
            t.sendMessage(message, message.getAllRecipients());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emailGenerator = null;
            message = null;
        }

    }

    public void enviarEmail() {

        EmailGenerator emailGenerator;
        MimeMessage message;

        try {
            emailGenerator = new EmailGenerator();

            emailGenerator.setCorreo(correoDestino);
            emailGenerator.setNombre(nombre);
            emailGenerator.setDireccion(direccion);

            emailGenerator.setProps(props);
            message = emailGenerator.generarMensaje();

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
//            t.connect("aulacsistemas@outlook.com", "villareal50");
            t.connect(correoServidor, password);
            t.sendMessage(message, message.getAllRecipients());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emailGenerator = null;
            message = null;
        }

    }

    public String getCorreoServidor() {
        return correoServidor;
    }

    public void setCorreoServidor(String correoServidor) {
        this.correoServidor = correoServidor;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoDestino() {
        return correoDestino;
    }

    public void setCorreoDestino(String correoDestino) {
        this.correoDestino = correoDestino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public static void main(String[] args) {
        MailSender mailSender = new MailSender();

         try {
        Email email = new Email();
             email.setNombreUsuario("MA");
             email.setMensaje("Mensaje de pruebita");
             email.setAsunto("HOLA MA2");
             email.setCorreoIdentificador("casio.soe@gmail.com");

             BodyPart adjunto = new MimeBodyPart();

             adjunto.setDataHandler(new DataHandler(new FileDataSource("D:\\iMAGE\\bad.jpg")));
             adjunto.setFileName("imagen.jpg");

             email.setCorreoIdentificador("casio.soe@gmail.com");
             email.setAdjunto(adjunto);

             List<Email> listaCorreos = new ArrayList<Email>();
             listaCorreos.add(email);

             mailSender.enviarEmail(listaCorreos);
         } catch (Exception e) {
             e.printStackTrace();
        }

        

    }

}
