/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App_Windows;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import lend.izi.collection.LendIziCollection;


/*
    Creado Por: Ronaldo Vindas B.    117610138
 */
public class Register_Window extends javax.swing.JFrame {

    /**
     * Creates new form Register_Window
     */
    public Register_Window() {
       this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Return_Button = new javax.swing.JButton();
        Exit_Button = new javax.swing.JButton();
        MenuBlack_Panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Identification_Label = new javax.swing.JLabel();
        Identification_Label1 = new javax.swing.JLabel();
        FirstName_Label = new javax.swing.JLabel();
        LastName_Label = new javax.swing.JLabel();
        Email_Label = new javax.swing.JLabel();
        Password_Label = new javax.swing.JLabel();
        PhoneNumber_Label = new javax.swing.JLabel();
        Birthday_Label = new javax.swing.JLabel();
        Identification_TextField = new javax.swing.JTextField();
        FirstName_TextField = new javax.swing.JTextField();
        LastName_TextField = new javax.swing.JTextField();
        Email_TextField = new javax.swing.JTextField();
        Password_TextField = new javax.swing.JTextField();
        PhoneNumber_TextField = new javax.swing.JTextField();
        BirthdayMonth_TextField = new javax.swing.JTextField();
        BirthdayDay_TextField = new javax.swing.JTextField();
        BirthdayYear_TextField = new javax.swing.JTextField();
        Register_Buttton = new javax.swing.JButton();
        RegisterNow_Label = new javax.swing.JLabel();
        Banner_Label = new javax.swing.JLabel();
        LogIn_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Return_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Return_Button.setForeground(new java.awt.Color(255, 255, 255));
        Return_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackArrow_Icon23.png"))); // NOI18N
        Return_Button.setText("  Return");
        Return_Button.setBorder(null);
        Return_Button.setBorderPainted(false);
        Return_Button.setContentAreaFilled(false);
        Return_Button.setFocusable(false);
        Return_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Return_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Return_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        Exit_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit Button.png"))); // NOI18N
        Exit_Button.setBorderPainted(false);
        Exit_Button.setContentAreaFilled(false);
        Exit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Exit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 30, 30));

        MenuBlack_Panel.setBackground(new java.awt.Color(0, 0, 0));
        MenuBlack_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(243, 149, 1)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Identification_Label.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Identification_Label.setForeground(new java.awt.Color(255, 255, 255));
        Identification_Label.setText("Identification:");
        jPanel2.add(Identification_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Identification_Label1.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        Identification_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Identification_Label1.setText("yyyy              mm               dd");
        jPanel2.add(Identification_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 240, -1));

        FirstName_Label.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        FirstName_Label.setForeground(new java.awt.Color(255, 255, 255));
        FirstName_Label.setText("First Name:");
        jPanel2.add(FirstName_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        LastName_Label.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        LastName_Label.setForeground(new java.awt.Color(255, 255, 255));
        LastName_Label.setText("Last Name:");
        jPanel2.add(LastName_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        Email_Label.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Email_Label.setForeground(new java.awt.Color(255, 255, 255));
        Email_Label.setText("Email:");
        jPanel2.add(Email_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        Password_Label.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Password_Label.setForeground(new java.awt.Color(255, 255, 255));
        Password_Label.setText("Password:");
        jPanel2.add(Password_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        PhoneNumber_Label.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        PhoneNumber_Label.setForeground(new java.awt.Color(255, 255, 255));
        PhoneNumber_Label.setText("Phone Number:");
        jPanel2.add(PhoneNumber_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        Birthday_Label.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Birthday_Label.setForeground(new java.awt.Color(255, 255, 255));
        Birthday_Label.setText("Birthday:");
        jPanel2.add(Birthday_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        Identification_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Identification_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Identification_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(234, 85, 3)));
        jPanel2.add(Identification_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 290, -1));

        FirstName_TextField.setBackground(new java.awt.Color(255, 255, 255));
        FirstName_TextField.setForeground(new java.awt.Color(0, 0, 0));
        FirstName_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(234, 85, 3)));
        jPanel2.add(FirstName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 290, -1));

        LastName_TextField.setBackground(new java.awt.Color(255, 255, 255));
        LastName_TextField.setForeground(new java.awt.Color(0, 0, 0));
        LastName_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(234, 85, 3)));
        jPanel2.add(LastName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 290, -1));

        Email_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Email_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Email_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(234, 85, 3)));
        jPanel2.add(Email_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 290, -1));

        Password_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Password_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Password_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(234, 85, 3)));
        jPanel2.add(Password_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 290, -1));

        PhoneNumber_TextField.setBackground(new java.awt.Color(255, 255, 255));
        PhoneNumber_TextField.setForeground(new java.awt.Color(0, 0, 0));
        PhoneNumber_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(234, 85, 3)));
        jPanel2.add(PhoneNumber_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 290, -1));

        BirthdayMonth_TextField.setBackground(new java.awt.Color(255, 255, 255));
        BirthdayMonth_TextField.setForeground(new java.awt.Color(0, 0, 0));
        BirthdayMonth_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(234, 85, 3)));
        jPanel2.add(BirthdayMonth_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 90, -1));

        BirthdayDay_TextField.setBackground(new java.awt.Color(255, 255, 255));
        BirthdayDay_TextField.setForeground(new java.awt.Color(0, 0, 0));
        BirthdayDay_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(234, 85, 3)));
        jPanel2.add(BirthdayDay_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 90, -1));

        BirthdayYear_TextField.setBackground(new java.awt.Color(255, 255, 255));
        BirthdayYear_TextField.setForeground(new java.awt.Color(0, 0, 0));
        BirthdayYear_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(234, 85, 3)));
        jPanel2.add(BirthdayYear_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 90, -1));

        Register_Buttton.setBackground(new java.awt.Color(15, 172, 103));
        Register_Buttton.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Register_Buttton.setForeground(new java.awt.Color(255, 255, 255));
        Register_Buttton.setText("Register!");
        Register_Buttton.setBorder(null);
        Register_Buttton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_ButttonActionPerformed(evt);
            }
        });
        jPanel2.add(Register_Buttton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 200, 150));

        MenuBlack_Panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 590, 500));

        RegisterNow_Label.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        RegisterNow_Label.setForeground(new java.awt.Color(255, 240, 1));
        RegisterNow_Label.setText("Register Now!");
        MenuBlack_Panel.add(RegisterNow_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        Banner_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner.jpg"))); // NOI18N
        MenuBlack_Panel.add(Banner_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        getContentPane().add(MenuBlack_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 720));

        LogIn_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Register_Wallpaper.jpg"))); // NOI18N
        getContentPane().add(LogIn_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Exit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_ButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Exit_ButtonActionPerformed

    private void Register_ButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_ButttonActionPerformed
      
            int person_id = Integer.parseInt(Identification_TextField.getText());
            String person_firstname = FirstName_TextField.getText();
            String person_lastname = LastName_TextField.getText();
            String person_email = Email_TextField.getText();
            String person_password = Password_TextField.getText();
            String person_phonenumber = PhoneNumber_TextField.getText();
            String year = BirthdayYear_TextField.getText();
            String month = BirthdayMonth_TextField.getText();
            String day = BirthdayDay_TextField.getText();
            
            String person_birthday = year + "-" + month + "-"+ day;
            System.out.println(person_birthday);

            
            //Date person_birthday=Date.valueOf(sDate);//converting string into sql date.
            //System.out.println(person_birthday);
            

            //Verificar que campos tengan datos correctos! antes de insertar
            
            
            
        try {
            DBConnection.ConnectDB.insertPerson(person_id, person_firstname, person_lastname, person_email, person_password, person_password,person_birthday,1);
            LendIziCollection.setIdentification(person_id);
            LendIziCollection.setEmail(person_email);
            
            
            
            Users_Menu result = new Users_Menu();
            dispose();
            result.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Register_Window.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Register_ButttonActionPerformed

    private void Return_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Return_ButtonActionPerformed
       LendIziCollection.setIdentification(0);
       LendIziCollection.setEmail(null);
       Main_Menu result = new Main_Menu();
       dispose();
       result.setVisible(true);
    }//GEN-LAST:event_Return_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Register_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Banner_Label;
    private javax.swing.JTextField BirthdayDay_TextField;
    private javax.swing.JTextField BirthdayMonth_TextField;
    private javax.swing.JTextField BirthdayYear_TextField;
    private javax.swing.JLabel Birthday_Label;
    private javax.swing.JLabel Email_Label;
    private javax.swing.JTextField Email_TextField;
    private javax.swing.JButton Exit_Button;
    private javax.swing.JLabel FirstName_Label;
    private javax.swing.JTextField FirstName_TextField;
    private javax.swing.JLabel Identification_Label;
    private javax.swing.JLabel Identification_Label1;
    private javax.swing.JTextField Identification_TextField;
    private javax.swing.JLabel LastName_Label;
    private javax.swing.JTextField LastName_TextField;
    private javax.swing.JLabel LogIn_Wallpaper;
    private javax.swing.JPanel MenuBlack_Panel;
    private javax.swing.JLabel Password_Label;
    private javax.swing.JTextField Password_TextField;
    private javax.swing.JLabel PhoneNumber_Label;
    private javax.swing.JTextField PhoneNumber_TextField;
    private javax.swing.JLabel RegisterNow_Label;
    private javax.swing.JButton Register_Buttton;
    private javax.swing.JButton Return_Button;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
