package com.cmlp.vistas;

import com.cmlp.conexion.DBConexion;
import com.cmlp.util.Formatos;
import com.cmlp.util.VerificarCampo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PagosJIF extends javax.swing.JInternalFrame {

    private DBConexion dbconnexion = new DBConexion();
    VerificarCampo c = new VerificarCampo();
    DefaultTableModel dtm;

    public PagosJIF() {
        initComponents();
        setLocation(50, 50);
        bloquearCamposPagos();
        c.validarSoloNumeros(txtImporte);
        c.validarSoloNumeros(txtMora);

        cargarTablaAlumnosPagos();        
        tabAlumnosPagos.getColumnModel().getColumn(4).setPreferredWidth(320);

    }

    private void nuevoPago() {

        String codigo = txtCodigo.getText().trim();
        double importe = Double.parseDouble(txtImporte.getText().trim());
        String f_pago = Formatos.sdtfecha.format(dtpFechaPago.getDate()).trim();
        String motivo = cobxPagoMotivo.getSelectedItem().toString().trim();
        String tipo = cobxTipoPago.getSelectedItem().toString().trim();
        double mora = Double.parseDouble(txtMora.getText().trim());

        Connection con = dbconnexion.getConnection();

        if (f_pago.equals("01/01/2019")) {

            String sql = "INSERT INTO pagos VALUES(null,?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, codigo);
                pst.setDouble(2, importe);
                pst.setString(3, "PENDIENTE");
                pst.setString(4, motivo);
                pst.setString(5, tipo);
                pst.setDouble(6, mora);

                int neo = pst.executeUpdate();
                cargarTablaAlumnosPagos();
                bloquearCamposPagos();

                if (neo > 0) {
                    JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo crear la Matricula de Notas");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR SQL EN LA MatriculaJIF");
            }
        } else {
            String sql = "INSERT INTO pagos VALUES(null,?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, codigo);
                pst.setDouble(2, importe);
                pst.setString(3, f_pago);
                pst.setString(4, motivo);
                pst.setString(5, tipo);
                pst.setDouble(6, mora);

                int neo = pst.executeUpdate();
                cargarTablaAlumnosPagos();
                bloquearCamposPagos();
                if (neo > 0) {
                    JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo crear la Matricual de Notas");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR SQL EN LA MatriculaJIF");
            }

        }

    }

    private void cargarTablaAlumnosPagos() {
        String[] titulos = {"ID-P", "ID-M", "DNI", "Periodo", "Alumno", "Fecha Pago", "Motivo", "Tipo Pago", "Importe", "Mora"};
        String[] registros = new String[10];
        dtm = new DefaultTableModel(null, titulos);

        Connection cn = dbconnexion.getConnection();
        String sql = "SELECT p.id_pagos,p.id_matricula, a.alumno_dni,m.periodo,concat(a.apellidos,', ',a.nombres)as alumno,p.fecha_pago,p.pago_motivo,p.tipo_pago,p.importe,p.pago_mora"
                + " FROM pagos as p"
                + " join matricula as m on m.id_matricula=p.id_matricula"
                + " join alumno as a on a.alumno_dni=m.alumno_dni"
                + " order by p.id_pagos,p.id_matricula;";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("id_pagos");
                registros[1] = rs.getString("id_matricula");
                registros[2] = rs.getString("alumno_dni");
                registros[3] = rs.getString("periodo");
                registros[4] = rs.getString("alumno");
                registros[5] = rs.getString("fecha_pago");
                registros[6] = rs.getString("pago_motivo");
                registros[7] = rs.getString("tipo_pago");
                registros[8] = rs.getString("importe");
                registros[9] = rs.getString("pago_mora");
                dtm.addRow(registros);
            }
            tabAlumnosPagos.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }
    }    

    private void actualizarPago() {

        String id_pago = lblIpPagos.getText().trim();
        double importe = Double.parseDouble(txtImporte.getText().trim());
        String f_pago = Formatos.sdtfecha.format(dtpFechaPago.getDate()).trim();
        String motivo = cobxPagoMotivo.getSelectedItem().toString().trim();
        String tipo = cobxTipoPago.getSelectedItem().toString().trim();
        double mora = Double.parseDouble(txtMora.getText().trim());

        Connection con = dbconnexion.getConnection();
        String sql = "UPDATE pagos SET "
                + "importe=?,"
                + "fecha_pago=?,"
                + "pago_motivo=?,"
                + "tipo_pago=?,"
                + "pago_mora=? WHERE id_pagos=?;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDouble(1, importe);
            pst.setString(2, f_pago);
            pst.setString(3, motivo);
            pst.setString(4, tipo);
            pst.setDouble(5, mora);
            pst.setString(6, id_pago);

            int neo = pst.executeUpdate();
            cargarTablaAlumnosPagos();
            bloquearCamposPagos();

            if (neo > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear la Matricual de Notas");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR SQL EN LA MatriculaJIF");
        }

    }
    
    private void buscarAlumnoPagos(String alumno) {
        String[] titulos = {"ID-P", "ID-M", "DNI", "Periodo", "Alumno", "Fecha Pago", "Motivo", "Tipo Pago", "Importe", "Mora"};
        String[] registros = new String[10];
        dtm = new DefaultTableModel(null, titulos);

        Connection cn = dbconnexion.getConnection();
        String sql = "SELECT p.id_pagos,p.id_matricula, a.alumno_dni,m.periodo,concat(a.apellidos,', ',a.nombres)as alumno,p.fecha_pago,p.pago_motivo,p.tipo_pago,p.importe,p.pago_mora"
                + " FROM pagos as p"
                + " join matricula as m on m.id_matricula=p.id_matricula"
                + " join alumno as a on a.alumno_dni=m.alumno_dni"
                + " where concat(a.alumno_dni,p.pago_motivo) LIKE '%"+alumno+"%'"
                + " order by p.id_pagos,p.id_matricula;";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("id_pagos");
                registros[1] = rs.getString("id_matricula");
                registros[2] = rs.getString("alumno_dni");
                registros[3] = rs.getString("periodo");
                registros[4] = rs.getString("alumno");
                registros[5] = rs.getString("fecha_pago");
                registros[6] = rs.getString("pago_motivo");
                registros[7] = rs.getString("tipo_pago");
                registros[8] = rs.getString("importe");
                registros[9] = rs.getString("pago_mora");
                dtm.addRow(registros);
            }
            tabAlumnosPagos.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGAR TABLA: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        popMenuItemModificar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnBuscarAlumno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtNombresAlumno = new javax.swing.JTextField();
        txtPeriodo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblIpPagos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dtpFechaPago = new com.toedter.calendar.JDateChooser();
        cobxPagoMotivo = new javax.swing.JComboBox<>();
        cobxTipoPago = new javax.swing.JComboBox<>();
        txtImporte = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMora = new javax.swing.JTextField();
        btnPendiente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnNuevoRegistro = new javax.swing.JButton();
        btnActualizarRegistro = new javax.swing.JButton();
        btnCancelarRegistro = new javax.swing.JButton();
        btnGuardarRegistro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabAlumnosPagos = new javax.swing.JTable();
        txtBuscarAlumnoPago = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        popMenuItemModificar.setText("Modificar");
        popMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuItemModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popMenuItemModificar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Alumno"));

        btnBuscarAlumno.setText("...");
        btnBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setText("DNI:");

        jLabel2.setText("Alumno:");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setText("ID-Matricula:");

        txtDNI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtNombresAlumno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtPeriodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel9.setText("Periodo:");

        lblIpPagos.setBackground(new java.awt.Color(255, 255, 255));
        lblIpPagos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIpPagos.setForeground(new java.awt.Color(0, 0, 153));
        lblIpPagos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIpPagos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombresAlumno)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDNI)
                            .addComponent(txtPeriodo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btnBuscarAlumno))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(lblIpPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarAlumno)
                        .addComponent(jLabel3)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblIpPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombresAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos"));

        jLabel1.setText("Importe (S/.) :");

        jLabel4.setText("Fecha Pago:");

        jLabel5.setText("Pago Motivo:");

        jLabel7.setText("Tipo Pago:");

        cobxPagoMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Despliegue el Motivo", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));

        cobxTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Despliegue", "CAJA", "P.O.S", "BECADO", "N/A" }));

        jLabel8.setText("Mora (S/.):");

        btnPendiente.setText("Pendiente");
        btnPendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cobxPagoMotivo, 0, 158, Short.MAX_VALUE)
                    .addComponent(dtpFechaPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cobxTipoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtImporte)
                    .addComponent(txtMora))
                .addGap(18, 18, 18)
                .addComponent(btnPendiente, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPendiente)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(dtpFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cobxPagoMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cobxTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        btnNuevoRegistro.setText("Nuevo");
        btnNuevoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoRegistroActionPerformed(evt);
            }
        });

        btnActualizarRegistro.setText("Actualizar");
        btnActualizarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRegistroActionPerformed(evt);
            }
        });

        btnCancelarRegistro.setText("Cancelar");
        btnCancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroActionPerformed(evt);
            }
        });

        btnGuardarRegistro.setText("Guardar");
        btnGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardarRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(btnActualizarRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCancelarRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNuevoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabAlumnosPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabAlumnosPagos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tabAlumnosPagos);

        txtBuscarAlumnoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarAlumnoPagoKeyReleased(evt);
            }
        });

        jLabel10.setText("BUSCAR ALUMNO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscarAlumnoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarAlumnoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnoActionPerformed
        try {
            PagosAlumnoBuscadorJIF pagos = new PagosAlumnoBuscadorJIF();
            PrincipalCMLPJF.jdbPanelPrincipal.add(pagos);
            pagos.toFront();
            pagos.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR ALUMNO");
        }
    }//GEN-LAST:event_btnBuscarAlumnoActionPerformed

    private void btnNuevoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoRegistroActionPerformed
        limpiarCamposPagos();
        desbloquearCamposPagos();
        cobxPagoMotivo.setSelectedIndex(0);
        cobxTipoPago.setSelectedIndex(0);
        btnGuardarRegistro.setEnabled(true);
        btnActualizarRegistro.setEnabled(false);
    }//GEN-LAST:event_btnNuevoRegistroActionPerformed

    private void btnActualizarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRegistroActionPerformed
        actualizarPago();
        limpiarCamposPagos();
        bloquearCamposPagos();
    }//GEN-LAST:event_btnActualizarRegistroActionPerformed

    private void btnCancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroActionPerformed
        bloquearCamposPagos();
        cobxPagoMotivo.setSelectedIndex(0);
        cobxTipoPago.setSelectedIndex(0);
    }//GEN-LAST:event_btnCancelarRegistroActionPerformed

    private void btnPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendienteActionPerformed
        try {
            String fecha = "01/01/2019";
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate = formato.parse(fecha);
            dtpFechaPago.setDate(fechaDate);
            txtImporte.setText("0");
            txtMora.setText("0");
            cobxTipoPago.setSelectedIndex(4);
        } catch (ParseException ex) {
            System.out.println("ERROR AL COLOCAR FECHA " + ex);
        }

    }//GEN-LAST:event_btnPendienteActionPerformed

    private void txtBuscarAlumnoPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoPagoKeyReleased
        String alumno = txtBuscarAlumnoPago.getText().trim();
        buscarAlumnoPagos(alumno);
    }//GEN-LAST:event_txtBuscarAlumnoPagoKeyReleased

    private void popMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuItemModificarActionPerformed
        desbloquearCamposPagos();
        btnGuardarRegistro.setEnabled(false);
        int fila = tabAlumnosPagos.getSelectedRow();
        if (fila >= 0) {
            try {
                lblIpPagos.setText(tabAlumnosPagos.getValueAt(fila, 0).toString());
                txtCodigo.setText(tabAlumnosPagos.getValueAt(fila, 1).toString());
                txtDNI.setText(tabAlumnosPagos.getValueAt(fila, 2).toString());
                txtPeriodo.setText(tabAlumnosPagos.getValueAt(fila, 3).toString());
                txtNombresAlumno.setText(tabAlumnosPagos.getValueAt(fila, 4).toString());

                String fecha = tabAlumnosPagos.getValueAt(fila, 5).toString();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaDate;
                if (fecha.equals("PENDIENTE")) {
                    fechaDate = formato.parse("01/01/2019");
                    dtpFechaPago.setDate(fechaDate);
                } else {
                    fechaDate = formato.parse(fecha);
                    dtpFechaPago.setDate(fechaDate);
                }

                cobxPagoMotivo.setSelectedItem(tabAlumnosPagos.getValueAt(fila, 6));
                cobxTipoPago.setSelectedItem(tabAlumnosPagos.getValueAt(fila, 7));
                txtImporte.setText(tabAlumnosPagos.getValueAt(fila, 8).toString());
                txtMora.setText(tabAlumnosPagos.getValueAt(fila, 9).toString());

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Error al ingresar fecha");
            }

        }
    }//GEN-LAST:event_popMenuItemModificarActionPerformed

    private void btnGuardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegistroActionPerformed
        nuevoPago();
        cargarTablaAlumnosPagos();
    }//GEN-LAST:event_btnGuardarRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarRegistro;
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnCancelarRegistro;
    private javax.swing.JButton btnGuardarRegistro;
    private javax.swing.JButton btnNuevoRegistro;
    private javax.swing.JButton btnPendiente;
    private javax.swing.JComboBox<String> cobxPagoMotivo;
    private javax.swing.JComboBox<String> cobxTipoPago;
    private com.toedter.calendar.JDateChooser dtpFechaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIpPagos;
    private javax.swing.JMenuItem popMenuItemModificar;
    private javax.swing.JTable tabAlumnosPagos;
    private javax.swing.JTextField txtBuscarAlumnoPago;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtMora;
    public static javax.swing.JTextField txtNombresAlumno;
    public static javax.swing.JTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables

    private void limpiarCamposPagos() {
        txtDNI.setText("");
        txtCodigo.setText("");
        txtNombresAlumno.setText("");
        txtImporte.setText("");
        txtMora.setText("");
        txtPeriodo.setText("");
        lblIpPagos.setText("");

        dtpFechaPago.setCalendar(null);

    }

    private void bloquearCamposPagos() {
        txtDNI.setEnabled(false);
        txtCodigo.setEnabled(false);
        txtNombresAlumno.setEnabled(false);
        txtImporte.setEnabled(false);
        txtMora.setEnabled(false);
        txtPeriodo.setEnabled(false);

        dtpFechaPago.setEnabled(false);
        btnBuscarAlumno.setEnabled(false);
        btnActualizarRegistro.setEnabled(false);
        btnPendiente.setEnabled(false);

        cobxPagoMotivo.setEnabled(false);
        cobxTipoPago.setEnabled(false);

    }

    private void desbloquearCamposPagos() {
        txtDNI.setEnabled(true);
        txtCodigo.setEnabled(true);
        txtNombresAlumno.setEnabled(true);
        txtImporte.setEnabled(true);
        txtMora.setEnabled(true);
        txtPeriodo.setEnabled(true);

        txtDNI.setEditable(false);
        txtCodigo.setEditable(false);
        txtNombresAlumno.setEditable(false);
        txtPeriodo.setEditable(false);

        cobxPagoMotivo.setEnabled(true);
        cobxTipoPago.setEnabled(true);

        dtpFechaPago.setEnabled(true);
        btnBuscarAlumno.setEnabled(true);
        btnActualizarRegistro.setEnabled(true);
        btnPendiente.setEnabled(true);

    }

}
