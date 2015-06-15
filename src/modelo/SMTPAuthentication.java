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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.FileTypeMap;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author cristhian
 */
public class SMTPAuthentication extends Authenticator {

    private String user = "";
    private String password = "";
    private static boolean ESTADO_AUTENTIFICADO;
    private static Session session;
    private GUIEnvios guiEnvios;
    String[] datosArchivo = new String[2];
    private static Properties props;
     

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
            case 3:
                return ""+mensaje.getContentType();
                        
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
    
    
   //---------------------------------------------------------------------------
   public void descarga(int posi)
   {
         Session sesion = Session.getInstance(props);
        try
        {
          // Se obtiene el Store y el Folder, para poder leer el correo.
           Store store = sesion.getStore("imaps");
           store.connect(Propiedades.getHost(), this.user, this.password);
           
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            // Se obtienen los mensajes.
            Message[] mensajes = folder.getMessages();

            // Se escribe from y subject de cada mensaje
            /*for (int i = 0; i < mensajes.length; i++)
            {
                System.out.println(
                    "From:" + mensajes[i].getFrom()[0].toString());
                System.out.println("Subject:" + mensajes[i].getSubject());*/
                
                // Se visualiza, si se sabe como, el contenido de cada mensaje
                analizaParteDeMensaje(mensajes[posi]);
           // }

            folder.close(false);
            store.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
   }
     public  void pruebas()
     {
        Session sesion = Session.getInstance(props);
        try
        {
          // Se obtiene el Store y el Folder, para poder leer el correo.
           Store store = sesion.getStore("imaps");
           store.connect(Propiedades.getHost(), this.user, this.password);
           
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            // Se obtienen los mensajes.
            Message[] mensajes = folder.getMessages();

            // Se escribe from y subject de cada mensaje
            for (int i = 0; i < mensajes.length; i++)
            {
                System.out.println(
                    "From:" + mensajes[i].getFrom()[0].toString());
                System.out.println("Subject:" + mensajes[i].getSubject());
                
                // Se visualiza, si se sabe como, el contenido de cada mensaje
                analizaParteDeMensaje(mensajes[i]);
            }

            folder.close(false);
            store.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
     
       private static void analizaParteDeMensaje(Part unaParte)
    {
        try
        {
          // Si es multipart, se analiza cada una de sus partes recursivamente.
            if (unaParte.isMimeType("multipart/*"))
            {
                Multipart multi;
                multi = (Multipart) unaParte.getContent();

                for (int j = 0; j < multi.getCount(); j++)
                {
                    analizaParteDeMensaje(multi.getBodyPart(j));
                }
            }
            else
            {
              // Si es texto, se escribe el texto.
                if (unaParte.isMimeType("text/*"))
                {
                    System.out.println("Texto " + unaParte.getContentType());
                    System.out.println(unaParte.getContent());
                    System.out.println("---------------------------------");
                }
                //AQUI
                else if(unaParte.isMimeType("multipart/alternative") )
                {
                    JOptionPane.showMessageDialog(null, "entro");
                    String cuerpoMensaje;
                            Multipart mp2=(Multipart) unaParte.getContent();
                            Part part2=mp2.getBodyPart(0);
                            cuerpoMensaje=(String)part2.getContent();
                            
                            String nombrePart=unaParte.getFileName();
				if(nombrePart==null)
					nombrePart="adjunto";
                                    MimeBodyPart mbp2;
					//procesar el adjunto
					mbp2=(MimeBodyPart)unaParte;
					mbp2.saveFile(nombrePart);

                    
	}
                else
                {
                  // Si es file, se guarda en fichero y se visualiza en JFrame
                    if (unaParte.isMimeType("image/*"))
                    {
                        System.out.println(
                            "Imagen " + unaParte.getContentType());
                        System.out.println("Fichero=" + unaParte.getFileName());
                        System.out.println("---------------------------------");

                        salvarFichero(unaParte);
                        visualizaImagenEnJFrame(unaParte);
                    }
                    else
                    {
                      // Si no es ninguna de las anteriores, se escribe en pantalla
                      // el tipo.
                        if(unaParte.isMimeType("APPLICATION/OCTET-STREAM"))
                        {
                            JOptionPane.showMessageDialog(null, "es aplication");
                            System.out.println(
                            "Recibido " + unaParte.getContentType());

                             FileDataSource file=new FileDataSource(unaParte.getContentType())  ; 
                             System.out.println("-------------------------------?????--"); 
                            salvarFichero(unaParte);
                        }
                       
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
       
         private static void visualizaImagenEnJFrame(Part unaParte)
        throws IOException, MessagingException
    {
       /* JFrame v = new JFrame();
        ImageIcon icono = new ImageIcon(
                ImageIO.read(unaParte.getInputStream()));
        JLabel l = new JLabel(icono);
        v.getContentPane().add(l);
        v.pack();
        v.setVisible(true);*/
    }
         private static void salvarFichero(Part unaParte)
        throws FileNotFoundException, MessagingException, IOException
    {
        FileOutputStream fichero = new FileOutputStream(unaParte.getFileName());
        InputStream file = unaParte.getInputStream();
        byte[] bytes = new byte[1000];
        int leidos = 0;

        while ((leidos = file.read(bytes)) > 0)
        {
            fichero.write(bytes, 0, leidos);
        }
    }

}
