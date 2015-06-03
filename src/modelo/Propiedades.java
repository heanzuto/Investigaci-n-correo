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

   private static int opcion;
   
    public static String[] PROPS_GMAIL = {"mail.smtp.host", "smtp.gmail.com",
        "mail.smtp.starttls.enable", "true",
        "mail.smtp.auth", "true",
        "mail.smtp.user", "usuario",
        "mail.smtp.port", "587"};

    public static String[] PROPS_OUTLOOK = {"mail.smtp.host", "smtp.live.com",
        "mail.smtp.starttls.enable", "true",
        "mail.smtp.auth", "true",
        "mail.smtp.user", "usuario",
        "mail.smtp.port", "25"};

   public static String[] PROPS_UCR = {"mail.smtp.host", "smtp.ucr.ac.cr ",
        "mail.smtp.starttls.enable", "true",
        "mail.smtp.auth", "true",
        "mail.smtp.user", "usuario",
        "mail.smtp.port", "25"};
                                //SMTP:smtp.ucr.ac.cr   (25) //POP:ucr.ac.cr (110)

    public Propiedades() {
    }

    public static int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
 
    
    public static String[] getPropiedades()
    {
        if(getOpcion()==1){
            return PROPS_GMAIL;
        }
        else if(getOpcion()==2){
            return PROPS_OUTLOOK;
        }
        else if(getOpcion()==3){
            return PROPS_UCR;
        }
        return null;
    }
 
}
