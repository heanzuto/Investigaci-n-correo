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
