/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Vista.GUI_Inicio;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

/**
 *
 * @author cristhian
 */
public class SMTPAuthentication extends Authenticator {
    
    private String user = "";
    private String password = "";
    private static boolean ESTADO_AUTENTIFICADO;

    public SMTPAuthentication(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.user, this.password);
    }

    public void autentificar() {

        Properties props = new Properties();
        try {
            props.put(Propiedades.getPropiedades()[0], Propiedades.getPropiedades()[1]);
            props.put(Propiedades.getPropiedades()[2], Propiedades.getPropiedades()[3]);
            props.put(Propiedades.getPropiedades()[4], Propiedades.getPropiedades()[5]);
            props.put(Propiedades.getPropiedades()[6], Propiedades.getPropiedades()[7]);
            props.put(Propiedades.getPropiedades()[8], Propiedades.getPropiedades()[9]);

            SMTPAuthentication auth = new SMTPAuthentication(this.user, this.password);
            Session session = Session.getDefaultInstance(props, auth);
            session.setDebug(true);
            Transport t = session.getTransport("smtp");
            t.connect(this.user, this.password);

            if (t.isConnected()) {
                GUI_Inicio.infoMessage("Es usuario se ha atentificado con exito");
                setEstadoAtentificado(true);
            }

        } catch (Exception e) {
            GUI_Inicio.errorMessage("Usuario o contraseña incorrectos,favor digitar los valores correctos");
            setEstadoAtentificado(false);

        }

    }


    public static boolean getEstadoAtentificado() {
        return ESTADO_AUTENTIFICADO;
    }

    public static void setEstadoAtentificado(boolean ESTADO_AUTENTIFICADO) {
        SMTPAuthentication.ESTADO_AUTENTIFICADO = ESTADO_AUTENTIFICADO;
    }



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
