/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Interfaz.EnviarCorreo;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author Equipo 3
 */
public class CorreoGmail implements EnviarCorreo {

    /**
     * Constructor vacio por defecto
     */
    public CorreoGmail() {
    }

    /**
     * Metodo donde se conecta al servidor del correo, donde pide la contraseña
     * y manda el correo con el mensaje, si se acompleto con exito soltara un
     * mensaje de correo enviado correctamente
     *
     * @param destinatario Destinatario
     * @param mensaje Mensaje
     * @throws Exception Exception
     */
    @Override
    public void enviarCorreo(String usuario, String contra, String destinatario, String mensaje, String asunto) throws Exception {
        //Esto es para conectarnos con el servidor de gmail
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.put("mail.smtp.user", usuario);
        propiedades.setProperty("mail.smtp.auth", "true");

        //Aqui se inicia sesion en el gmail
        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contra);
            }
        });
        MimeMessage correo = new MimeMessage(sesion);

        //Aqui le envias el correo a la persona que quisiste
        correo.setFrom(new InternetAddress(usuario));
        correo.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        correo.setSubject(asunto);
        correo.setText(mensaje);
        Transport t = sesion.getTransport("smtp");
        t.connect(usuario, contra);
        t.sendMessage(correo, correo.getRecipients(Message.RecipientType.TO));
        Transport.send(correo);
        System.out.println("Correo enviado correctamente a: " + destinatario);
    }
}
