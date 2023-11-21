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

public class PagantesJIF extends javax.swing.JInternalFrame {

    DBConexion dbconexion = new DBConexion();

    public PagantesJIF() {
        initComponents();
        setLocation(10, 60);
        cargarTablaAlumnos();
        txtCalendarioBuscar.setEnabled(false);
        txtCalendarioBuscar.setDate(null);
        btnBuscarPagante.setEnabled(false);
        tabAlumnosPagantes.getColumnModel().getColumn(2).setPreferredWidth(350);
    }

    private void cargarTablaAlumnos() {
        String[] titulos = {"Periodo", "DNI", "Alumno", "Importe", "F. Inicio", "F. Vencimiento", "Fecha Pago", "Mora"};
        String[] registros = new String[8];
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(titulos);

        Connection cn = dbconexion.getConnection();
        String sql = "select m.periodo,a.alumno_dni,concat(a.apellidos,', ',a.nombres)as alumno, p.importe,m.fecha_inicio,m.fecha_final,p.fecha_pago,p.pago_mora"
                + " from alumno as a"
                + " join matricula as m on m.alumno_dni=a.alumno_dni"
                + " join pagos as p on p.id_matricula=m.id_matricula"
                + " where p.importe!='0.00'"
                + " group by a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("periodo");
                registros[1] = rs.getString("alumno_dni");
                registros[2] = rs.getString("alumno");
                registros[3] = rs.getString("importe");
                registros[4] = rs.getString("fecha_inicio");
                registros[5] = rs.getString("fecha_final");
                registros[6] = rs.getString("fecha_pago");
                registros[7] = rs.getString("pago_mora");
                dtm.addRow(registros);
            }
            tabAlumnosPagantes.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButonGroup = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabAlumnosPagantes = new javax.swing.JTable();
        txtCalendarioBuscar = new com.toedter.calendar.JDateChooser();
        btnBuscarPagante = new javax.swing.JButton();
        rbFecha = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        btnImprimirPagantes = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tabAlumnosPagantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabAlumnosPagantes);

        btnBuscarPagante.setText("Buscar");
        btnBuscarPagante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPaganteActionPerformed(evt);
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
                        .addComponent(btnBuscarPagante)
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
                        .addComponent(btnBuscarPagante)
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
            btnBuscarPagante.setEnabled(true);
        }
    }//GEN-LAST:event_rbFechaActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        if (rbTodos.isSelected() == true) {
            txtCalendarioBuscar.setEnabled(false);
            txtCalendarioBuscar.setDate(null);
            btnBuscarPagante.setEnabled(false);
            cargarTablaAlumnos();
        }
    }//GEN-LAST:event_rbTodosActionPerformed

    private void btnBuscarPaganteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPaganteActionPerformed
        String[] titulos = {"Periodo", "DNI", "Alumno", "Importe", "F. Inicio", "F. Vencimiento", "Fecha Pago", "Mora"};
        String[] registros = new String[8];
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(titulos);

        String obtener = "";
        String sql = "";

        if (rbFecha.isSelected() == true) {
            Date fecha = txtCalendarioBuscar.getDate();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
            obtener = "" + formato.format(fecha);
            sql = "select m.periodo,a.alumno_dni,concat(a.apellidos,', ',a.nombres)as alumno, p.importe,m.fecha_inicio,m.fecha_final,p.fecha_pago,p.pago_mora"
                    + " from alumno as a"
                    + " join matricula as m on m.alumno_dni=a.alumno_dni"
                    + " join pagos as p on p.id_matricula=m.id_matricula"
                    + " where p.importe!='0.00' and  m.periodo=?"
                    + " group by a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;";
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
                registros[3] = rs.getString("importe");
                registros[4] = rs.getString("fecha_inicio");
                registros[5] = rs.getString("fecha_final");
                registros[6] = rs.getString("fecha_pago");
                registros[7] = rs.getString("pago_mora");
                dtm.addRow(registros);
            }
            tabAlumnosPagantes.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }


    }//GEN-LAST:event_btnBuscarPaganteActionPerformed

    private void btnImprimirPagantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirPagantesActionPerformed
        Connection con = dbconexion.getConnection();
        int fila = tabAlumnosPagantes.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No ha selecionado ninguna fila");
        } else {
            String periodo = tabAlumnosPagantes.getValueAt(fila, 0).toString();
            try {
                JasperReport reporte = (JasperReport)JRLoader.loadObject("src/com/cmlp/reportes/PagantesReport.jasper");
                Map parametro = new HashedMap();
                parametro.put("periodo", periodo);
                JasperPrint print = JasperFillManager.fillReport(reporte, parametro,con);
                JasperViewer viewer = new JasperViewer(print,false);
                viewer.setTitle("Pagantes");
                viewer.setVisible(true);
            } catch (JRException e) {
                 JOptionPane.showMessageDialog(null, "Error al mostrar Reporte: "+e);
            }
        }

    }//GEN-LAST:event_btnImprimirPagantesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPagante;
    private javax.swing.JButton btnImprimirPagantes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup radioButonGroup;
    private javax.swing.JRadioButton rbFecha;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tabAlumnosPagantes;
    private com.toedter.calendar.JDateChooser txtCalendarioBuscar;
    // End of variables declaration//GEN-END:variables
}
