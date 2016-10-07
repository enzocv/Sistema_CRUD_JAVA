
package Presentacion;

import java.text.*;
import java.util.*;
import javax.swing.*;

public class frm_Pricipal extends javax.swing.JFrame {

    
    public String Apellido;
    public String Nombre;
    public String Nivel;
    public int Estado;
    
    
    public frm_Pricipal() {
        initComponents();
        obtenerFehca();
    }
    
    public void obtenerUsuario(){
        String Usuario;
        Usuario = Nombre + " " + Apellido + " ( " + Nivel + " ) ";
        lbl_usuario.setText(Usuario);
    }
    
    public void obtenerFehca(){
        Date fecha = new Date();
        String formato = new String("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        lbl_Fecha.setText(sdf.format(fecha));
    }
    
    public void salir(){
        int rpta;
        rpta = JOptionPane.showConfirmDialog(null, "Esta seguro de salir del sistema ?","Sistema",0);
        if (rpta == 0) {
            System.exit(0);
        }
    }

    public void abrirFrmUsuario(){
        //instanciar el formulario JInternarl Frame
        frm_Usuario usuario = new frm_Usuario();
        
        //agregar al formulario pricnipal el formulario Usuario
        Escritorio.add(usuario);
        
        //visualizar el formulario
        usuario.show();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btn_Docente = new javax.swing.JButton();
        btn_Usuario = new javax.swing.JButton();
        btn_Semestre = new javax.swing.JButton();
        btn_Criterio = new javax.swing.JButton();
        btn_Modelo = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        Escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lbl_Fecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Mnu_Archivo = new javax.swing.JMenu();
        Mnu_Mantenimiento = new javax.swing.JMenu();
        Mante_Usuario = new javax.swing.JMenuItem();
        Mante_Docente = new javax.swing.JMenuItem();
        Mante_Semestre = new javax.swing.JMenuItem();
        Mante_TipoDocumento = new javax.swing.JMenuItem();
        Mnu_Consulta = new javax.swing.JMenu();
        Mnu_Reporte = new javax.swing.JMenu();
        Mnu_Ayuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jToolBar1.setRollover(true);

        btn_Docente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/users.png"))); // NOI18N
        btn_Docente.setText("Docente");
        btn_Docente.setFocusable(false);
        btn_Docente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Docente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_Docente);

        btn_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user.png"))); // NOI18N
        btn_Usuario.setText("Usuario");
        btn_Usuario.setFocusable(false);
        btn_Usuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Usuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UsuarioActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_Usuario);

        btn_Semestre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/applications.png"))); // NOI18N
        btn_Semestre.setText("Semestre");
        btn_Semestre.setFocusable(false);
        btn_Semestre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Semestre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_Semestre);

        btn_Criterio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/application_edit.png"))); // NOI18N
        btn_Criterio.setText("Criterio");
        btn_Criterio.setFocusable(false);
        btn_Criterio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Criterio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_Criterio);

        btn_Modelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/blog_post_edit.png"))); // NOI18N
        btn_Modelo.setText("Modelo");
        btn_Modelo.setFocusable(false);
        btn_Modelo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Modelo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_Modelo);

        btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/remove.png"))); // NOI18N
        btn_Salir.setText("Salir");
        btn_Salir.setFocusable(false);
        btn_Salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_Salir);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1037, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );

        jLabel1.setText("Fecha:");

        jScrollPane1.setViewportView(jTree1);

        jLabel2.setText("Usuario: ");

        Mnu_Archivo.setText("Archivo");
        jMenuBar1.add(Mnu_Archivo);

        Mnu_Mantenimiento.setText("Mantenimiento");

        Mante_Usuario.setText("Usuario");
        Mante_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mante_UsuarioActionPerformed(evt);
            }
        });
        Mnu_Mantenimiento.add(Mante_Usuario);

        Mante_Docente.setText("Docente");
        Mnu_Mantenimiento.add(Mante_Docente);

        Mante_Semestre.setText("Semestre");
        Mante_Semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mante_SemestreActionPerformed(evt);
            }
        });
        Mnu_Mantenimiento.add(Mante_Semestre);

        Mante_TipoDocumento.setText("TIpo Documento");
        Mnu_Mantenimiento.add(Mante_TipoDocumento);

        jMenuBar1.add(Mnu_Mantenimiento);

        Mnu_Consulta.setText("Consultas");
        jMenuBar1.add(Mnu_Consulta);

        Mnu_Reporte.setText("Reportes");
        jMenuBar1.add(Mnu_Reporte);

        Mnu_Ayuda.setText("Ayuda");
        jMenuBar1.add(Mnu_Ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Mante_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mante_UsuarioActionPerformed
        abrirFrmUsuario();
    }//GEN-LAST:event_Mante_UsuarioActionPerformed

    private void Mante_SemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mante_SemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mante_SemestreActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        salir();
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        lbl_usuario.setText("Desconectado...");
        if (Estado == 1) {
            obtenerUsuario();
        }
        else{
            //ocultar
            Mnu_Archivo.setVisible(false);
            
            //deshabilitar
            Mnu_Reporte.setEnabled(false);
            Mante_Docente.setEnabled(false);
            btn_Criterio.setEnabled(false);
        }
    }//GEN-LAST:event_formComponentShown

    private void btn_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UsuarioActionPerformed
        abrirFrmUsuario();
    }//GEN-LAST:event_btn_UsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Pricipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem Mante_Docente;
    private javax.swing.JMenuItem Mante_Semestre;
    private javax.swing.JMenuItem Mante_TipoDocumento;
    private javax.swing.JMenuItem Mante_Usuario;
    private javax.swing.JMenu Mnu_Archivo;
    private javax.swing.JMenu Mnu_Ayuda;
    private javax.swing.JMenu Mnu_Consulta;
    private javax.swing.JMenu Mnu_Mantenimiento;
    private javax.swing.JMenu Mnu_Reporte;
    private javax.swing.JButton btn_Criterio;
    private javax.swing.JButton btn_Docente;
    private javax.swing.JButton btn_Modelo;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton btn_Semestre;
    private javax.swing.JButton btn_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lbl_Fecha;
    private javax.swing.JLabel lbl_usuario;
    // End of variables declaration//GEN-END:variables
}
