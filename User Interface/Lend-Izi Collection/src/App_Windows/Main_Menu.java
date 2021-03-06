
package App_Windows;

public class Main_Menu extends javax.swing.JFrame {
/*
By:
    Renzo Barra
    Álvaro Moreira
    Ronaldo Vindas
*/

    public Main_Menu() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Exit_Button = new javax.swing.JButton();
        LogIn_Button = new javax.swing.JButton();
        NewAccount_Button = new javax.swing.JButton();
        MainMenu_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Exit_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit Button.png"))); // NOI18N
        Exit_Button.setBorderPainted(false);
        Exit_Button.setContentAreaFilled(false);
        Exit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Exit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 30, 30));

        LogIn_Button.setBorderPainted(false);
        LogIn_Button.setContentAreaFilled(false);
        LogIn_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogIn_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LogIn_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 440, 70));

        NewAccount_Button.setBorderPainted(false);
        NewAccount_Button.setContentAreaFilled(false);
        NewAccount_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAccount_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(NewAccount_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, 340, 50));

        MainMenu_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainMenu_Wallpaper.jpg"))); // NOI18N
        getContentPane().add(MainMenu_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogIn_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn_ButtonActionPerformed
      
        LogIn_Window result = new LogIn_Window();
        result.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogIn_ButtonActionPerformed

    private void Exit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_ButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Exit_ButtonActionPerformed

    private void NewAccount_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAccount_ButtonActionPerformed
        Register_Window result = new Register_Window();
        result.setVisible(true);
        dispose();
    }//GEN-LAST:event_NewAccount_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit_Button;
    private javax.swing.JButton LogIn_Button;
    private javax.swing.JLabel MainMenu_Wallpaper;
    private javax.swing.JButton NewAccount_Button;
    // End of variables declaration//GEN-END:variables
}
