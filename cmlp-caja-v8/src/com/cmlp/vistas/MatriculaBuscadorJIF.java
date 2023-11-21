package com.cmlp.vistas;

import com.cmlp.conexion.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MatriculaBuscadorJIF extends javax.swing.JInternalFrame {

    DefaultTableModel dtm;
    DBConexion dbconexion = new DBConexion();

    public MatriculaBuscadorJIF() {
        initComponents();
        cargarTablaAlumnos();
    }

    private void cargarTablaAlumnos() {
        String[] titulos = {"DNI", "Apellidos", "Nombres", "Sexo", "Edad", "Grado", "Seccion"};
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
        String sql = "SELECT * FROM alumno WHERE CONCAT(alumno_dni,apellidos,nombres) LIKE '%" + alumno + "%' order by apellidos";

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
        popMenuItemEnviar = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarAlumno = new javax.swing.JTextField();
        btnListarAlumnos = new javax.swing.JButton();
        btnRegistrarAlumnos = new javax.swing.JButton();

        popMenuItemEnviar.setText("Enviar");
        popMenuItemEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuItemEnviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popMenuItemEnviar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

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

        jLabel1.setText("Buscar Alumno:");

        txtBuscarAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarAlumnoKeyReleased(evt);
            }
        });

        btnListarAlumnos.setText("Listar Todos");
        btnListarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAlumnosActionPerformed(evt);
            }
        });

        btnRegistrarAlumnos.setText("Registrar Alumno");
        btnRegistrarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAlumnosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(btnListarAlumnos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(btnRegistrarAlumnos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarAlumnos)
                    .addComponent(btnRegistrarAlumnos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoKeyReleased
       String alumno = txtBuscarAlumno.getText().trim().toUpperCase();
        buscarAlumnosDatos(alumno);
    }//GEN-LAST:event_txtBuscarAlumnoKeyReleased

    private void popMenuItemEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuItemEnviarActionPerformed
       int fila = tabAlumnos.getSelectedRow();
       
       try {
             if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato..!!");
                } else {
                     
                    String dni = (String) tabAlumnos.getValueAt(fila, 0);                    
                    String apellidos = (String) tabAlumnos.getValueAt(fila, 1);
                    String nombres = (String) tabAlumnos.getValueAt(fila, 2);
                    String grado = (String) tabAlumnos.getValueAt(fila, 5);
                    String seccion = (String) tabAlumnos.getValueAt(fila, 6);
                    

                    MatriculaJIF.txtDNI.setText(dni);
                    MatriculaJIF.txtNombresAlumno.setText(apellidos  + " " + nombres);                      
                    MatriculaJIF.txtGrado.setText(grado);
                    MatriculaJIF.txtSeccion.setText(seccion);
                    
                    
                    this.dispose();
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ENVIAR DATOS A LA BOLETA");
        }
       
       
    }//GEN-LAST:event_popMenuItemEnviarActionPerformed

    private void btnListarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAlumnosActionPerformed
        txtBuscarAlumno.setText("");
        cargarTablaAlumnos();
    }//GEN-LAST:event_btnListarAlumnosActionPerformed

    private void btnRegistrarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAlumnosActionPerformed
         AlumnosCrudJIF crud = new AlumnosCrudJIF();
         PrincipalCMLPJF.jdbPanelPrincipal.add(crud);
         crud.setVisible(true);
         dispose();
    }//GEN-LAST:event_btnRegistrarAlumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarAlumnos;
    private javax.swing.JButton btnRegistrarAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem popMenuItemEnviar;
    private javax.swing.JTable tabAlumnos;
    private javax.swing.JTextField txtBuscarAlumno;
    // End of variables declaration//GEN-END:variables
}
