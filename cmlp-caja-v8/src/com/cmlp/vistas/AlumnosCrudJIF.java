package com.cmlp.vistas;

import com.cmlp.conexion.DBConexion;
import com.cmlp.util.VerificarCampo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AlumnosCrudJIF extends javax.swing.JInternalFrame {

    DefaultTableModel dtm;
    DBConexion dbconexion = new DBConexion();
    VerificarCampo c = new VerificarCampo();

    public AlumnosCrudJIF() {
        initComponents();
        this.setLocation(50, 50);
        cargarTablaAlumnos();
        bloquearBotones();
        c.validarSoloNumeros(txtDNI);
        c.limitarCaracteres(txtDNI, 8);
        c.validarSoloNumeros(txtEdad);
        c.limitarCaracteres(txtEdad, 2);
       
        c.validarSoloLetras(txtNombres);
        c.validarSoloLetras(txtApellidos);
        tabAlumnos.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabAlumnos.getColumnModel().getColumn(1).setPreferredWidth(310);
        tabAlumnos.getColumnModel().getColumn(2).setPreferredWidth(310);
    }

    private void cargarTablaAlumnos() {
        String[] titulos = {"DNI", "Apellidos", "Nombres", "Sexo", "Edad", "Grado", "Sección"};
        String[] registros = new String[7];
        dtm = new DefaultTableModel(null, titulos);
        

        Connection cn = dbconexion.getConnection();
        String sql = "SELECT * FROM alumno where estado='1' order by apellidos";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("alumno_dni");
                registros[1] = rs.getString("apellidos");
                registros[2] = rs.getString("nombres");
                registros[3] = rs.getString("sexo");
                registros[4] = rs.getString("edad");
                registros[5] = rs.getString("grado");
                registros[6] = rs.getString("seccion");
                dtm.addRow(registros);
            }
            tabAlumnos.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }
    }

    private void buscarAlumnosDatos(String alumno) {

        String[] titulos = {"DNI", "Apellidos", "Nombres", "Sexo", "Edad", "Grado", "Seccion"};
        String[] registros = new String[7];
        dtm = new DefaultTableModel(null, titulos);

        Connection cn = dbconexion.getConnection();
        String sql = "SELECT * FROM alumno WHERE where estado='1' CONCAT(alumno_dni,apellidos,nombres) LIKE '%" + alumno + "%'";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("alumno_dni");
                registros[1] = rs.getString("apellidos");
                registros[2] = rs.getString("nombres");
                registros[3] = rs.getString("sexo");
                registros[4] = rs.getString("edad");
                registros[5] = rs.getString("grado");
                registros[6] = rs.getString("seccion");
                dtm.addRow(registros);
            }
            tabAlumnos.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        popMenuItemModificar = new javax.swing.JMenuItem();
        popMenuItemDarBaja = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxGrado = new javax.swing.JComboBox<>();
        cbxSeccion = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarAlumno = new javax.swing.JTextField();

        popMenuItemModificar.setText("Modificar");
        popMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuItemModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popMenuItemModificar);

        popMenuItemDarBaja.setText("Dar Baja");
        popMenuItemDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuItemDarBajaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popMenuItemDarBaja);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Alumno"));

        jLabel3.setText("DNI:");

        jLabel4.setText("Nombres:");

        jLabel5.setText("Apellidos:");

        jLabel10.setText("Sexo:");

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        jLabel2.setText("Edad:");

        jLabel6.setText("Grado:");

        jLabel7.setText("Sección");

        cbxGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Grado", "3", "4", "5" }));

        cbxSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Grado", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDNI)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(cbxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(cbxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabAlumnos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tabAlumnos);

        jLabel1.setText("BUSCAR ALUMNO:");

        txtBuscarAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarAlumnoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        desbloquearBotones();
        limpiarCampos();
        btnActualizar.setEnabled(false);
        cbxGrado.setSelectedIndex(0);
        cbxSeccion.setSelectedIndex(0);
        cbxSexo.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String dni = txtDNI.getText().trim().toUpperCase();
        String apellidos = txtApellidos.getText().trim().toUpperCase();
        String nombres = txtNombres.getText().trim().toUpperCase();
        String edad = txtEdad.getText().trim().toUpperCase();
        String sexo = cbxSexo.getSelectedItem().toString().trim().toUpperCase();
        String grado = cbxGrado.getSelectedItem().toString().trim().toUpperCase();
        String seccion = cbxSeccion.getSelectedItem().toString().trim().toUpperCase();

        String sql = "INSERT INTO alumno VALUES(?, ?, ?, ?, ?, ?, ?,'1')";
        Connection con = dbconexion.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, dni);
            pst.setString(2, apellidos);
            pst.setString(3, nombres);
            pst.setString(4, sexo);
            pst.setString(5, edad);
            pst.setString(6, grado);
            pst.setString(7, seccion);

            int neo = pst.executeUpdate();
            if (neo > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado Correctamente...");
                bloquearBotones();
            }
            cargarTablaAlumnos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR ALUMNO: " + e);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        String dni = txtDNI.getText().trim().toUpperCase();
        String apellidos = txtApellidos.getText().trim().toUpperCase();
        String nombres = txtNombres.getText().trim().toUpperCase();
        String edad = txtEdad.getText().trim().toUpperCase();
        String sexo = cbxSexo.getSelectedItem().toString().trim().toUpperCase();
        String grado = cbxGrado.getSelectedItem().toString().trim().toUpperCase();
        String seccion = cbxSeccion.getSelectedItem().toString().trim().toUpperCase();

        Connection con = dbconexion.getConnection();
        String sql = "UPDATE alumno SET apellidos=?, nombres=?, sexo=?, edad=?, grado=?, seccion=? WHERE alumno_dni=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, apellidos);
            pst.setString(2, nombres);
            pst.setString(3, sexo);
            pst.setString(4, edad);
            pst.setString(5, grado);
            pst.setString(6, seccion);
            pst.setString(7, dni);

            pst.executeUpdate();
            cargarTablaAlumnos();
            bloquearBotones();
            JOptionPane.showMessageDialog(null, "SE ACTUALIZO CORRECTAMENTE EL ALUMNO ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR ALUMNO: " + e);
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        bloquearBotones();
        cbxGrado.setSelectedIndex(0);
        cbxSeccion.setSelectedIndex(0);
        cbxSexo.setSelectedIndex(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoKeyReleased
        String alumno = txtBuscarAlumno.getText().trim();
        buscarAlumnosDatos(alumno);
    }//GEN-LAST:event_txtBuscarAlumnoKeyReleased

    private void popMenuItemDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuItemDarBajaActionPerformed
        int fila = tabAlumnos.getSelectedRow();
        String dni = tabAlumnos.getValueAt(fila, 0).toString();

        String sql = "UPDATE alumno SET estado='0' WHERE alumno_dni=?";

        if (fila >= 0) {
            try {
                Connection con = dbconexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, dni);
                pst.executeUpdate();

                cargarTablaAlumnos();
                JOptionPane.showMessageDialog(null, "SE DIO DE BAJA AL ALUMNO...");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL DAR BAJA AL ALUMNO...");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Fila");
        }
    }//GEN-LAST:event_popMenuItemDarBajaActionPerformed

    private void popMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuItemModificarActionPerformed
        desbloquearBotones();
        btnActualizar.setEnabled(true);
        btnGuardar.setEnabled(false);
        txtDNI.setEditable(false);
        txtDNI.setEnabled(false);

        int filaModificar = tabAlumnos.getSelectedRow();

        if (filaModificar >= 0) {
            txtDNI.setText(tabAlumnos.getValueAt(filaModificar, 0).toString());
            txtApellidos.setText(tabAlumnos.getValueAt(filaModificar, 1).toString());
            txtNombres.setText(tabAlumnos.getValueAt(filaModificar, 2).toString());
            cbxSexo.setSelectedItem(tabAlumnos.getValueAt(filaModificar, 3).toString());
            txtEdad.setText(tabAlumnos.getValueAt(filaModificar, 4).toString());
            cbxGrado.setSelectedItem(tabAlumnos.getValueAt(filaModificar, 5).toString());
            cbxSeccion.setSelectedItem(tabAlumnos.getValueAt(filaModificar, 6).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila...!!!");
        }


    }//GEN-LAST:event_popMenuItemModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxGrado;
    private javax.swing.JComboBox<String> cbxSeccion;
    private javax.swing.JComboBox cbxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem popMenuItemDarBaja;
    private javax.swing.JMenuItem popMenuItemModificar;
    private javax.swing.JTable tabAlumnos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscarAlumno;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

    private void bloquearBotones() {
        txtDNI.setEnabled(false);
        txtNombres.setEnabled(false);
        txtEdad.setEnabled(false);
        txtApellidos.setEnabled(false);
        cbxSexo.setEnabled(false);
        cbxGrado.setEnabled(false);
        cbxSeccion.setEnabled(false);

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnActualizar.setEnabled(false);
    }

    private void desbloquearBotones() {
        txtDNI.setEnabled(true);
        txtNombres.setEnabled(true);
        txtEdad.setEnabled(true);
        txtApellidos.setEnabled(true);
        cbxSexo.setEnabled(true);
        cbxGrado.setEnabled(true);
        cbxSeccion.setEnabled(true);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnActualizar.setEnabled(true);
    }

    private void limpiarCampos() {
        txtDNI.setText("");
        txtNombres.setText("");
        txtEdad.setText("");
        txtApellidos.setText("");

    }

}
