/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUILogin;
import Vista.GUI_Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Propiedades;

/**
 *
 * @author cristhian
 */
public class ControladorGUI_Inicio implements ActionListener
{
private GUI_Inicio guiInicio;
            Propiedades propiedades = new Propiedades();
            
    public ControladorGUI_Inicio(GUI_Inicio guiInicio) {
        this.guiInicio=guiInicio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase(GUI_Inicio.BTN_ACEPTAR))
        {
         if(guiInicio.radioGmail().isSelected())
         {
             if(GUI_Inicio.confirmMessage("G-Mail fue selecionado esta seguro que desea ingresar a este correo?").equalsIgnoreCase("si"))
            {
              GUILogin guiLogin  =new GUILogin();
               propiedades.setOpcion(1);
              guiLogin.setVisible(true);
            }
         }
         if(guiInicio.radioOutlook().isSelected())
         {
             if(GUI_Inicio.confirmMessage("Outlook fue selecionado esta seguro que desea ingresar a este correo?").equalsIgnoreCase("si"))
            {
                 GUILogin guiLogin  =new GUILogin();
               propiedades.setOpcion(2);
              guiLogin.setVisible(true);
            }
         }
         if(guiInicio.radioUCR().isSelected())
         {
              if(GUI_Inicio.confirmMessage("Correo institucional UCR fue selecionado esta seguro que desea ingresar a este correo?").equalsIgnoreCase("si"))
            {
                 GUILogin guiLogin  =new GUILogin();
               propiedades.setOpcion(3);
              guiLogin.setVisible(true);
            }
         }
        }
        if(e.getActionCommand().equalsIgnoreCase(GUI_Inicio.BTN_SALIR))
        {
            if(GUI_Inicio.confirmMessage("Esta seguro que quiere salir d la aplicación?").equalsIgnoreCase("si"))
            {
               System.exit(0); 
            }
             
        }
    }
    
}
