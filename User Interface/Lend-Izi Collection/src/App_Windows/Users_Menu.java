
package App_Windows;



import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import DBConnection.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import lend.izi.collection.LendIziCollection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Users_Menu extends javax.swing.JFrame {

    private ChartFrame frame;
    int selected_item_id;
    
    public Users_Menu() {
     
     this.setUndecorated(true);
     initComponents();
     Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
     
       
       try{
          ResultSet res = DBConnection.ConnectDB.updateToleranceDays(LendIziCollection.getIdentification());
          
          while(res.next()){
              String item_id = res.getString(2);
              String return_date_string = res.getString(4);
              String item_status = res.getString(8);

              String current_date_local = java.time.LocalDate.now().toString();
              
              Date return_date = new SimpleDateFormat("yyyy-MM-dd").parse(return_date_string);  
              Date sysdate = new SimpleDateFormat("yyyy-MM-dd").parse(current_date_local);  


              if(return_date.before(sysdate) || return_date.equals(sysdate)){
                    if(item_status.equals("1")){
                        String person2_id = res.getString(1);
                        String tolerance_yellow = res.getString(6);
                        LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(return_date) );
                        int tolerance_days_yellow = Integer.parseInt(tolerance_yellow);

                          
                        String new_date = localDate.plusDays(tolerance_days_yellow).toString();
                        System.out.println(new_date);
                       
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed = sdf.parse(new_date);
                        java.sql.Date data = new java.sql.Date(parsed.getTime());
                        
                        
                        DBConnection.ConnectDB.updatePersonLendItemReturnDate(LendIziCollection.getIdentification(), Integer.parseInt(person2_id),data);
                        DBConnection.ConnectDB.updateItemStatus(Integer.parseInt(item_id), 2);
                    }
                    
                    else if(item_status.equals("2")){
                        
                        String person2_id = res.getString(1);
                        String tolerance_red = res.getString(7);
                        LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(return_date) );
                        int tolerance_days_red = Integer.parseInt(tolerance_red);

                          
                        String new_date = localDate.plusDays(tolerance_days_red).toString();
                        System.out.println(new_date);
                       
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed = sdf.parse(new_date);
                        java.sql.Date data = new java.sql.Date(parsed.getTime());
                        
                        
                        DBConnection.ConnectDB.updatePersonLendItemReturnDate(LendIziCollection.getIdentification(), Integer.parseInt(person2_id),data);
                        DBConnection.ConnectDB.updateItemStatus(Integer.parseInt(item_id), 3);
                    }
                    
                    else if(item_status.equals("3")){
                        
                        String person2_id = res.getString(1);
                       
                        LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(return_date) );


                          
                        String new_date = localDate.plusDays(365).toString();
                        System.out.println(new_date);
                       
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed = sdf.parse(new_date);
                        java.sql.Date data = new java.sql.Date(parsed.getTime());
                        
                        
                        DBConnection.ConnectDB.updatePersonLendItemReturnDate(LendIziCollection.getIdentification(), Integer.parseInt(person2_id),data);
                        DBConnection.ConnectDB.updateItemStatus(Integer.parseInt(item_id), 5);
                    }
                    
               } 

              
              else{
               System.out.println("Adiós Varo!");

              }
          }
           
           
      } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, ex);
      } 
       
       
       
       
     this.setLocationRelativeTo(null);
     
     byte[] photo = null;
     
     
     
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Collection_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel = new javax.swing.JPanel();
        Title_Label = new javax.swing.JLabel();
        Subtitle_Label = new javax.swing.JLabel();
        Upper_Banner = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Collection_Table = new CellColor();
        ItemInfo_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel16 = new javax.swing.JPanel();
        Title_Label16 = new javax.swing.JLabel();
        Subtitle_Label16 = new javax.swing.JLabel();
        Upper_Banner16 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        ItemType_Label1 = new javax.swing.JLabel();
        Genre_Label1 = new javax.swing.JLabel();
        ItemEdition_Label1 = new javax.swing.JLabel();
        ItemBarcode_Label1 = new javax.swing.JLabel();
        ItemTitle_Label1 = new javax.swing.JLabel();
        Publisher_Label2 = new javax.swing.JLabel();
        TitleItem_TextField = new javax.swing.JTextField();
        EditionItem_TextField = new javax.swing.JTextField();
        BarbcodeItem_TextField = new javax.swing.JTextField();
        CommitChanges_Button = new javax.swing.JButton();
        AddPhoto_Button1 = new javax.swing.JButton();
        Cover_Image_Label1 = new javax.swing.JLabel();
        RemoveItem_CheckBox = new javax.swing.JCheckBox();
        UpdateItem_CheckBox = new javax.swing.JCheckBox();
        ItemType_ComboBox1 = new javax.swing.JComboBox<>();
        Publisher_ComboBox2 = new javax.swing.JComboBox<>();
        Genre_ComboBox1 = new javax.swing.JComboBox<>();
        AddPeople_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel1 = new javax.swing.JPanel();
        Title_Label1 = new javax.swing.JLabel();
        Subtitle_Label1 = new javax.swing.JLabel();
        Upper_Banner1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PersonEmail_TextField = new javax.swing.JTextField();
        RelationType_Label = new javax.swing.JLabel();
        RelationType_ComboBox = new javax.swing.JComboBox<>();
        PersonEmail_Label = new javax.swing.JLabel();
        AddPeople_Button = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        RelationType_Table = new javax.swing.JTable();
        RemovePersonKnowsPerson_CheckBox = new javax.swing.JCheckBox();
        LendItem_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel2 = new javax.swing.JPanel();
        Title_Label2 = new javax.swing.JLabel();
        Subtitle_Label2 = new javax.swing.JLabel();
        Upper_Banner2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Day_TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SelectIItem_ComboBox = new javax.swing.JComboBox<>();
        Lend_Button = new javax.swing.JButton();
        SelectITem_Label = new javax.swing.JLabel();
        YellowTolerance_TextField = new javax.swing.JTextField();
        Month_TextField = new javax.swing.JTextField();
        ToleranceDays_Label = new javax.swing.JLabel();
        ReturnDate_Label = new javax.swing.JLabel();
        RedTolerance_TextField = new javax.swing.JTextField();
        Year_TextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        LendItemPersons_Table = new javax.swing.JTable();
        SelectITem_Label2 = new javax.swing.JLabel();
        ReceiveItem_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel3 = new javax.swing.JPanel();
        Title_Label3 = new javax.swing.JLabel();
        Subtitle_Label3 = new javax.swing.JLabel();
        Upper_Banner3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Receive_Button = new javax.swing.JButton();
        SelectITem_Label1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LendedItems_Table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        ReviewItem_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel4 = new javax.swing.JPanel();
        Title_Label4 = new javax.swing.JLabel();
        Subtitle_Label4 = new javax.swing.JLabel();
        Upper_Banner4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        SelectReview_ComboBox = new javax.swing.JComboBox<>();
        Review_Button = new javax.swing.JButton();
        SelectItem_Label2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Review_Table = new javax.swing.JTable();
        SelectStars_Label = new javax.swing.JLabel();
        Queries_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel15 = new javax.swing.JPanel();
        Title_Label15 = new javax.swing.JLabel();
        Subtitle_Label15 = new javax.swing.JLabel();
        Upper_Banner15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        ParametersText_Label = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Queries_Table = new javax.swing.JTable();
        Select_Label2 = new javax.swing.JLabel();
        Parameter2_TextField = new javax.swing.JTextField();
        Go_Button = new javax.swing.JButton();
        Parameter1_TextField = new javax.swing.JTextField();
        New_ComboBox = new javax.swing.JComboBox<>();
        Total_TextField = new javax.swing.JTextField();
        Parameters_Label = new javax.swing.JLabel();
        Filter_ComboBox = new javax.swing.JComboBox<>();
        Parameters_Label1 = new javax.swing.JLabel();
        AddItem_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel7 = new javax.swing.JPanel();
        Title_Label7 = new javax.swing.JLabel();
        Subtitle_Label7 = new javax.swing.JLabel();
        Upper_Banner7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        ItemType_Label = new javax.swing.JLabel();
        Genre_ComboBox = new javax.swing.JComboBox<>();
        Genre_Label = new javax.swing.JLabel();
        ItemEdition_Label = new javax.swing.JLabel();
        ItemBarcode_Label = new javax.swing.JLabel();
        ItemTitle_Label = new javax.swing.JLabel();
        Publisher_Label1 = new javax.swing.JLabel();
        ItemType_ComboBox = new javax.swing.JComboBox<>();
        ItemTitle_TextField = new javax.swing.JTextField();
        ItemEdition_TextField = new javax.swing.JTextField();
        ItemBarbcode_TextField = new javax.swing.JTextField();
        AddItem_Button = new javax.swing.JButton();
        AddPhoto_Button = new javax.swing.JButton();
        Cover_Image_Label = new javax.swing.JLabel();
        Publisher_ComboBox = new javax.swing.JComboBox<>();
        Menu_Panel = new javax.swing.JPanel();
        Divisor_Panel = new javax.swing.JPanel();
        Banner_Label = new javax.swing.JLabel();
        Lateral_Button1 = new javax.swing.JButton();
        Lateral_Button3 = new javax.swing.JButton();
        Lateral_Button4 = new javax.swing.JButton();
        Lateral_Button5 = new javax.swing.JButton();
        Lateral_Button6 = new javax.swing.JButton();
        Lateral_Button2 = new javax.swing.JButton();
        AddItem_Panel = new javax.swing.JPanel();
        AddAnItem_Button = new javax.swing.JButton();
        MainMenu_Button = new javax.swing.JButton();
        Return_Button = new javax.swing.JButton();
        Exit_Button = new javax.swing.JButton();
        Wallpaper_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Collection_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        Collection_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(233, 85, 4)));
        Collection_InternalFrame.setClosable(true);
        Collection_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        Collection_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        Collection_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        Collection_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        Collection_InternalFrame.setVisible(false);
        Collection_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label.setText("Your Collection!");
        Background_Panel.add(Title_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        Subtitle_Label.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label.setText("See your items and their current status...");
        Background_Panel.add(Subtitle_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        Upper_Banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel.add(Upper_Banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Collection_Table.setBackground(new java.awt.Color(255, 255, 255));
        Collection_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Collection_Table.setRowSelectionAllowed(false);
        Collection_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Collection_TableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Collection_Table);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 510));

        Background_Panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        Collection_InternalFrame.getContentPane().add(Background_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(Collection_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        ItemInfo_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        ItemInfo_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(233, 85, 4)));
        ItemInfo_InternalFrame.setClosable(true);
        ItemInfo_InternalFrame.setForeground(new java.awt.Color(0, 0, 0));
        ItemInfo_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        ItemInfo_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        ItemInfo_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        ItemInfo_InternalFrame.setVisible(false);
        ItemInfo_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel16.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label16.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label16.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label16.setText("See your Item Info!");
        Background_Panel16.add(Title_Label16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label16.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label16.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label16.setText("See details or change them...");
        Background_Panel16.add(Subtitle_Label16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        Upper_Banner16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel16.add(Upper_Banner16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ItemType_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemType_Label1.setForeground(new java.awt.Color(255, 255, 255));
        ItemType_Label1.setText("Item Type:");
        jPanel17.add(ItemType_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        Genre_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Genre_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Genre_Label1.setText("Genre:");
        jPanel17.add(Genre_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        ItemEdition_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemEdition_Label1.setForeground(new java.awt.Color(255, 255, 255));
        ItemEdition_Label1.setText("Item Edition:");
        jPanel17.add(ItemEdition_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        ItemBarcode_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemBarcode_Label1.setForeground(new java.awt.Color(255, 255, 255));
        ItemBarcode_Label1.setText("Item Barcode:");
        jPanel17.add(ItemBarcode_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        ItemTitle_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemTitle_Label1.setForeground(new java.awt.Color(255, 255, 255));
        ItemTitle_Label1.setText("Item Title:");
        jPanel17.add(ItemTitle_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        Publisher_Label2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Publisher_Label2.setForeground(new java.awt.Color(255, 255, 255));
        Publisher_Label2.setText("Publisher:");
        jPanel17.add(Publisher_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        TitleItem_TextField.setBackground(new java.awt.Color(255, 255, 255));
        TitleItem_TextField.setForeground(new java.awt.Color(0, 0, 0));
        TitleItem_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(233, 85, 4)));
        jPanel17.add(TitleItem_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 260, 30));

        EditionItem_TextField.setBackground(new java.awt.Color(255, 255, 255));
        EditionItem_TextField.setForeground(new java.awt.Color(0, 0, 0));
        EditionItem_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(233, 85, 4)));
        jPanel17.add(EditionItem_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 260, 30));

        BarbcodeItem_TextField.setBackground(new java.awt.Color(255, 255, 255));
        BarbcodeItem_TextField.setForeground(new java.awt.Color(0, 0, 0));
        BarbcodeItem_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(233, 85, 4)));
        jPanel17.add(BarbcodeItem_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 260, 30));

        CommitChanges_Button.setBackground(new java.awt.Color(255, 240, 0));
        CommitChanges_Button.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        CommitChanges_Button.setForeground(new java.awt.Color(0, 0, 0));
        CommitChanges_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonWhite.png"))); // NOI18N
        CommitChanges_Button.setText("Commit Changes");
        CommitChanges_Button.setBorderPainted(false);
        CommitChanges_Button.setContentAreaFilled(false);
        CommitChanges_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CommitChanges_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommitChanges_ButtonActionPerformed(evt);
            }
        });
        jPanel17.add(CommitChanges_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 190, 40));

        AddPhoto_Button1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        AddPhoto_Button1.setForeground(new java.awt.Color(255, 255, 255));
        AddPhoto_Button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Camera_Icon32.png"))); // NOI18N
        AddPhoto_Button1.setText("   Change Cover Image!");
        AddPhoto_Button1.setBorder(null);
        AddPhoto_Button1.setBorderPainted(false);
        AddPhoto_Button1.setContentAreaFilled(false);
        AddPhoto_Button1.setFocusable(false);
        AddPhoto_Button1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddPhoto_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPhoto_Button1ActionPerformed(evt);
            }
        });
        jPanel17.add(AddPhoto_Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 280, 60));
        jPanel17.add(Cover_Image_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 250, 250));

        RemoveItem_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        RemoveItem_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RemoveItem_CheckBox.setText("Remove");
        RemoveItem_CheckBox.setContentAreaFilled(false);
        RemoveItem_CheckBox.setFocusable(false);
        RemoveItem_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveItem_CheckBoxActionPerformed(evt);
            }
        });
        jPanel17.add(RemoveItem_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 80, -1));

        UpdateItem_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        UpdateItem_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        UpdateItem_CheckBox.setText("Update");
        UpdateItem_CheckBox.setContentAreaFilled(false);
        UpdateItem_CheckBox.setFocusable(false);
        UpdateItem_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateItem_CheckBoxActionPerformed(evt);
            }
        });
        jPanel17.add(UpdateItem_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 80, -1));

        ItemType_ComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        ItemType_ComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        ItemType_ComboBox1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(233, 85, 4)));
        jPanel17.add(ItemType_ComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 260, 30));

        Publisher_ComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        Publisher_ComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        Publisher_ComboBox2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(233, 85, 4)));
        jPanel17.add(Publisher_ComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 260, 30));

        Genre_ComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        Genre_ComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        Genre_ComboBox1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(233, 85, 4)));
        jPanel17.add(Genre_ComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 260, 30));

        Background_Panel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        ItemInfo_InternalFrame.getContentPane().add(Background_Panel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(ItemInfo_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        AddPeople_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        AddPeople_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 240, 0)));
        AddPeople_InternalFrame.setClosable(true);
        AddPeople_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        AddPeople_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        AddPeople_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        AddPeople_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        AddPeople_InternalFrame.setVisible(false);
        AddPeople_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel1.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label1.setText("Add People and See Your Friends!");
        Background_Panel1.add(Title_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        Subtitle_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label1.setText("Family, friends, coworkers, everyone is here!");
        Background_Panel1.add(Subtitle_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        Upper_Banner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel1.add(Upper_Banner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PersonEmail_TextField.setBackground(new java.awt.Color(255, 255, 255));
        PersonEmail_TextField.setForeground(new java.awt.Color(0, 0, 0));
        PersonEmail_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 240, 0)));
        jPanel1.add(PersonEmail_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 260, 30));

        RelationType_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        RelationType_Label.setForeground(new java.awt.Color(255, 255, 255));
        RelationType_Label.setText("Relation Type:");
        jPanel1.add(RelationType_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        RelationType_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        RelationType_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        RelationType_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 240, 0)));
        jPanel1.add(RelationType_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 260, 30));

        PersonEmail_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        PersonEmail_Label.setForeground(new java.awt.Color(255, 255, 255));
        PersonEmail_Label.setText("Person Email:");
        jPanel1.add(PersonEmail_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        AddPeople_Button.setBackground(new java.awt.Color(255, 240, 0));
        AddPeople_Button.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        AddPeople_Button.setForeground(new java.awt.Color(0, 0, 0));
        AddPeople_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonWhite.png"))); // NOI18N
        AddPeople_Button.setText("Add!");
        AddPeople_Button.setBorderPainted(false);
        AddPeople_Button.setContentAreaFilled(false);
        AddPeople_Button.setFocusable(false);
        AddPeople_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddPeople_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPeople_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddPeople_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 320, 100));

        RelationType_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        RelationType_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RelationType_TableMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(RelationType_Table);

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 470, 230));

        RemovePersonKnowsPerson_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        RemovePersonKnowsPerson_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RemovePersonKnowsPerson_CheckBox.setText("Remove");
        RemovePersonKnowsPerson_CheckBox.setBorder(null);
        RemovePersonKnowsPerson_CheckBox.setContentAreaFilled(false);
        RemovePersonKnowsPerson_CheckBox.setFocusable(false);
        RemovePersonKnowsPerson_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovePersonKnowsPerson_CheckBoxActionPerformed(evt);
            }
        });
        jPanel1.add(RemovePersonKnowsPerson_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 110, -1));

        Background_Panel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        AddPeople_InternalFrame.getContentPane().add(Background_Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(AddPeople_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        LendItem_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        LendItem_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(242, 150, 0)));
        LendItem_InternalFrame.setClosable(true);
        LendItem_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        LendItem_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        LendItem_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        LendItem_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        LendItem_InternalFrame.setVisible(false);
        LendItem_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel2.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label2.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label2.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label2.setText("Lend Your Items!");
        Background_Panel2.add(Title_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        Subtitle_Label2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label2.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label2.setText("Sharing never was so easy!");
        Background_Panel2.add(Subtitle_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        Upper_Banner2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel2.add(Upper_Banner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Day_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Day_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Day_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(242, 150, 0)));
        Day_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Day_TextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(Day_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 80, 30));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("yyyy                    mm                    dd");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        SelectIItem_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        SelectIItem_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        SelectIItem_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(242, 150, 0)));
        jPanel2.add(SelectIItem_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 260, 30));

        Lend_Button.setBackground(new java.awt.Color(255, 240, 0));
        Lend_Button.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Lend_Button.setForeground(new java.awt.Color(0, 0, 0));
        Lend_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonWhite.png"))); // NOI18N
        Lend_Button.setText("Lend-Izi!");
        Lend_Button.setBorderPainted(false);
        Lend_Button.setContentAreaFilled(false);
        Lend_Button.setFocusable(false);
        Lend_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lend_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lend_ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(Lend_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 320, 100));

        SelectITem_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectITem_Label.setForeground(new java.awt.Color(255, 255, 255));
        SelectITem_Label.setText("Select Item:");
        jPanel2.add(SelectITem_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        YellowTolerance_TextField.setBackground(new java.awt.Color(255, 255, 255));
        YellowTolerance_TextField.setForeground(new java.awt.Color(0, 0, 0));
        YellowTolerance_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(242, 150, 0)));
        jPanel2.add(YellowTolerance_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 80, 30));

        Month_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Month_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Month_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(242, 150, 0)));
        jPanel2.add(Month_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 80, 30));

        ToleranceDays_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ToleranceDays_Label.setForeground(new java.awt.Color(255, 255, 255));
        ToleranceDays_Label.setText("Tolerance Days:");
        jPanel2.add(ToleranceDays_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        ReturnDate_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ReturnDate_Label.setForeground(new java.awt.Color(255, 255, 255));
        ReturnDate_Label.setText("Return Date:");
        jPanel2.add(ReturnDate_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        RedTolerance_TextField.setBackground(new java.awt.Color(255, 255, 255));
        RedTolerance_TextField.setForeground(new java.awt.Color(0, 0, 0));
        RedTolerance_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(242, 150, 0)));
        jPanel2.add(RedTolerance_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 80, 30));

        Year_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Year_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Year_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(242, 150, 0)));
        jPanel2.add(Year_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 80, 30));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("min                         max");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 150, 30));

        LendItemPersons_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        LendItemPersons_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LendItemPersons_TableMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(LendItemPersons_Table);

        jPanel2.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 460, 280));

        SelectITem_Label2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectITem_Label2.setForeground(new java.awt.Color(255, 255, 255));
        SelectITem_Label2.setText("Select Person:");
        jPanel2.add(SelectITem_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        Background_Panel2.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        LendItem_InternalFrame.getContentPane().add(Background_Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(LendItem_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        ReceiveItem_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        ReceiveItem_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 159, 232)));
        ReceiveItem_InternalFrame.setClosable(true);
        ReceiveItem_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        ReceiveItem_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        ReceiveItem_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        ReceiveItem_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        ReceiveItem_InternalFrame.setVisible(false);
        ReceiveItem_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel3.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label3.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label3.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label3.setText("Mark Your Items As Received!");
        Background_Panel3.add(Title_Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label3.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label3.setText("Stay in control with your items!");
        Background_Panel3.add(Subtitle_Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        Upper_Banner3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel3.add(Upper_Banner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Receive_Button.setBackground(new java.awt.Color(255, 240, 0));
        Receive_Button.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Receive_Button.setForeground(new java.awt.Color(0, 0, 0));
        Receive_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonWhite.png"))); // NOI18N
        Receive_Button.setText("Receive - Izi");
        Receive_Button.setBorderPainted(false);
        Receive_Button.setContentAreaFilled(false);
        Receive_Button.setFocusable(false);
        Receive_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Receive_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Receive_ButtonActionPerformed(evt);
            }
        });
        jPanel3.add(Receive_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 320, 100));

        SelectITem_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectITem_Label1.setForeground(new java.awt.Color(255, 255, 255));
        SelectITem_Label1.setText("Select the item you have loaned:");
        jPanel3.add(SelectITem_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        LendedItems_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(LendedItems_Table);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 790, 280));

        jButton2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Email_Icon64.png"))); // NOI18N
        jButton2.setText("Send Email !");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 110, 90));

        Background_Panel3.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        ReceiveItem_InternalFrame.getContentPane().add(Background_Panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(ReceiveItem_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        ReviewItem_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        ReviewItem_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(238, 141, 183)));
        ReviewItem_InternalFrame.setClosable(true);
        ReviewItem_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        ReviewItem_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        ReviewItem_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        ReviewItem_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        ReviewItem_InternalFrame.setVisible(false);
        ReviewItem_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel4.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label4.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label4.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label4.setText("Review Your Items!");
        Background_Panel4.add(Title_Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label4.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label4.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label4.setText("Stars means greatness");
        Background_Panel4.add(Subtitle_Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        Upper_Banner4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel4.add(Upper_Banner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectReview_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        SelectReview_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        SelectReview_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "★", "★★", "★★★", "★★★★", "★★★★★" }));
        SelectReview_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(238, 141, 183)));
        jPanel4.add(SelectReview_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 260, 30));

        Review_Button.setBackground(new java.awt.Color(255, 240, 0));
        Review_Button.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Review_Button.setForeground(new java.awt.Color(0, 0, 0));
        Review_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonWhite.png"))); // NOI18N
        Review_Button.setText("Review!");
        Review_Button.setBorderPainted(false);
        Review_Button.setContentAreaFilled(false);
        Review_Button.setFocusable(false);
        Review_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Review_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Review_ButtonActionPerformed(evt);
            }
        });
        jPanel4.add(Review_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 320, 100));

        SelectItem_Label2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectItem_Label2.setForeground(new java.awt.Color(255, 255, 255));
        SelectItem_Label2.setText("Select Item:");
        jPanel4.add(SelectItem_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        Review_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(Review_Table);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 780, 240));

        SelectStars_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectStars_Label.setForeground(new java.awt.Color(255, 255, 255));
        SelectStars_Label.setText("Select Stars:");
        jPanel4.add(SelectStars_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        Background_Panel4.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        ReviewItem_InternalFrame.getContentPane().add(Background_Panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(ReviewItem_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        Queries_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        Queries_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(13, 172, 103)));
        Queries_InternalFrame.setClosable(true);
        Queries_InternalFrame.setForeground(new java.awt.Color(0, 0, 0));
        Queries_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        Queries_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        Queries_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        Queries_InternalFrame.setVisible(false);
        Queries_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel15.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label15.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label15.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label15.setText("Queries!");
        Background_Panel15.add(Title_Label15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label15.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label15.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label15.setText("See infor about your database...");
        Background_Panel15.add(Subtitle_Label15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        Upper_Banner15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel15.add(Upper_Banner15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ParametersText_Label.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ParametersText_Label.setForeground(new java.awt.Color(255, 255, 255));
        ParametersText_Label.setText("Parameters:");
        jPanel16.add(ParametersText_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 220, -1));

        Queries_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(Queries_Table);

        jPanel16.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 800, 370));

        Select_Label2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Select_Label2.setForeground(new java.awt.Color(255, 255, 255));
        Select_Label2.setText("Select:");
        jPanel16.add(Select_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        Parameter2_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Parameter2_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Parameter2_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(13, 172, 103)));
        jPanel16.add(Parameter2_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 110, 30));

        Go_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Go_Button.setForeground(new java.awt.Color(255, 255, 255));
        Go_Button.setText("Go!");
        Go_Button.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(13, 172, 103)));
        Go_Button.setContentAreaFilled(false);
        Go_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Go_ButtonActionPerformed(evt);
            }
        });
        jPanel16.add(Go_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 40, 30));

        Parameter1_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Parameter1_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Parameter1_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(13, 172, 103)));
        Parameter1_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Parameter1_TextFieldActionPerformed(evt);
            }
        });
        jPanel16.add(Parameter1_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 110, 30));

        New_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        New_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        New_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Items", "All Lended Items" }));
        New_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(13, 172, 103)));
        New_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                New_ComboBoxActionPerformed(evt);
            }
        });
        jPanel16.add(New_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 320, 30));

        Total_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Total_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Total_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(13, 172, 103)));
        jPanel16.add(Total_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 320, 30));

        Parameters_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Parameters_Label.setForeground(new java.awt.Color(255, 255, 255));
        Parameters_Label.setText("Filter By:");
        jPanel16.add(Parameters_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        Filter_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        Filter_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        Filter_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(13, 172, 103)));
        Filter_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_ComboBoxActionPerformed(evt);
            }
        });
        jPanel16.add(Filter_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 160, 30));

        Parameters_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Parameters_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Parameters_Label1.setText("Parameters:");
        jPanel16.add(Parameters_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, -1, -1));

        Background_Panel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 550));

        Queries_InternalFrame.getContentPane().add(Background_Panel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(Queries_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        AddItem_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        AddItem_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        AddItem_InternalFrame.setClosable(true);
        AddItem_InternalFrame.setForeground(new java.awt.Color(0, 0, 0));
        AddItem_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        AddItem_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        AddItem_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        AddItem_InternalFrame.setVisible(false);
        AddItem_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel7.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label7.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label7.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label7.setText("Add an Item!");
        Background_Panel7.add(Title_Label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label7.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label7.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label7.setText("Expand your collection...");
        Background_Panel7.add(Subtitle_Label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        Upper_Banner7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel7.add(Upper_Banner7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ItemType_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemType_Label.setForeground(new java.awt.Color(255, 255, 255));
        ItemType_Label.setText("Item Type:");
        jPanel8.add(ItemType_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        Genre_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        Genre_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        Genre_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel8.add(Genre_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 260, 30));

        Genre_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Genre_Label.setForeground(new java.awt.Color(255, 255, 255));
        Genre_Label.setText("Genre:");
        jPanel8.add(Genre_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        ItemEdition_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemEdition_Label.setForeground(new java.awt.Color(255, 255, 255));
        ItemEdition_Label.setText("Item Edition:");
        jPanel8.add(ItemEdition_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        ItemBarcode_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemBarcode_Label.setForeground(new java.awt.Color(255, 255, 255));
        ItemBarcode_Label.setText("Item Barcode:");
        jPanel8.add(ItemBarcode_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        ItemTitle_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemTitle_Label.setForeground(new java.awt.Color(255, 255, 255));
        ItemTitle_Label.setText("Item Title:");
        jPanel8.add(ItemTitle_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        Publisher_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Publisher_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Publisher_Label1.setText("Publisher:");
        jPanel8.add(Publisher_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        ItemType_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        ItemType_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        ItemType_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        jPanel8.add(ItemType_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 260, 30));

        ItemTitle_TextField.setBackground(new java.awt.Color(255, 255, 255));
        ItemTitle_TextField.setForeground(new java.awt.Color(0, 0, 0));
        ItemTitle_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        jPanel8.add(ItemTitle_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 260, 30));

        ItemEdition_TextField.setBackground(new java.awt.Color(255, 255, 255));
        ItemEdition_TextField.setForeground(new java.awt.Color(0, 0, 0));
        ItemEdition_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        jPanel8.add(ItemEdition_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 260, 30));

        ItemBarbcode_TextField.setBackground(new java.awt.Color(255, 255, 255));
        ItemBarbcode_TextField.setForeground(new java.awt.Color(0, 0, 0));
        ItemBarbcode_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        jPanel8.add(ItemBarbcode_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 260, 30));

        AddItem_Button.setBackground(new java.awt.Color(255, 240, 0));
        AddItem_Button.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        AddItem_Button.setForeground(new java.awt.Color(0, 0, 0));
        AddItem_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonWhite.png"))); // NOI18N
        AddItem_Button.setText("Add Item!");
        AddItem_Button.setBorderPainted(false);
        AddItem_Button.setContentAreaFilled(false);
        AddItem_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddItem_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItem_ButtonActionPerformed(evt);
            }
        });
        jPanel8.add(AddItem_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 320, 100));

        AddPhoto_Button.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        AddPhoto_Button.setForeground(new java.awt.Color(255, 255, 255));
        AddPhoto_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Camera_Icon32.png"))); // NOI18N
        AddPhoto_Button.setText("   Add a Cover Image!");
        AddPhoto_Button.setBorder(null);
        AddPhoto_Button.setBorderPainted(false);
        AddPhoto_Button.setContentAreaFilled(false);
        AddPhoto_Button.setFocusable(false);
        AddPhoto_Button.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddPhoto_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPhoto_ButtonActionPerformed(evt);
            }
        });
        jPanel8.add(AddPhoto_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 280, 60));
        jPanel8.add(Cover_Image_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 250, 250));

        Publisher_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        Publisher_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        Publisher_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        jPanel8.add(Publisher_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 260, 30));

        Background_Panel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        AddItem_InternalFrame.getContentPane().add(Background_Panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(AddItem_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        Menu_Panel.setBackground(new java.awt.Color(0, 0, 0));
        Menu_Panel.setForeground(new java.awt.Color(0, 0, 0));
        Menu_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Divisor_Panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Divisor_PanelLayout = new javax.swing.GroupLayout(Divisor_Panel);
        Divisor_Panel.setLayout(Divisor_PanelLayout);
        Divisor_PanelLayout.setHorizontalGroup(
            Divisor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        Divisor_PanelLayout.setVerticalGroup(
            Divisor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        Menu_Panel.add(Divisor_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, 360, 3));

        Banner_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner.jpg"))); // NOI18N
        Menu_Panel.add(Banner_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 60));

        Lateral_Button1.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Lateral_Button1.setForeground(new java.awt.Color(255, 255, 255));
        Lateral_Button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LateralButton1.png"))); // NOI18N
        Lateral_Button1.setText("              See Collection!");
        Lateral_Button1.setAlignmentX(5.0F);
        Lateral_Button1.setBorderPainted(false);
        Lateral_Button1.setFocusable(false);
        Lateral_Button1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lateral_Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lateral_Button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Lateral_Button1MouseExited(evt);
            }
        });
        Lateral_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lateral_Button1ActionPerformed(evt);
            }
        });
        Menu_Panel.add(Lateral_Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 170, 440, 60));

        Lateral_Button3.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Lateral_Button3.setForeground(new java.awt.Color(255, 255, 255));
        Lateral_Button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LateralButton3.png"))); // NOI18N
        Lateral_Button3.setText("Lend Item");
        Lateral_Button3.setAlignmentX(5.0F);
        Lateral_Button3.setBorderPainted(false);
        Lateral_Button3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lateral_Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lateral_Button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Lateral_Button3MouseExited(evt);
            }
        });
        Lateral_Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lateral_Button3ActionPerformed(evt);
            }
        });
        Menu_Panel.add(Lateral_Button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 290, 440, 60));

        Lateral_Button4.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Lateral_Button4.setForeground(new java.awt.Color(0, 0, 0));
        Lateral_Button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LateralButton4.png"))); // NOI18N
        Lateral_Button4.setText("        Receive Item");
        Lateral_Button4.setAlignmentX(5.0F);
        Lateral_Button4.setBorderPainted(false);
        Lateral_Button4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lateral_Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lateral_Button4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Lateral_Button4MouseExited(evt);
            }
        });
        Lateral_Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lateral_Button4ActionPerformed(evt);
            }
        });
        Menu_Panel.add(Lateral_Button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 350, 440, 60));

        Lateral_Button5.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Lateral_Button5.setForeground(new java.awt.Color(255, 255, 255));
        Lateral_Button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LateralButton5.png"))); // NOI18N
        Lateral_Button5.setText("      Review Item");
        Lateral_Button5.setAlignmentX(5.0F);
        Lateral_Button5.setBorderPainted(false);
        Lateral_Button5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lateral_Button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lateral_Button5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Lateral_Button5MouseExited(evt);
            }
        });
        Lateral_Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lateral_Button5ActionPerformed(evt);
            }
        });
        Menu_Panel.add(Lateral_Button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 410, 440, 60));

        Lateral_Button6.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Lateral_Button6.setForeground(new java.awt.Color(0, 0, 0));
        Lateral_Button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LateralButton6.png"))); // NOI18N
        Lateral_Button6.setText("                      Do some Queries!");
        Lateral_Button6.setAlignmentX(5.0F);
        Lateral_Button6.setBorderPainted(false);
        Lateral_Button6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lateral_Button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lateral_Button6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Lateral_Button6MouseExited(evt);
            }
        });
        Lateral_Button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lateral_Button6ActionPerformed(evt);
            }
        });
        Menu_Panel.add(Lateral_Button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 470, 440, 60));

        Lateral_Button2.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Lateral_Button2.setForeground(new java.awt.Color(0, 0, 0));
        Lateral_Button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LateralButton2.png"))); // NOI18N
        Lateral_Button2.setText("                        Add known person");
        Lateral_Button2.setAlignmentX(5.0F);
        Lateral_Button2.setBorderPainted(false);
        Lateral_Button2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lateral_Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lateral_Button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Lateral_Button2MouseExited(evt);
            }
        });
        Lateral_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lateral_Button2ActionPerformed(evt);
            }
        });
        Menu_Panel.add(Lateral_Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 230, 440, 60));

        AddItem_Panel.setBackground(new java.awt.Color(204, 204, 204));
        AddItem_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddItem_PanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddItem_PanelMouseExited(evt);
            }
        });
        AddItem_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddAnItem_Button.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        AddAnItem_Button.setForeground(new java.awt.Color(51, 51, 51));
        AddAnItem_Button.setText("Add an Item!");
        AddAnItem_Button.setBorderPainted(false);
        AddAnItem_Button.setContentAreaFilled(false);
        AddAnItem_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddAnItem_ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddAnItem_ButtonMouseExited(evt);
            }
        });
        AddAnItem_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAnItem_ButtonActionPerformed(evt);
            }
        });
        AddItem_Panel.add(AddAnItem_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 80));

        Menu_Panel.add(AddItem_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 270, 80));

        MainMenu_Button.setFont(new java.awt.Font("Bahnschrift", 0, 22)); // NOI18N
        MainMenu_Button.setForeground(new java.awt.Color(255, 255, 255));
        MainMenu_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Home_Icon_32.png"))); // NOI18N
        MainMenu_Button.setText("Main              Menu");
        MainMenu_Button.setBorderPainted(false);
        MainMenu_Button.setContentAreaFilled(false);
        MainMenu_Button.setFocusable(false);
        MainMenu_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MainMenu_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenu_ButtonActionPerformed(evt);
            }
        });
        Menu_Panel.add(MainMenu_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 240, 40));

        getContentPane().add(Menu_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 720));

        Return_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Return_Button.setForeground(new java.awt.Color(255, 255, 255));
        Return_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout_Icon32.png"))); // NOI18N
        Return_Button.setBorder(null);
        Return_Button.setBorderPainted(false);
        Return_Button.setContentAreaFilled(false);
        Return_Button.setFocusable(false);
        Return_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Return_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Return_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 40, 30, -1));

        Exit_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit Button.png"))); // NOI18N
        Exit_Button.setBorderPainted(false);
        Exit_Button.setContentAreaFilled(false);
        Exit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Exit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 30, 30));

        Wallpaper_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu_Wallpaper.png"))); // NOI18N
        getContentPane().add(Wallpaper_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Lateral_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button1ActionPerformed
     Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);

        Collection_Table.removeAll();
       
       
       
       
       
       
       
       
       DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Item Id");
            modelo.addColumn("Title");
            modelo.addColumn("Publisher");
            modelo.addColumn("Edition");
            modelo.addColumn("Genre");           
            modelo.addColumn("Stars");
            modelo.addColumn("Status");

            
            
       
       try {
           
             //ResultSet res = pst.executeQuery();
                    
             ResultSet res = DBConnection.ConnectDB.getCollection(LendIziCollection.getIdentification());

             String data [] = new String[7];
             

             while(res.next()){
                 data [0] = res.getString(1);
                 data [1] = res.getString(2);
                 data [2] = res.getString(3);
                 data [3] = res.getString(4);
                 data [4] = res.getString(5);
                 
                 if(res.getString(6).equals("1")){
                     data [5] = "★";
                 }
                 
                 else if(res.getString(6).equals("2")){
                     data [5] = "★★";
                 }   
                 
                 else if(res.getString(6).equals("3")){
                     data [5] = "★★★";

                 }   
                 
                 else if(res.getString(6).equals("4")){
                     data [5] = "★★★★";
                    
                 }   
                 
                 else if(res.getString(6).equals("5")){
                     data [5] = "★★★★★";
                 }  
                 
                 else if(res.getString(6).equals("0")){
                        data [5] = "No Review Yet";
                 }  
                 ///////
                 
                 if(res.getString(7).equals("Blue")){
                     data [6] = "In Stock";
                 }
                 
                 else if(res.getString(7).equals("Green")){
                     data [6] = "Loaned";
                 }   
                 
                 else if(res.getString(7).equals("Yellow")){
                     data [6] = "In Tolerance";
                 }   
                 
                 else if(res.getString(7).equals("Red")){
                     data [6] = "In Max Tolerance";
                 }   
                 
                 else if(res.getString(7).equals("Purple")){
                     data [6] = "Return Time Exceeded";
                 }   
                 modelo.addRow(data);
            
             }
             
             
            Collection_Table.setModel(modelo); 
            
            
            Collection_InternalFrame.setVisible(true);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, ex);
        }
       
       
    }//GEN-LAST:event_Lateral_Button1ActionPerformed

    private void Lateral_Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button3ActionPerformed
        try {
            Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
            AddPeople_InternalFrame.setVisible(false);
            LendItem_InternalFrame.setVisible(false);
            ReceiveItem_InternalFrame.setVisible(false);
            ReviewItem_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
            AddItem_InternalFrame.setVisible(false);
            
            LendItemPersons_Table.removeAll();
            SelectIItem_ComboBox.removeAllItems();
            Year_TextField.setText("");
            Month_TextField.setText("");
            Day_TextField.setText("");
            YellowTolerance_TextField.setText("");
            RedTolerance_TextField.setText("");
            
            ResultSet res = DBConnection.ConnectDB.getItems(LendIziCollection.getIdentification());
            while(res.next()){
                SelectIItem_ComboBox.addItem(res.getString(1));
            }

            
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("First Name");
            modelo.addColumn("Last Name");
            modelo.addColumn("Email");
            modelo.addColumn("Phone Number");
            modelo.addColumn("Relation");
            
            
            ResultSet res2 = DBConnection.ConnectDB.getKnownPeople(LendIziCollection.getIdentification());
            
            String data [] = new String[5];
            
            
            while(res2.next()){
                data [0] = res2.getString(1);
                data [1] = res2.getString(2);
                data [2] = res2.getString(3);
                data [3] = res2.getString(4);
                data [4] = res2.getString(5);               
                
                
                modelo.addRow(data);
                
            }
            
            
            
            LendItemPersons_Table.setModel(modelo);
            
            
            
            
            
            
            
            
            LendItem_InternalFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Lateral_Button3ActionPerformed

    private void Lateral_Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button4ActionPerformed
        try {
            Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
            AddPeople_InternalFrame.setVisible(false);
            LendItem_InternalFrame.setVisible(false);
            ReceiveItem_InternalFrame.setVisible(false);
            ReviewItem_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
            AddItem_InternalFrame.setVisible(false);
            
            ReceiveItem_InternalFrame.setVisible(true);
            
            
            
            
            LendedItems_Table.removeAll();
            
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Title");
            modelo.addColumn("First Name");
            modelo.addColumn("Last Name");
            modelo.addColumn("Email");
            modelo.addColumn("Phone Number");
            
            modelo.addColumn("Lend Date");
            modelo.addColumn("Return Date");
            modelo.addColumn("Amount Days");
            modelo.addColumn("Tolerance Days");
            modelo.addColumn("Max Tolerance Days");
            
            
            
            
            ResultSet res2 = DBConnection.ConnectDB.getLendedItems(LendIziCollection.getIdentification());
            
            String data [] = new String[10];
            
            
            while(res2.next()){
                data [0] = res2.getString(1);
                data [1] = res2.getString(2);
                data [2] = res2.getString(3);
                data [3] = res2.getString(4);
                data [4] = res2.getString(5);               
                
                data [5] = res2.getString(6);
                data [6] = res2.getString(7);
                data [7] = res2.getString(8);
                data [8] = res2.getString(9);
                data [9] = res2.getString(10);      
                
                
                
                modelo.addRow(data);
                
            }
            
            
            
            LendedItems_Table.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       
       
       
       
    }//GEN-LAST:event_Lateral_Button4ActionPerformed

    private void Lateral_Button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button5ActionPerformed
        try {
            Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
            AddPeople_InternalFrame.setVisible(false);
            LendItem_InternalFrame.setVisible(false);
            ReceiveItem_InternalFrame.setVisible(false);
            ReviewItem_InternalFrame.setVisible(false);

            Queries_InternalFrame.setVisible(false);
            AddItem_InternalFrame.setVisible(false);
            
             Review_Table.removeAll();
            
            
            
             DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Item Id");
            modelo.addColumn("Title");
            modelo.addColumn("Publisher");
            modelo.addColumn("Edition");
            modelo.addColumn("Genre");           
            modelo.addColumn("Stars");

            
            
       
           
             //ResultSet res = pst.executeQuery();
                    
             ResultSet res = DBConnection.ConnectDB.getCollection(LendIziCollection.getIdentification());

             String data [] = new String[7];
             

             while(res.next()){
                 data [0] = res.getString(1);
                 data [1] = res.getString(2);
                 data [2] = res.getString(3);
                 data [3] = res.getString(4);
                 data [4] = res.getString(5);
                 
                 
                 if(res.getString(6).equals("1")){
                     data [5] = "★";
                 }
                 
                 else if(res.getString(6).equals("2")){
                     data [5] = "★★";
                 }   
                 
                 else if(res.getString(6).equals("3")){
                     data [5] = "★★★";

                 }   
                 
                 else if(res.getString(6).equals("4")){
                     data [5] = "★★★★";
                    
                 }   
                 
                 else if(res.getString(6).equals("5")){
                     data [5] = "★★★★★";
                 }   
                 
                 else if(res.getString(6).equals("0")){
                     data [5] = "No Review Yet";
                 }  

                 modelo.addRow(data);
            
             }

            Review_Table.setModel(modelo);
            
            
            ReviewItem_InternalFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Lateral_Button5ActionPerformed

    private void Lateral_Button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button6ActionPerformed
       Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
       
       Queries_InternalFrame.setVisible(true);

    }//GEN-LAST:event_Lateral_Button6ActionPerformed

    private void Lateral_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button2ActionPerformed
        try {
            Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
            AddPeople_InternalFrame.setVisible(false);
            LendItem_InternalFrame.setVisible(false);
            ReceiveItem_InternalFrame.setVisible(false);
            ReviewItem_InternalFrame.setVisible(false);

            Queries_InternalFrame.setVisible(false);
            AddItem_InternalFrame.setVisible(false);
            
            
            RelationType_ComboBox.removeAllItems();
            PersonEmail_TextField.setText("");
            
            
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("First Name");
            modelo.addColumn("Last Name");
            modelo.addColumn("Email");
            modelo.addColumn("Phone Number");
            modelo.addColumn("Relation");
            
            
            ResultSet res = DBConnection.ConnectDB.getKnownPeople(LendIziCollection.getIdentification());
            
            String data [] = new String[5];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                data [1] = res.getString(2);
                data [2] = res.getString(3);
                data [3] = res.getString(4);
                data [4] = res.getString(5);               
                
                
                modelo.addRow(data);
                
            }
            
            RelationType_Table.setModel(modelo);
            
            
            
            
            ResultSet res1 = DBConnection.ConnectDB.getRelationTypes();
            while(res1.next()){
              RelationType_ComboBox.addItem(res1.getString(1));
            }
            
            
            
            
            
            
            
            

            AddPeople_InternalFrame.setVisible(true);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Lateral_Button2ActionPerformed

    private void Lateral_Button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button1MouseEntered
        Lateral_Button1.setBounds(-60, 170, 440, 60);
    }//GEN-LAST:event_Lateral_Button1MouseEntered

    private void Lateral_Button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button1MouseExited
        Lateral_Button1.setBounds(-140, 170, 440, 60);
    }//GEN-LAST:event_Lateral_Button1MouseExited

    private void Lateral_Button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button2MouseEntered
        Lateral_Button2.setBounds(-60, 230, 440, 60);
    }//GEN-LAST:event_Lateral_Button2MouseEntered

    private void Lateral_Button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button2MouseExited
       Lateral_Button2.setBounds(-140, 230, 440, 60);
    }//GEN-LAST:event_Lateral_Button2MouseExited

    private void Lateral_Button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button3MouseEntered
       Lateral_Button3.setBounds(-60, 290, 440, 60);
    }//GEN-LAST:event_Lateral_Button3MouseEntered

    private void Lateral_Button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button4MouseExited
     Lateral_Button4.setBounds(-140, 350, 440, 60);
    }//GEN-LAST:event_Lateral_Button4MouseExited

    private void Lateral_Button5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button5MouseEntered
       Lateral_Button5.setBounds(-60, 410, 440, 60);
    }//GEN-LAST:event_Lateral_Button5MouseEntered

    private void Lateral_Button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button4MouseEntered
        Lateral_Button4.setBounds(-60, 350, 440, 60);
    }//GEN-LAST:event_Lateral_Button4MouseEntered

    private void Lateral_Button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button3MouseExited
       Lateral_Button3.setBounds(-140, 290, 440, 60);
    }//GEN-LAST:event_Lateral_Button3MouseExited

    private void Lateral_Button5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button5MouseExited
       Lateral_Button5.setBounds(-140, 410, 440, 60);
    }//GEN-LAST:event_Lateral_Button5MouseExited

    private void Lateral_Button6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button6MouseEntered
      Lateral_Button6.setBounds(-60, 470, 440, 60);
    }//GEN-LAST:event_Lateral_Button6MouseEntered

    private void Lateral_Button6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button6MouseExited
      Lateral_Button6.setBounds(-140, 470, 440, 60);
    }//GEN-LAST:event_Lateral_Button6MouseExited

    private void Exit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_ButtonActionPerformed
     System.exit(0);
    }//GEN-LAST:event_Exit_ButtonActionPerformed

    private void AddItem_PanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddItem_PanelMouseEntered
       
    }//GEN-LAST:event_AddItem_PanelMouseEntered

    private void AddItem_PanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddItem_PanelMouseExited
    
    }//GEN-LAST:event_AddItem_PanelMouseExited

    private void AddAnItem_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAnItem_ButtonActionPerformed
      Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);

            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
       
      ItemType_ComboBox.removeAllItems();
      Publisher_ComboBox.removeAllItems();
      Genre_ComboBox.removeAllItems();
      
      ItemTitle_TextField.setText("");
      ItemEdition_TextField.setText("");
      ItemBarbcode_TextField.setText("");
       
         try {
             ResultSet res1 = DBConnection.ConnectDB.getItemTypes();
             while(res1.next()){
              ItemType_ComboBox.addItem(res1.getString(1));
             }
                
             ResultSet res2 = DBConnection.ConnectDB.getPublishers();
             while(res2.next()){
              Publisher_ComboBox.addItem(res2.getString(1));
             }
            
            ResultSet res3 = DBConnection.ConnectDB.getGenres();
             while(res3.next()){
              Genre_ComboBox.addItem(res3.getString(1));
             }
            

       
       AddItem_InternalFrame.setVisible(true);
       
       } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_AddAnItem_ButtonActionPerformed

    private void AddAnItem_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddAnItem_ButtonMouseEntered
         AddItem_Panel.setBackground(new java.awt.Color(255,255,255));
         AddAnItem_Button.setForeground(new java.awt.Color(0,0,0));
         
         
    }//GEN-LAST:event_AddAnItem_ButtonMouseEntered

    private void AddAnItem_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddAnItem_ButtonMouseExited
         AddItem_Panel.setBackground(new java.awt.Color(204,204,204));
         AddAnItem_Button.setForeground(new java.awt.Color(51,51,51  ));
    }//GEN-LAST:event_AddAnItem_ButtonMouseExited

    private void MainMenu_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenu_ButtonActionPerformed
      Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);

    }//GEN-LAST:event_MainMenu_ButtonActionPerformed

    private void Receive_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Receive_ButtonActionPerformed
        try {
            String selected_item_title = LendedItems_Table.getValueAt(LendedItems_Table.getSelectedRow(),0).toString();
            System.out.println(selected_item_title);
            
            int selected_item_id = DBConnection.ConnectDB.getItemId(selected_item_title);
            
            
            String selected_person2_first_name = LendedItems_Table.getValueAt(LendedItems_Table.getSelectedRow(),1).toString();
            System.out.println(selected_person2_first_name);
            
            String selected_person2_email = LendedItems_Table.getValueAt(LendedItems_Table.getSelectedRow(),3).toString();
            System.out.println(selected_person2_email);
            
            int selected_person2_id = DBConnection.ConnectDB.getPersonId(selected_person2_email);
            System.out.println(selected_person2_id);
            
            String current_date =  java.time.LocalDate.now().toString();

          
            DBConnection.ConnectDB.removePersonLendItem(selected_item_id);
            DBConnection.ConnectDB.updateItemStatus(selected_item_id, 0);
            
            
            JOptionPane.showMessageDialog(frame, "Returned item ");
            

            
            LendedItems_Table.removeAll();
            
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Title");
            modelo.addColumn("First Name");
            modelo.addColumn("Last Name");
            modelo.addColumn("Email");
            modelo.addColumn("Phone Number");
            
            modelo.addColumn("Lend Date");
            modelo.addColumn("Return Date");
            modelo.addColumn("Amount Days");
            modelo.addColumn("Tolerance Days");
            modelo.addColumn("Max Tolerance Days");
            
            
            
            
            ResultSet res2 = DBConnection.ConnectDB.getLendedItems(LendIziCollection.getIdentification());
            
            String data [] = new String[10];
                           
            while(res2.next()){
                data [0] = res2.getString(1);
                data [1] = res2.getString(2);
                data [2] = res2.getString(3);
                data [3] = res2.getString(4);
                data [4] = res2.getString(5);
                
                data [5] = res2.getString(6);
                data [6] = res2.getString(7);
                data [7] = res2.getString(8);
                data [8] = res2.getString(9);
                data [9] = res2.getString(10);      
                
                
                
                modelo.addRow(data);
                
            }
            
            
            
            LendedItems_Table.setModel(modelo);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Receive_ButtonActionPerformed

    private void Review_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Review_ButtonActionPerformed
      
        try {
            String selected_item_id = null;
            selected_item_id = Review_Table.getValueAt(Review_Table.getSelectedRow(),0).toString();            
            int selected_item_id2 = Integer.parseInt(selected_item_id);
            
            String selected_review = String.valueOf(SelectReview_ComboBox.getSelectedIndex());
            int selected_review2 = Integer.parseInt(selected_review);
            
            System.out.println(selected_review);
                    
            if(!selected_item_id.equals(null)){ //Se debe verificar que se haya escogido un item.
                
            
                
                DBConnection.ConnectDB.updateItemHasReview(selected_item_id2, selected_item_id2, selected_review2);
            

            
                JOptionPane.showMessageDialog(null,"Item Review Updated.");
            
            
                Review_Table.removeAll();
            


                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("Item Id");
                modelo.addColumn("Title");
                modelo.addColumn("Publisher");
                modelo.addColumn("Edition");
                modelo.addColumn("Genre");           
                modelo.addColumn("Stars");


                //ResultSet res = pst.executeQuery();

                ResultSet res = DBConnection.ConnectDB.getCollection(LendIziCollection.getIdentification());

                String data [] = new String[7];


                while(res.next()){
                    data [0] = res.getString(1);
                    data [1] = res.getString(2);
                    data [2] = res.getString(3);
                    data [3] = res.getString(4);
                    data [4] = res.getString(5);


                    if(res.getString(6).equals("1")){
                        data [5] = "★";
                    }

                    else if(res.getString(6).equals("2")){
                        data [5] = "★★";
                    }   

                    else if(res.getString(6).equals("3")){
                        data [5] = "★★★";

                    }   
                 
                    else if(res.getString(6).equals("4")){
                        data [5] = "★★★★";

                    }   

                    else if(res.getString(6).equals("5")){
                        data [5] = "★★★★★";
                    }   

                    else if(res.getString(6).equals("0")){
                        data [5] = "No Review Yet";
                    }  

                    modelo.addRow(data);

                }

                Review_Table.setModel(modelo);


                
            }else{
                JOptionPane.showMessageDialog(frame,"An item must be selected","Warning:",JOptionPane.WARNING_MESSAGE);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_Review_ButtonActionPerformed

    private void AddItem_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItem_ButtonActionPerformed
     try{
         
       String new_item_title = null;
       String new_item_edition = null;
       String new_item_barcode = null;
       String new_item_itemtype = null;
       String new_item_publisher = null;
       String new_item_genre = null;
       

               
      new_item_title      = ItemTitle_TextField.getText();
      new_item_edition    = ItemEdition_TextField.getText();
      new_item_barcode    = ItemBarbcode_TextField.getText();
      
      new_item_itemtype   = ItemType_ComboBox.getSelectedItem().toString();
      new_item_publisher  = Publisher_ComboBox.getSelectedItem().toString();     
      new_item_genre      = Genre_ComboBox.getSelectedItem().toString(); 
            
       
      int new_itemtype_id = DBConnection.ConnectDB.getItemTypeId(new_item_itemtype);
      int new_publisher_id = DBConnection.ConnectDB.getPublisherId(new_item_publisher);
      int new_genre_id = DBConnection.ConnectDB.getGenreId(new_item_genre);
      
      
      if( !new_item_title.equals(null) && !new_item_title.equals("") &&
          !new_item_edition.equals(null) && !new_item_edition.equals("") &&
          !new_item_barcode.equals(null) && !new_item_barcode.equals("") ){
          
            int id_new_title = DBConnection.ConnectDB.insertItem(new_item_title, new_item_edition, photo_item, new_item_barcode, new_itemtype_id, 0, new_publisher_id);
            DBConnection.ConnectDB.insertItemHasGenre(id_new_title, new_genre_id);
            DBConnection.ConnectDB.insertItemHasReview(id_new_title, 5);
            DBConnection.ConnectDB.insertPersonHasItem(LendIziCollection.getIdentification(), id_new_title);
            JOptionPane.showMessageDialog(frame, "New Item Added.");

      }
      
      JOptionPane.showMessageDialog(frame, "Missing Information.","Warning:", JOptionPane.WARNING_MESSAGE);
      
      
    
     } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
     }
          
          
        
        
    }//GEN-LAST:event_AddItem_ButtonActionPerformed

    private void AddPhoto_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPhoto_ButtonActionPerformed

       JFileChooser chooser = new JFileChooser();
       chooser.showOpenDialog(null);
       File f = chooser.getSelectedFile();
       filename = f.getAbsolutePath();
       ImageIcon cover = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
       Cover_Image_Label.setIcon(cover);
       
       try{ 
           File cover_image = new File(filename);
           FileInputStream fis = new FileInputStream(cover_image);
           ByteArrayOutputStream bos = new ByteArrayOutputStream();
           byte [] buf = new byte[1024];
            for(int readNum; (readNum = fis.read(buf)) != -1;){
                bos.write(buf, 0, readNum);
            }
          photo_item = bos.toByteArray();
          
          
          JOptionPane.showMessageDialog(null,"Cover Image Uploaded.");
       } catch(Exception e){
           JOptionPane.showMessageDialog(null, e);       
       }  
    
       
    }//GEN-LAST:event_AddPhoto_ButtonActionPerformed

    private void CommitChanges_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommitChanges_ButtonActionPerformed
       try {
        
        if(UpdateItem_CheckBox.isSelected()){
           
               String new_title = TitleItem_TextField.getText();
               System.out.println("============");
               
               String new_edition = EditionItem_TextField.getText();
               String new_barcode = BarbcodeItem_TextField.getText();
               String new_itemtype = ItemType_ComboBox1.getSelectedItem().toString();
               int new_itemtype_id = DBConnection.ConnectDB.getItemTypeId(new_itemtype);
               String new_publisher = Publisher_ComboBox2.getSelectedItem().toString();
               int new_publisher_id = DBConnection.ConnectDB.getPublisherId(new_publisher);
               String new_genre = Genre_ComboBox1.getSelectedItem().toString();
               int new_genre_id = DBConnection.ConnectDB.getGenreId(new_genre);
               
                            
               int item_status = DBConnection.ConnectDB.getItemStatus(selected_item_id);
               if(item_status == 0){
                    DBConnection.ConnectDB.updateItemHasGenre(selected_item_id, selected_item_id, new_genre_id);
                    DBConnection.ConnectDB.updateItem(selected_item_id, new_title, new_edition, new_barcode, new_itemtype_id, 0, new_publisher_id);

                    JOptionPane.showMessageDialog(null,"Item Updated");
               }
               else{
                   JOptionPane.showMessageDialog(frame,
                    "Item is currently on loan.", null, 
                    JOptionPane.WARNING_MESSAGE);
               }
       }
        
        
        
        
       if(RemoveItem_CheckBox.isSelected()){
          int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "You want to delete it??", 
                                  "Select:", 
                                  JOptionPane.YES_NO_OPTION); 
          if (selectedOption == JOptionPane.YES_OPTION) {

         
              System.out.println(selected_item_id);
              int item_status = DBConnection.ConnectDB.getItemStatus(selected_item_id);
              System.out.println(item_status);
              if(item_status == 0){
                  
                DBConnection.ConnectDB.removeItemHasReview(selected_item_id);
                DBConnection.ConnectDB.removeItemHasGenre(selected_item_id);
                DBConnection.ConnectDB.removePersonHasItem(LendIziCollection.getIdentification(),selected_item_id);
                DBConnection.ConnectDB.removeItem(selected_item_id);
                JOptionPane.showMessageDialog(null,"Item Removed");
                ItemInfo_InternalFrame.setVisible(false);
                Collection_InternalFrame.setVisible(true);
              
               }
              else{
                   JOptionPane.showMessageDialog(frame,
                    "Item is currently on loan.", null, 
                    JOptionPane.WARNING_MESSAGE);
               }
         
          }
          else if (selectedOption == JOptionPane.NO_OPTION) { }    
        } 
         
       } catch(Exception e){
           JOptionPane.showMessageDialog(null, e);       
       }
         
        
     
    }//GEN-LAST:event_CommitChanges_ButtonActionPerformed

    private void AddPhoto_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPhoto_Button1ActionPerformed
    if(UpdateItem_CheckBox.isSelected()){
       JFileChooser chooser = new JFileChooser();
       chooser.showOpenDialog(null);
       File f = chooser.getSelectedFile();
       filename = f.getAbsolutePath();
       ImageIcon cover = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
       Cover_Image_Label1.setIcon(cover);
       
       try{ 
           File cover_image = new File(filename);
           FileInputStream fis = new FileInputStream(cover_image);
           ByteArrayOutputStream bos = new ByteArrayOutputStream();
           byte [] buf = new byte[1024];
            for(int readNum; (readNum = fis.read(buf)) != -1;){
                bos.write(buf, 0, readNum);
            }
          photo = bos.toByteArray();
          
          DBConnection.ConnectDB.updateItemCover(selected_item_id, photo);
          JOptionPane.showMessageDialog(null,"Cover Image Updated.");
       } catch(Exception e){
           JOptionPane.showMessageDialog(null, e);       
       }  
    }
  
    }//GEN-LAST:event_AddPhoto_Button1ActionPerformed

    private void RemoveItem_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveItem_CheckBoxActionPerformed
       UpdateItem_CheckBox.setSelected(false);
       CommitChanges_Button.setEnabled(true);
       
       TitleItem_TextField.setEditable(false);
       EditionItem_TextField.setEditable(false);
       BarbcodeItem_TextField.setEditable(false);
       ItemType_ComboBox1.setEnabled(false);
       Publisher_ComboBox2.setEnabled(false);
       Genre_ComboBox1.setEnabled(false);
       
       
       TitleItem_TextField.setEditable(false);
       EditionItem_TextField.setEditable(false);
       BarbcodeItem_TextField.setEditable(false);
       ItemType_ComboBox1.setEditable(false);
       Publisher_ComboBox2.setEditable(false);
       Genre_ComboBox1.setEditable(false);
      
       
       if(!RemoveItem_CheckBox.isSelected()){
          TitleItem_TextField.setEditable(false);
         EditionItem_TextField.setEditable(false);
         BarbcodeItem_TextField.setEditable(false);
         ItemType_ComboBox1.setEditable(false);
         Publisher_ComboBox2.setEditable(false);
         Genre_ComboBox1.setEditable(false);
         
         ItemType_ComboBox1.setEnabled(false);
         Publisher_ComboBox2.setEnabled(false);
         Genre_ComboBox1.setEnabled(false);
         
       }
       
       
       
    }//GEN-LAST:event_RemoveItem_CheckBoxActionPerformed

    private void UpdateItem_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateItem_CheckBoxActionPerformed
         RemoveItem_CheckBox.setSelected(false);
         CommitChanges_Button.setEnabled(true);
         
         
         
        ItemType_ComboBox1.setEnabled(true);
        Publisher_ComboBox2.setEnabled(true);
        Genre_ComboBox1.setEnabled(true);
         
         TitleItem_TextField.setEditable(true);
         EditionItem_TextField.setEditable(true);
         BarbcodeItem_TextField.setEditable(true);
         ItemType_ComboBox1.setEditable(true);
         Publisher_ComboBox2.setEditable(true);
         Genre_ComboBox1.setEditable(true);
         
         ItemType_ComboBox1.removeAllItems();
         Publisher_ComboBox2.removeAllItems();
         Genre_ComboBox1.removeAllItems();
        
         try {
             ResultSet res1 = DBConnection.ConnectDB.getItemTypes();
             while(res1.next()){
              ItemType_ComboBox1.addItem(res1.getString(1));
             }
                
             ResultSet res2 = DBConnection.ConnectDB.getPublishers();
             while(res2.next()){
              Publisher_ComboBox2.addItem(res2.getString(1));
             }
            
            ResultSet res3 = DBConnection.ConnectDB.getGenres();
             while(res3.next()){
              Genre_ComboBox1.addItem(res3.getString(1));
             }
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
         
         

         if(!UpdateItem_CheckBox.isSelected()){
          TitleItem_TextField.setEditable(false);
         EditionItem_TextField.setEditable(false);
         BarbcodeItem_TextField.setEditable(false);
         ItemType_ComboBox1.setEditable(false);
         Publisher_ComboBox2.setEditable(false);
         Genre_ComboBox1.setEditable(false);
             
         
         
         ItemType_ComboBox1.setEnabled(false);
         Publisher_ComboBox2.setEnabled(false);
         Genre_ComboBox1.setEnabled(false);
         }
    }//GEN-LAST:event_UpdateItem_CheckBoxActionPerformed

    private void Collection_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Collection_TableMouseClicked
        Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);    
        
 
       
       
        try {
            
            String selected_item_title = Collection_Table.getValueAt(Collection_Table.getSelectedRow(),1).toString();
            System.out.println(selected_item_title);
            
            selected_item_id = DBConnection.ConnectDB.getItemId(selected_item_title);
            System.out.println(selected_item_id);
            
            
            
            
            
            ItemType_ComboBox1.removeAllItems();
            Publisher_ComboBox2.removeAllItems();
            Genre_ComboBox1.removeAllItems();
            
            
            
            TitleItem_TextField.setEditable(false);
            EditionItem_TextField.setEditable(false);
            BarbcodeItem_TextField.setEditable(false);
            ItemType_ComboBox1.setEditable(false);
            Publisher_ComboBox2.setEditable(false);
            Genre_ComboBox1.setEditable(false);

            
            
            
            TitleItem_TextField.setText(DBConnection.ConnectDB.getItemTitle(selected_item_id));
            EditionItem_TextField.setText(DBConnection.ConnectDB.getItemEdition(selected_item_id));
            BarbcodeItem_TextField.setText(DBConnection.ConnectDB.getItemBarcode(selected_item_id));
            
            int select_item_itemtype_id = DBConnection.ConnectDB.getItemItemType(selected_item_id);
            String select_item_itemtype_name = DBConnection.ConnectDB.getItemTypeName(select_item_itemtype_id);

            ItemType_ComboBox1.addItem(select_item_itemtype_name);
            
            int selected_item_publisher_id = DBConnection.ConnectDB.getItemPublisher(selected_item_id);
            Publisher_ComboBox2.addItem(DBConnection.ConnectDB.getPublisherName(selected_item_publisher_id));
            
          
            int selected_item_genre_id = DBConnection.ConnectDB.getItemHasGenreGenreId(selected_item_id);
            Genre_ComboBox1.addItem(DBConnection.ConnectDB.getGenreName(selected_item_genre_id));
            
            
            
            
            
            
            format = DBConnection.ConnectDB.getItemCover(selected_item_id);
            Cover_Image_Label1.setIcon(format);
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ItemInfo_InternalFrame.setVisible(true);
    }//GEN-LAST:event_Collection_TableMouseClicked

    private void Day_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Day_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Day_TextFieldActionPerformed

    private void RemovePersonKnowsPerson_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovePersonKnowsPerson_CheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemovePersonKnowsPerson_CheckBoxActionPerformed

    private void Return_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Return_ButtonActionPerformed
        LendIziCollection.setIdentification(0);
        LendIziCollection.setEmail(null);
        Main_Menu result = new Main_Menu();
        dispose();
        result.setVisible(true);
    }//GEN-LAST:event_Return_ButtonActionPerformed

    private void LendItemPersons_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LendItemPersons_TableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LendItemPersons_TableMouseClicked

    private void AddPeople_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPeople_ButtonActionPerformed
        try {
            String known_person_email = PersonEmail_TextField.getText();
            int known_person_id = DBConnection.ConnectDB.getPersonId(known_person_email);
            
            String known_person_relationtype = RelationType_ComboBox.getSelectedItem().toString();
            int known_person_relationtype_id = DBConnection.ConnectDB.getRelationTypeId(known_person_relationtype);
           
            boolean selection = false;

            for (int i = 0; i < RelationType_Table.getRowCount(); i++) {         //----Si la persona no se encuentra ya en la lista de gentet conocida   
            if(known_person_email.equals(RelationType_Table.getValueAt(i, 2).toString())){
                 JOptionPane.showMessageDialog(frame, "Person it's already in your known list", null, JOptionPane.WARNING_MESSAGE);
                 selection = true;
                 break;
                }
           
            }
            if(selection == false){
              DBConnection.ConnectDB.insertPerson1KnowsPerson2(LendIziCollection.getIdentification(),known_person_id , known_person_relationtype_id);
              JOptionPane.showMessageDialog(frame, "Person added successfully");
              RelationType_Table.removeAll();
              
                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("First Name");
                modelo.addColumn("Last Name");
                modelo.addColumn("Email");
                modelo.addColumn("Phone Number");
                modelo.addColumn("Relation");
 
                ResultSet res = DBConnection.ConnectDB.getKnownPeople(LendIziCollection.getIdentification());

                String data [] = new String[5];

                while(res.next()){
                    data [0] = res.getString(1);
                    data [1] = res.getString(2);
                    data [2] = res.getString(3);
                    data [3] = res.getString(4);
                    data [4] = res.getString(5);               


                    modelo.addRow(data);

                }

            RelationType_Table.setModel(modelo);
              
            }

        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, "Invalid Email", null, JOptionPane.ERROR_MESSAGE);
            
        }
        
        
        
    }//GEN-LAST:event_AddPeople_ButtonActionPerformed

    private void RelationType_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationType_TableMouseClicked
        try {
            if(RemovePersonKnowsPerson_CheckBox.isSelected()){
                int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "You want to delete it??", 
                                  "Select:", 
                                  JOptionPane.YES_NO_OPTION); 
                if (selectedOption == JOptionPane.YES_OPTION) {
                    String selected_person_email = RelationType_Table.getValueAt(RelationType_Table.getSelectedRow(),2).toString();
                    int selected_person_id = DBConnection.ConnectDB.getPersonId(selected_person_email);
                    DBConnection.ConnectDB.removePerson1KnowsPerson2(LendIziCollection.getIdentification(), selected_person_id);
                    
                    
                    
                    RelationType_Table.removeAll();
              
                    DefaultTableModel modelo = new DefaultTableModel();
                    modelo.addColumn("First Name");
                    modelo.addColumn("Last Name");
                    modelo.addColumn("Email");
                    modelo.addColumn("Phone Number");
                    modelo.addColumn("Relation");
 
                    ResultSet res = DBConnection.ConnectDB.getKnownPeople(LendIziCollection.getIdentification());

                    String data [] = new String[5];

                    while(res.next()){
                        data [0] = res.getString(1);
                        data [1] = res.getString(2);
                        data [2] = res.getString(3);
                        data [3] = res.getString(4);
                        data [4] = res.getString(5);               
                        modelo.addRow(data);
                    }

                    RelationType_Table.setModel(modelo);
                    
                }
               


            }
        } catch (SQLException ex) {
                Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(frame, ex, null, JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
        
    }//GEN-LAST:event_RelationType_TableMouseClicked

    private void Lend_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lend_ButtonActionPerformed
       
        try {
            String lend_person_email = LendItemPersons_Table.getValueAt(LendItemPersons_Table.getSelectedRow(),2).toString();
            int lend_person_id = DBConnection.ConnectDB.getPersonId(lend_person_email);
            
            
            String lend_item = SelectIItem_ComboBox.getSelectedItem().toString();
            int lend_item_id = DBConnection.ConnectDB.getItemId(lend_item);

            String year = Year_TextField.getText();
            String month = Month_TextField.getText();
            String day = Day_TextField.getText();
            String lend_return_date = year + "-" + month + "-"+ day;
            String current_date = java.time.LocalDate.now().toString();
            int lend_tolerance_yellow = Integer.parseInt(YellowTolerance_TextField.getText());                    
            int lend_tolerance_red = Integer.parseInt(RedTolerance_TextField.getText());  
            
            
            Date return_date = new SimpleDateFormat("yyyy-mm-dd").parse(lend_return_date);  
            Date lend_date = new SimpleDateFormat("yyyy-mm-dd").parse(current_date);  
               
            if(return_date.compareTo(lend_date) >= 0){
                DBConnection.ConnectDB.insertLoanHistory(LendIziCollection.getIdentification(), lend_person_id, lend_item_id, lend_return_date, lend_tolerance_yellow, lend_tolerance_red);
                DBConnection.ConnectDB.insertPersonLendItem(LendIziCollection.getIdentification(), lend_person_id, lend_item_id, lend_return_date, lend_tolerance_yellow, lend_tolerance_red);
                DBConnection.ConnectDB.updateItemStatus(lend_item_id, 1);
                
                
                JOptionPane.showMessageDialog(frame, "Item loaned correctly.");
            }
            else{
                JOptionPane.showMessageDialog(frame, "Invalid Date.","Warning", JOptionPane.WARNING_MESSAGE);
            }
            
            SelectIItem_ComboBox.removeAllItems();
            
            ResultSet res = DBConnection.ConnectDB.getItems(LendIziCollection.getIdentification());
            while(res.next()){
                SelectIItem_ComboBox.addItem(res.getString(1));
            }
            
       
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(frame, ex, null, JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_Lend_ButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            String selected_item_title = LendedItems_Table.getValueAt(LendedItems_Table.getSelectedRow(),0).toString();
            System.out.println(selected_item_title);
            
            String selected_person2_first_name = LendedItems_Table.getValueAt(LendedItems_Table.getSelectedRow(),1).toString();
            System.out.println(selected_person2_first_name);            

            String selected_person2_email = LendedItems_Table.getValueAt(LendedItems_Table.getSelectedRow(),3).toString();
            System.out.println(selected_person2_email);
            
            int selected_person2_id = DBConnection.ConnectDB.getPersonId(selected_person2_email);
            System.out.println(selected_person2_id);
            
            String my_first_name = DBConnection.ConnectDB.getPersonFirstName(LendIziCollection.getIdentification());
            System.out.println(my_first_name);
            
            String my_last_name = DBConnection.ConnectDB.getPersonLastName(LendIziCollection.getIdentification());
            System.out.println(my_last_name);
            
            

            String to = selected_person2_email;
            String subject = "LEND-IZI COLLECTION | Remind to return your items!  ";
            String message = "Hi! " + selected_person2_first_name + 
                            " we remind you that you have the item " + 
                             selected_item_title + " from " + my_first_name + 
                            " " + my_last_name + ".";
                
            
            
            JTextArea ta = new JTextArea(10, 10);
            ta.setText(message);
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            ta.setCaretPosition(0);
            ta.setEditable(true);

            JOptionPane.showMessageDialog(null, new JScrollPane(ta), "Email Message", JOptionPane.INFORMATION_MESSAGE);
            
            
            int selectedOption = JOptionPane.showConfirmDialog(null,  "Send Email Anyways?", "Select:",  JOptionPane.YES_NO_OPTION); 
            if (selectedOption == JOptionPane.YES_OPTION) {
                String final_message = ta.getText();

                String user = "lend.izi.item.bs@gmail.com";
                String pass = "Bs123456";

                SendMail.send(to,subject, final_message, user, pass);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Go_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Go_ButtonActionPerformed
       try{
        String selection = New_ComboBox.getSelectedItem().toString();
        
        if(selection.equals("Top Most Borrowed Items")){
            
            int top = Integer.parseInt(Parameter1_TextField.getText());
              DefaultTableModel modelo = new DefaultTableModel();
                    modelo.addColumn("Title");
                    modelo.addColumn("Cuantity");

                    ResultSet res = DBConnection.ConnectDB.AdminTopMostBorrowed(top);

                    String data [] = new String[2];

                    while(res.next()){
                        data [0] = res.getString(1);
                        data [1] = res.getString(2);
        
                        modelo.addRow(data);
                    }
                    Queries_Table.setModel(modelo);
            
        } else if(selection.equals("Most Borrowed Items Per Month")){
        
            int times = Integer.parseInt(Parameter1_TextField.getText());
            int months = Integer.parseInt(Parameter2_TextField.getText());
            
            
            DefaultTableModel modelo = new DefaultTableModel();
                    modelo.addColumn("Title");
                    modelo.addColumn("Times Borrowed");
                    

                    ResultSet res = DBConnection.ConnectDB.AdminMostBorrowedPerMonth(times, months);

                    String data [] = new String[2];

                    while(res.next()){
                        data [0] = res.getString(1);
                        data [1] = res.getString(2);
                        
                        modelo.addRow(data);
                    }
                    
                    Queries_Table.setModel(modelo);

        }
        

        } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        } 

       }//GEN-LAST:event_Go_ButtonActionPerformed

    private void New_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_New_ComboBoxActionPerformed
        
        String selection = New_ComboBox.getSelectedItem().toString();
        System.out.println(selection);
        try{
        
        if(selection.equals("All Items")){
            Filter_ComboBox.setVisible(false);
            Parameter1_TextField.setVisible(false);
            Parameter2_TextField.setVisible(false);
            Go_Button.setVisible(false);
            ParametersText_Label.setText("");
            Queries_Table.removeAll();
            Total_TextField.setVisible(false);
            Parameters_Label.setVisible(false);
            
                DefaultTableModel modelo = new DefaultTableModel();
                
                
                
                    modelo.addColumn("Title");
                    modelo.addColumn("Edition");
                    modelo.addColumn("Barcode");
                    modelo.addColumn("Type");
                    modelo.addColumn("Status");
                    modelo.addColumn("Publisher");
                    modelo.addColumn("Barcode");
                    modelo.addColumn("Type");
                    modelo.addColumn("Item Id");
                    modelo.addColumn("Title");
                    modelo.addColumn("Barcode");
                    modelo.addColumn("Type");

                    ResultSet res = DBConnection.ConnectDB.AdminNotBorrowed();

                    String data [] = new String[4];

                    while(res.next()){
                        data [0] = res.getString(1);
                        data [1] = res.getString(2);
                        data [2] = res.getString(3);
                        data [3] = res.getString(4);            
                        modelo.addRow(data);
                    }

                    ResultSet res2 = DBConnection.ConnectDB.AdminNotBorrowedTotal();
                    
                    while(res2.next()){
                    Total_TextField.setText("Total of not borrowed Items: "+ res2.getString(1));
                    }
                    Total_TextField.setEditable(false);
                    Queries_Table.setModel(modelo);
                    Total_TextField.setVisible(true);
          }

        else if(selection.equals("Top Most Borrowed Items")){
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(false);
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Select Top");
            Total_TextField.setVisible(false);
            Queries_Table.removeAll();
            Parameters_Label.setVisible(true);
            
        }
        else if(selection.equals("Most Borrowed Items Per Month")){
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(true);
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Times Borrowed             In Months");
            Total_TextField.setVisible(false);
            Queries_Table.removeAll();
            Parameters_Label.setVisible(true);
        }  

        else if(selection.equals("Total People to Whom iIems are Loaned by Age")){
           
            Parameter2_TextField.setVisible(false);
            Parameter1_TextField.setVisible(false);
            Go_Button.setVisible(false);
            ParametersText_Label.setText("");
            Total_TextField.setVisible(false);
            Parameters_Label.setVisible(false);
            
            DefaultTableModel modelo = new DefaultTableModel();
                    modelo.addColumn("Age Range");
                    modelo.addColumn("People Cuantity");
                    

                    ResultSet res = DBConnection.ConnectDB.AdminAgeOfPeopleLoan();

                    String data [] = new String[2];

                    while(res.next()){
                        data [0] = res.getString(1);
                        System.out.println(res.getString(1));
                        data [1] = res.getString(2);
                        System.out.println(res.getString(2));
                        modelo.addRow(data);
                    }
                    
                    Queries_Table.setModel(modelo);

            
            
        }
        else{
            Parameter1_TextField.setVisible(false);
            Parameter2_TextField.setVisible(false);
            Go_Button.setVisible(false);
            ParametersText_Label.setText("");
            Total_TextField.setVisible(false);
            Queries_Table.removeAll();
        }
        
        
          } catch (SQLException ex) {
            Logger.getLogger(Users_Menu.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
    }//GEN-LAST:event_New_ComboBoxActionPerformed

    private void Parameter1_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Parameter1_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Parameter1_TextFieldActionPerformed

    private void Filter_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Filter_ComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(Users_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Users_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Users_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Users_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAnItem_Button;
    private javax.swing.JButton AddItem_Button;
    private javax.swing.JInternalFrame AddItem_InternalFrame;
    private javax.swing.JPanel AddItem_Panel;
    private javax.swing.JButton AddPeople_Button;
    private javax.swing.JInternalFrame AddPeople_InternalFrame;
    private javax.swing.JButton AddPhoto_Button;
    private javax.swing.JButton AddPhoto_Button1;
    private javax.swing.JPanel Background_Panel;
    private javax.swing.JPanel Background_Panel1;
    private javax.swing.JPanel Background_Panel15;
    private javax.swing.JPanel Background_Panel16;
    private javax.swing.JPanel Background_Panel2;
    private javax.swing.JPanel Background_Panel3;
    private javax.swing.JPanel Background_Panel4;
    private javax.swing.JPanel Background_Panel7;
    private javax.swing.JLabel Banner_Label;
    private javax.swing.JTextField BarbcodeItem_TextField;
    private javax.swing.JInternalFrame Collection_InternalFrame;
    private javax.swing.JTable Collection_Table;
    private javax.swing.JButton CommitChanges_Button;
    private javax.swing.JLabel Cover_Image_Label;
    private javax.swing.JLabel Cover_Image_Label1;
    private javax.swing.JTextField Day_TextField;
    private javax.swing.JPanel Divisor_Panel;
    private javax.swing.JTextField EditionItem_TextField;
    private javax.swing.JButton Exit_Button;
    private javax.swing.JComboBox<String> Filter_ComboBox;
    private javax.swing.JComboBox<String> Genre_ComboBox;
    private javax.swing.JComboBox<String> Genre_ComboBox1;
    private javax.swing.JLabel Genre_Label;
    private javax.swing.JLabel Genre_Label1;
    private javax.swing.JButton Go_Button;
    private javax.swing.JTextField ItemBarbcode_TextField;
    private javax.swing.JLabel ItemBarcode_Label;
    private javax.swing.JLabel ItemBarcode_Label1;
    private javax.swing.JLabel ItemEdition_Label;
    private javax.swing.JLabel ItemEdition_Label1;
    private javax.swing.JTextField ItemEdition_TextField;
    private javax.swing.JInternalFrame ItemInfo_InternalFrame;
    private javax.swing.JLabel ItemTitle_Label;
    private javax.swing.JLabel ItemTitle_Label1;
    private javax.swing.JTextField ItemTitle_TextField;
    private javax.swing.JComboBox<String> ItemType_ComboBox;
    private javax.swing.JComboBox<String> ItemType_ComboBox1;
    private javax.swing.JLabel ItemType_Label;
    private javax.swing.JLabel ItemType_Label1;
    private javax.swing.JButton Lateral_Button1;
    private javax.swing.JButton Lateral_Button2;
    private javax.swing.JButton Lateral_Button3;
    private javax.swing.JButton Lateral_Button4;
    private javax.swing.JButton Lateral_Button5;
    private javax.swing.JButton Lateral_Button6;
    private javax.swing.JTable LendItemPersons_Table;
    private javax.swing.JInternalFrame LendItem_InternalFrame;
    private javax.swing.JButton Lend_Button;
    private javax.swing.JTable LendedItems_Table;
    private javax.swing.JButton MainMenu_Button;
    private javax.swing.JPanel Menu_Panel;
    private javax.swing.JTextField Month_TextField;
    private javax.swing.JComboBox<String> New_ComboBox;
    private javax.swing.JTextField Parameter1_TextField;
    private javax.swing.JTextField Parameter2_TextField;
    private javax.swing.JLabel ParametersText_Label;
    private javax.swing.JLabel Parameters_Label;
    private javax.swing.JLabel Parameters_Label1;
    private javax.swing.JLabel PersonEmail_Label;
    private javax.swing.JTextField PersonEmail_TextField;
    private javax.swing.JComboBox<String> Publisher_ComboBox;
    private javax.swing.JComboBox<String> Publisher_ComboBox2;
    private javax.swing.JLabel Publisher_Label1;
    private javax.swing.JLabel Publisher_Label2;
    private javax.swing.JInternalFrame Queries_InternalFrame;
    private javax.swing.JTable Queries_Table;
    private javax.swing.JInternalFrame ReceiveItem_InternalFrame;
    private javax.swing.JButton Receive_Button;
    private javax.swing.JTextField RedTolerance_TextField;
    private javax.swing.JComboBox<String> RelationType_ComboBox;
    private javax.swing.JLabel RelationType_Label;
    private javax.swing.JTable RelationType_Table;
    private javax.swing.JCheckBox RemoveItem_CheckBox;
    private javax.swing.JCheckBox RemovePersonKnowsPerson_CheckBox;
    private javax.swing.JLabel ReturnDate_Label;
    private javax.swing.JButton Return_Button;
    private javax.swing.JInternalFrame ReviewItem_InternalFrame;
    private javax.swing.JButton Review_Button;
    private javax.swing.JTable Review_Table;
    private javax.swing.JComboBox<String> SelectIItem_ComboBox;
    private javax.swing.JLabel SelectITem_Label;
    private javax.swing.JLabel SelectITem_Label1;
    private javax.swing.JLabel SelectITem_Label2;
    private javax.swing.JLabel SelectItem_Label2;
    private javax.swing.JComboBox<String> SelectReview_ComboBox;
    private javax.swing.JLabel SelectStars_Label;
    private javax.swing.JLabel Select_Label2;
    private javax.swing.JLabel Subtitle_Label;
    private javax.swing.JLabel Subtitle_Label1;
    private javax.swing.JLabel Subtitle_Label15;
    private javax.swing.JLabel Subtitle_Label16;
    private javax.swing.JLabel Subtitle_Label2;
    private javax.swing.JLabel Subtitle_Label3;
    private javax.swing.JLabel Subtitle_Label4;
    private javax.swing.JLabel Subtitle_Label7;
    private javax.swing.JTextField TitleItem_TextField;
    private javax.swing.JLabel Title_Label;
    private javax.swing.JLabel Title_Label1;
    private javax.swing.JLabel Title_Label15;
    private javax.swing.JLabel Title_Label16;
    private javax.swing.JLabel Title_Label2;
    private javax.swing.JLabel Title_Label3;
    private javax.swing.JLabel Title_Label4;
    private javax.swing.JLabel Title_Label7;
    private javax.swing.JLabel ToleranceDays_Label;
    private javax.swing.JTextField Total_TextField;
    private javax.swing.JCheckBox UpdateItem_CheckBox;
    private javax.swing.JLabel Upper_Banner;
    private javax.swing.JLabel Upper_Banner1;
    private javax.swing.JLabel Upper_Banner15;
    private javax.swing.JLabel Upper_Banner16;
    private javax.swing.JLabel Upper_Banner2;
    private javax.swing.JLabel Upper_Banner3;
    private javax.swing.JLabel Upper_Banner4;
    private javax.swing.JLabel Upper_Banner7;
    private javax.swing.JLabel Wallpaper_Label;
    private javax.swing.JTextField Year_TextField;
    private javax.swing.JTextField YellowTolerance_TextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
  byte[] photo = null;
  byte[] photo_item = null; 
  String filename = null;
  private ImageIcon format = null;

}
