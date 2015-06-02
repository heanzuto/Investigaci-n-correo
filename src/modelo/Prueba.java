/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author cristhian
 */
public class Prueba {
    private String user;
    private String pass;
    private String host;
    public static Folder inbox ;
    public Prueba(String user, String pass) throws NoSuchProviderException, MessagingException {
    this.user = user + "@gmail.com";
    this.pass = pass;
    this.host = "imap.gmail.com";
    
        Properties props = System.getProperties();
    props.setProperty("mail.store.protocol", "imaps");
    Session session = Session.getDefaultInstance(props, null);
Store store = session.getStore("imaps");
    store.connect(host, user, pass);
    
     inbox = store.getFolder("Inbox");
       
    
    }
     public boolean connect() {
    try {
    Properties props = System.getProperties();
    props.setProperty("mail.store.protocol", "imaps");
     
    Session session = Session.getDefaultInstance(props, null);
    Store store = session.getStore("imaps");
    store.connect(host, user, pass);
     
    inbox = store.getFolder("Inbox");
    // Obtenemos la casilla de entrada como carpeta a analizar
     
    return true;
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }
    }
         public static void main(String[] args) throws MessagingException {
   Prueba gmail = new Prueba("campse21@gmail.com", "tengoqueestudiar");
    gmail.connect();
             System.err.println(inbox.getName());
     
         }
}
