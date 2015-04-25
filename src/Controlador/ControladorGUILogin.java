/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUILogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            GUILogin.printMessage("asdasdasd");
        }
        if (e.getActionCommand().equals(GUILogin.BTN_SALIR)) {
            GUILogin.printExit();
        }
    }

}
