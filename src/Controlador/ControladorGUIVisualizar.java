/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUICorreo;
import Vista.GUIVisualizarCorreo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.SMTPAuthentication;

/**
 *
 * @author cristhian
 */
public class ControladorGUIVisualizar implements ActionListener{
private Vista.GUIVisualizarCorreo guiVisualizar;
SMTPAuthentication autentificacion;
GUICorreo guiCorreo;
    public ControladorGUIVisualizar(GUIVisualizarCorreo guiVisualizar,
            SMTPAuthentication autentificacion,GUICorreo guiCorreo) {
        this.guiVisualizar=guiVisualizar;
        this.guiCorreo=guiCorreo;
        this.autentificacion=autentificacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase(GUIVisualizarCorreo.BTN_DOWLOAD))
        {
            //JOptionPane.showMessageDialog(null,guiCorreo.getPanelTabla1().getjTable1().getSelectedRow());
            autentificacion.descargaAdjunto(guiCorreo.getPanelTabla1().getjTable1().getSelectedRow());
            
        }
        if(e.getActionCommand().equalsIgnoreCase(GUIVisualizarCorreo.BTN_SAlIR))
        {
            guiVisualizar.dispose();
        }
    }
    
}
