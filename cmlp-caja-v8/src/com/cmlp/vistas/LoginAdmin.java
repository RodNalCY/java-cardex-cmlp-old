/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmlp.vistas;

//import vista.login.*;
import com.cmlp.login.Admin;
// import com.sun.awt.AWTUtilities;
import javax.swing.JFrame;
import com.cmlp.login.Hash;
import javax.swing.JOptionPane;


/**
 *
 * @author Marko
 */
public class LoginAdmin extends javax.swing.JFrame {
     

  //  public static RegistrarAdmin frmrad;
   // public static Login frmlog;
    public static LoginAdmin frmAdm;
    int posx,posy;

    public LoginAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        // AWTUtilities.setWindowOpaque(this,false);
    }
    /**public login() {
        initComponents();
        setLocationRelativeTo(null);
    }**/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setMinimumSize(new java.awt.Dimension(860, 480));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 290, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 290, 40));

        jLabel5.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("LEONCIO PRADO\"");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Volver");
        jButton4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 100, 30));

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
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 60, 30));

        btnEntrar.setBackground(new java.awt.Color(255, 0, 0));
        btnEntrar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("ENTRAR");
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 610, 110, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/incognito.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, -1, -1));

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
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 60, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/usuario.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 40, 40));

        jLabel7.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("\" COLEGIO MILITAR");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText(" ADMINISTRADOR");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<HTML><CENTER> PARA REGISTRAR UN NUEVO EMPLEADO DEBERA INICIAR  SESION EN MODO   ADMINISTRADOR</CENTER>.</HTML>");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 210, 90));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/borde_registro.png"))); // NOI18N
        jLabel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel11MouseDragged(evt);
            }
        });
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText("");
       /* txtUsuario1.setText("");
        txtPassword1.setText("");
        txtEmail.setText("");
        txtConfirmaPassword.setText("");         
        txtNombre.setText("");*/
    }
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        Admin modSql = new Admin();
        Admin mod = new Admin();

        String pass = new String(txtPassword.getPassword());

        if (!txtUsuario.getText().equals("") && !pass.equals("")) {

            String nuevoPass = Hash.sha1(pass);

            mod.setUsuario(txtUsuario.getText());
            mod.setPassword(nuevoPass);

            if (modSql.loginAdmin(mod)) {
                LoginAdmin.frmAdm = null;
                this.dispose();
                

                Registrar frmReg = new Registrar(mod);
                //Registrar frmReg2= new Registrar();
                frmReg.setVisible(true);
                
              /*  if (frmPrin == null) {

                frmPrin = new PrincipalCMLPJF(mod);                          
                frmPrin.setVisible(true);
            
        }else{
            //System.exit(0);
                 frmPrin = new PrincipalCMLPJF();                          
                frmPrin.setVisible(true);
            
        
        }*/

            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        // TODO add your handling code here:
        posx=evt.getX();
        posy=evt.getY();
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel11MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseDragged
        // TODO add your handling code here:
        int xp=evt.getXOnScreen() -posx;
        int yp=evt.getYOnScreen() -posy;
        this.setLocation(xp,yp);
    }//GEN-LAST:event_jLabel11MouseDragged

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
                LoginAdmin.frmAdm = null;
                this.dispose();
                

                Login frmlog = new Login();
                frmlog.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        LoginAdmin.frmAdm = null;
                this.dispose();
                
        RegistrarAdmin frmrad= new RegistrarAdmin();
        frmrad.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdmin().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEntrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
