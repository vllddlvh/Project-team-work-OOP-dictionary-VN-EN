/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package destoplogin;

/**
 *
 * @author ADMIN
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitleThuVien = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonTongQuan = new javax.swing.JButton();
        jButtonSach = new javax.swing.JButton();
        jButtonBanDoc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 450));

        jLabelTitleThuVien.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelTitleThuVien.setText("THƯ VIỆN");

        jPanel1.setBackground(new java.awt.Color(224, 224, 224));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jButtonTongQuan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButtonTongQuan.setText("Tổng quan");
        jButtonTongQuan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonTongQuan.setMaximumSize(new java.awt.Dimension(150, 30));
        jButtonTongQuan.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonTongQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTongQuanActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTongQuan);

        jButtonSach.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButtonSach.setText("Sách");
        jButtonSach.setMaximumSize(new java.awt.Dimension(150, 30));
        jButtonSach.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jButtonSach);

        jButtonBanDoc.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButtonBanDoc.setText("Bạn đọc");
        jButtonBanDoc.setMaximumSize(new java.awt.Dimension(150, 30));
        jButtonBanDoc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jButtonBanDoc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabelTitleThuVien)
                .addContainerGap(326, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitleThuVien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTongQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTongQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTongQuanActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBanDoc;
    private javax.swing.JButton jButtonSach;
    private javax.swing.JButton jButtonTongQuan;
    private javax.swing.JLabel jLabelTitleThuVien;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
