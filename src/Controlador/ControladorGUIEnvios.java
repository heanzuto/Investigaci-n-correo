/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUIEnvios;
import Vista.GUI_Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import modelo.SMTPAuthentication;

/**
 *
 * @author cristhian
 */
public class ControladorGUIEnvios implements ActionListener{
private GUIEnvios guiEnvios;
private SMTPAuthentication autentificacion;

    public ControladorGUIEnvios(GUIEnvios guiEnvios,SMTPAuthentication autentificacion) {
        this.guiEnvios=guiEnvios;
        this.autentificacion=autentificacion;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase(GUIEnvios.BTN_ENVIAR))
        {
            if(guiEnvios.getTxtAdjunto().equalsIgnoreCase(""))
            {
                try {
                    autentificacion.enviarCorreoNormal();
                    GUI_Inicio.infoMessage("Correo enviado exitosamente");
                } catch (MessagingException ex) {
                     GUI_Inicio.errorMessage("Fallo al enviar el correo, Favor volver a intentar");
                }
            }else if(!guiEnvios.getTxtAdjunto().equalsIgnoreCase(""))
            {
                try {
                    autentificacion.enviarCorreoAdjunto();
                    GUI_Inicio.infoMessage("Correo enviado exitosamente");
                } catch (MessagingException ex) {
                    GUI_Inicio.errorMessage("Fallo al enviar el correo, Favor volver a intentar");
            }
                
             }
        if(e.getActionCommand().equalsIgnoreCase(GUIEnvios.BTN_ADJUNTAR))
        {
            this.autentificacion.mostrarRutas();
        }

    }
    }
}
