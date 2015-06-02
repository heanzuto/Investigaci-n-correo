/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Vista.GUI_Inicio;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;

/**
 *
 * @author cristhian
 */
public class Propiedades {

    private String[] PROPS_GMAIL = {"mail.smtp.host", "smtp.gmail.com",
        "mail.smtp.starttls.enable", "true",
        "mail.smtp.auth", "true",
        "mail.smtp.user", "usuario",
        "mail.smtp.port", "587"};

    private static String[] PROPS_OUTLOOK = {"mail.smtp.host", "smtp.live.com",
        "mail.smtp.starttls.enable", "true",
        "mail.smtp.auth", "true",
        "mail.smtp.user", "usuario",
        "mail.smtp.port", "25"};

    private static String[] PROPS_UCR = {"mail.smtp.host", "smtp.ucr.ac.cr ",
        "mail.smtp.starttls.enable", "true",
        "mail.smtp.auth", "true",
        "mail.smtp.user", "usuario",
        "mail.smtp.port", "25"};
                                //SMTP:smtp.ucr.ac.cr   (25) //POP:ucr.ac.cr (110)

    public Propiedades() {
    }

    public String[] getPropsGmail() {
        return PROPS_GMAIL;
    }

    public static String[] getPropsOutlook() {
        return PROPS_OUTLOOK;
    }

    public static String[] getPropsUCR() {
        return PROPS_UCR;
    }
 public void autentificar() {
         //Session session = null ;
        Properties props = new Properties();
        
            try{
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.user", "cristhian");
            props.put("mail.smtp.port", 587);

            String correo="cnampse21@gmail.com";
            String contra="tengoqueestudiar";
        SMTPAuthentication auth = new SMTPAuthentication(correo, contra);
      Session session= Session.getDefaultInstance(props, auth);
       session.setDebug(true);
       Transport t = session.getTransport("smtp");
       t.connect(correo, contra);
    if(t.isConnected())
    {
        System.err.println("entro");
    }

    }

    catch (Exception e)
    {

     
    }
 
    }
 public static void main(String args[])
 {
     Propiedades p=new Propiedades();
     p.autentificar();
 }
}
