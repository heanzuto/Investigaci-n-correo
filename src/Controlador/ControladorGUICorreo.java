/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUICorreo;
import Vista.GUIEnvios;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import modelo.SMTPAuthentication;

/**
 *
 * @author cristhian
 */
public class ControladorGUICorreo implements MouseListener {
 private Vista.GUICorreo guiCorreo;
 private SMTPAuthentication autentificacion;
    public ControladorGUICorreo(GUICorreo guiCorreo,SMTPAuthentication autentificacion) {
       this.guiCorreo=guiCorreo;
       this.autentificacion=autentificacion;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(guiCorreo.getLbBandeja()))
        {
            try {
                autentificacion.cargarInbox();
            } catch (MessagingException ex) {
                Logger.getLogger(ControladorGUICorreo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControladorGUICorreo.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.err.println("se pulso la bandeja");
        }
         if(e.getSource().equals(guiCorreo.getLbCerrarSesion()))
        {
            System.err.println("se pulso la cerrar cesion");
        }
          if(e.getSource().equals(guiCorreo.getLbNuevo()))
        {
            GUIEnvios guiEnvios=new GUIEnvios(autentificacion);
            guiEnvios.setVisible(true);
        }
           if(e.getSource().equals(guiCorreo.getLbUsuario()))
        {
            System.err.println("se pulso la cerrar usuario");
        }
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
   }

    @Override
    public void mouseExited(MouseEvent e) {
       }
    
}