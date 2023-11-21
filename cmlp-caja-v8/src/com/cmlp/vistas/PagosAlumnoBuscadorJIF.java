package com.cmlp.vistas;

import com.cmlp.conexion.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PagosAlumnoBuscadorJIF extends javax.swing.JInternalFrame {

    DefaultTableModel dtm;
    DBConexion dbconexion = new DBConexion();

    public PagosAlumnoBuscadorJIF() {
        initComponents();
        cargarTablaAlumnos();
    }

    private void cargarTablaAlumnos() {
        String[] titulos = {"Periodo", "DNI", "Apellidos", "Nombres", "ID Matricula"};
        String[] registros = new String[5];
        dtm = new DefaultTableModel(null, titulos);

        Connection cn = dbconexion.getConnection();
        String sql = "SELECT m.periodo,a.alumno_dni,a.apellidos,a.nombres,m.id_matricula from matricula m"
                + " join alumno as a on a.alumno_dni=m.alumno_dni"
                + " where a.estado!='0'"
                + " order by m.periodo,alumno_dni";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("periodo");
                registros[1] = rs.getString("alumno_dni");
                registros[2] = rs.getString("apellidos");
                registros[3] = rs.getString("nombres");
                registros[4] = rs.getString("id_matricula");
                dtm.addRow(registros);
            }
            tabAlumnos.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR TABLA: " + e);
        }

    }

    private void buscarAlumnosDatosPagos(String alumno) {

        String[] titulos = {"Periodo", "DNI", "Apellidos", "Nombres", "ID Matricula"};
        String[] registros = new String[5];
        dtm = new DefaultTableModel(null, titulos);

        Connection cn = dbconexion.getConnection();
        String sql = "SELECT m.periodo,m.alumno_dni,a.apellidos,a.nombres,m.id_matricula FROM pagos as p"
                + " join matricula as m on m.id_matricula=p.id_matricula"
                + " join alumno as a on a.alumno_dni=m.alumno_dni"
                + " where concat(m.periodo,m.alumno_dni,a.apellidos,a.nombres) LIKE '%" + alumno + "%' and a.estado!='0'"
                + " group by m.periodo,m.id_matricula,m.alumno_dni,a.apellidos,a.nombres";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("periodo");
                registros[1] = rs.getString("alumno_dni");
                registros[2] = rs.getString("apellidos");
                registros[3] = rs.getString("nombres");
                registros[4] = rs.getString("id_matricula");
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
        txtBuscarAlumno = new javax.swing.JTextField();
        btnListarAlumnos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCalendarioBuscar = new com.toedter.calendar.JDateChooser();
        btnBuscarDeudores = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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

        jLabel1.setText("Buscar Alumno Codigo:");

        btnBuscarDeudores.setText("Buscar");
        btnBuscarDeudores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDeudoresActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar por Periodo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCalendarioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarDeudores)
                            .addComponent(btnListarAlumnos))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCalendarioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscarDeudores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnListarAlumnos))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoKeyReleased
        String alumno = txtBuscarAlumno.getText().trim().toUpperCase();
        buscarAlumnosDatosPagos(alumno);
    }//GEN-LAST:event_txtBuscarAlumnoKeyReleased

    private void popMenuItemEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuItemEnviarActionPerformed
        int fila = tabAlumnos.getSelectedRow();

        try {
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato..!!");
            } else {

                String periodo = (String) tabAlumnos.getValueAt(fila, 0);
                String dni = (String) tabAlumnos.getValueAt(fila, 1);
                String apellidos = (String) tabAlumnos.getValueAt(fila, 2);
                String nombres = (String) tabAlumnos.getValueAt(fila, 3);
                String id_matricula = (String) tabAlumnos.getValueAt(fila, 4);

                PagosJIF.txtPeriodo.setText(periodo);
                PagosJIF.txtDNI.setText(dni);
                PagosJIF.txtNombresAlumno.setText(apellidos + " " + nombres);
                PagosJIF.txtCodigo.setText(id_matricula);

                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ENVIAR DATOS A LA BOLETA");
        }
    }//GEN-LAST:event_popMenuItemEnviarActionPerformed

    private void btnListarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAlumnosActionPerformed
        txtBuscarAlumno.setText("");
        txtCalendarioBuscar.setDate(null);
        cargarTablaAlumnos();
    }//GEN-LAST:event_btnListarAlumnosActionPerformed

    private void btnBuscarDeudoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDeudoresActionPerformed
        String[] titulos = {"Periodo", "DNI", "Apellidos", "Nombres", "ID Matricula"};
        String[] registros = new String[5];
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(titulos);

        Date fecha = txtCalendarioBuscar.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");

        String periodo = "" + formato.format(fecha);

        String sql = "SELECT m.periodo,m.alumno_dni,a.apellidos,a.nombres,m.id_matricula FROM pagos as p"
                + " join matricula as m on m.id_matricula=p.id_matricula"
                + " join alumno as a on a.alumno_dni=m.alumno_dni"
                + " where m.periodo=? and a.estado!=0"
                + " group by m.periodo,m.id_matricula,m.alumno_dni,a.apellidos,a.nombres";

        Connection con = dbconexion.getConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, periodo);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("periodo");
                registros[1] = rs.getString("alumno_dni");
                registros[2] = rs.getString("apellidos");
                registros[3] = rs.getString("nombres");
                registros[4] = rs.getString("id_matricula");
                dtm.addRow(registros);
            }
            tabAlumnos.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }

    }//GEN-LAST:event_btnBuscarDeudoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarDeudores;
    private javax.swing.JButton btnListarAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem popMenuItemEnviar;
    private javax.swing.JTable tabAlumnos;
    private javax.swing.JTextField txtBuscarAlumno;
    private com.toedter.calendar.JDateChooser txtCalendarioBuscar;
    // End of variables declaration//GEN-END:variables
}
