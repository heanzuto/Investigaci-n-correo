/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorGUICorreo;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import modelo.SMTPAuthentication;

/**
 *
 * @author "Heber Anthony Zuniga Torres"
 */
public class GUICorreo extends javax.swing.JFrame {

    /** 
     * Creates new form GUICorreo
     */
    private Controlador.ControladorGUICorreo control;
    public GUICorreo(SMTPAuthentication autentificacion) {
        initComponents();
        control=new ControladorGUICorreo(this,autentificacion);
        escuchar(control);
        
        
        
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbNuevo = new javax.swing.JLabel();
        lbBandeja = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbCerrarSesion = new javax.swing.JLabel();
        panelTabla1 = new Vista.PanelTabla();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(java.awt.SystemColor.window);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Mail-icon.png"))); // NOI18N

        lbNuevo.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/addmail.png"))); // NOI18N
        lbNuevo.setText("Nuevo");
        lbNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbBandeja.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbBandeja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/mailbox .png"))); // NOI18N
        lbBandeja.setText("Bandeja entrada");
        lbBandeja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbUsuario.setText("Usuario");
        lbUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbCerrarSesion.setText("Cerrar sesion");
        lbCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbUsuario)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbCerrarSesion)
                                .addGap(23, 23, 23))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNuevo)
                            .addComponent(lbBandeja))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCerrarSesion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbBandeja))
                    .addComponent(panelTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbBandeja;
    private javax.swing.JLabel lbCerrarSesion;
    private javax.swing.JLabel lbNuevo;
    private javax.swing.JLabel lbUsuario;
    private Vista.PanelTabla panelTabla1;
    // End of variables declaration//GEN-END:variables

public void escuchar(ControladorGUICorreo control)
{
    this.lbCerrarSesion.addMouseListener(control);
    this.lbBandeja.addMouseListener(control);
    this.lbNuevo.addMouseListener(control);
    this.lbUsuario.addMouseListener(control);
    this.panelTabla1.getjTable1().addMouseListener(control);
}

    public JLabel getLbBandeja() {
        return lbBandeja;
    }

    public void setLbBandeja(JLabel lbBandeja) {
        this.lbBandeja = lbBandeja;
    }

    public JLabel getLbCerrarSesion() {
        return lbCerrarSesion;
    }

    public void setLbCerrarSesion(JLabel lbCerrarSesion) {
        this.lbCerrarSesion = lbCerrarSesion;
    }

    public JLabel getLbNuevo() {
        return lbNuevo;
    }

    public void setLbNuevo(JLabel lbNuevo) {
        this.lbNuevo = lbNuevo;
    }

    public JLabel getLbUsuario() {
        return lbUsuario;
    }

    public void setLbUsuario(String lbUsuario) {
        this.lbUsuario.setText(lbUsuario);
    }
    
    public void setCargarInbox(String[][] datosFilas) {

        this.panelTabla1.setValores(datosFilas);
    }

    public PanelTabla getPanelTabla1() {
        return panelTabla1;
    }

    public void setPanelTabla1(PanelTabla panelTabla1) {
        this.panelTabla1 = panelTabla1;
    }
    
}
