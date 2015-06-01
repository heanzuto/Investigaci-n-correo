/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cristhian
 */
public class Propiedades {

    private String []propsGmail={"mail.smtp.host","smtp.gmail.com",
                                 "mail.smtp.starttls.enable","true",
                                 "mail.smtp.auth","true",
                                  "mail.smtp.user","usuario" ,
                                   "mail.smtp.port", "587" };
    
    private static String []propsOutlook={"mail.smtp.host", "smtp.live.com",
                                 "mail.smtp.starttls.enable", "true",
                                 "mail.smtp.auth", "true",
                                  "mail.smtp.user","usuario" ,
                                   "mail.smtp.port", "25" };
      
    private static String[]propsUCR={"mail.smtp.host", "smtp.ucr.ac.cr ",
                                 "mail.smtp.starttls.enable", "true",
                                 "mail.smtp.auth", "true",
                                  "mail.smtp.user","usuario" ,
                                   "mail.smtp.port", "25" };
                                //SMTP:smtp.ucr.ac.cr   (25) //POP:ucr.ac.cr (110)
            
    public Propiedades() {
    }

    public String[] getPropsGmail() {
        return propsGmail;
    }

    public static String[] getPropsOutlook() {
        return propsOutlook;
    }

    public static String[] getPropsUCR() {
        return propsUCR;
    }
    
}
