
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sambasu
 */
public class flav extends javax.swing.JFrame {
    private int count;

    /**
     * Creates new form flav
     */
    public flav() {
        initComponents();
        
        ImageIcon myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imgs/7.png")));
        
        Image fill1 =myimage.getImage();
        Image fill2 = fill1.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(fill2);
        
        jLabel1.setIcon(i);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(699, 599));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jButton1.setText("Next");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Flavor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        new fill3().setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel1KeyPressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (count == 1) {
            jTextField1.setText("Flavor: Cherry");
        }
        else if (count == 2) {
            jTextField1.setText("Flavor: Matcha");
        }
        
        else if (count == 3) {
            try {
                Thread.sleep(500);
                //25%
                ImageIcon myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imgs/2.png")));
                
                Image fill1 =myimage.getImage();
                Image fill2 = fill1.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon i = new ImageIcon(fill2);
                
                jLabel1.setIcon(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(flav.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (count == 4) {
            try {
                Thread.sleep(500);
                //50%
                ImageIcon myimage2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imgs/3.png")));
                
                Image fill3 =myimage2.getImage();
                Image fill4 = fill3.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon i2 = new ImageIcon(fill4);
                
                jLabel1.setIcon(i2);
            } catch (InterruptedException ex) {
                Logger.getLogger(flav.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (count == 5) {
            try {
                Thread.sleep(500);
                //75%
                ImageIcon myimage4 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imgs/4.png")));
                
                Image fill5 =myimage4.getImage();
                Image fill6 = fill5.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon i3 = new ImageIcon(fill6);
                
                jLabel1.setIcon(i3);
            } catch (InterruptedException ex) {
                Logger.getLogger(flav.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (count == 6) {
            try {
                Thread.sleep(500);
                //80%
                ImageIcon myimage5 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imgs/5.png")));
                
                Image fill7 =myimage5.getImage();
                Image fill8 = fill7.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon i4 = new ImageIcon(fill8);
                
                jLabel1.setIcon(i4);
            } catch (InterruptedException ex) {
                Logger.getLogger(flav.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        count++;
        
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(flav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(flav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(flav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(flav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new flav().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
