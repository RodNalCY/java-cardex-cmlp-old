package com.cmlp.vistas;

import com.cmlp.conexion.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;

public class BajasJIF extends javax.swing.JInternalFrame {

    DBConexion dbconexion = new DBConexion();

    public BajasJIF() {
        initComponents();
        setLocation(10, 60);
        cargarTablaAlumnos();
        txtCalendarioBuscar.setEnabled(false);
        txtCalendarioBuscar.setDate(null);
        btnBuscarBajas.setEnabled(false);
        tabAlumnosBajas.getColumnModel().getColumn(2).setPreferredWidth(400);
    }

    private void cargarTablaAlumnos() {
        String[] titulos = {"Periodo","DNI", "Alumno", "Sexo", "Edad", "Grado", "Seccion"};
        String[] registros = new String[7];
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(titulos);

        Connection cn = dbconexion.getConnection();
        String sql = "select m.periodo,a.alumno_dni,concat(a.apellidos,', ',a.nombres)as alumno,a.sexo,a.edad,a.grado,a.seccion"
                + " from alumno a"
                + " join matricula as m on m.alumno_dni=a.alumno_dni"
                + " where a.estado='0'"
                + " order by m.periodo;";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("periodo");
                registros[1] = rs.getString("alumno_dni");
                registros[2] = rs.getString("alumno");
                registros[3] = rs.getString("sexo");
                registros[4] = rs.getString("edad");
                registros[5] = rs.getString("grado");
                registros[6] = rs.getString("seccion");
                dtm.addRow(registros);
            }
            tabAlumnosBajas.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButonGroup = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popMenuItemDarAlta = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabAlumnosBajas = new javax.swing.JTable();
        txtCalendarioBuscar = new com.toedter.calendar.JDateChooser();
        btnBuscarBajas = new javax.swing.JButton();
        rbFecha = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        btnImprimirPagantes = new javax.swing.JButton();

        popMenuItemDarAlta.setText("Dar Alta");
        popMenuItemDarAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuItemDarAltaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popMenuItemDarAlta);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tabAlumnosBajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabAlumnosBajas.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tabAlumnosBajas);

        btnBuscarBajas.setText("Buscar");
        btnBuscarBajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBajasActionPerformed(evt);
            }
        });

        radioButonGroup.add(rbFecha);
        rbFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbFecha.setText("Fecha");
        rbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFechaActionPerformed(evt);
            }
        });

        radioButonGroup.add(rbTodos);
        rbTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbTodos.setSelected(true);
        rbTodos.setText("Todos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        btnImprimirPagantes.setText("Imprimir");
        btnImprimirPagantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirPagantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbTodos)
                            .addComponent(rbFecha))
                        .addGap(18, 18, 18)
                        .addComponent(txtCalendarioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarBajas)
                        .addGap(81, 81, 81)
                        .addComponent(btnImprimirPagantes)
                        .addGap(0, 345, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarBajas)
                        .addComponent(btnImprimirPagantes))
                    .addComponent(txtCalendarioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFechaActionPerformed
        if (rbFecha.isSelected() == true) {
            txtCalendarioBuscar.setEnabled(true);
            btnBuscarBajas.setEnabled(true);
        }
    }//GEN-LAST:event_rbFechaActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        if (rbTodos.isSelected() == true) {
            txtCalendarioBuscar.setEnabled(false);
            txtCalendarioBuscar.setDate(null);
            cargarTablaAlumnos();
            btnBuscarBajas.setEnabled(false);
        }
    }//GEN-LAST:event_rbTodosActionPerformed

    private void btnBuscarBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBajasActionPerformed
        String[] titulos = {"Periodo","DNI", "Alumno", "Sexo", "Edad", "Grado", "Seccion"};
        String[] registros = new String[7];
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(titulos);

        String obtener = "";
        String sql = "";

        if (rbFecha.isSelected() == true) {
            Date fecha = txtCalendarioBuscar.getDate();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
            obtener = "" + formato.format(fecha);
            
            sql = "select m.periodo,a.alumno_dni,concat(a.apellidos,', ',a.nombres)as alumno,a.sexo,a.edad,a.grado,a.seccion,a.estado"
                + " from alumno a"
                + " join matricula as m on m.alumno_dni=a.alumno_dni"
                + " where a.estado='0' and m.periodo>=?"
                + " order by m.periodo;";
        }

        Connection con = dbconexion.getConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obtener);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("periodo");
                registros[1] = rs.getString("alumno_dni");
                registros[2] = rs.getString("alumno");
                registros[3] = rs.getString("sexo");
                registros[4] = rs.getString("edad");
                registros[5] = rs.getString("grado");
                registros[6] = rs.getString("seccion");
                dtm.addRow(registros);
            }
            tabAlumnosBajas.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }


    }//GEN-LAST:event_btnBuscarBajasActionPerformed

    private void btnImprimirPagantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirPagantesActionPerformed
        Connection con = dbconexion.getConnection();
        int fila = tabAlumnosBajas.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No ha selecionado ninguna fila");
        } else {
            String periodo = tabAlumnosBajas.getValueAt(fila, 0).toString();
            try {
                JasperReport reporte = (JasperReport) JRLoader.loadObject("src/com/cmlp/reportes/BajasReport.jasper");
                Map parametro = new HashedMap();
                parametro.put("periodo", periodo);
                JasperPrint print = JasperFillManager.fillReport(reporte, parametro, con);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Bajas de Alumnos");
                viewer.setVisible(true);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Error al mostrar Reporte: " + e);
            }
        }

    }//GEN-LAST:event_btnImprimirPagantesActionPerformed

    private void popMenuItemDarAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuItemDarAltaActionPerformed
        int fila = tabAlumnosBajas.getSelectedRow();
        String dni = tabAlumnosBajas.getValueAt(fila,1).toString();
        if (fila>=0) {
            try {
                String sql = "UPDATE alumno SET estado='1' WHERE alumno_dni=?";
                Connection con = dbconexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, dni);
                pst.executeUpdate();
                
                cargarTablaAlumnos();
                JOptionPane.showMessageDialog(null, "Se dio de Alta al Alumno");
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL: "+e);
            }
        }else{
           JOptionPane.showMessageDialog(null, "Debe Seleccionar una Fila...");
        }
    }//GEN-LAST:event_popMenuItemDarAltaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarBajas;
    private javax.swing.JButton btnImprimirPagantes;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem popMenuItemDarAlta;
    private javax.swing.ButtonGroup radioButonGroup;
    private javax.swing.JRadioButton rbFecha;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tabAlumnosBajas;
    private com.toedter.calendar.JDateChooser txtCalendarioBuscar;
    // End of variables declaration//GEN-END:variables
}
