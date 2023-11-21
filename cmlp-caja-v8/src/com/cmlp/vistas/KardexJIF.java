package com.cmlp.vistas;

import com.cmlp.conexion.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KardexJIF extends javax.swing.JInternalFrame {

    DefaultTableModel dtm;
    DBConexion dbconexion = new DBConexion();

    public KardexJIF() {
        initComponents();
        cargarTablaAlumnos();
        setLocation(100, 60);
        tabAlumnosKardex.getColumnModel().getColumn(1).setPreferredWidth(320);
        tabAlumnosKardex.getColumnModel().getColumn(2).setPreferredWidth(320);
    }

    private void cargarTablaAlumnos() {
        String[] titulos = {"DNI", "Apellidos", "Nombres", "Grado", "Sección"};
        String[] registros = new String[5];
        dtm = new DefaultTableModel(null, titulos);

        Connection cn = dbconexion.getConnection();
        String sql = "select a.alumno_dni,a.nombres,a.apellidos,a.grado,a.seccion"
                + " from alumno as a"
                + " join matricula as m on m.alumno_dni=a.alumno_dni"
                + " join pagos as p on p.id_matricula=m.id_matricula"
                + " group by a.alumno_dni,a.nombres,a.apellidos,a.grado,a.seccion";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("alumno_dni");
                registros[1] = rs.getString("apellidos");
                registros[2] = rs.getString("nombres");
                registros[3] = rs.getString("grado");
                registros[4] = rs.getString("seccion");
                dtm.addRow(registros);
            }
            tabAlumnosKardex.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }

    }

    private void buscarAlumnosDocumentos(String datos) {

        String[] titulos = {"DNI", "Apellidos", "Nombres", "Grado", "Sección"};
        String[] registros = new String[5];
        dtm = new DefaultTableModel(null, titulos);

        Connection cn = dbconexion.getConnection();
        String sql = "select a.alumno_dni,a.nombres,a.apellidos,a.grado,a.seccion"
                + " from alumno as a"
                + " join matricula as m on m.alumno_dni=a.alumno_dni"
                + " join pagos as p on p.id_matricula=m.id_matricula"
                + " where concat(a.alumno_dni,a.nombres,a.apellidos) LIKE '%"+datos+"%'"
                + " group by a.alumno_dni,a.nombres,a.apellidos,a.grado,a.seccion;";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("alumno_dni");
                registros[1] = rs.getString("apellidos");
                registros[2] = rs.getString("nombres");
                registros[3] = rs.getString("grado");
                registros[4] = rs.getString("seccion");
                dtm.addRow(registros);
            }
            tabAlumnosKardex.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        popMenuItemDetalle = new javax.swing.JMenuItem();
        txtKardexAlumno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnListarAlumnosKardex = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabAlumnosKardex = new javax.swing.JTable();

        popMenuItemDetalle.setText("Ver Detalle");
        popMenuItemDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuItemDetalleActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popMenuItemDetalle);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        txtKardexAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKardexAlumnoKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar Alumno:");

        btnListarAlumnosKardex.setText("Listar Todos");
        btnListarAlumnosKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAlumnosKardexActionPerformed(evt);
            }
        });

        tabAlumnosKardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabAlumnosKardex.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tabAlumnosKardex);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKardexAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(btnListarAlumnosKardex)
                        .addGap(0, 212, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKardexAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnListarAlumnosKardex))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKardexAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKardexAlumnoKeyReleased
        String datos = txtKardexAlumno.getText().trim();
        buscarAlumnosDocumentos(datos);
    }//GEN-LAST:event_txtKardexAlumnoKeyReleased

    private void popMenuItemDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuItemDetalleActionPerformed
        int fila = tabAlumnosKardex.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No ha selecionado ninguna fila");
        } else {

            KardexDetalleJIF detalle = new KardexDetalleJIF();
            PrincipalCMLPJF.jdbPanelPrincipal.add(detalle);
            detalle.toFront();
            detalle.setVisible(true);

            String dni = tabAlumnosKardex.getValueAt(fila, 0).toString();
            String apellidos = tabAlumnosKardex.getValueAt(fila, 1).toString();
            String nombres = tabAlumnosKardex.getValueAt(fila, 2).toString();

            KardexDetalleJIF.txtDetalleDNI.setText(dni);
            KardexDetalleJIF.txtDetalleAlumno.setText(apellidos + " " + nombres);

            DefaultTableModel dtm = (DefaultTableModel) KardexDetalleJIF.tbDetalleKardex.getModel();
            String[] datos = new String[8];

            Connection con = dbconexion.getConnection();
            String sql = "select p.tipo_pago,m.fecha_inicio,m.fecha_final,"
                    + "p.fecha_pago,p.pago_motivo,p.importe,p.pago_mora"
                    + " from alumno as a"
                    + " join matricula as m on m.alumno_dni=a.alumno_dni"
                    + " join pagos as p on p.id_matricula=m.id_matricula"
                    + " where a.alumno_dni=?"
                    + " order by m.fecha_inicio";
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, dni);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    datos[0] = rs.getString("tipo_pago");
                    datos[1] = rs.getString("fecha_inicio");
                    datos[2] = rs.getString("fecha_final");
                    datos[3] = rs.getString("fecha_pago");
                    datos[4] = rs.getString("pago_motivo");
                    datos[5] = rs.getString("importe");
                    datos[6] = rs.getString("pago_mora");
                    dtm.addRow(datos);

                }
                KardexDetalleJIF.tbDetalleKardex.setModel(dtm);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL LLEVAR LOS DATOS");
            }

        }


    }//GEN-LAST:event_popMenuItemDetalleActionPerformed

    private void btnListarAlumnosKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAlumnosKardexActionPerformed
        cargarTablaAlumnos();
        txtKardexAlumno.setText("");
    }//GEN-LAST:event_btnListarAlumnosKardexActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarAlumnosKardex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem popMenuItemDetalle;
    private javax.swing.JTable tabAlumnosKardex;
    private javax.swing.JTextField txtKardexAlumno;
    // End of variables declaration//GEN-END:variables
}
