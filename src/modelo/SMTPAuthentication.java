/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Vista.GUIEnvios;
import Vista.GUI_Inicio;
import Vista.PanelTabla;
import com.sun.mail.smtp.SMTPMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author cristhian
 */
public class SMTPAuthentication extends Authenticator {

    private String user = "";
    private String password = "";
    private static boolean ESTADO_AUTENTIFICADO;
    private Session session;
    private GUIEnvios guiEnvios;
    String[] datosArchivo = new String[2];
    private Properties props;
     

    public SMTPAuthentication(String user, String password) {
        this.user = user;
        this.password = password;
        // datosArchivo=null;
    }

    public SMTPAuthentication() {
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.user, this.password);
    }

    public void autentificar() {

        props = new Properties();
        try {
            props.put(Propiedades.getPropiedades()[0], Propiedades.getPropiedades()[1]);
            props.put(Propiedades.getPropiedades()[2], Propiedades.getPropiedades()[3]);
            props.put(Propiedades.getPropiedades()[4], Propiedades.getPropiedades()[5]);
            props.put(Propiedades.getPropiedades()[6], Propiedades.getPropiedades()[7]);
            props.put(Propiedades.getPropiedades()[8], Propiedades.getPropiedades()[9]);

            SMTPAuthentication auth = new SMTPAuthentication(this.user, this.password);
            session = Session.getDefaultInstance(props, auth);
            //session.setDebug(true);
            Transport transport = session.getTransport("smtp");

            transport.connect(this.user, this.password);

            if (transport.isConnected()) {
                GUI_Inicio.infoMessage("Es usuario se ha atentificado con exito");
                setEstadoAtentificado(true);
            }

        } catch (Exception e) {
            GUI_Inicio.errorMessage("Usuario o contraseña incorrectos,favor digitar los valores correctamente");
            setEstadoAtentificado(false);

        }

    }

    // ---------------------------------------------------envio________________________________
    public String[] mostrarRutas()//retorna la ruta selecionada de archivo a copiar
    {
        String ruta;
        File origen = null;

        try {
            JFileChooser selector = new JFileChooser();//ventana que se muestra
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);//para abrir archivos y carpetas
            selector.showOpenDialog(null);
            origen = selector.getSelectedFile();//le asignamos lo que seleciono el JFilechooser()
            ruta = origen.getAbsolutePath();

            datosArchivo[0] = origen.getAbsolutePath();
            datosArchivo[1] = origen.getName();
            getGuiEnvios().setTxtAdjunto(origen.getAbsolutePath());

            System.err.println("......................." + origen.getAbsolutePath());
            System.err.println("......................." + origen.getName());

            return datosArchivo;
        } catch (NullPointerException e) {

        }

        return null;
    }

    public void enviarCorreoNormal() throws MessagingException {
        //http://www.chuidiang.com/java/herramientas/javamail/enviar-adjuntos-javamail.php
        BodyPart texto = new MimeBodyPart();
        texto.setText(getGuiEnvios().getTextArea());
        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
        MimeMessage message = new MimeMessage(this.session);
        // Se rellena el From
        message.setFrom(new InternetAddress(this.user));

        // Se rellenan los destinatarios
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(getGuiEnvios().getTxtPara()));
        // Se rellena el subject
        message.setSubject(getGuiEnvios().getTxtAsunto());
        // Se mete el texto y la foto adjunta.
        message.setContent(multiParte);

        //enviar el correo
        Transport transport = session.getTransport("smtp");
        transport.connect(this.user, this.password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public void enviarCorreoAdjunto() throws MessagingException {
        // mostrarRutas();
        //http://www.chuidiang.com/java/herramientas/javamail/enviar-adjuntos-javamail.php
        BodyPart texto = new MimeBodyPart();
        texto.setText(getGuiEnvios().getTextArea());
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource(datosArchivo[0])));
        adjunto.setFileName(datosArchivo[1]);

        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
        multiParte.addBodyPart(adjunto);

        MimeMessage message = new MimeMessage(this.session);
        // Se rellena el From
        message.setFrom(new InternetAddress(this.user));

        // Se rellenan los destinatarios
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(getGuiEnvios().getTxtPara()));
        // Se rellena el subject
        message.setSubject(getGuiEnvios().getTxtAsunto());
        // Se mete el texto y la foto adjunta.
        message.setContent(multiParte);

        //enviar el correo
        Transport transport = session.getTransport("smtp");
        transport.connect(this.user, this.password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public GUIEnvios getGuiEnvios() {
        return guiEnvios;
    }

    public void setGuiEnvios(GUIEnvios guiEnvios) {
        this.guiEnvios = guiEnvios;
    }

//------------------------------------------fin envio-----------------------------------------
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

    public String[] getDatosArchivo() {
        return datosArchivo;
    }

    public void setDatosArchivo(String[] datosArchivo) {
        this.datosArchivo = datosArchivo;
    }

    public Message[] getMensajes() throws NoSuchProviderException, MessagingException, IOException {

        Session sesion = Session.getInstance(props);

        // Para obtener un log más extenso.
        //sesion.setDebug(false);
        //Para obtener los mensajes, establecemos la conexión, pedimos el almacén de mensajes y dentro del almacén, la carpeta INBOX 
        Store store = sesion.getStore("imaps");

        //"imap-mail.outlook.com"  => host outlook
        //"smtp.gmail.com"  => host gmail
        store.connect(Propiedades.getHost(), this.user, this.password);

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        //Una vez que tenemos la carpeta, obtener los mensajes es inmediato 
        Message[] mensajes = folder.getMessages();
        return mensajes;
    }

    public String getDato(Message mensaj,int dato) throws MessagingException {
        Message mensaje = mensaj;
        Address[] from = mensaje.getFrom();
        switch (dato) {
            case 0:
                return ""+from[0].toString();
            case 1:
                return mensaje.getSubject();
            case 2:
                return ""+mensaje.getSentDate();
            default:
                return null;
        }
    }

    public String[][] getMatriz() throws MessagingException, NoSuchProviderException, IOException {
        Message[] mensajes = getMensajes();
        String matriz[][] = new String[mensajes.length][PanelTabla.getTamannoEtiquetas()];

        for (int fila = 0 ; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[fila].length; colum++) {
                matriz[fila][colum] = getDato(mensajes[fila],colum);
            }
        }
        return matriz;

    }
 
}
