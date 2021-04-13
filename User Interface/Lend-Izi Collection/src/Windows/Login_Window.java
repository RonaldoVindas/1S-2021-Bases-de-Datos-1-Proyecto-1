/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

/**
 *
 * @author pc
 */
public class Login_Window extends javax.swing.JFrame {

    /**
     * Creates new form Login_Window
     */
    public Login_Window() {
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Phone_Number_Label = new javax.swing.JLabel();
        Phone_Number_TextField = new javax.swing.JTextField();
        Email_Label = new javax.swing.JLabel();
        Email_TextField = new javax.swing.JTextField();
        Password_TextField = new javax.swing.JTextField();
        Password_Label = new javax.swing.JLabel();
        Birthday_Label = new javax.swing.JLabel();
        Year_TextField = new javax.swing.JTextField();
        Day_TextField = new javax.swing.JTextField();
        Month_TextField = new javax.swing.JTextField();
        Day_Month_Year_Label = new javax.swing.JLabel();
        RegisterNow_Button = new javax.swing.JButton();
        Log_in_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Phone_Number_Label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Phone_Number_Label.setForeground(new java.awt.Color(0, 0, 0));
        Phone_Number_Label.setText("Phone Number:");
        jPanel1.add(Phone_Number_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));
        jPanel1.add(Phone_Number_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 350, -1));

        Email_Label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Email_Label.setForeground(new java.awt.Color(0, 0, 0));
        Email_Label.setText("Email:");
        jPanel1.add(Email_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));
        jPanel1.add(Email_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 350, -1));
        jPanel1.add(Password_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 350, -1));

        Password_Label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Password_Label.setForeground(new java.awt.Color(0, 0, 0));
        Password_Label.setText("Password:");
        jPanel1.add(Password_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        Birthday_Label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Birthday_Label.setForeground(new java.awt.Color(0, 0, 0));
        Birthday_Label.setText("Birthday:");
        jPanel1.add(Birthday_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));
        jPanel1.add(Year_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 40, -1));

        Day_TextField.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Day_TextFieldComponentShown(evt);
            }
        });
        jPanel1.add(Day_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 40, -1));
        jPanel1.add(Month_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 40, -1));

        Day_Month_Year_Label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Day_Month_Year_Label.setForeground(new java.awt.Color(0, 0, 0));
        Day_Month_Year_Label.setText("   dd            mm          yyyy");
        jPanel1.add(Day_Month_Year_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 140, 20));

        RegisterNow_Button.setBackground(new java.awt.Color(248, 190, 61));
        RegisterNow_Button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RegisterNow_Button.setForeground(new java.awt.Color(0, 0, 0));
        RegisterNow_Button.setText("Register Now!");
        RegisterNow_Button.setBorder(null);
        RegisterNow_Button.setBorderPainted(false);
        RegisterNow_Button.setFocusPainted(false);
        RegisterNow_Button.setFocusable(false);
        jPanel1.add(RegisterNow_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 570, 140, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 720));

        Log_in_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Login_Wallpaper.jpg"))); // NOI18N
        getContentPane().add(Log_in_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Day_TextFieldComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Day_TextFieldComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_Day_TextFieldComponentShown

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
            java.util.logging.Logger.getLogger(Login_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Birthday_Label;
    private javax.swing.JLabel Day_Month_Year_Label;
    private javax.swing.JTextField Day_TextField;
    private javax.swing.JLabel Email_Label;
    private javax.swing.JTextField Email_TextField;
    private javax.swing.JLabel Log_in_Wallpaper;
    private javax.swing.JTextField Month_TextField;
    private javax.swing.JLabel Password_Label;
    private javax.swing.JTextField Password_TextField;
    private javax.swing.JLabel Phone_Number_Label;
    private javax.swing.JTextField Phone_Number_TextField;
    private javax.swing.JButton RegisterNow_Button;
    private javax.swing.JTextField Year_TextField;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
