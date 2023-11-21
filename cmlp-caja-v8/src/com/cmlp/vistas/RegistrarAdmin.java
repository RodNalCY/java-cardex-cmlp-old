package com.cmlp.vistas;

import com.cmlp.conexion.DBConexion;
import com.cmlp.login.Admin;
// import com.sun.awt.AWTUtilities;
import javax.swing.JFrame;
import com.cmlp.login.Hash;
import javax.swing.JOptionPane;
import com.cmlp.login.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class RegistrarAdmin extends javax.swing.JFrame {
    
    public Admin mod;
DBConexion cc= new DBConexion();
Connection cn=cc.getConnection();
   // public static Login frmIni;
    public static RegistrarAdmin frmReg;
    public static RegistrarAdmin frmReg2;
    int posx, posy;
    DefaultTableModel modelo = new DefaultTableModel();
    
 
 private void limpiarCajas(){
     
     txtUsuario.setText(null);     
     txtPassword.setText(null);
     txtConfirmaPassword.setText(null);
     
     
 }
  void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("N°");
    modelo.addColumn("USUARIO");
    jtbUsuarios.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT id,usuario FROM admin";
    }
    else{
        sql="SELECT id,usuario FROM admin WHERE usuario ='"+valor+"'";
    }
 
    String []datos = new String [2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);                
                datos[1]=rs.getString(2);
                modelo.addRow(datos);
            }
            jtbUsuarios.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    

    public RegistrarAdmin() {
        initComponents();
        this.setLocationRelativeTo(this);       
        // AWTUtilities.setWindowOpaque(this, false);
        
        mostrardatos("");
    }
    RegistrarAdmin(Admin mod) {
         initComponents();
        this.setLocationRelativeTo(this);
      //  AWTUtilities.setWindowOpaque(this, false);
        this.mod = mod;
        mostrardatos("");
        
    }

   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        btnModifica1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmaPassword = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbUsuarios = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        jMenuItem2.setText("Eliminar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModifica1.setBackground(new java.awt.Color(255, 102, 102));
        btnModifica1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModifica1.setText("<html><center>GUARDAR CAMBIOS</center></html>");
        btnModifica1.setToolTipText("");
        btnModifica1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifica1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnModifica1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 90, 40));

        btnBuscar.setBackground(new java.awt.Color(255, 102, 102));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, -1, 40));

        txtbuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 363, 170, 30));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 0));
        btnRegistrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 600, 120, 40));

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("REGISTR0");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 70, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("\"C M L P\"  ADMINISTRADOR");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 153))); // NOI18N
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 270, -1));

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton4.setText("VOLVER");
        jButton4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 100, 30));

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("X");
        jButton3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 60, 30));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton2.setText("-");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 60, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 80, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("<html>Confirmar Password:</html>");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 150, 30));

        jButton5.setBackground(new java.awt.Color(255, 102, 102));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("REFRESH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("<html><CENTER>TODA BUSQUEDA SERA CON EL DATO USUARIO Y POR ELLO NO BEBE SER MODIFICADA.</CENTER></html>");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 220, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/incognito.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 50, 60));

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 153))); // NOI18N
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 270, -1));

        txtConfirmaPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtConfirmaPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 153))); // NOI18N
        getContentPane().add(txtConfirmaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 270, -1));

        jtbUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtbUsuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Nombre", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbUsuarios.setAutoscrolls(false);
        jtbUsuarios.setComponentPopupMenu(jPopupMenu1);
        jtbUsuarios.setGridColor(new java.awt.Color(255, 204, 204));
        jtbUsuarios.setOpaque(false);
        jtbUsuarios.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jtbUsuarios.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbUsuariosMouseClicked(evt);
            }
        });
        jtbUsuarios.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtbUsuariosPropertyChange(evt);
            }
        });
        jtbUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbUsuariosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbUsuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 450, 270));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/borde_registro.png"))); // NOI18N
        fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                fondoMouseDragged(evt);
            }
        });
        fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fondoMousePressed(evt);
            }
        });
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, 860, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        Admin modSql = new Admin();
        Admin mod = new Admin();

        String pass = new String(txtPassword.getPassword());
        String passC = new String(txtConfirmaPassword.getPassword());

        if (txtUsuario.getText().equals("") || pass.equals("")|| passC.equals("")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los datos");
        } else {

            if (pass.equals(passC)) {

                if (modSql.existeUsuario(txtUsuario.getText()) == 0) {

                    //if (modSql.esEmail(txtCargo.getText())) {
                    String nuevoPass = Hash.sha1(pass);

                    mod.setUsuario(txtUsuario.getText());
                    mod.setPassword(nuevoPass);
                    
                    
                      


                    if (modSql.registrar(mod)) {
                        //JOptionPane.showMessageDialog(null, "Registro Guardado");
                         JOptionPane.showMessageDialog(null, "Registro Guardado");
                           
                            
                        limpiar();
                        
                        RegistrarAdmin.frmReg = null;
                        this.dispose();

                        RegistrarAdmin frmRegs = new RegistrarAdmin();
                        frmRegs.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Guardar");
                        limpiar();
                    }
                    //} else {
                    //   JOptionPane.showMessageDialog(null, "El email es incorrecto");
                    //}
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        Login.frmIni = null;

    }//GEN-LAST:event_formWindowClosing

    private void fondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMousePressed
        // TODO add your handling code here:
        posx = evt.getX();
        posy = evt.getY();

    }//GEN-LAST:event_fondoMousePressed

    private void fondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseDragged
        // TODO add your handling code here:
        int xp = evt.getXOnScreen() - posx;
        int yp = evt.getYOnScreen() - posy;
        this.setLocation(xp, yp);
    }//GEN-LAST:event_fondoMouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        RegistrarAdmin.frmReg = null;
        this.dispose();

        Login frmIni = new Login();
        frmIni.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtbUsuariosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtbUsuariosPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbUsuariosPropertyChange

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        mostrardatos(txtbuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jtbUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbUsuariosKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jtbUsuariosKeyPressed

    private void jtbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbUsuariosMouseClicked
        // TODO add your handling code here:
        int cor = jtbUsuarios.getSelectedRow();
       // txtId.setText(jtProductos.getValueAt(cor, 0).toString());
        txtUsuario.setText(jtbUsuarios.getValueAt(cor, 1).toString());
    }//GEN-LAST:event_jtbUsuariosMouseClicked

    private void btnModifica1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifica1ActionPerformed

        Admin modSql = new Admin();
        Admin usr = new Admin();
        String pass = new String(txtPassword.getPassword());
        String passC = new String(txtConfirmaPassword.getPassword());

        if (txtUsuario.getText().equals("") || pass.equals("") || passC.equals("") ) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los datos");
        } else {

            if (pass.equals(passC)) {

                //f (modSql.existeUsuario(txtUsuario.getText()) == 0) {

                    
                    String nuevoPass = Hash.sha1(pass);

                    usr.setUsuario(txtUsuario.getText());
                    usr.setPassword(nuevoPass);
                    
                    
                      


                    if (modSql.actualizar(usr)) {
                        //JOptionPane.showMessageDialog(null, "Registro Guardado");
                         JOptionPane.showMessageDialog(null, "Actualizacion Guardada");
                           
                            
                        limpiar();
                        
                        RegistrarAdmin.frmReg = null;
                        this.dispose();

                        RegistrarAdmin frmRegs = new RegistrarAdmin();
                        frmRegs.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Guardar");
                        limpiar();
                    }
                    //} else {
                    //   JOptionPane.showMessageDialog(null, "El email es incorrecto");
                    //}
              //  } else {
                 //   JOptionPane.showMessageDialog(null, "El usuario ya existe");
               // }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        }

    }//GEN-LAST:event_btnModifica1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        mostrardatos("");
        limpiarCajas();
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int fila = jtbUsuarios.getSelectedRow();
    String cod="";
    cod=jtbUsuarios.getValueAt(fila, 0).toString();
    
    try {
        PreparedStatement pst = cn.prepareStatement("DELETE FROM admin WHERE  id='"+cod+"'");
        pst.executeUpdate();
        mostrardatos("");
    } catch (Exception e) {
    }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
                                          
// TODO add your handling code here:
   


    private void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText("");
        txtConfirmaPassword.setText("");
    }

  
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
            java.util.logging.Logger.getLogger(RegistrarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModifica1;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbUsuarios;
    public javax.swing.JPasswordField txtConfirmaPassword;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
