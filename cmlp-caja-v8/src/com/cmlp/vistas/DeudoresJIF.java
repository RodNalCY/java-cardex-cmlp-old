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

public class DeudoresJIF extends javax.swing.JInternalFrame {

    DBConexion dbconexion = new DBConexion();

    public DeudoresJIF() {
        initComponents();
        setLocation(10, 60);
        cargarTablaAlumnos();
        txtCalendarioBuscar.setEnabled(false);
        txtCalendarioBuscar.setDate(null);
        cbGrado.setEnabled(false);
        tabAlumnosDeudores.getColumnModel().getColumn(3).setPreferredWidth(350);
    }

    private void cargarTablaAlumnos() {
        String[] titulos = {"Periodo", "Grado", "DNI", "Alumno", "Importe", "F. Inicio", "F. Vencimiento", "Fecha Pago", "Mora"};
        String[] registros = new String[9];
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(titulos);

        Connection cn = dbconexion.getConnection();
        String sql = "select m.periodo,a.grado, a.alumno_dni,concat(a.apellidos,', ',a.nombres)as alumno, m.fecha_inicio,m.fecha_final,p.importe,p.fecha_pago,p.pago_mora"
                + " from alumno as a"
                + " join matricula as m on m.alumno_dni=a.alumno_dni"
                + " join pagos as p on p.id_matricula=m.id_matricula"
                + " where p.importe='0.00'"
                + " group by a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("periodo");
                registros[1] = rs.getString("grado");
                registros[2] = rs.getString("alumno_dni");
                registros[3] = rs.getString("alumno");
                registros[4] = rs.getString("importe");
                registros[5] = rs.getString("fecha_inicio");
                registros[6] = rs.getString("fecha_final");
                registros[7] = rs.getString("fecha_pago");
                registros[8] = rs.getString("pago_mora");
                dtm.addRow(registros);
            }
            tabAlumnosDeudores.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButonGroup = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabAlumnosDeudores = new javax.swing.JTable();
        txtCalendarioBuscar = new com.toedter.calendar.JDateChooser();
        btnBuscarDeudores = new javax.swing.JButton();
        rbFecha = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        btnImprimirDeudores = new javax.swing.JButton();
        cbGrado = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tabAlumnosDeudores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabAlumnosDeudores);

        btnBuscarDeudores.setText("Buscar");
        btnBuscarDeudores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDeudoresActionPerformed(evt);
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

        btnImprimirDeudores.setText("Imprimir");
        btnImprimirDeudores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirDeudoresActionPerformed(evt);
            }
        });

        cbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5" }));

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
                        .addGap(59, 59, 59)
                        .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btnBuscarDeudores)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimirDeudores)
                        .addGap(0, 221, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarDeudores)
                        .addComponent(btnImprimirDeudores)
                        .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCalendarioBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFechaActionPerformed
        if (rbFecha.isSelected() == true) {
            txtCalendarioBuscar.setEnabled(true);
            cbGrado.setEnabled(true);
        }
    }//GEN-LAST:event_rbFechaActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        if (rbTodos.isSelected() == true) {
            txtCalendarioBuscar.setEnabled(false);
            txtCalendarioBuscar.setDate(null);
            cargarTablaAlumnos();
            cbGrado.setEnabled(false);
        }
    }//GEN-LAST:event_rbTodosActionPerformed

    private void btnBuscarDeudoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDeudoresActionPerformed
        String[] titulos = {"Periodo", "Grado", "DNI", "Alumno", "Importe", "F. Inicio", "F. Vencimiento", "Fecha Pago", "Mora"};
        String[] registros = new String[9];
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(titulos);

        String periodo = "";
        int grado = 3;
        String sql = "";

        if (rbFecha.isSelected() == true) {

            Date fecha = txtCalendarioBuscar.getDate();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");

            periodo = "" + formato.format(fecha);
            grado = Integer.parseInt(cbGrado.getSelectedItem().toString().trim());

            sql = "select m.periodo,a.grado, a.alumno_dni,concat(a.apellidos,', ',a.nombres)as alumno, m.fecha_inicio,m.fecha_final,p.importe,p.fecha_pago,p.pago_mora"
                    + " from alumno as a"
                    + " join matricula as m on m.alumno_dni=a.alumno_dni"
                    + " join pagos as p on p.id_matricula=m.id_matricula"
                    + " where m.periodo=? and p.importe='0.00' and a.grado=?"
                    + " group by a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;";
        }

        Connection con = dbconexion.getConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, periodo);
            st.setInt(2, grado);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("periodo");
                registros[1] = rs.getString("grado");
                registros[2] = rs.getString("alumno_dni");
                registros[3] = rs.getString("alumno");
                registros[4] = rs.getString("importe");
                registros[5] = rs.getString("fecha_inicio");
                registros[6] = rs.getString("fecha_final");
                registros[7] = rs.getString("fecha_pago");
                registros[8] = rs.getString("pago_mora");
                dtm.addRow(registros);
            }
            tabAlumnosDeudores.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }


    }//GEN-LAST:event_btnBuscarDeudoresActionPerformed

    private void btnImprimirDeudoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirDeudoresActionPerformed
        Connection con = dbconexion.getConnection();
        int fila = tabAlumnosDeudores.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No ha selecionado ninguna fila");
        } else {
            String periodo = tabAlumnosDeudores.getValueAt(fila, 0).toString();
            String grado = tabAlumnosDeudores.getValueAt(fila, 1).toString();
            int convertGrado =Integer.parseInt(grado);
            try {
                JasperReport reporte = (JasperReport) JRLoader.loadObject("src/com/cmlp/reportes/DeudoresReport.jasper");
                Map parametro = new HashedMap();
                parametro.put("grado", convertGrado);                
                parametro.put("periodo", periodo);
                JasperPrint print = JasperFillManager.fillReport(reporte, parametro, con);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Deudores");
                viewer.setVisible(true);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Error al mostrar Reporte: " + e);
            }
        }

    }//GEN-LAST:event_btnImprimirDeudoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarDeudores;
    private javax.swing.JButton btnImprimirDeudores;
    private javax.swing.JComboBox<String> cbGrado;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup radioButonGroup;
    private javax.swing.JRadioButton rbFecha;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tabAlumnosDeudores;
    private com.toedter.calendar.JDateChooser txtCalendarioBuscar;
    // End of variables declaration//GEN-END:variables
}
