package Vista;

import Controlador.ControladorGUIEnvios;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.SMTPAuthentication;

/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class GUIEnvios extends javax.swing.JFrame {
private Controlador.ControladorGUIEnvios control;

    /** Creates new form interfaz */
    public GUIEnvios(SMTPAuthentication autentificacion) {
        initComponents();
        this.setTitle("Envio de correos");
        control=new ControladorGUIEnvios(this,autentificacion);
        escuchar(control);
        autentificacion.setGuiEnvios(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEnvios = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPara = new javax.swing.JTextField();
        lbDe = new javax.swing.JLabel();
        lbPara = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnAdjuntar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtAdjunto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelEnvios.setBackground(new java.awt.Color(221, 209, 198));

        jLabel1.setText("Redactar correo");

        lbDe.setText("Para:");

        lbPara.setText("Asunto:");

        jLabel2.setText("Contenido:");

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel.png"))); // NOI18N
        btnCancelar.setActionCommand("Cancelar");

        btnAdjuntar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/clip.png"))); // NOI18N
        btnAdjuntar.setActionCommand("Adjuntar");
        btnAdjuntar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjuntarActionPerformed(evt);
            }
        });

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sendMail.png"))); // NOI18N
        btnEnviar.setActionCommand("Enviar");

        jLabel3.setText("Adjunto:");

        txtAdjunto.setEditable(false);

        javax.swing.GroupLayout panelEnviosLayout = new javax.swing.GroupLayout(panelEnvios);
        panelEnvios.setLayout(panelEnviosLayout);
        panelEnviosLayout.setHorizontalGroup(
            panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnviosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelEnviosLayout.createSequentialGroup()
                        .addGroup(panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDe)
                            .addComponent(lbPara))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPara)
                            .addComponent(txtAsunto)))
                    .addGroup(panelEnviosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1))
                    .addGroup(panelEnviosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEnviosLayout.createSequentialGroup()
                                .addGap(0, 277, Short.MAX_VALUE)
                                .addComponent(btnEnviar)
                                .addGap(39, 39, 39)
                                .addComponent(btnAdjuntar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAdjunto))))
                .addGap(29, 29, 29)
                .addComponent(btnCancelar)
                .addGap(75, 75, 75))
            .addGroup(panelEnviosLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEnviosLayout.setVerticalGroup(
            panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnviosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDe)
                    .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPara)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnviosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdjuntar)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelEnviosLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelEnviosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAdjunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEnvios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEnvios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdjuntarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdjuntarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjuntar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDe;
    private javax.swing.JLabel lbPara;
    private javax.swing.JPanel panelEnvios;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtAdjunto;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtPara;
    // End of variables declaration//GEN-END:variables

    public static String BTN_ADJUNTAR="Adjuntar";
      public static String BTN_CANCELAR="Cancelar";
        public static String BTN_ENVIAR="Enviar";
        
    public void escuchar(ControladorGUIEnvios control)
    {
        this.btnAdjuntar.addActionListener(control); 
        this.btnCancelar.addActionListener(control);
         this.btnEnviar.addActionListener(control);
         
    }

    public String getTextArea() {
        return textArea.getText();
    }

    public void setTextArea(String textArea) {
        this.textArea.setText(textArea);
    }

    public String getTxtAdjunto() {
        return txtAdjunto.getText();
    }

    public void setTxtAdjunto(String txtAdjunto) {
        this.txtAdjunto.setText(txtAdjunto);
    }

    public String getTxtAsunto() {
        return txtAsunto.getText();
    }

    public void setTxtAsunto(String txtAsunto) {
        this.txtAsunto.setText(txtAsunto);
    }

    public String getTxtPara() {
        return txtPara.getText();
    }

    public void setTxtPara(String txtPara) {
        this.txtPara.setText(txtPara);
    }
    
}
