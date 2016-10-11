package Presentacion;

import Negocio.ClsNegocioUsuario;
import Negocio.ClsNegocioDocente;
import Entidad.ClsEntidadDocente;
import Entidad.ClsEntidadUsuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frm_Usuario extends javax.swing.JInternalFrame {

    String codigo;
    int registro;
    String idDoc[] = new String[100];
    static int iContador;
    static ResultSet rs = null;
    
    public frm_Usuario() {
        initComponents();
        llenarComboEstado();
        llenarComboNivel();
        llenarComboDocente();
        desactivarCampos();
        listarTabla();
        activarBotones(true, false, false, false, false);
    }
    
    void llenarComboNivel(){
        cmb_Nivel.removeAllItems();
        cmb_Nivel.addItem("Administrador");
        cmb_Nivel.addItem("Supervisor");
        cmb_Nivel.addItem("Usuario");
    }
    
    void llenarComboEstado(){
        cmb_Estado.removeAllItems();
        cmb_Estado.addItem("Activo");
        cmb_Estado.addItem("Inactivo");
    }
    
    void activarCampos(){
        cmb_Docente.setEnabled(true);
        txt_Usuario.setEnabled(true);
        txt_Password.setEnabled(true);
        cmb_Nivel.setEnabled(true);
        cmb_Estado.setEnabled(true);
    }
    
    void desactivarCampos(){
        cmb_Docente.setEnabled(false);
        txt_Usuario.setEnabled(false);
        txt_Password.setEnabled(false);
        cmb_Nivel.setEnabled(false);
        cmb_Estado.setEnabled(false);
    }
    
    void limpiarCampos(){
        txt_Usuario.setText("");
        txt_Password.setText("");
    }
    
    void activarBotones(boolean n, boolean g, boolean m, boolean e, boolean c){
        btn_Nuevo.setEnabled(n);
        btn_Grabar.setEnabled(g);
        btn_Modificar.setEnabled(m);
        btn_Eliminar.setEnabled(e);
        btn_Cancelar.setEnabled(c);
    }
    
    void llenarComboDocente(){
        ClsNegocioDocente docente = new ClsNegocioDocente();
        
        ArrayList<ClsEntidadDocente> doc = docente.ListarDocente();
        
        Iterator iterator = doc.iterator();
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        
        modeloCombo.removeAllElements();
        
        String campo[] = new String[3];
        
        iContador = 0;
        
        while (iterator.hasNext()) {
            ClsEntidadDocente objDocente= new ClsEntidadDocente();
            objDocente = (ClsEntidadDocente) iterator.next();
            idDoc[iContador] = objDocente.getCodDoc();
            campo[0] = objDocente.getCodDoc();
            campo[1] = objDocente.getApelDoc();
            campo[2] = objDocente.getNombDoc();
            
            modeloCombo.addElement(objDocente.getApelDoc());
            iContador++;
        }
        
        cmb_Docente.setModel(modeloCombo);
    }

    void listarTabla(){
        String titulos[] = {"Codigo",
                            "Apellidos",
                            "Nombres",
                            "Usuario",
                            "Password",
                            "Nivel",
                            "Estado"};
        
        ClsNegocioUsuario usuarios = new ClsNegocioUsuario();
        ArrayList<ClsEntidadUsuario> usuario = usuarios.ListarUsuario();
        
        Iterator iterator = usuario.iterator();
        
        DefaultTableModel modeloTabla = new DefaultTableModel(null, titulos);
        
        String campo[] = new String[7];
        
        while (iterator.hasNext()) {
            ClsEntidadUsuario objUsuario = new ClsEntidadUsuario();
            
            objUsuario = (ClsEntidadUsuario) iterator.next();
            
            campo[0] = objUsuario.getIdUs();
            campo[1] = objUsuario.getApelDoc();
            campo[2] = objUsuario.getNombDoc();
            campo[3] = objUsuario.getNombUsu();
            campo[4] = objUsuario.getPassUsu();
            campo[5] = objUsuario.getNivelUsu();
            campo[6] = objUsuario.getEstadoUsu();
            
            modeloTabla.addRow(campo);
        }
        tbl_Usuario.setModel(modeloTabla);
    }
   
    void seleccionarTabla(){
        DefaultTableModel modeloTabla = new DefaultTableModel();
        //seleccionar un registro en la tabla
        //almacena en "REGISTRO" el valor seleccionado de la tabla
        registro = tbl_Usuario.getSelectedRow();
        
        if (registro == -1) {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro.");
        }
        else{
            modeloTabla = (DefaultTableModel) tbl_Usuario.getModel();
            codigo = ((String) modeloTabla.getValueAt(registro, 0));
            cmb_Docente.setSelectedItem((String) modeloTabla.getValueAt(registro, 1));
            txt_Usuario.setText((String) modeloTabla.getValueAt(registro, 3));
            txt_Password.setText((String) modeloTabla.getValueAt(registro, 4));
            cmb_Nivel.setSelectedItem((String) modeloTabla.getValueAt(registro, 5));
            cmb_Estado.setSelectedItem((String) modeloTabla.getValueAt(registro, 6));
            
            activarBotones(true, false, true, true, true);
            activarCampos();
        }
    }
    
    void recorrerTabla(){
        DefaultTableModel modeloTabla = new DefaultTableModel();
        
        if (registro == -1) {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro.");
        }
        else{
            modeloTabla = (DefaultTableModel) tbl_Usuario.getModel();
            codigo = ((String) modeloTabla.getValueAt(registro, 0));
            cmb_Docente.setSelectedItem((String) modeloTabla.getValueAt(registro, 1));
            txt_Usuario.setText((String) modeloTabla.getValueAt(registro, 3));
            txt_Password.setText((String) modeloTabla.getValueAt(registro, 4));
            cmb_Nivel.setSelectedItem((String) modeloTabla.getValueAt(registro, 5));
            cmb_Estado.setSelectedItem((String) modeloTabla.getValueAt(registro, 6));
            
            activarBotones(true, false, true, true, true);
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmb_Docente = new javax.swing.JComboBox<>();
        txt_Password = new javax.swing.JPasswordField();
        txt_Usuario = new javax.swing.JTextField();
        cmb_Nivel = new javax.swing.JComboBox<>();
        cmb_Estado = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btn_Nuevo = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Grabar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Usuario = new javax.swing.JTable();
        btn_Primero = new javax.swing.JButton();
        btn_Anterior = new javax.swing.JButton();
        btn_Siguiente = new javax.swing.JButton();
        btn_Ultimo = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("MANTENIMIENTO DE USUARIOS");

        jLabel3.setText("Docente:");

        jLabel4.setText("Usuario:");

        jLabel5.setText("Password:");

        jLabel6.setText("Nivel:");

        jLabel7.setText("Estado:");

        cmb_Docente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmb_Nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmb_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_Nuevo.setText("Nuevo");
        btn_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NuevoActionPerformed(evt);
            }
        });

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        btn_Grabar.setText("Grabar");
        btn_Grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GrabarActionPerformed(evt);
            }
        });

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btn_Modificar.setText("Modificar");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });

        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Grabar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Modificar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Nuevo)
                    .addComponent(btn_Eliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_Grabar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Modificar)
                    .addComponent(btn_Salir))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        tbl_Usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_UsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Usuario);

        btn_Primero.setText("Primero");
        btn_Primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrimeroActionPerformed(evt);
            }
        });

        btn_Anterior.setText("Anterior");
        btn_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnteriorActionPerformed(evt);
            }
        });

        btn_Siguiente.setText("Siguiente");
        btn_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiguienteActionPerformed(evt);
            }
        });

        btn_Ultimo.setText("Ultimo");
        btn_Ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UltimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Primero)
                                .addGap(54, 54, 54)
                                .addComponent(btn_Anterior))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_Password)
                                    .addComponent(cmb_Docente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_Usuario)
                                    .addComponent(cmb_Nivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmb_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Siguiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Ultimo)))))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmb_Docente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmb_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmb_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Primero)
                    .addComponent(btn_Anterior)
                    .addComponent(btn_Siguiente)
                    .addComponent(btn_Ultimo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_UsuarioMouseClicked
        seleccionarTabla();
    }//GEN-LAST:event_tbl_UsuarioMouseClicked

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
        limpiarCampos();
        activarCampos();
        //focus en la caja de texto usuario
        txt_Usuario.requestFocus();
        activarBotones(false, true, false, false, true);
    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_GrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GrabarActionPerformed
        //instanciar la clase entidad usuario
        ClsNegocioUsuario usuarioNegocio = new ClsNegocioUsuario();
        ClsEntidadUsuario usuarioEntidad = new ClsEntidadUsuario();
        
        //agregar los datos a la clase entidad para despues ser guardado en la BD
        usuarioEntidad.setCodDoc(idDoc[cmb_Docente.getSelectedIndex()]);
        usuarioEntidad.setNombUsu(txt_Usuario.getText());
        usuarioEntidad.setPassUsu(txt_Password.getText());
        usuarioEntidad.setNivelUsu(cmb_Nivel.getSelectedItem().toString());
        usuarioEntidad.setEstadoUsu(cmb_Estado.getSelectedItem().toString());
        
        //guargas el objeto agregado de usuario
        usuarioNegocio.AgregarUsuario(usuarioEntidad);
        
        //refrescar tabla
        listarTabla();
        limpiarCampos();
        activarBotones(true, false, false, false, false);
        
    }//GEN-LAST:event_btn_GrabarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        //instanciar la clase entidad usuario
        ClsNegocioUsuario usuarioNegocio = new ClsNegocioUsuario();
        ClsEntidadUsuario usuarioEntidad = new ClsEntidadUsuario();
        
        //agregar los datos a la clase entidad para despues ser guardado en la BD
        usuarioEntidad.setCodDoc(idDoc[cmb_Docente.getSelectedIndex()]);
        usuarioEntidad.setNombUsu(txt_Usuario.getText());
        usuarioEntidad.setPassUsu(txt_Password.getText());
        usuarioEntidad.setNivelUsu(cmb_Nivel.getSelectedItem().toString());
        usuarioEntidad.setEstadoUsu(cmb_Estado.getSelectedItem().toString());
        
        //guargas el objeto agregado de usuario
        usuarioNegocio.ModificarUsuario(codigo,usuarioEntidad);
        
        //refrescar tabla
        listarTabla();
        limpiarCampos();
        activarBotones(true, false, false, false, false);
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        int respuesta;
        
        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea ELIMINAR el registro?",
                                                  "Pregunta",0);
        
        if (respuesta == 0) {
            ClsNegocioUsuario usuarioNegocio = new ClsNegocioUsuario();
            usuarioNegocio.EliminarUsuario(codigo);
            listarTabla();
            limpiarCampos();
            activarBotones(true, false, false, false, false);
            desactivarCampos();
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        int respuesta;
        
        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la operación?",
                                                  "Pregunta",0);
        
        if (respuesta == 0) {
            limpiarCampos();
            txt_Usuario.setEditable(true);
            activarBotones(true, false, false, false, false);
            desactivarCampos();
        }
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btn_PrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrimeroActionPerformed
        registro = 0;
        recorrerTabla();
        tbl_Usuario.changeSelection(registro,0,false,false);
    }//GEN-LAST:event_btn_PrimeroActionPerformed

    private void btn_UltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UltimoActionPerformed
        registro = tbl_Usuario.getRowCount()-1;
        recorrerTabla();
        tbl_Usuario.changeSelection(tbl_Usuario.getRowCount()-1, 0, false, false);
    }//GEN-LAST:event_btn_UltimoActionPerformed

    private void btn_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnteriorActionPerformed
        registro = registro - 1;
        if (registro < 0) {
            registro = 0;
            JOptionPane.showMessageDialog(null, "Primer Registro");
        }
        recorrerTabla();
        tbl_Usuario.changeSelection(registro,0,false,false);
    }//GEN-LAST:event_btn_AnteriorActionPerformed

    private void btn_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiguienteActionPerformed
        registro = registro + 1;
        if (registro > tbl_Usuario.getRowCount()-1) {
            registro = tbl_Usuario.getRowCount()-1;
            JOptionPane.showMessageDialog(null, "Ultimo Registro");
        }
        recorrerTabla();
        tbl_Usuario.changeSelection(registro,0,false,false);
    }//GEN-LAST:event_btn_SiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Anterior;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Grabar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_Primero;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton btn_Siguiente;
    private javax.swing.JButton btn_Ultimo;
    private javax.swing.JComboBox<String> cmb_Docente;
    private javax.swing.JComboBox<String> cmb_Estado;
    private javax.swing.JComboBox<String> cmb_Nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Usuario;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_Usuario;
    // End of variables declaration//GEN-END:variables
}
