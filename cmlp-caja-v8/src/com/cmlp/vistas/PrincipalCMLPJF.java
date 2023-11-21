package com.cmlp.vistas;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import com.cmlp.util.Horas;
import com.cmlp.login.Usuarios;
import javax.swing.JOptionPane;

public class PrincipalCMLPJF extends javax.swing.JFrame {

    public Usuarios mod;
    public Horas hor;
    public static Login frmIni;
    public static PrincipalCMLPJF frmcmlp;

    private AlumnosCrudJIF alumnos;
    private MatriculaJIF matricula;
    private PagosJIF pagos;
    private DeudoresJIF deuda;
    private PagantesJIF pagantes;
    private KardexJIF documentos;
    private BajasJIF bajas;
    private int x = 0;

    public PrincipalCMLPJF() {
        initComponents();
        this.setLocationRelativeTo(this);

        // Para visualizar el Tiempo en
        Horas horas = new Horas();
        horas.tiempo();

    }

    PrincipalCMLPJF(Usuarios mod) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.mod = mod;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/cmlp/recursos/cmlp_background.jpg"));
        Image image = icon.getImage();
        jdbPanelPrincipal = new javax.swing.JDesktopPane();
        labelFecha = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        lblWeb = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemAlumnos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuItemMatricula = new javax.swing.JMenuItem();
        menuItemPagos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItemKardex = new javax.swing.JMenuItem();
        menuItemPagantes = new javax.swing.JMenuItem();
        menuItemDeudores = new javax.swing.JMenuItem();
        menuItemBajas = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdbPanelPrincipal.setBorder(new javax.swing.border.MatteBorder(null));
        jdbPanelPrincipal = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        labelFecha.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFecha.setText("FECHA");

        labelHora.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHora.setText("HORA");

        lblUbicacion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblUbicacion.setForeground(new java.awt.Color(255, 255, 255));
        lblUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/ubicacion.png"))); // NOI18N
        lblUbicacion.setText("Av. Costanera 1541 La Perla Callao");

        lblWeb.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblWeb.setForeground(new java.awt.Color(255, 255, 255));
        lblWeb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/web.png"))); // NOI18N
        lblWeb.setText("www.leoncioprado.com");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/email.png"))); // NOI18N
        lblEmail.setText("informes@leoncioprado.com");

        jdbPanelPrincipal.setLayer(labelFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdbPanelPrincipal.setLayer(labelHora, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdbPanelPrincipal.setLayer(lblUbicacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdbPanelPrincipal.setLayer(lblWeb, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdbPanelPrincipal.setLayer(lblEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdbPanelPrincipalLayout = new javax.swing.GroupLayout(jdbPanelPrincipal);
        jdbPanelPrincipal.setLayout(jdbPanelPrincipalLayout);
        jdbPanelPrincipalLayout.setHorizontalGroup(
            jdbPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdbPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jdbPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdbPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addComponent(labelFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jdbPanelPrincipalLayout.setVerticalGroup(
            jdbPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdbPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(457, Short.MAX_VALUE)
                .addComponent(labelHora)
                .addGap(18, 18, 18)
                .addComponent(labelFecha)
                .addGap(18, 18, 18)
                .addGroup(jdbPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jdbPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUbicacion)
                        .addComponent(lblWeb)))
                .addGap(11, 11, 11))
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(800, 60));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/usuario.png"))); // NOI18N
        jMenu1.setText("Usuario");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem2.setText("Cerrar Sessión");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(200, 40));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem3.setText("Salir");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(200, 40));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/mantenimiento.png"))); // NOI18N
        jMenu2.setText("Mantenimiento");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jMenu2.setMaximumSize(new java.awt.Dimension(205, 32767));
        jMenu2.setPreferredSize(new java.awt.Dimension(200, 50));

        menuItemAlumnos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemAlumnos.setText("Alumnos");
        menuItemAlumnos.setPreferredSize(new java.awt.Dimension(200, 40));
        menuItemAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAlumnosActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemAlumnos);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/matriculas.png"))); // NOI18N
        jMenu3.setText("Matriculas");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(200, 50));

        menuItemMatricula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemMatricula.setText("Matricula");
        menuItemMatricula.setPreferredSize(new java.awt.Dimension(200, 40));
        menuItemMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMatriculaActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemMatricula);

        menuItemPagos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemPagos.setText("Pagos");
        menuItemPagos.setPreferredSize(new java.awt.Dimension(200, 40));
        menuItemPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPagosActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemPagos);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cmlp/recursos/documentos.png"))); // NOI18N
        jMenu4.setText("Documentos");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(200, 50));

        menuItemKardex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemKardex.setText("Kardex");
        menuItemKardex.setPreferredSize(new java.awt.Dimension(200, 40));
        menuItemKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKardexActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemKardex);

        menuItemPagantes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemPagantes.setText("Pagantes");
        menuItemPagantes.setPreferredSize(new java.awt.Dimension(200, 40));
        menuItemPagantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPagantesActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemPagantes);

        menuItemDeudores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemDeudores.setText("Deudores");
        menuItemDeudores.setPreferredSize(new java.awt.Dimension(200, 40));
        menuItemDeudores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDeudoresActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemDeudores);

        menuItemBajas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemBajas.setText("Bajas");
        menuItemBajas.setPreferredSize(new java.awt.Dimension(200, 40));
        menuItemBajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBajasActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemBajas);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdbPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdbPanelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        PrincipalCMLPJF.frmcmlp = null;
        this.dispose();

        Login frmIni = new Login();
        frmIni.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuItemAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAlumnosActionPerformed

        if (alumnos != null) {
            alumnos.dispose();
        }
        if (x == 0) {
            alumnos = new AlumnosCrudJIF();
            jdbPanelPrincipal.add(alumnos);
            alumnos.setDefaultCloseOperation(AlumnosCrudJIF.DISPOSE_ON_CLOSE);
            alumnos.setVisible(true);
        }


    }//GEN-LAST:event_menuItemAlumnosActionPerformed

    private void menuItemMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMatriculaActionPerformed

        if (matricula != null) {
            matricula.dispose();
        }
        if (x == 0) {
            matricula = new MatriculaJIF();
            jdbPanelPrincipal.add(matricula);
            matricula.setDefaultCloseOperation(MatriculaJIF.DISPOSE_ON_CLOSE);
            matricula.setVisible(true);
        }

    }//GEN-LAST:event_menuItemMatriculaActionPerformed

    private void menuItemPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPagosActionPerformed

        if (pagos != null) {
            pagos.dispose();
        }
        if (x == 0) {
            pagos = new PagosJIF();
            jdbPanelPrincipal.add(pagos);
            pagos.setDefaultCloseOperation(PagosJIF.DISPOSE_ON_CLOSE);
            pagos.setVisible(true);

        }
    }//GEN-LAST:event_menuItemPagosActionPerformed

    private void menuItemDeudoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDeudoresActionPerformed
        if (deuda != null) {
            deuda.dispose();
        }
        if (x == 0) {
            deuda = new DeudoresJIF();
            jdbPanelPrincipal.add(deuda);
            deuda.setDefaultCloseOperation(DeudoresJIF.DISPOSE_ON_CLOSE);
            deuda.setVisible(true);

        }
    }//GEN-LAST:event_menuItemDeudoresActionPerformed

    private void menuItemPagantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPagantesActionPerformed
        if (pagantes != null) {
            pagantes.dispose();
        }
        if (x == 0) {
            pagantes = new PagantesJIF();
            jdbPanelPrincipal.add(pagantes);
            pagantes.setDefaultCloseOperation(PagantesJIF.DISPOSE_ON_CLOSE);
            pagantes.setVisible(true);
        }
    }//GEN-LAST:event_menuItemPagantesActionPerformed

    private void menuItemKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKardexActionPerformed
        if (documentos != null) {
            documentos.dispose();
        }
        if (x == 0) {
            documentos = new KardexJIF();
            jdbPanelPrincipal.add(documentos);
            documentos.setDefaultCloseOperation(KardexJIF.DISPOSE_ON_CLOSE);
            documentos.setVisible(true);
        }
    }//GEN-LAST:event_menuItemKardexActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuItemBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBajasActionPerformed

        if (bajas != null) {
            bajas.dispose();
        }
        if (x == 0) {
            bajas = new BajasJIF();
            jdbPanelPrincipal.add(bajas);
            bajas.setDefaultCloseOperation(BajasJIF.DISPOSE_ON_CLOSE);
            bajas.setVisible(true);
        }

    }//GEN-LAST:event_menuItemBajasActionPerformed

    public static void main(String args[]) {
        /*Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalCMLPJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalCMLPJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalCMLPJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalCMLPJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCMLPJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    public static javax.swing.JDesktopPane jdbPanelPrincipal;
    public static javax.swing.JLabel labelFecha;
    public static javax.swing.JLabel labelHora;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JLabel lblWeb;
    private javax.swing.JMenuItem menuItemAlumnos;
    private javax.swing.JMenuItem menuItemBajas;
    private javax.swing.JMenuItem menuItemDeudores;
    private javax.swing.JMenuItem menuItemKardex;
    private javax.swing.JMenuItem menuItemMatricula;
    private javax.swing.JMenuItem menuItemPagantes;
    private javax.swing.JMenuItem menuItemPagos;
    // End of variables declaration//GEN-END:variables
}
