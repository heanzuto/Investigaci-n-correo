/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUICorreo;
import Vista.GUILogin;
import Vista.GUI_Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Propiedades;
import modelo.SMTPAuthentication;

/**
 *
 * @author "Heber Anthony Zuniga Torres"
 */
public class ControladorGUILogin implements ActionListener {

    private final GUILogin guiLogin;

    public ControladorGUILogin(GUILogin guiLogin) {
        this.guiLogin = guiLogin;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GUILogin.BTN_INICIO)) {
            
             SMTPAuthentication autentificacion = new SMTPAuthentication(guiLogin.getTxtCuenta(),guiLogin.getTxtPassword());
             autentificacion.autentificar();
             if(SMTPAuthentication.getEstadoAtentificado())
             {
                 GUICorreo guiCorreo = new GUICorreo(autentificacion);
                 guiCorreo.show();
                 guiLogin.setVisible(false);
                 
             }
             guiLogin.limpiarTxt();
        }
        if (e.getActionCommand().equals(GUILogin.BTN_SALIR)) {
           if(GUI_Inicio.confirmMessage("Esta seguro que quiere salir d la aplicación?").equalsIgnoreCase("si"))
            {
               System.exit(0); 
            }
        }
    }

}
