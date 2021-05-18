
package App_Windows;

/*
By:
    Renzo Barra
    Álvaro Moreira
    Ronaldo Vindas
*/

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

public class Admin_Menu extends javax.swing.JFrame {

    private ChartFrame frame;
    int selected_item_id;
    
    public Admin_Menu() {
     
     this.setUndecorated(true);
     initComponents();
     Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
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
        RegisterValues_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel5 = new javax.swing.JPanel();
        Title_Label5 = new javax.swing.JLabel();
        Subtitle_Label5 = new javax.swing.JLabel();
        Upper_Banner5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        SelectField_Label = new javax.swing.JLabel();
        StatusType_Button = new javax.swing.JButton();
        RelationType_Button = new javax.swing.JButton();
        Author_Button = new javax.swing.JButton();
        ItemTypes_Button = new javax.swing.JButton();
        Genre_Button = new javax.swing.JButton();
        Publisher_Button = new javax.swing.JButton();
        RegisterRelationType_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel8 = new javax.swing.JPanel();
        Title_Label8 = new javax.swing.JLabel();
        Subtitle_Label8 = new javax.swing.JLabel();
        Upper_Banner8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        SelectField_Label1 = new javax.swing.JLabel();
        RemoveRelationType_CheckBox = new javax.swing.JCheckBox();
        InsertRelationType_CheckBox = new javax.swing.JCheckBox();
        UpdateRelationType_CheckBox = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        RelationTypes_Table = new javax.swing.JTable();
        RelationTypeName_TextField = new javax.swing.JTextField();
        RelationTypeCommitChanges_Panel = new javax.swing.JPanel();
        RelationTypeCommit_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SelectField_Label2 = new javax.swing.JLabel();
        RegisterItemType_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel9 = new javax.swing.JPanel();
        Title_Label9 = new javax.swing.JLabel();
        Subtitle_Label9 = new javax.swing.JLabel();
        Upper_Banner9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        SelectField_Label3 = new javax.swing.JLabel();
        RemoveItemType_CheckBox = new javax.swing.JCheckBox();
        InsertItemType_CheckBox = new javax.swing.JCheckBox();
        UpdateItemType_CheckBox = new javax.swing.JCheckBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        ItemTypes_Table = new javax.swing.JTable();
        ItemTypeName_TextField = new javax.swing.JTextField();
        RelationTypeCommitChanges_Panel1 = new javax.swing.JPanel();
        ItemTypeCommit_Button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SelectField_Label4 = new javax.swing.JLabel();
        RegisterStatusType_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel10 = new javax.swing.JPanel();
        Title_Label10 = new javax.swing.JLabel();
        Subtitle_Label10 = new javax.swing.JLabel();
        Upper_Banner10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        SelectField_Label5 = new javax.swing.JLabel();
        RemoveStatusType_CheckBox = new javax.swing.JCheckBox();
        InsertStatusType_CheckBox = new javax.swing.JCheckBox();
        UpdateStatusType_CheckBox = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        Status_Table = new javax.swing.JTable();
        StatusTypeName_TextField = new javax.swing.JTextField();
        RelationTypeCommitChanges_Panel2 = new javax.swing.JPanel();
        StatusCommit_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        SelectField_Label6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        StatusTypeDescription_TextField = new javax.swing.JTextField();
        RegisterGenreType_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel11 = new javax.swing.JPanel();
        Title_Label11 = new javax.swing.JLabel();
        Subtitle_Label11 = new javax.swing.JLabel();
        Upper_Banner11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        SelectField_Label7 = new javax.swing.JLabel();
        RemoveGenreType_CheckBox = new javax.swing.JCheckBox();
        InsertGenreType_CheckBox = new javax.swing.JCheckBox();
        UpdateGenreType_CheckBox = new javax.swing.JCheckBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        Genre_Table = new javax.swing.JTable();
        GenreTypeName_TextField = new javax.swing.JTextField();
        RelationTypeCommitChanges_Panel3 = new javax.swing.JPanel();
        GenreCommit_Button = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        SelectField_Label8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        GenreTypeDescription_TextField = new javax.swing.JTextField();
        RegisterPublisher_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel12 = new javax.swing.JPanel();
        Title_Label12 = new javax.swing.JLabel();
        Subtitle_Label12 = new javax.swing.JLabel();
        Upper_Banner12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        SelectField_Label9 = new javax.swing.JLabel();
        RemovePublisher_CheckBox = new javax.swing.JCheckBox();
        InsertPublisher_CheckBox = new javax.swing.JCheckBox();
        UpdatePublisher_CheckBox = new javax.swing.JCheckBox();
        jScrollPane8 = new javax.swing.JScrollPane();
        Publisher_Table = new javax.swing.JTable();
        PublisherName_TextField = new javax.swing.JTextField();
        RelationTypeCommitChanges_Panel4 = new javax.swing.JPanel();
        PublisherCommit_Button = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        SelectField_Label10 = new javax.swing.JLabel();
        RegisterAuthor_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel13 = new javax.swing.JPanel();
        Title_Label13 = new javax.swing.JLabel();
        Subtitle_Label13 = new javax.swing.JLabel();
        Upper_Banner13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        SelectField_Label11 = new javax.swing.JLabel();
        RemoveAuthor_CheckBox = new javax.swing.JCheckBox();
        InsertAuthor_CheckBox = new javax.swing.JCheckBox();
        UpdateAuthor_CheckBox = new javax.swing.JCheckBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        Authors_Table = new javax.swing.JTable();
        AuthorID_TextField = new javax.swing.JTextField();
        RelationTypeCommitChanges_Panel5 = new javax.swing.JPanel();
        AuthorCommit_Button = new javax.swing.JButton();
        SelectField_Label12 = new javax.swing.JLabel();
        Author_Last_Name = new javax.swing.JLabel();
        Author_Id_Label = new javax.swing.JLabel();
        AuthorFirstName_TextField = new javax.swing.JTextField();
        Author_First_Name_Label = new javax.swing.JLabel();
        AuthorLastName_TextField = new javax.swing.JTextField();
        Author_Email_Label = new javax.swing.JLabel();
        AuthorEmail_TextField = new javax.swing.JTextField();
        Author_Email_Label1 = new javax.swing.JLabel();
        AuthorPhoneNumber_TextField = new javax.swing.JTextField();
        StatisticsQueries_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel14 = new javax.swing.JPanel();
        Title_Label14 = new javax.swing.JLabel();
        Subtitle_Label14 = new javax.swing.JLabel();
        Upper_Banner14 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        SelectField_Label13 = new javax.swing.JLabel();
        Queries_Button = new javax.swing.JButton();
        Stadistics_Button = new javax.swing.JButton();
        Statistics_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel6 = new javax.swing.JPanel();
        Title_Label6 = new javax.swing.JLabel();
        Subtitle_Label6 = new javax.swing.JLabel();
        Upper_Banner6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Select_Label = new javax.swing.JLabel();
        SelectStatistic_ComboBox = new javax.swing.JComboBox<>();
        CloseAllCharts_Button = new javax.swing.JButton();
        Queries_InternalFrame = new javax.swing.JInternalFrame();
        Background_Panel15 = new javax.swing.JPanel();
        Title_Label15 = new javax.swing.JLabel();
        Subtitle_Label15 = new javax.swing.JLabel();
        Upper_Banner15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        ParametersText_Label = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Queries_Table = new CellColor();
        Select_Label2 = new javax.swing.JLabel();
        Parameter2_TextField = new javax.swing.JTextField();
        Go_Button = new javax.swing.JButton();
        Parameter1_TextField = new javax.swing.JTextField();
        Queries_ComboBox = new javax.swing.JComboBox<>();
        Total_TextField = new javax.swing.JTextField();
        Parameters_Label = new javax.swing.JLabel();
        Filter_ComboBox = new javax.swing.JComboBox<>();
        Filter_Label = new javax.swing.JLabel();
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
        Genre_Label2 = new javax.swing.JLabel();
        Author_ComboBox = new javax.swing.JComboBox<>();
        Menu_Panel = new javax.swing.JPanel();
        Divisor_Panel = new javax.swing.JPanel();
        Banner_Label = new javax.swing.JLabel();
        Lateral_Button7 = new javax.swing.JButton();
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
        Admin_Label = new javax.swing.JLabel();
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

        TitleItem_TextField.setBackground(new java.awt.Color(51, 51, 51));
        TitleItem_TextField.setForeground(new java.awt.Color(255, 255, 255));
        TitleItem_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(233, 85, 4)));
        jPanel17.add(TitleItem_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 260, 30));

        EditionItem_TextField.setBackground(new java.awt.Color(51, 51, 51));
        EditionItem_TextField.setForeground(new java.awt.Color(255, 255, 255));
        EditionItem_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(233, 85, 4)));
        jPanel17.add(EditionItem_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 260, 30));

        BarbcodeItem_TextField.setBackground(new java.awt.Color(51, 51, 51));
        BarbcodeItem_TextField.setForeground(new java.awt.Color(255, 255, 255));
        BarbcodeItem_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(233, 85, 4)));
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
        Subtitle_Label1.setText("Family, friends, coworkers. Everyone is here!");
        Background_Panel1.add(Subtitle_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        Upper_Banner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel1.add(Upper_Banner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PersonEmail_TextField.setBackground(new java.awt.Color(51, 51, 51));
        PersonEmail_TextField.setForeground(new java.awt.Color(255, 255, 255));
        PersonEmail_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 240, 0)));
        jPanel1.add(PersonEmail_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 260, 30));

        RelationType_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        RelationType_Label.setForeground(new java.awt.Color(255, 255, 255));
        RelationType_Label.setText("Relation Type:");
        jPanel1.add(RelationType_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        RelationType_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        RelationType_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        RelationType_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 240, 0)));
        RelationType_ComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RelationType_ComboBox.setFocusable(false);
        RelationType_ComboBox.setName(""); // NOI18N
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

        Day_TextField.setBackground(new java.awt.Color(51, 51, 51));
        Day_TextField.setForeground(new java.awt.Color(255, 255, 255));
        Day_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 150, 0)));
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

        YellowTolerance_TextField.setBackground(new java.awt.Color(51, 51, 51));
        YellowTolerance_TextField.setForeground(new java.awt.Color(255, 255, 255));
        YellowTolerance_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 150, 0)));
        jPanel2.add(YellowTolerance_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 80, 30));

        Month_TextField.setBackground(new java.awt.Color(51, 51, 51));
        Month_TextField.setForeground(new java.awt.Color(255, 255, 255));
        Month_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 150, 0)));
        jPanel2.add(Month_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 80, 30));

        ToleranceDays_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ToleranceDays_Label.setForeground(new java.awt.Color(255, 255, 255));
        ToleranceDays_Label.setText("Tolerance Days:");
        jPanel2.add(ToleranceDays_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        ReturnDate_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ReturnDate_Label.setForeground(new java.awt.Color(255, 255, 255));
        ReturnDate_Label.setText("Return Date:");
        jPanel2.add(ReturnDate_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        RedTolerance_TextField.setBackground(new java.awt.Color(51, 51, 51));
        RedTolerance_TextField.setForeground(new java.awt.Color(255, 255, 255));
        RedTolerance_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 150, 0)));
        jPanel2.add(RedTolerance_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 80, 30));

        Year_TextField.setBackground(new java.awt.Color(51, 51, 51));
        Year_TextField.setForeground(new java.awt.Color(255, 255, 255));
        Year_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 150, 0)));
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

        RegisterValues_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        RegisterValues_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(13, 172, 103)));
        RegisterValues_InternalFrame.setClosable(true);
        RegisterValues_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        RegisterValues_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        RegisterValues_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        RegisterValues_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        RegisterValues_InternalFrame.setVisible(false);
        RegisterValues_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel5.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label5.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label5.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label5.setText("Register In Database!");
        Background_Panel5.add(Title_Label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label5.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label5.setText("Add, Delete or Update values in the Database...");
        Background_Panel5.add(Subtitle_Label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        Upper_Banner5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel5.add(Upper_Banner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectField_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label.setText("Select Field:");
        jPanel6.add(SelectField_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        StatusType_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        StatusType_Button.setForeground(new java.awt.Color(255, 255, 255));
        StatusType_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Status_Icon64.png"))); // NOI18N
        StatusType_Button.setText("Status Types");
        StatusType_Button.setBorderPainted(false);
        StatusType_Button.setContentAreaFilled(false);
        StatusType_Button.setFocusable(false);
        StatusType_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        StatusType_Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        StatusType_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusType_ButtonActionPerformed(evt);
            }
        });
        jPanel6.add(StatusType_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 130, 90));

        RelationType_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        RelationType_Button.setForeground(new java.awt.Color(255, 255, 255));
        RelationType_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RelationType_Icon64.png"))); // NOI18N
        RelationType_Button.setText("Relation Types");
        RelationType_Button.setBorderPainted(false);
        RelationType_Button.setContentAreaFilled(false);
        RelationType_Button.setFocusable(false);
        RelationType_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RelationType_Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RelationType_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelationType_ButtonActionPerformed(evt);
            }
        });
        jPanel6.add(RelationType_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 130, 90));

        Author_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Author_Button.setForeground(new java.awt.Color(255, 255, 255));
        Author_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Author_Icon64.png"))); // NOI18N
        Author_Button.setText("Authors");
        Author_Button.setBorderPainted(false);
        Author_Button.setContentAreaFilled(false);
        Author_Button.setFocusable(false);
        Author_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Author_Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Author_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Author_ButtonActionPerformed(evt);
            }
        });
        jPanel6.add(Author_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, 90));

        ItemTypes_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ItemTypes_Button.setForeground(new java.awt.Color(255, 255, 255));
        ItemTypes_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ItemType_Icon64.png"))); // NOI18N
        ItemTypes_Button.setText("Item Types");
        ItemTypes_Button.setBorderPainted(false);
        ItemTypes_Button.setContentAreaFilled(false);
        ItemTypes_Button.setFocusable(false);
        ItemTypes_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ItemTypes_Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ItemTypes_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemTypes_ButtonActionPerformed(evt);
            }
        });
        jPanel6.add(ItemTypes_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 130, 90));

        Genre_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Genre_Button.setForeground(new java.awt.Color(255, 255, 255));
        Genre_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Genre_Icon64.png"))); // NOI18N
        Genre_Button.setText("Item Genre Types");
        Genre_Button.setBorderPainted(false);
        Genre_Button.setContentAreaFilled(false);
        Genre_Button.setFocusable(false);
        Genre_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Genre_Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Genre_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Genre_ButtonActionPerformed(evt);
            }
        });
        jPanel6.add(Genre_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, 90));

        Publisher_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Publisher_Button.setForeground(new java.awt.Color(255, 255, 255));
        Publisher_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Publisher_Icon64.png"))); // NOI18N
        Publisher_Button.setText("Publishers");
        Publisher_Button.setBorderPainted(false);
        Publisher_Button.setContentAreaFilled(false);
        Publisher_Button.setFocusable(false);
        Publisher_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Publisher_Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Publisher_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Publisher_ButtonActionPerformed(evt);
            }
        });
        jPanel6.add(Publisher_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, 90));

        Background_Panel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        RegisterValues_InternalFrame.getContentPane().add(Background_Panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(RegisterValues_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        RegisterRelationType_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        RegisterRelationType_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(13, 172, 103)));
        RegisterRelationType_InternalFrame.setClosable(true);
        RegisterRelationType_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        RegisterRelationType_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        RegisterRelationType_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        RegisterRelationType_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        RegisterRelationType_InternalFrame.setVisible(false);
        RegisterRelationType_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel8.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label8.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label8.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label8.setText("Register Relation Types");
        Background_Panel8.add(Title_Label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label8.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label8.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label8.setText("Register In Catalogue");
        Background_Panel8.add(Subtitle_Label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        Upper_Banner8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel8.add(Upper_Banner8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectField_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label1.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label1.setText("Existing in Database:");
        jPanel9.add(SelectField_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        RemoveRelationType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        RemoveRelationType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RemoveRelationType_CheckBox.setText("Remove");
        RemoveRelationType_CheckBox.setContentAreaFilled(false);
        RemoveRelationType_CheckBox.setFocusable(false);
        RemoveRelationType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveRelationType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel9.add(RemoveRelationType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, -1));

        InsertRelationType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        InsertRelationType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        InsertRelationType_CheckBox.setText("Insert");
        InsertRelationType_CheckBox.setContentAreaFilled(false);
        InsertRelationType_CheckBox.setFocusable(false);
        InsertRelationType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertRelationType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel9.add(InsertRelationType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        UpdateRelationType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        UpdateRelationType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        UpdateRelationType_CheckBox.setText("Update");
        UpdateRelationType_CheckBox.setContentAreaFilled(false);
        UpdateRelationType_CheckBox.setFocusable(false);
        UpdateRelationType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateRelationType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel9.add(UpdateRelationType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        RelationTypes_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(RelationTypes_Table);

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 340, 250));

        RelationTypeName_TextField.setBackground(new java.awt.Color(51, 51, 51));
        RelationTypeName_TextField.setForeground(new java.awt.Color(255, 255, 255));
        RelationTypeName_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel9.add(RelationTypeName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 270, 30));

        RelationTypeCommitChanges_Panel.setBackground(new java.awt.Color(255, 255, 255));
        RelationTypeCommitChanges_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_PanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_PanelMouseExited(evt);
            }
        });
        RelationTypeCommitChanges_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RelationTypeCommit_Button.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        RelationTypeCommit_Button.setForeground(new java.awt.Color(0, 0, 0));
        RelationTypeCommit_Button.setText("Commit changes");
        RelationTypeCommit_Button.setBorderPainted(false);
        RelationTypeCommit_Button.setContentAreaFilled(false);
        RelationTypeCommit_Button.setFocusable(false);
        RelationTypeCommit_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelationTypeCommit_ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelationTypeCommit_ButtonMouseExited(evt);
            }
        });
        RelationTypeCommit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelationTypeCommit_ButtonActionPerformed(evt);
            }
        });
        RelationTypeCommitChanges_Panel.add(RelationTypeCommit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jPanel9.add(RelationTypeCommitChanges_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 200, 50));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Relation Type Name:");
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        SelectField_Label2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label2.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label2.setText("Select Field:");
        jPanel9.add(SelectField_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        Background_Panel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        RegisterRelationType_InternalFrame.getContentPane().add(Background_Panel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(RegisterRelationType_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        RegisterItemType_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        RegisterItemType_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(13, 172, 103)));
        RegisterItemType_InternalFrame.setClosable(true);
        RegisterItemType_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        RegisterItemType_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        RegisterItemType_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        RegisterItemType_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        RegisterItemType_InternalFrame.setVisible(false);
        RegisterItemType_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel9.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label9.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label9.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label9.setText("Register Item Types");
        Background_Panel9.add(Title_Label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label9.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label9.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label9.setText("Register In Catalogue");
        Background_Panel9.add(Subtitle_Label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        Upper_Banner9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel9.add(Upper_Banner9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectField_Label3.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label3.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label3.setText("Existing in Database:");
        jPanel10.add(SelectField_Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        RemoveItemType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        RemoveItemType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RemoveItemType_CheckBox.setText("Remove");
        RemoveItemType_CheckBox.setContentAreaFilled(false);
        RemoveItemType_CheckBox.setFocusable(false);
        RemoveItemType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveItemType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel10.add(RemoveItemType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, -1));

        InsertItemType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        InsertItemType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        InsertItemType_CheckBox.setText("Insert");
        InsertItemType_CheckBox.setContentAreaFilled(false);
        InsertItemType_CheckBox.setFocusable(false);
        InsertItemType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertItemType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel10.add(InsertItemType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        UpdateItemType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        UpdateItemType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        UpdateItemType_CheckBox.setText("Update");
        UpdateItemType_CheckBox.setContentAreaFilled(false);
        UpdateItemType_CheckBox.setFocusable(false);
        UpdateItemType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateItemType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel10.add(UpdateItemType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        ItemTypes_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(ItemTypes_Table);

        jPanel10.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 340, 250));

        ItemTypeName_TextField.setBackground(new java.awt.Color(51, 51, 51));
        ItemTypeName_TextField.setForeground(new java.awt.Color(255, 255, 255));
        ItemTypeName_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel10.add(ItemTypeName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 270, 30));

        RelationTypeCommitChanges_Panel1.setBackground(new java.awt.Color(255, 255, 255));
        RelationTypeCommitChanges_Panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel1MouseExited(evt);
            }
        });
        RelationTypeCommitChanges_Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ItemTypeCommit_Button.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        ItemTypeCommit_Button.setForeground(new java.awt.Color(0, 0, 0));
        ItemTypeCommit_Button.setText("Commit changes");
        ItemTypeCommit_Button.setBorderPainted(false);
        ItemTypeCommit_Button.setContentAreaFilled(false);
        ItemTypeCommit_Button.setFocusable(false);
        ItemTypeCommit_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ItemTypeCommit_ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ItemTypeCommit_ButtonMouseExited(evt);
            }
        });
        ItemTypeCommit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemTypeCommit_ButtonActionPerformed(evt);
            }
        });
        RelationTypeCommitChanges_Panel1.add(ItemTypeCommit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jPanel10.add(RelationTypeCommitChanges_Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 200, 50));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Item Type Name:");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        SelectField_Label4.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label4.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label4.setText("Select Field:");
        jPanel10.add(SelectField_Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        Background_Panel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        RegisterItemType_InternalFrame.getContentPane().add(Background_Panel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(RegisterItemType_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        RegisterStatusType_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        RegisterStatusType_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(13, 172, 103)));
        RegisterStatusType_InternalFrame.setClosable(true);
        RegisterStatusType_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        RegisterStatusType_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        RegisterStatusType_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        RegisterStatusType_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        RegisterStatusType_InternalFrame.setVisible(false);
        RegisterStatusType_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel10.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label10.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label10.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label10.setText("Register Status Types");
        Background_Panel10.add(Title_Label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label10.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label10.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label10.setText("Register In Catalogue");
        Background_Panel10.add(Subtitle_Label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        Upper_Banner10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel10.add(Upper_Banner10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectField_Label5.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label5.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label5.setText("Existing in Database:");
        jPanel11.add(SelectField_Label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        RemoveStatusType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        RemoveStatusType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RemoveStatusType_CheckBox.setText("Remove");
        RemoveStatusType_CheckBox.setContentAreaFilled(false);
        RemoveStatusType_CheckBox.setFocusable(false);
        RemoveStatusType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveStatusType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel11.add(RemoveStatusType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, -1));

        InsertStatusType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        InsertStatusType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        InsertStatusType_CheckBox.setText("Insert");
        InsertStatusType_CheckBox.setContentAreaFilled(false);
        InsertStatusType_CheckBox.setFocusable(false);
        InsertStatusType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertStatusType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel11.add(InsertStatusType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        UpdateStatusType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        UpdateStatusType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        UpdateStatusType_CheckBox.setText("Update");
        UpdateStatusType_CheckBox.setContentAreaFilled(false);
        UpdateStatusType_CheckBox.setFocusable(false);
        UpdateStatusType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateStatusType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel11.add(UpdateStatusType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        Status_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(Status_Table);

        jPanel11.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 340, 250));

        StatusTypeName_TextField.setBackground(new java.awt.Color(51, 51, 51));
        StatusTypeName_TextField.setForeground(new java.awt.Color(255, 255, 255));
        StatusTypeName_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel11.add(StatusTypeName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 270, 30));

        RelationTypeCommitChanges_Panel2.setBackground(new java.awt.Color(255, 255, 255));
        RelationTypeCommitChanges_Panel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel2MouseExited(evt);
            }
        });
        RelationTypeCommitChanges_Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StatusCommit_Button.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        StatusCommit_Button.setForeground(new java.awt.Color(0, 0, 0));
        StatusCommit_Button.setText("Commit changes");
        StatusCommit_Button.setBorderPainted(false);
        StatusCommit_Button.setContentAreaFilled(false);
        StatusCommit_Button.setFocusable(false);
        StatusCommit_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StatusCommit_ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StatusCommit_ButtonMouseExited(evt);
            }
        });
        StatusCommit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusCommit_ButtonActionPerformed(evt);
            }
        });
        RelationTypeCommitChanges_Panel2.add(StatusCommit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jPanel11.add(RelationTypeCommitChanges_Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 200, 50));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Status Type Description:");
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        SelectField_Label6.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label6.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label6.setText("Select Field:");
        jPanel11.add(SelectField_Label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status Type Name:");
        jPanel11.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        StatusTypeDescription_TextField.setBackground(new java.awt.Color(51, 51, 51));
        StatusTypeDescription_TextField.setForeground(new java.awt.Color(255, 255, 255));
        StatusTypeDescription_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel11.add(StatusTypeDescription_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 270, 30));

        Background_Panel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        RegisterStatusType_InternalFrame.getContentPane().add(Background_Panel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(RegisterStatusType_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        RegisterGenreType_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        RegisterGenreType_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(13, 172, 103)));
        RegisterGenreType_InternalFrame.setClosable(true);
        RegisterGenreType_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        RegisterGenreType_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        RegisterGenreType_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        RegisterGenreType_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        RegisterGenreType_InternalFrame.setVisible(false);
        RegisterGenreType_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel11.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label11.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label11.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label11.setText("Register Genre Types");
        Background_Panel11.add(Title_Label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label11.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label11.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label11.setText("Register In Catalogue");
        Background_Panel11.add(Subtitle_Label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        Upper_Banner11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel11.add(Upper_Banner11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectField_Label7.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label7.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label7.setText("Existing in Database:");
        jPanel12.add(SelectField_Label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        RemoveGenreType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        RemoveGenreType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RemoveGenreType_CheckBox.setText("Remove");
        RemoveGenreType_CheckBox.setContentAreaFilled(false);
        RemoveGenreType_CheckBox.setFocusable(false);
        RemoveGenreType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveGenreType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel12.add(RemoveGenreType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, -1));

        InsertGenreType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        InsertGenreType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        InsertGenreType_CheckBox.setText("Insert");
        InsertGenreType_CheckBox.setContentAreaFilled(false);
        InsertGenreType_CheckBox.setFocusable(false);
        InsertGenreType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertGenreType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel12.add(InsertGenreType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        UpdateGenreType_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        UpdateGenreType_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        UpdateGenreType_CheckBox.setText("Update");
        UpdateGenreType_CheckBox.setContentAreaFilled(false);
        UpdateGenreType_CheckBox.setFocusable(false);
        UpdateGenreType_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateGenreType_CheckBoxActionPerformed(evt);
            }
        });
        jPanel12.add(UpdateGenreType_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        Genre_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(Genre_Table);

        jPanel12.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 540, 250));

        GenreTypeName_TextField.setBackground(new java.awt.Color(51, 51, 51));
        GenreTypeName_TextField.setForeground(new java.awt.Color(255, 255, 255));
        GenreTypeName_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel12.add(GenreTypeName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 270, 30));

        RelationTypeCommitChanges_Panel3.setBackground(new java.awt.Color(255, 255, 255));
        RelationTypeCommitChanges_Panel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel3MouseExited(evt);
            }
        });
        RelationTypeCommitChanges_Panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GenreCommit_Button.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        GenreCommit_Button.setForeground(new java.awt.Color(0, 0, 0));
        GenreCommit_Button.setText("Commit changes");
        GenreCommit_Button.setBorderPainted(false);
        GenreCommit_Button.setContentAreaFilled(false);
        GenreCommit_Button.setFocusable(false);
        GenreCommit_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GenreCommit_ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GenreCommit_ButtonMouseExited(evt);
            }
        });
        GenreCommit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenreCommit_ButtonActionPerformed(evt);
            }
        });
        RelationTypeCommitChanges_Panel3.add(GenreCommit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jPanel12.add(RelationTypeCommitChanges_Panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 200, 50));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Genre Description:");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        SelectField_Label8.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label8.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label8.setText("Select Field:");
        jPanel12.add(SelectField_Label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Genre Name:");
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        GenreTypeDescription_TextField.setBackground(new java.awt.Color(51, 51, 51));
        GenreTypeDescription_TextField.setForeground(new java.awt.Color(255, 255, 255));
        GenreTypeDescription_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel12.add(GenreTypeDescription_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 270, 30));

        Background_Panel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        RegisterGenreType_InternalFrame.getContentPane().add(Background_Panel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(RegisterGenreType_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        RegisterPublisher_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        RegisterPublisher_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(13, 172, 103)));
        RegisterPublisher_InternalFrame.setClosable(true);
        RegisterPublisher_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        RegisterPublisher_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        RegisterPublisher_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        RegisterPublisher_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        RegisterPublisher_InternalFrame.setVisible(false);
        RegisterPublisher_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel12.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label12.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label12.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label12.setText("Register Publishers");
        Background_Panel12.add(Title_Label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label12.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label12.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label12.setText("Register In Catalogue");
        Background_Panel12.add(Subtitle_Label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        Upper_Banner12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel12.add(Upper_Banner12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectField_Label9.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label9.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label9.setText("Existing in Database:");
        jPanel13.add(SelectField_Label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        RemovePublisher_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        RemovePublisher_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RemovePublisher_CheckBox.setText("Remove");
        RemovePublisher_CheckBox.setContentAreaFilled(false);
        RemovePublisher_CheckBox.setFocusable(false);
        RemovePublisher_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovePublisher_CheckBoxActionPerformed(evt);
            }
        });
        jPanel13.add(RemovePublisher_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, -1));

        InsertPublisher_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        InsertPublisher_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        InsertPublisher_CheckBox.setText("Insert");
        InsertPublisher_CheckBox.setContentAreaFilled(false);
        InsertPublisher_CheckBox.setFocusable(false);
        InsertPublisher_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertPublisher_CheckBoxActionPerformed(evt);
            }
        });
        jPanel13.add(InsertPublisher_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        UpdatePublisher_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        UpdatePublisher_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        UpdatePublisher_CheckBox.setText("Update");
        UpdatePublisher_CheckBox.setContentAreaFilled(false);
        UpdatePublisher_CheckBox.setFocusable(false);
        UpdatePublisher_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePublisher_CheckBoxActionPerformed(evt);
            }
        });
        jPanel13.add(UpdatePublisher_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        Publisher_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(Publisher_Table);

        jPanel13.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 340, 250));

        PublisherName_TextField.setEditable(false);
        PublisherName_TextField.setBackground(new java.awt.Color(51, 51, 51));
        PublisherName_TextField.setForeground(new java.awt.Color(255, 255, 255));
        PublisherName_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel13.add(PublisherName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 270, 30));

        RelationTypeCommitChanges_Panel4.setBackground(new java.awt.Color(255, 255, 255));
        RelationTypeCommitChanges_Panel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel4MouseExited(evt);
            }
        });
        RelationTypeCommitChanges_Panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PublisherCommit_Button.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        PublisherCommit_Button.setForeground(new java.awt.Color(0, 0, 0));
        PublisherCommit_Button.setText("Commit changes");
        PublisherCommit_Button.setBorderPainted(false);
        PublisherCommit_Button.setContentAreaFilled(false);
        PublisherCommit_Button.setFocusable(false);
        PublisherCommit_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PublisherCommit_ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PublisherCommit_ButtonMouseExited(evt);
            }
        });
        PublisherCommit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublisherCommit_ButtonActionPerformed(evt);
            }
        });
        RelationTypeCommitChanges_Panel4.add(PublisherCommit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jPanel13.add(RelationTypeCommitChanges_Panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 200, 50));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Publisher Name:");
        jPanel13.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        SelectField_Label10.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label10.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label10.setText("Select Field:");
        jPanel13.add(SelectField_Label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        Background_Panel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        RegisterPublisher_InternalFrame.getContentPane().add(Background_Panel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(RegisterPublisher_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        RegisterAuthor_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        RegisterAuthor_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(13, 172, 103)));
        RegisterAuthor_InternalFrame.setClosable(true);
        RegisterAuthor_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        RegisterAuthor_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        RegisterAuthor_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        RegisterAuthor_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        RegisterAuthor_InternalFrame.setVisible(false);
        RegisterAuthor_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel13.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label13.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label13.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label13.setText("Register Authors");
        Background_Panel13.add(Title_Label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label13.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label13.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label13.setText("Register In Catalogue");
        Background_Panel13.add(Subtitle_Label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        Upper_Banner13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel13.add(Upper_Banner13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectField_Label11.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label11.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label11.setText("Existing in Database:");
        jPanel14.add(SelectField_Label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        RemoveAuthor_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        RemoveAuthor_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RemoveAuthor_CheckBox.setText("Remove");
        RemoveAuthor_CheckBox.setContentAreaFilled(false);
        RemoveAuthor_CheckBox.setFocusable(false);
        RemoveAuthor_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveAuthor_CheckBoxActionPerformed(evt);
            }
        });
        jPanel14.add(RemoveAuthor_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, -1));

        InsertAuthor_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        InsertAuthor_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        InsertAuthor_CheckBox.setText("Insert");
        InsertAuthor_CheckBox.setContentAreaFilled(false);
        InsertAuthor_CheckBox.setFocusable(false);
        InsertAuthor_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertAuthor_CheckBoxActionPerformed(evt);
            }
        });
        jPanel14.add(InsertAuthor_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        UpdateAuthor_CheckBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        UpdateAuthor_CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        UpdateAuthor_CheckBox.setText("Update");
        UpdateAuthor_CheckBox.setContentAreaFilled(false);
        UpdateAuthor_CheckBox.setFocusable(false);
        UpdateAuthor_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateAuthor_CheckBoxActionPerformed(evt);
            }
        });
        jPanel14.add(UpdateAuthor_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        Authors_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(Authors_Table);

        jPanel14.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 380, 250));

        AuthorID_TextField.setBackground(new java.awt.Color(51, 51, 51));
        AuthorID_TextField.setForeground(new java.awt.Color(255, 255, 255));
        AuthorID_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel14.add(AuthorID_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 270, 30));

        RelationTypeCommitChanges_Panel5.setBackground(new java.awt.Color(255, 255, 255));
        RelationTypeCommitChanges_Panel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelationTypeCommitChanges_Panel5MouseExited(evt);
            }
        });
        RelationTypeCommitChanges_Panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AuthorCommit_Button.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        AuthorCommit_Button.setForeground(new java.awt.Color(0, 0, 0));
        AuthorCommit_Button.setText("Commit changes");
        AuthorCommit_Button.setBorderPainted(false);
        AuthorCommit_Button.setContentAreaFilled(false);
        AuthorCommit_Button.setFocusable(false);
        AuthorCommit_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AuthorCommit_ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AuthorCommit_ButtonMouseExited(evt);
            }
        });
        AuthorCommit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorCommit_ButtonActionPerformed(evt);
            }
        });
        RelationTypeCommitChanges_Panel5.add(AuthorCommit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jPanel14.add(RelationTypeCommitChanges_Panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 200, 50));

        SelectField_Label12.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label12.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label12.setText("Select Field:");
        jPanel14.add(SelectField_Label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        Author_Last_Name.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        Author_Last_Name.setForeground(new java.awt.Color(255, 255, 255));
        Author_Last_Name.setText("Author Last Name:");
        jPanel14.add(Author_Last_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));

        Author_Id_Label.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        Author_Id_Label.setForeground(new java.awt.Color(255, 255, 255));
        Author_Id_Label.setText("Author Person Id:");
        jPanel14.add(Author_Id_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        AuthorFirstName_TextField.setBackground(new java.awt.Color(51, 51, 51));
        AuthorFirstName_TextField.setForeground(new java.awt.Color(255, 255, 255));
        AuthorFirstName_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        AuthorFirstName_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorFirstName_TextFieldActionPerformed(evt);
            }
        });
        jPanel14.add(AuthorFirstName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 270, 30));

        Author_First_Name_Label.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        Author_First_Name_Label.setForeground(new java.awt.Color(255, 255, 255));
        Author_First_Name_Label.setText("Author First Name:");
        jPanel14.add(Author_First_Name_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        AuthorLastName_TextField.setEditable(false);
        AuthorLastName_TextField.setBackground(new java.awt.Color(51, 51, 51));
        AuthorLastName_TextField.setForeground(new java.awt.Color(255, 255, 255));
        AuthorLastName_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel14.add(AuthorLastName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 270, 30));

        Author_Email_Label.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        Author_Email_Label.setForeground(new java.awt.Color(255, 255, 255));
        Author_Email_Label.setText("Author Phone Number:");
        jPanel14.add(Author_Email_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, -1));

        AuthorEmail_TextField.setBackground(new java.awt.Color(51, 51, 51));
        AuthorEmail_TextField.setForeground(new java.awt.Color(255, 255, 255));
        AuthorEmail_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel14.add(AuthorEmail_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 270, 30));

        Author_Email_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        Author_Email_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Author_Email_Label1.setText("Author Email:");
        jPanel14.add(Author_Email_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        AuthorPhoneNumber_TextField.setBackground(new java.awt.Color(51, 51, 51));
        AuthorPhoneNumber_TextField.setForeground(new java.awt.Color(255, 255, 255));
        AuthorPhoneNumber_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(13, 172, 103)));
        jPanel14.add(AuthorPhoneNumber_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 270, 30));

        Background_Panel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 840, 530));

        RegisterAuthor_InternalFrame.getContentPane().add(Background_Panel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(RegisterAuthor_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        StatisticsQueries_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        StatisticsQueries_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(147, 46, 236)));
        StatisticsQueries_InternalFrame.setClosable(true);
        StatisticsQueries_InternalFrame.setForeground(new java.awt.Color(255, 255, 255));
        StatisticsQueries_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        StatisticsQueries_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        StatisticsQueries_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        StatisticsQueries_InternalFrame.setVisible(false);
        StatisticsQueries_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel14.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label14.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label14.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label14.setText("Statistics And Queries!");
        Background_Panel14.add(Title_Label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label14.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label14.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label14.setText("See info about your database...");
        Background_Panel14.add(Subtitle_Label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        Upper_Banner14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel14.add(Upper_Banner14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectField_Label13.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        SelectField_Label13.setForeground(new java.awt.Color(255, 255, 255));
        SelectField_Label13.setText("Select Field:");
        jPanel15.add(SelectField_Label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        Queries_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Queries_Button.setForeground(new java.awt.Color(255, 255, 255));
        Queries_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Query_Icon128.png"))); // NOI18N
        Queries_Button.setText("Queries");
        Queries_Button.setBorderPainted(false);
        Queries_Button.setContentAreaFilled(false);
        Queries_Button.setFocusable(false);
        Queries_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Queries_Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Queries_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Queries_ButtonActionPerformed(evt);
            }
        });
        jPanel15.add(Queries_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 200, 180));

        Stadistics_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Stadistics_Button.setForeground(new java.awt.Color(255, 255, 255));
        Stadistics_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Stadistics_Icon128.png"))); // NOI18N
        Stadistics_Button.setText("Statistics");
        Stadistics_Button.setBorderPainted(false);
        Stadistics_Button.setContentAreaFilled(false);
        Stadistics_Button.setFocusable(false);
        Stadistics_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Stadistics_Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Stadistics_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stadistics_ButtonActionPerformed(evt);
            }
        });
        jPanel15.add(Stadistics_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 200, 190));

        Background_Panel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        StatisticsQueries_InternalFrame.getContentPane().add(Background_Panel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(StatisticsQueries_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        Statistics_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        Statistics_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(147, 46, 236)));
        Statistics_InternalFrame.setClosable(true);
        Statistics_InternalFrame.setForeground(new java.awt.Color(0, 0, 0));
        Statistics_InternalFrame.setMaximumSize(new java.awt.Dimension(900, 720));
        Statistics_InternalFrame.setMinimumSize(new java.awt.Dimension(900, 720));
        Statistics_InternalFrame.setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        Statistics_InternalFrame.setVisible(false);
        Statistics_InternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background_Panel6.setBackground(new java.awt.Color(102, 102, 102));
        Background_Panel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title_Label6.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        Title_Label6.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label6.setText("Statistics in Database!");
        Background_Panel6.add(Title_Label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Subtitle_Label6.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Subtitle_Label6.setForeground(new java.awt.Color(255, 255, 255));
        Subtitle_Label6.setText("See info about this database...");
        Background_Panel6.add(Subtitle_Label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        Upper_Banner6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel6.add(Upper_Banner6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Select_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Select_Label.setForeground(new java.awt.Color(255, 255, 255));
        Select_Label.setText("Select:");
        jPanel7.add(Select_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        SelectStatistic_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        SelectStatistic_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        SelectStatistic_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Items by Genre", "Items Borrowed Now", "Items borrowed From Always", "Borrowed Items By Genre", "Borrowed Items By Age of Who Borrowed them" }));
        SelectStatistic_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(147, 46, 236)));
        SelectStatistic_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectStatistic_ComboBoxActionPerformed(evt);
            }
        });
        jPanel7.add(SelectStatistic_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 420, 30));

        CloseAllCharts_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CloseAllCharts_Button.setForeground(new java.awt.Color(255, 255, 255));
        CloseAllCharts_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_Icon32.png"))); // NOI18N
        CloseAllCharts_Button.setText("  Close Chart");
        CloseAllCharts_Button.setBorderPainted(false);
        CloseAllCharts_Button.setContentAreaFilled(false);
        CloseAllCharts_Button.setFocusable(false);
        CloseAllCharts_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseAllCharts_ButtonActionPerformed(evt);
            }
        });
        jPanel7.add(CloseAllCharts_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 180, 50));

        Background_Panel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 530));

        Statistics_InternalFrame.getContentPane().add(Background_Panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        getContentPane().add(Statistics_InternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 720));

        Queries_InternalFrame.setBackground(new java.awt.Color(0, 0, 0));
        Queries_InternalFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(147, 46, 236)));
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
        Subtitle_Label15.setText("See information about your database...");
        Background_Panel15.add(Subtitle_Label15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        Upper_Banner15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner3.png"))); // NOI18N
        Background_Panel15.add(Upper_Banner15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 100));

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ParametersText_Label.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ParametersText_Label.setForeground(new java.awt.Color(255, 255, 255));
        ParametersText_Label.setText("Parameters:");
        jPanel16.add(ParametersText_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 240, -1));

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

        jPanel16.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 820, 380));

        Select_Label2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Select_Label2.setForeground(new java.awt.Color(255, 255, 255));
        Select_Label2.setText("Select:");
        jPanel16.add(Select_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        Parameter2_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Parameter2_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Parameter2_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(147, 46, 236)));
        jPanel16.add(Parameter2_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 110, 30));

        Go_Button.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Go_Button.setForeground(new java.awt.Color(255, 255, 255));
        Go_Button.setText("Go!");
        Go_Button.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(147, 46, 236)));
        Go_Button.setContentAreaFilled(false);
        Go_Button.setFocusable(false);
        Go_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Go_ButtonActionPerformed(evt);
            }
        });
        jPanel16.add(Go_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 40, 30));

        Parameter1_TextField.setBackground(new java.awt.Color(255, 255, 255));
        Parameter1_TextField.setForeground(new java.awt.Color(0, 0, 0));
        Parameter1_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(147, 46, 236)));
        Parameter1_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Parameter1_TextFieldActionPerformed(evt);
            }
        });
        jPanel16.add(Parameter1_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 110, 30));

        Queries_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        Queries_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        Queries_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Borrowed Items", "Top Most Borrowed Items", "Most Borrowed Items Per Month", "Total People to Whom Items are Loaned by Age", "All Items", "All Lended Items" }));
        Queries_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(147, 46, 236)));
        Queries_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Queries_ComboBoxActionPerformed(evt);
            }
        });
        jPanel16.add(Queries_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 320, 30));

        Total_TextField.setBackground(new java.awt.Color(51, 51, 51));
        Total_TextField.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        Total_TextField.setForeground(new java.awt.Color(255, 255, 255));
        Total_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(147, 46, 236)));
        jPanel16.add(Total_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 320, 30));

        Parameters_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Parameters_Label.setForeground(new java.awt.Color(255, 255, 255));
        Parameters_Label.setText("Parameters:");
        jPanel16.add(Parameters_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        Filter_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        Filter_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        Filter_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "Author", "Publisher" }));
        Filter_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(147, 46, 236)));
        Filter_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_ComboBoxActionPerformed(evt);
            }
        });
        jPanel16.add(Filter_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 160, 30));

        Filter_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Filter_Label.setForeground(new java.awt.Color(255, 255, 255));
        Filter_Label.setText("Filter By:");
        jPanel16.add(Filter_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

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
        jPanel8.add(ItemType_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        Genre_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        Genre_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        Genre_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel8.add(Genre_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 260, 30));

        Genre_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Genre_Label.setForeground(new java.awt.Color(255, 255, 255));
        Genre_Label.setText("Genre:");
        jPanel8.add(Genre_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        ItemEdition_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemEdition_Label.setForeground(new java.awt.Color(255, 255, 255));
        ItemEdition_Label.setText("Item Edition:");
        jPanel8.add(ItemEdition_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        ItemBarcode_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemBarcode_Label.setForeground(new java.awt.Color(255, 255, 255));
        ItemBarcode_Label.setText("Item Barcode:");
        jPanel8.add(ItemBarcode_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        ItemTitle_Label.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        ItemTitle_Label.setForeground(new java.awt.Color(255, 255, 255));
        ItemTitle_Label.setText("Item Title:");
        jPanel8.add(ItemTitle_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        Publisher_Label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Publisher_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Publisher_Label1.setText("Publisher:");
        jPanel8.add(Publisher_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        ItemType_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        ItemType_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        ItemType_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        jPanel8.add(ItemType_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 260, 30));

        ItemTitle_TextField.setBackground(new java.awt.Color(51, 51, 51));
        ItemTitle_TextField.setForeground(new java.awt.Color(255, 255, 255));
        ItemTitle_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        jPanel8.add(ItemTitle_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 260, 30));

        ItemEdition_TextField.setBackground(new java.awt.Color(51, 51, 51));
        ItemEdition_TextField.setForeground(new java.awt.Color(255, 255, 255));
        ItemEdition_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        jPanel8.add(ItemEdition_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 260, 30));

        ItemBarbcode_TextField.setBackground(new java.awt.Color(51, 51, 51));
        ItemBarbcode_TextField.setForeground(new java.awt.Color(255, 255, 255));
        ItemBarbcode_TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        jPanel8.add(ItemBarbcode_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 260, 30));

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
        jPanel8.add(Publisher_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 260, 30));

        Genre_Label2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        Genre_Label2.setForeground(new java.awt.Color(255, 255, 255));
        Genre_Label2.setText("Created By:");
        jPanel8.add(Genre_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        Author_ComboBox.setBackground(new java.awt.Color(255, 255, 255));
        Author_ComboBox.setForeground(new java.awt.Color(0, 0, 0));
        Author_ComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel8.add(Author_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 260, 30));

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

        Lateral_Button7.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Lateral_Button7.setForeground(new java.awt.Color(255, 255, 255));
        Lateral_Button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LateralButton7.png"))); // NOI18N
        Lateral_Button7.setText("                        Statistics & Queries");
        Lateral_Button7.setAlignmentX(5.0F);
        Lateral_Button7.setBorderPainted(false);
        Lateral_Button7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lateral_Button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lateral_Button7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Lateral_Button7MouseExited(evt);
            }
        });
        Lateral_Button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lateral_Button7ActionPerformed(evt);
            }
        });
        Menu_Panel.add(Lateral_Button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 530, 440, 60));

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
        Lateral_Button6.setText("               Register Values");
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

        Admin_Label.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        Admin_Label.setForeground(new java.awt.Color(255, 255, 255));
        Admin_Label.setText("Admin");
        Admin_Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Admin_Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Admin_Label.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(Admin_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 60, 20));

        Wallpaper_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu_Wallpaper.png"))); // NOI18N
        getContentPane().add(Wallpaper_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Lateral_Button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button7ActionPerformed
        Collection_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
       Queries_Table.removeAll();


       StatisticsQueries_InternalFrame.setVisible(true);
    }//GEN-LAST:event_Lateral_Button7ActionPerformed

    private void Lateral_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button1ActionPerformed
     Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);

        Collection_Table.removeAll();
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
       
       
       
       
       
       
       
       DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Item Id");
            modelo.addColumn("Title");
            modelo.addColumn("Publisher");
            modelo.addColumn("Edition");
            modelo.addColumn("Genre");           
            modelo.addColumn("Stars");
            modelo.addColumn("Status");

            
            
       
       
           
             //ResultSet res = pst.executeQuery();
                    
             ResultSet res2 = DBConnection.ConnectDB.getCollection(LendIziCollection.getIdentification());

             String data [] = new String[7];
             

             while(res2.next()){
                 data [0] = res2.getString(1);
                 data [1] = res2.getString(2);
                 data [2] = res2.getString(3);
                 data [3] = res2.getString(4);
                 data [4] = res2.getString(5);
                 
                 if(res2.getString(6).equals("1")){
                     data [5] = "★";
                 }
                 
                 else if(res2.getString(6).equals("2")){
                     data [5] = "★★";
                 }   
                 
                 else if(res2.getString(6).equals("3")){
                     data [5] = "★★★";

                 }   
                 
                 else if(res2.getString(6).equals("4")){
                     data [5] = "★★★★";
                    
                 }   
                 
                 else if(res2.getString(6).equals("5")){
                     data [5] = "★★★★★";
                 }  
                 
                 else if(res2.getString(6).equals("0")){
                        data [5] = "No Review Yet";
                 }  
                 ///////
                 
                 if(res2.getString(7).equals("Blue")){
                     data [6] = "In Stock";
                 }
                 
                 else if(res2.getString(7).equals("Green")){
                     data [6] = "Loaned";
                 }   
                 
                 else if(res2.getString(7).equals("Yellow")){
                     data [6] = "In Tolerance";
                 }   
                 
                 else if(res2.getString(7).equals("Red")){
                     data [6] = "In Max Tolerance";
                 }   
                 
                 else if(res2.getString(7).equals("Purple")){
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
            RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
            StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
            RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
            StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
            AddItem_InternalFrame.setVisible(false);
            
            ReceiveItem_InternalFrame.setVisible(true);
            

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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
            RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
            StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Lateral_Button5ActionPerformed

    private void Lateral_Button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button6ActionPerformed
       Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
       
       RegisterValues_InternalFrame.setVisible(true);
    }//GEN-LAST:event_Lateral_Button6ActionPerformed

    private void Lateral_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lateral_Button2ActionPerformed
        try {
            Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
            AddPeople_InternalFrame.setVisible(false);
            LendItem_InternalFrame.setVisible(false);
            ReceiveItem_InternalFrame.setVisible(false);
            ReviewItem_InternalFrame.setVisible(false);
            RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
            StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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

    private void Lateral_Button7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button7MouseEntered
      Lateral_Button7.setBounds(-60, 530, 440, 60);
    }//GEN-LAST:event_Lateral_Button7MouseEntered

    private void Lateral_Button7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lateral_Button7MouseExited
      Lateral_Button7.setBounds(-140, 530, 440, 60);
    }//GEN-LAST:event_Lateral_Button7MouseExited

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
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
       
      ItemType_ComboBox.removeAllItems();
      Publisher_ComboBox.removeAllItems();
      Genre_ComboBox.removeAllItems();
      Author_ComboBox.removeAllItems();

      
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

            ResultSet res4 = DBConnection.ConnectDB.getAuthors();
            
            while(res4.next()){
              String author = res4.getString(1) + " " + res4.getString(2);
              Author_ComboBox.addItem(author);
            }
            
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
       
       AddItem_InternalFrame.setVisible(true);
       
       } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
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
            
            
            JOptionPane.showMessageDialog(frame, "Returned Item Sucessfully");
            

            
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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
                JOptionPane.showMessageDialog(frame,"Must Select An Item","Warning:",JOptionPane.WARNING_MESSAGE);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
       String new_item_author = null;

               
      new_item_title      = ItemTitle_TextField.getText();
      new_item_edition    = ItemEdition_TextField.getText();
      new_item_barcode    = ItemBarbcode_TextField.getText();
      
      new_item_itemtype   = ItemType_ComboBox.getSelectedItem().toString();
      new_item_publisher  = Publisher_ComboBox.getSelectedItem().toString();     
      new_item_genre      = Genre_ComboBox.getSelectedItem().toString(); 
      new_item_author     = Author_ComboBox.getSelectedItem().toString();
      
      String[] parts = new_item_author.split("\\s+");
      String Author_name = parts[0];
      String Author_lastname = parts[1];
      
         System.out.println(Author_name);
         System.out.println(Author_lastname);
       
      int new_itemtype_id = DBConnection.ConnectDB.getItemTypeId(new_item_itemtype);
      int new_publisher_id = DBConnection.ConnectDB.getPublisherId(new_item_publisher);
      int new_genre_id = DBConnection.ConnectDB.getGenreId(new_item_genre);
      
      
      if( !new_item_title.equals(null) && !new_item_title.equals("") &&
          !new_item_edition.equals(null) && !new_item_edition.equals("") &&
          !new_item_barcode.equals(null) && !new_item_barcode.equals("") ){
          
            int id_new_title = DBConnection.ConnectDB.insertItem(new_item_title, new_item_edition, photo_item, new_item_barcode, new_itemtype_id, 0, new_publisher_id);
            int id_new_item_author = DBConnection.ConnectDB.getPersonIdByNames(Author_name, Author_lastname);
          
            
            
            DBConnection.ConnectDB.insertItemHasGenre(id_new_title, new_genre_id);
            DBConnection.ConnectDB.insertItemHasReview(id_new_title, 5);
            DBConnection.ConnectDB.insertPersonHasItem(LendIziCollection.getIdentification(), id_new_title);
            DBConnection.ConnectDB.insertPersonCreatesItem(id_new_item_author, id_new_title);
            
            
            JOptionPane.showMessageDialog(frame, "New Item Added.");

      }
      else{
        JOptionPane.showMessageDialog(frame, "Missing Information","Warning:", JOptionPane.WARNING_MESSAGE);
      }
      
    
     } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(frame, "Something happenend","Caution:", JOptionPane.WARNING_MESSAGE);
     }
          
          
        
        
    }//GEN-LAST:event_AddItem_ButtonActionPerformed

    private void RelationTypeCommit_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommit_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommit_ButtonMouseEntered

    private void RelationTypeCommit_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommit_ButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommit_ButtonMouseExited

    private void RelationTypeCommit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelationTypeCommit_ButtonActionPerformed
      try {
      if(InsertRelationType_CheckBox.isSelected()){
          
              String relation_type_name = RelationTypeName_TextField.getText();
              DBConnection.ConnectDB.insertRelationType(relation_type_name);
              JOptionPane.showMessageDialog(frame, "New Relation Type Created.");
        
      }
      
      else if(UpdateRelationType_CheckBox.isSelected()){
          
          String relation_type_name = RelationTypeName_TextField.getText();
          String selected_relationtype_name = RelationTypes_Table.getValueAt(RelationTypes_Table.getSelectedRow(),0).toString();
          int relation_type_id = DBConnection.ConnectDB.getRelationTypeId(selected_relationtype_name);
          
          
          DBConnection.ConnectDB.updateRelationType(relation_type_id, relation_type_name);
          
          JOptionPane.showMessageDialog(frame, "Relation Type Updated.");
      }
      
      else if(RemoveRelationType_CheckBox.isSelected()){
            int selectedOption = JOptionPane.showConfirmDialog(null, "You want to delete it?", "Select:", JOptionPane.YES_NO_OPTION); 
            if (selectedOption == JOptionPane.YES_OPTION) {
                String selected_relationtype_name = RelationTypes_Table.getValueAt(RelationTypes_Table.getSelectedRow(),0).toString();
                int relation_type_id = DBConnection.ConnectDB.getRelationTypeId(selected_relationtype_name);
          
                DBConnection.ConnectDB.removeRelationType(relation_type_id);
                JOptionPane.showMessageDialog(frame, "Relation Type Removed.");
            }
      
      }
            
      RelationTypes_Table.removeAll();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Relation Name");

            
            ResultSet res = DBConnection.ConnectDB.getRelationTypes();
            
            String data [] = new String[1];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                
                
                
                modelo.addRow(data);
                
            }
            
            RelationTypes_Table.setModel(modelo);
            
      } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      
      
    }//GEN-LAST:event_RelationTypeCommit_ButtonActionPerformed

    private void RelationTypeCommitChanges_PanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_PanelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_PanelMouseEntered

    private void RelationTypeCommitChanges_PanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_PanelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_PanelMouseExited

    private void InsertRelationType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertRelationType_CheckBoxActionPerformed
       UpdateRelationType_CheckBox.setSelected(false);
       RemoveRelationType_CheckBox.setSelected(false);
       

       RelationTypeName_TextField.setEnabled(true);
       
    }//GEN-LAST:event_InsertRelationType_CheckBoxActionPerformed

    private void UpdateRelationType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateRelationType_CheckBoxActionPerformed
      InsertRelationType_CheckBox.setSelected(false);
      RemoveRelationType_CheckBox.setSelected(false);
      

      RelationTypeName_TextField.setEnabled(true);
    }//GEN-LAST:event_UpdateRelationType_CheckBoxActionPerformed

    private void RemoveRelationType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveRelationType_CheckBoxActionPerformed
     InsertRelationType_CheckBox.setSelected(false);
     UpdateRelationType_CheckBox.setSelected(false);
     

     RelationTypeName_TextField.setEnabled(false);
     
    }//GEN-LAST:event_RemoveRelationType_CheckBoxActionPerformed

    private void RelationType_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelationType_ButtonActionPerformed
        try {
            Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
            AddPeople_InternalFrame.setVisible(false);
            LendItem_InternalFrame.setVisible(false);
            ReceiveItem_InternalFrame.setVisible(false);
            ReviewItem_InternalFrame.setVisible(false);
            RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
            StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
            AddItem_InternalFrame.setVisible(false);
            
            
            RelationTypes_Table.removeAll();
            
            
            
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Relation Name");
          
            
            ResultSet res = DBConnection.ConnectDB.getRelationTypes();
            
            String data [] = new String[1];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                
                
                
                modelo.addRow(data);
                
            }
            
            RelationTypes_Table.setModel(modelo);
            
            RegisterRelationType_InternalFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RelationType_ButtonActionPerformed

    private void RemoveItemType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveItemType_CheckBoxActionPerformed
     InsertItemType_CheckBox.setSelected(false);
     UpdateItemType_CheckBox.setSelected(false);

     ItemTypeName_TextField.setEnabled(false);
    }//GEN-LAST:event_RemoveItemType_CheckBoxActionPerformed

    private void InsertItemType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertItemType_CheckBoxActionPerformed
     UpdateItemType_CheckBox.setSelected(false);
     RemoveItemType_CheckBox.setSelected(false);

     ItemTypeName_TextField.setEnabled(true);     
    }//GEN-LAST:event_InsertItemType_CheckBoxActionPerformed

    private void UpdateItemType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateItemType_CheckBoxActionPerformed
     InsertItemType_CheckBox.setSelected(false);
     RemoveItemType_CheckBox.setSelected(false);

     ItemTypeName_TextField.setEnabled(true);
    }//GEN-LAST:event_UpdateItemType_CheckBoxActionPerformed

    private void ItemTypeCommit_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTypeCommit_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTypeCommit_ButtonMouseEntered

    private void ItemTypeCommit_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTypeCommit_ButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTypeCommit_ButtonMouseExited

    private void ItemTypeCommit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemTypeCommit_ButtonActionPerformed
    try {
        if(InsertItemType_CheckBox.isSelected()){
            
                String item_type_name = ItemTypeName_TextField.getText();
                DBConnection.ConnectDB.insertItemType(item_type_name);
                JOptionPane.showMessageDialog(frame, "New Item Type Created.");
            
        }
        else if(UpdateItemType_CheckBox.isSelected()){
            
            String selected_itemtype_name = ItemTypes_Table.getValueAt(ItemTypes_Table.getSelectedRow(),0).toString();
            int itemtype_id = DBConnection.ConnectDB.getItemTypeId(selected_itemtype_name);
            String item_type_name = ItemTypeName_TextField.getText();

            DBConnection.ConnectDB.updateItemType(itemtype_id, item_type_name);     
            JOptionPane.showMessageDialog(frame, "Item Type Updated.");
        }
          
        else if(RemoveItemType_CheckBox.isSelected()){
            int selectedOption = JOptionPane.showConfirmDialog(null, "You want to delete it?", "Select:", JOptionPane.YES_NO_OPTION); 
            if (selectedOption == JOptionPane.YES_OPTION) {
                String selected_itemtype_name = ItemTypes_Table.getValueAt(ItemTypes_Table.getSelectedRow(),0).toString();
                int itemtype_id = DBConnection.ConnectDB.getItemTypeId(selected_itemtype_name);
            
                DBConnection.ConnectDB.removeItemType(itemtype_id);
                   JOptionPane.showMessageDialog(frame, "Item Type Deleted.");
            }
        
        }
         ItemTypes_Table.removeAll();
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Item Type Name");
            
            
            ResultSet res = DBConnection.ConnectDB.getItemTypes();
            
            String data [] = new String[1];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                modelo.addRow(data);       
            }
            
            ItemTypes_Table.setModel(modelo);
     } catch (SQLException ex) {
                Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }//GEN-LAST:event_ItemTypeCommit_ButtonActionPerformed

    private void RelationTypeCommitChanges_Panel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel1MouseEntered

    private void RelationTypeCommitChanges_Panel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel1MouseExited

    private void ItemTypes_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemTypes_ButtonActionPerformed
        try {
            Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
            AddPeople_InternalFrame.setVisible(false);
            LendItem_InternalFrame.setVisible(false);
            ReceiveItem_InternalFrame.setVisible(false);
            ReviewItem_InternalFrame.setVisible(false);
            RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
            StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
            AddItem_InternalFrame.setVisible(false);
            
            
            ItemTypes_Table.removeAll();
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Item Type Name");
            
            
            ResultSet res = DBConnection.ConnectDB.getItemTypes();
            
            String data [] = new String[2];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                modelo.addRow(data);       
            }
            
            ItemTypes_Table.setModel(modelo);
            
            
            RegisterItemType_InternalFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ItemTypes_ButtonActionPerformed

    private void RemoveStatusType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveStatusType_CheckBoxActionPerformed
    UpdateStatusType_CheckBox.setSelected(false);
    InsertStatusType_CheckBox.setSelected(false);
    
    StatusTypeName_TextField.setEnabled(false);
    StatusTypeDescription_TextField.setEnabled(false);
    }//GEN-LAST:event_RemoveStatusType_CheckBoxActionPerformed

    private void InsertStatusType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertStatusType_CheckBoxActionPerformed
    UpdateStatusType_CheckBox.setSelected(false);
    RemoveStatusType_CheckBox.setSelected(false);
        
    StatusTypeName_TextField.setEnabled(true);
    StatusTypeDescription_TextField.setEnabled(true);    
        
    }//GEN-LAST:event_InsertStatusType_CheckBoxActionPerformed

    private void UpdateStatusType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateStatusType_CheckBoxActionPerformed
    InsertStatusType_CheckBox.setSelected(false);
    RemoveStatusType_CheckBox.setSelected(false);
        
    StatusTypeName_TextField.setEnabled(true);
    StatusTypeDescription_TextField.setEnabled(true);
    }//GEN-LAST:event_UpdateStatusType_CheckBoxActionPerformed

    private void StatusCommit_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StatusCommit_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusCommit_ButtonMouseEntered

    private void StatusCommit_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StatusCommit_ButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusCommit_ButtonMouseExited

    private void StatusCommit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusCommit_ButtonActionPerformed
     try {
        if(InsertStatusType_CheckBox.isSelected()){
            
                String status_name = StatusTypeName_TextField.getText();
                String status_description = StatusTypeDescription_TextField.getText();
                DBConnection.ConnectDB.insertStatus(status_name, status_description);
                JOptionPane.showMessageDialog(frame, "New Status Created.");
            
        }
        else if(UpdateStatusType_CheckBox.isSelected()){
            
            String selected_status_name = Status_Table.getValueAt(Status_Table.getSelectedRow(),0).toString();
            int status_id = DBConnection.ConnectDB.getStatusId(selected_status_name);
                    
            String status_name = StatusTypeName_TextField.getText();
            String status_desc = StatusTypeDescription_TextField.getText();

            DBConnection.ConnectDB.updateStatus(status_id, status_name, status_desc);
            JOptionPane.showMessageDialog(frame, "Status Updated.");
        }
          
        else if(RemoveStatusType_CheckBox.isSelected()){
            
            int selectedOption = JOptionPane.showConfirmDialog(null, "You want to delete it?", "Select:", JOptionPane.YES_NO_OPTION); 
            
            if (selectedOption == JOptionPane.YES_OPTION) {
                
                String selected_status_name = Status_Table.getValueAt(Status_Table.getSelectedRow(),0).toString();
                int status_id = DBConnection.ConnectDB.getStatusId(selected_status_name);
                
                DBConnection.ConnectDB.removeStatus(status_id);
                JOptionPane.showMessageDialog(frame, "Status Deleted.");
            }
        
        }
        Status_Table.removeAll();
       
       
           DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Status Name");
             modelo.addColumn("Description");
            
            ResultSet res = DBConnection.ConnectDB.getStatus();
            
            String data [] = new String[2];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                data [1] = res.getString(2);
                modelo.addRow(data);       
            }
            
            Status_Table.setModel(modelo);
            
            
     } catch (SQLException ex) {
                Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }//GEN-LAST:event_StatusCommit_ButtonActionPerformed

    private void RelationTypeCommitChanges_Panel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel2MouseEntered

    private void RelationTypeCommitChanges_Panel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel2MouseExited

    private void StatusType_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusType_ButtonActionPerformed
      try{
        Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
       
       Status_Table.removeAll();
       
       
           DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Status Name");
             modelo.addColumn("Description");
            
            ResultSet res = DBConnection.ConnectDB.getStatus();
            
            String data [] = new String[2];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                data [1] = res.getString(2);
                modelo.addRow(data);       
            }
            
            Status_Table.setModel(modelo);
       

       
      RegisterStatusType_InternalFrame.setVisible(true); 
      
       } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_StatusType_ButtonActionPerformed

    private void RemoveGenreType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveGenreType_CheckBoxActionPerformed
     UpdateGenreType_CheckBox.setSelected(false);
     RemoveGenreType_CheckBox.setSelected(false);

     GenreTypeName_TextField.setEnabled(false);
     GenreTypeDescription_TextField.setEnabled(false);
     
    }//GEN-LAST:event_RemoveGenreType_CheckBoxActionPerformed

    private void InsertGenreType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertGenreType_CheckBoxActionPerformed
      UpdateGenreType_CheckBox.setSelected(false);
      RemoveGenreType_CheckBox.setSelected(false);

      GenreTypeName_TextField.setEnabled(true);
      GenreTypeDescription_TextField.setEnabled(true);
    }//GEN-LAST:event_InsertGenreType_CheckBoxActionPerformed

    private void UpdateGenreType_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateGenreType_CheckBoxActionPerformed
      InsertGenreType_CheckBox.setSelected(false);
      RemoveGenreType_CheckBox.setSelected(false);
      

      GenreTypeName_TextField.setEnabled(true);
      GenreTypeDescription_TextField.setEnabled(true);
    }//GEN-LAST:event_UpdateGenreType_CheckBoxActionPerformed

    private void GenreCommit_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenreCommit_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_GenreCommit_ButtonMouseEntered

    private void GenreCommit_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenreCommit_ButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_GenreCommit_ButtonMouseExited

    private void GenreCommit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenreCommit_ButtonActionPerformed

        
        try {
        if(InsertGenreType_CheckBox.isSelected()){
            
            String genre_name = GenreTypeName_TextField.getText();
            String genre_description = GenreTypeDescription_TextField.getText();

            ConnectDB.insertGenre(genre_name, genre_description);
            JOptionPane.showMessageDialog(null, "New Genre Created Successfully");
        }
        else if(UpdateGenreType_CheckBox.isSelected()){
            
            
            String selected_genre_name = Genre_Table.getValueAt(Genre_Table.getSelectedRow(),0).toString();
            int genre_id = DBConnection.ConnectDB.getGenreId(selected_genre_name);
            String new_genre_name = GenreTypeName_TextField.getText();
            String new_genre_description = GenreTypeDescription_TextField.getText();
            
            DBConnection.ConnectDB.updateGenre(genre_id, new_genre_name, new_genre_description);
            JOptionPane.showMessageDialog(null, "Genre Updated Successfully");
            
        }
        
        else if (RemoveGenreType_CheckBox.isSelected()){

            int selectedOption = JOptionPane.showConfirmDialog(null, "You want to delete it?", "Select:", JOptionPane.YES_NO_OPTION); 
            
            if (selectedOption == JOptionPane.YES_OPTION) {
                String selected_genre_name = Genre_Table.getValueAt(Genre_Table.getSelectedRow(),0).toString();
                int delete_genre_id = DBConnection.ConnectDB.getGenreId(selected_genre_name);

                DBConnection.ConnectDB.removeGenre(delete_genre_id);
                JOptionPane.showMessageDialog(null, "Genre Removed");
            }
            
        }
        
        Genre_Table.removeAll();
       
       
       
           DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Status Name");
             modelo.addColumn("Description");
            
            ResultSet res = DBConnection.ConnectDB.getGenresWithDescription();
            
            String data [] = new String[2];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                data [1] = res.getString(2);
                modelo.addRow(data);       
            }
            
            Genre_Table.setModel(modelo);
        
        
        
        
        } catch (SQLException ex) {
           Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);

        }
        
 
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_GenreCommit_ButtonActionPerformed

    private void RelationTypeCommitChanges_Panel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel3MouseEntered

    private void RelationTypeCommitChanges_Panel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel3MouseExited

    private void Genre_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Genre_ButtonActionPerformed
     
       try{ 
           
        Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
       
       Genre_Table.removeAll();
       
       
       
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Status Name");
        modelo.addColumn("Description");
            
        ResultSet res = DBConnection.ConnectDB.getGenresWithDescription();
            
        String data [] = new String[2];
            
            
        while(res.next()){
           data [0] = res.getString(1);
           data [1] = res.getString(2);
           modelo.addRow(data);       
        }
            
         Genre_Table.setModel(modelo);
       
      
              
     } catch (SQLException ex) {
         Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
     }   
       
       
       
    RegisterGenreType_InternalFrame.setVisible(true);   
    }//GEN-LAST:event_Genre_ButtonActionPerformed

    private void RemovePublisher_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovePublisher_CheckBoxActionPerformed
      UpdatePublisher_CheckBox.setSelected(false);
      InsertPublisher_CheckBox.setSelected(false);  
      
      PublisherName_TextField.setEnabled(false);  
    }//GEN-LAST:event_RemovePublisher_CheckBoxActionPerformed

    private void InsertPublisher_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertPublisher_CheckBoxActionPerformed
       UpdatePublisher_CheckBox.setSelected(false);
       RemovePublisher_CheckBox.setSelected(false);
   
       PublisherName_TextField.setEnabled(true);       
    }//GEN-LAST:event_InsertPublisher_CheckBoxActionPerformed

    private void UpdatePublisher_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePublisher_CheckBoxActionPerformed
      InsertPublisher_CheckBox.setSelected(false);
      RemovePublisher_CheckBox.setSelected(false);
       
      PublisherName_TextField.setEnabled(true);     
    }//GEN-LAST:event_UpdatePublisher_CheckBoxActionPerformed

    private void PublisherCommit_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PublisherCommit_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PublisherCommit_ButtonMouseEntered

    private void PublisherCommit_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PublisherCommit_ButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PublisherCommit_ButtonMouseExited

    private void PublisherCommit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublisherCommit_ButtonActionPerformed
       try{

        if(InsertPublisher_CheckBox.isSelected()){
            String publisher_name = PublisherName_TextField.getText();
            
            DBConnection.ConnectDB.insertPublisher(publisher_name);
            JOptionPane.showMessageDialog(null, "New Publisher Created Successfully");
        }
        else if(UpdatePublisher_CheckBox.isSelected()){
            String selected_publisher_name = Publisher_Table.getValueAt(Publisher_Table.getSelectedRow(),0).toString();
            int publisher_id = DBConnection.ConnectDB.getPublisherId(selected_publisher_name);
            String new_publisher_name = PublisherName_TextField.getText();

            
            DBConnection.ConnectDB.updatePublisher(publisher_id, new_publisher_name);
            JOptionPane.showMessageDialog(null, "Publisher Updated Successfully");
            
        }
        
        else if (RemovePublisher_CheckBox.isSelected()){

             int selectedOption = JOptionPane.showConfirmDialog(null, "You want to delete it?", "Select:", JOptionPane.YES_NO_OPTION); 
            
            if (selectedOption == JOptionPane.YES_OPTION) {

                String selected_publisher_name = Publisher_Table.getValueAt(Publisher_Table.getSelectedRow(),0).toString();
                int delete_publisher_id = DBConnection.ConnectDB.getPublisherId(selected_publisher_name);

                DBConnection.ConnectDB.removePublisher(delete_publisher_id);
                 JOptionPane.showMessageDialog(null, "Publisher Removed");
            }
        }
        
        Publisher_Table.removeAll();
       
       
       
           DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Publisher Name");

            ResultSet res = DBConnection.ConnectDB.getPublishers();
            
            String data [] = new String[1];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                modelo.addRow(data);       
            }
            
            Publisher_Table.setModel(modelo);
        
        
        
        
        } catch (SQLException ex) {
           Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_PublisherCommit_ButtonActionPerformed

    private void RelationTypeCommitChanges_Panel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel4MouseEntered

    private void RelationTypeCommitChanges_Panel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel4MouseExited

    private void Publisher_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Publisher_ButtonActionPerformed
        try {
            Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
            AddPeople_InternalFrame.setVisible(false);
            LendItem_InternalFrame.setVisible(false);
            ReceiveItem_InternalFrame.setVisible(false);
            ReviewItem_InternalFrame.setVisible(false);
            RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
            StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
            AddItem_InternalFrame.setVisible(false);
            
            Publisher_Table.removeAll();
            
            
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Publisher Name");

            ResultSet res = DBConnection.ConnectDB.getPublishers();
            
            String data [] = new String[1];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                modelo.addRow(data);       
            }
            
            Publisher_Table.setModel(modelo);
            

            RegisterPublisher_InternalFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Publisher_ButtonActionPerformed

    private void Author_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Author_ButtonActionPerformed
      try{
        Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
       
       Authors_Table.removeAll();
       
       
       
       
       
       DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Author Name");
            modelo.addColumn("Author Last Name");
            modelo.addColumn("Author or Agent Email"); 
             
            ResultSet res = DBConnection.ConnectDB.getAuthors();
            
            String data [] = new String[3];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                data [1] = res.getString(2);
                data [2] = res.getString(3);
                
                modelo.addRow(data);       
            }
            
            Authors_Table.setModel(modelo);
       

       
       
       
       RegisterAuthor_InternalFrame.setVisible(true);
       
         } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_Author_ButtonActionPerformed

    private void RemoveAuthor_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveAuthor_CheckBoxActionPerformed
       InsertAuthor_CheckBox.setSelected(false);
       UpdateAuthor_CheckBox.setSelected(false);
     
       AuthorID_TextField.setEnabled(false);
       AuthorFirstName_TextField.setEnabled(false);
       AuthorLastName_TextField.setEnabled(false);
       AuthorEmail_TextField.setEnabled(false);
       AuthorPhoneNumber_TextField.setEnabled(false);
       
    }//GEN-LAST:event_RemoveAuthor_CheckBoxActionPerformed

    private void InsertAuthor_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertAuthor_CheckBoxActionPerformed
       UpdateAuthor_CheckBox.setSelected(false);
       RemoveAuthor_CheckBox.setSelected(false);
     
       AuthorID_TextField.setEnabled(true);
       AuthorFirstName_TextField.setEnabled(true);
       AuthorLastName_TextField.setEnabled(true);
       AuthorEmail_TextField.setEnabled(true);
       AuthorPhoneNumber_TextField.setEnabled(true);
    
    }//GEN-LAST:event_InsertAuthor_CheckBoxActionPerformed

    private void UpdateAuthor_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateAuthor_CheckBoxActionPerformed
       InsertAuthor_CheckBox.setSelected(false);
       RemoveAuthor_CheckBox.setSelected(false);
     
       AuthorID_TextField.setEnabled(true);
       AuthorFirstName_TextField.setEnabled(true);
       AuthorLastName_TextField.setEnabled(true);
       AuthorEmail_TextField.setEnabled(true);
       AuthorPhoneNumber_TextField.setEnabled(true);
    
    }//GEN-LAST:event_UpdateAuthor_CheckBoxActionPerformed

    private void AuthorCommit_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AuthorCommit_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AuthorCommit_ButtonMouseEntered

    private void AuthorCommit_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AuthorCommit_ButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AuthorCommit_ButtonMouseExited

    private void AuthorCommit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorCommit_ButtonActionPerformed
    try{
        if(InsertAuthor_CheckBox.isSelected()){
            int author_id = Integer.parseInt(AuthorID_TextField.getText());
            String author_firstname = AuthorFirstName_TextField.getText();
            String author_lastname =AuthorLastName_TextField.getText();
            String author_email = AuthorEmail_TextField.getText();
            String author_phonenumber = AuthorPhoneNumber_TextField.getText();
            
            DBConnection.ConnectDB.insertPerson(author_id, author_firstname, author_lastname, author_email, "123", author_phonenumber, "1972-12-11",2);
            JOptionPane.showMessageDialog(null, "New Author Registered Successfully");
        }
        
        
       
        else if(UpdateAuthor_CheckBox.isSelected()){
            int new_author_id = Integer.parseInt(AuthorID_TextField.getText());
            String new_author_firstname = AuthorFirstName_TextField.getText();
            String new_author_lastname =AuthorLastName_TextField.getText();
            String new_author_email = AuthorEmail_TextField.getText();
            String new_author_phonenumber = AuthorPhoneNumber_TextField.getText();
            
            
            String old_author_email = Authors_Table.getValueAt(Authors_Table.getSelectedRow(),2).toString();
            int old_author_id = DBConnection.ConnectDB.getPersonId(old_author_email);

            System.out.println(new_author_id + new_author_firstname + new_author_lastname + new_author_email+ new_author_phonenumber + old_author_email+ old_author_id );

                        
            DBConnection.ConnectDB.updatePerson(old_author_id, new_author_firstname, new_author_lastname, new_author_email, "123", new_author_phonenumber, "1972-12-11");
            JOptionPane.showMessageDialog(null, "Author Updated");
            
        }
        
        else if (RemoveAuthor_CheckBox.isSelected()){
            
            int selectedOption = JOptionPane.showConfirmDialog(null, "You want to delete it?", "Select:", JOptionPane.YES_NO_OPTION); 
            
            if (selectedOption == JOptionPane.YES_OPTION) {
                String old_author_email = Authors_Table.getValueAt(Authors_Table.getSelectedRow(),2).toString();
                int old_author_id = DBConnection.ConnectDB.getPersonId(old_author_email);

                DBConnection.ConnectDB.removePerson(old_author_id);
                JOptionPane.showMessageDialog(null, "Author Removed");
            }
        } 

        
          Authors_Table.removeAll();
       

       DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Author Name");
            modelo.addColumn("Author Last Name");
            modelo.addColumn("Author or Agent Email"); 
             
            ResultSet res = DBConnection.ConnectDB.getAuthors();
            
            String data [] = new String[3];
            
            
            while(res.next()){
                data [0] = res.getString(1);
                data [1] = res.getString(2);
                data [2] = res.getString(3);
                
                modelo.addRow(data);       
            }
            
            Authors_Table.setModel(modelo);
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_AuthorCommit_ButtonActionPerformed

    private void RelationTypeCommitChanges_Panel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel5MouseEntered

    private void RelationTypeCommitChanges_Panel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelationTypeCommitChanges_Panel5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationTypeCommitChanges_Panel5MouseExited

    private void Queries_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Queries_ButtonActionPerformed
       Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);
       
       Parameter1_TextField.setVisible(false);
       Parameter2_TextField.setVisible(false);
       Go_Button.setVisible(false);
       Total_TextField.setVisible(false);
       ParametersText_Label.setText("");
       Queries_Table.removeAll();
       
       Parameters_Label.setVisible(false);
       Filter_Label.setVisible(false);
       Filter_ComboBox.setVisible(false);
       
       
       
       
       Queries_InternalFrame.setVisible(true);
       Queries_Table.removeAll();

    }//GEN-LAST:event_Queries_ButtonActionPerformed

    private void Stadistics_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stadistics_ButtonActionPerformed
       Collection_InternalFrame.setVisible(false);
            ItemInfo_InternalFrame.setVisible(false);
       AddPeople_InternalFrame.setVisible(false);
       LendItem_InternalFrame.setVisible(false);
       ReceiveItem_InternalFrame.setVisible(false); 
       ReviewItem_InternalFrame.setVisible(false);
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
            Queries_InternalFrame.setVisible(false);
       AddItem_InternalFrame.setVisible(false);    
        
        Statistics_InternalFrame.setVisible(true);
    }//GEN-LAST:event_Stadistics_ButtonActionPerformed

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
          int selectedOption = JOptionPane.showConfirmDialog(null,"You want to delete it??",  "Select:", JOptionPane.YES_NO_OPTION); 
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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
       RegisterValues_InternalFrame.setVisible(false);
            RegisterRelationType_InternalFrame.setVisible(false);
            RegisterItemType_InternalFrame.setVisible(false);
            RegisterStatusType_InternalFrame.setVisible(false);
            RegisterGenreType_InternalFrame.setVisible(false);
            RegisterPublisher_InternalFrame.setVisible(false);
            RegisterAuthor_InternalFrame.setVisible(false);
            
       StatisticsQueries_InternalFrame.setVisible(false);
            Statistics_InternalFrame.setVisible(false);
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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ItemInfo_InternalFrame.setVisible(true);
    }//GEN-LAST:event_Collection_TableMouseClicked

    private void Day_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Day_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Day_TextFieldActionPerformed

    private void SelectStatistic_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectStatistic_ComboBoxActionPerformed
      try{
          
      
        if (SelectStatistic_ComboBox.getSelectedItem().toString().equals("Items by Genre")){

            
            
            
            ResultSet res = DBConnection.ConnectDB.StatisticTotalItemsByGenre();
            DefaultPieDataset dataset = new DefaultPieDataset();
            
            
            while(res.next()){
              
                int cuantity = Integer.parseInt(res.getString(1));
             
              Double percentage = new Double(res.getString(2));
        
                String name = res.getString(3);

                
               // String stat = name + " ("+ cuantity + ")";
                
                dataset.setValue(name, cuantity);            
            }

            // create pir chart
            JFreeChart chart = ChartFactory.createPieChart3D(
                    "Items by Genre", // chart title                   
                    dataset, // data 
                    true, // include legend                   
                    true,
                    false);
            // set chart properties
            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(270);    //Rotr gráfica
            plot.setForegroundAlpha(0.60f);     //Transparencia
            plot.setInteriorGap(0.05);
            // create chart panel the add it to swing panel in  jframe
            ChartPanel chartPanel = new ChartPanel(chart);
            frame = new ChartFrame("Pie Chart", chart);



            frame.setLocation(1050,490);       
            frame.setUndecorated(true);  // quitar bordes 
            frame.setSize(550,500);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setBounds(770, 390, 780, 350);
            }
        
        

        else if (SelectStatistic_ComboBox.getSelectedItem().toString().equals("Items Borrowed Now")){

            
            
            ResultSet res = DBConnection.ConnectDB.StatistictotalLendedItemsNow();
            DefaultPieDataset dataset = new DefaultPieDataset();
            
            
            while(res.next()){
              
              int cuantity_not_borrowed = Integer.parseInt(res.getString(1));
                System.out.println(cuantity_not_borrowed);
              int cuantity_borrowed = Integer.parseInt(res.getString(2));
                System.out.println(cuantity_borrowed);

              dataset.setValue("Total Items Not Borrowed", cuantity_not_borrowed);    
              dataset.setValue("Total Items Borrowed", cuantity_borrowed);  
            }

            // create pir chart
            JFreeChart chart = ChartFactory.createPieChart3D(
                    "Items Borrowed Now", // chart title                   
                    dataset, // data 
                    true, // include legend                   
                    true,
                    false);
            // set chart properties
            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(270);    //Rotr gráfica
            plot.setForegroundAlpha(0.60f);     //Transparencia
            plot.setInteriorGap(0.05);
            // create chart panel the add it to swing panel in  jframe
            ChartPanel chartPanel = new ChartPanel(chart);
            frame = new ChartFrame("Pie Chart", chart);



            frame.setLocation(1050,490);       
            frame.setUndecorated(true);  // quitar bordes 
            frame.setSize(550,500);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setBounds(770, 390, 780, 350);
            }

        else if (SelectStatistic_ComboBox.getSelectedItem().toString().equals("Items borrowed From Always")){
            
            
            
            ResultSet res = DBConnection.ConnectDB.StatistictotalLendedItems();
            DefaultPieDataset dataset = new DefaultPieDataset();
            
            
            while(res.next()){
              
              String title = res.getString(1);
                System.out.println(title);
              int cuantity_borrowed = Integer.parseInt(res.getString(2));
                System.out.println(cuantity_borrowed);

              dataset.setValue(title, cuantity_borrowed);    
            
            }

            // create pir chart
            JFreeChart chart = ChartFactory.createPieChart3D(
                    "Items borrowed From Always", // chart title                   
                    dataset, // data 
                    true, // include legend                   
                    true,
                    false);
            // set chart properties
            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(270);    //Rotr gráfica
            plot.setForegroundAlpha(0.60f);     //Transparencia
            plot.setInteriorGap(0.05);
            // create chart panel the add it to swing panel in  jframe
            ChartPanel chartPanel = new ChartPanel(chart);
            frame = new ChartFrame("Pie Chart", chart);



            frame.setLocation(1050,490);       
            frame.setUndecorated(true);  // quitar bordes 
            frame.setSize(550,500);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setBounds(770, 390, 780, 350);
            
            }    
       
        else if (SelectStatistic_ComboBox.getSelectedItem().toString().equals("Borrowed Items By Genre")){
            
            
            ResultSet res = DBConnection.ConnectDB.StatistictotalLendedItemsByGenre();
            DefaultPieDataset dataset = new DefaultPieDataset();
            
            
            while(res.next()){

              int cuantity_borrowed = Integer.parseInt(res.getString(1));
              String genre = res.getString(3);

              dataset.setValue(genre, cuantity_borrowed);    
            
            }

            // create pir chart
            JFreeChart chart = ChartFactory.createPieChart3D(
                    "Borrowed Items By Genre", // chart title                   
                    dataset, // data 
                    true, // include legend                   
                    true,
                    false);
            // set chart properties
            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(270);    //Rotr gráfica
            plot.setForegroundAlpha(0.60f);     //Transparencia
            plot.setInteriorGap(0.05);
            // create chart panel the add it to swing panel in  jframe
            ChartPanel chartPanel = new ChartPanel(chart);
            frame = new ChartFrame("Pie Chart", chart);



            frame.setLocation(1050,490);       
            frame.setUndecorated(true);  // quitar bordes 
            frame.setSize(550,500);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setBounds(770, 390, 780, 350);
            
            }    
        
    else if (SelectStatistic_ComboBox.getSelectedItem().toString().equals("Borrowed Items By Age of Who Borrowed them")){
            
            
            ResultSet res = DBConnection.ConnectDB.StatistictotalLendedItemsByAge();
            DefaultPieDataset dataset = new DefaultPieDataset();
            
            
            while(res.next()){

              int cuantity = Integer.parseInt(res.getString(1));
              String age = res.getString(2);

              dataset.setValue(age, cuantity);    
              }

            // create pir chart
            JFreeChart chart = ChartFactory.createPieChart3D(
                    "Borrowed Items By Age of Who Borrowed them", // chart title                   
                    dataset, // data 
                    true, // include legend                   
                    true,
                    false);
            // set chart properties
            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(270);    //Rotr gráfica
            plot.setForegroundAlpha(0.60f);     //Transparencia
            plot.setInteriorGap(0.05);
            // create chart panel the add it to swing panel in  jframe
            ChartPanel chartPanel = new ChartPanel(chart);
            frame = new ChartFrame("Pie Chart", chart);



            frame.setLocation(1050,490);       
            frame.setUndecorated(true);  // quitar bordes 
            frame.setSize(550,500);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setBounds(770, 390, 780, 350);
            
            }        
        
        
        
        
        
        
        
        
    } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
    }    
    }//GEN-LAST:event_SelectStatistic_ComboBoxActionPerformed

    private void CloseAllCharts_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseAllCharts_ButtonActionPerformed
        frame.setVisible(false);
    }//GEN-LAST:event_CloseAllCharts_ButtonActionPerformed

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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(frame, ex, null, JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AuthorFirstName_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorFirstName_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuthorFirstName_TextFieldActionPerformed

    private void Go_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Go_ButtonActionPerformed
       try{
        String selection = Queries_ComboBox.getSelectedItem().toString();
        

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
     
        else{
       
        String filter_selection = Filter_ComboBox.getSelectedItem().toString(); 
        
            if(filter_selection.equals("Title") && selection.equals("All Items")){
                Queries_Table.removeAll();
                String pTitle = Parameter1_TextField.getText();

                DefaultTableModel modelo = new DefaultTableModel();
                  modelo.addColumn("Status");
                  modelo.addColumn("Title");
                  modelo.addColumn("Edition");
                  modelo.addColumn("Barcode");
                  modelo.addColumn("Type");
                  modelo.addColumn("Publisher");
                  modelo.addColumn("Genre");       
                  modelo.addColumn("Author First Name");   
                  modelo.addColumn("Author Last Name");  


                         ResultSet res = DBConnection.ConnectDB.UserAllItems(pTitle,null,null,null);

                         String data [] = new String[9];

                         while(res.next()){
                             data [0] = res.getString(5);
                             data [1] = res.getString(1);                      
                             data [2] = res.getString(2);
                             data [3] = res.getString(3);
                             data [4] = res.getString(4);//
                             data [5] = res.getString(6);
                             data [6] = res.getString(7);
                             data [7] = res.getString(8);
                             data [8] = res.getString(9);

                             modelo.addRow(data);
                         }

                         Queries_Table.setModel(modelo);    

             } 
            
            else if(filter_selection.equals("Author") && selection.equals("All Items")){
                Queries_Table.removeAll();
                String pAuthorFirstName = Parameter1_TextField.getText();
                String pAuthorLastName = Parameter2_TextField.getText();
                
                DefaultTableModel modelo = new DefaultTableModel();
                  modelo.addColumn("Status");
                  modelo.addColumn("Title");
                  modelo.addColumn("Edition");
                  modelo.addColumn("Barcode");
                  modelo.addColumn("Type");
                  modelo.addColumn("Publisher");
                  modelo.addColumn("Genre");       
                  modelo.addColumn("Author First Name");   
                  modelo.addColumn("Author Last Name");  


                         ResultSet res = DBConnection.ConnectDB.UserAllItems(null,pAuthorFirstName,pAuthorLastName,null);

                         String data [] = new String[9];

                         while(res.next()){
                             data [0] = res.getString(5);
                             data [1] = res.getString(1);                      
                             data [2] = res.getString(2);
                             data [3] = res.getString(3);
                             data [4] = res.getString(4);//
                             data [5] = res.getString(6);
                             data [6] = res.getString(7);
                             data [7] = res.getString(8);
                             data [8] = res.getString(9);

                             modelo.addRow(data);
                         }

                         Queries_Table.setModel(modelo);    

             }  
            
            else if(filter_selection.equals("Publisher") && selection.equals("All Items")){
                Queries_Table.removeAll();
                String pPublisher = Parameter1_TextField.getText();
               
                
                DefaultTableModel modelo = new DefaultTableModel();
                  modelo.addColumn("Status");
                  modelo.addColumn("Title");
                  modelo.addColumn("Edition");
                  modelo.addColumn("Barcode");
                  modelo.addColumn("Type");
                  modelo.addColumn("Publisher");
                  modelo.addColumn("Genre");       
                  modelo.addColumn("Author First Name");   
                  modelo.addColumn("Author Last Name");  


                         ResultSet res = DBConnection.ConnectDB.UserAllItems(null,null,null,pPublisher);

                         String data [] = new String[9];

                         while(res.next()){
                             data [0] = res.getString(5);
                             data [1] = res.getString(1);                      
                             data [2] = res.getString(2);
                             data [3] = res.getString(3);
                             data [4] = res.getString(4);//
                             data [5] = res.getString(6);
                             data [6] = res.getString(7);
                             data [7] = res.getString(8);
                             data [8] = res.getString(9);

                             modelo.addRow(data);
                         }

                         Queries_Table.setModel(modelo);    

             }  
            
            
           else if(filter_selection.equals("Lent To") && selection.equals("All Lended Items")){
                Queries_Table.removeAll();
                String pPersonFirstName = Parameter1_TextField.getText();
                String pPersonLastName = Parameter2_TextField.getText();
                
                DefaultTableModel modelo = new DefaultTableModel();
             
                modelo.addColumn("Status");
                modelo.addColumn("Title");
                modelo.addColumn("Edition");
                modelo.addColumn("Barcode");
                modelo.addColumn("Item Type");

                modelo.addColumn("Publisher");
                modelo.addColumn("Genre");
                modelo.addColumn("Lent To");
                modelo.addColumn("Lent To");
                modelo.addColumn("Lend Date");
                modelo.addColumn("Return Date");
                modelo.addColumn("Amount Days");
                modelo.addColumn("Tolerance");
                modelo.addColumn("Max Tolerance");


                ResultSet res = DBConnection.ConnectDB.UserAllLendedItems(pPersonFirstName,pPersonLastName,null,null,null,"");

                         String data [] = new String[14];

                         while(res.next()){
                             data [0] = res.getString(5);
                             data [1] = res.getString(1);
                             data [2] = res.getString(2);
                             data [3] = res.getString(3);
                             data [4] = res.getString(4);//
                             data [5] = res.getString(6);
                             data [6] = res.getString(7);
                             data [7] = res.getString(8);
                             data [8] = res.getString(9);
                             data [9] = res.getString(10);
                             data [10] = res.getString(11);
                             data [11] = res.getString(12);
                             data [12] = res.getString(13);
                             data [13] = res.getString(14);
                             
                            
                            
                             modelo.addRow(data);
                         }

                         Queries_Table.setModel(modelo);    

             }   
            
          else if(filter_selection.equals("Amount Days") && selection.equals("All Lended Items")){
                Queries_Table.removeAll();
                String pAmountDays = Parameter1_TextField.getText();
              
                
                DefaultTableModel modelo = new DefaultTableModel();
             
                modelo.addColumn("Status");
                modelo.addColumn("Title");
                modelo.addColumn("Edition");
                modelo.addColumn("Barcode");
                modelo.addColumn("Item Type");

                modelo.addColumn("Publisher");
                modelo.addColumn("Genre");
                modelo.addColumn("Lent To");
                modelo.addColumn("Lent To");
                modelo.addColumn("Lend Date");
                modelo.addColumn("Return Date");
                modelo.addColumn("Amount Days");
                modelo.addColumn("Tolerance");
                modelo.addColumn("Max Tolerance");


                ResultSet res = DBConnection.ConnectDB.UserAllLendedItems(null,null,pAmountDays,null,null,null);

                         String data [] = new String[14];

                         while(res.next()){
                             data [0] = res.getString(5);
                             data [1] = res.getString(1);
                             data [2] = res.getString(2);
                             data [3] = res.getString(3);
                             data [4] = res.getString(4);//
                             data [5] = res.getString(6);
                             data [6] = res.getString(7);
                             data [7] = res.getString(8);
                             data [8] = res.getString(9);
                             data [9] = res.getString(10);
                             data [10] = res.getString(11);
                             data [11] = res.getString(12);
                             data [12] = res.getString(13);
                             data [13] = res.getString(14);
                             
                            
                            
                             modelo.addRow(data);
                         }

                         Queries_Table.setModel(modelo);    

             }    
            
            
            else if(filter_selection.equals("Tolerance") && selection.equals("All Lended Items")){
                Queries_Table.removeAll();
                String pToleranceYellow = Parameter1_TextField.getText();
                String pToleranceRed = Parameter2_TextField.getText();
                
                DefaultTableModel modelo = new DefaultTableModel();
             
                modelo.addColumn("Status");
                modelo.addColumn("Title");
                modelo.addColumn("Edition");
                modelo.addColumn("Barcode");
                modelo.addColumn("Item Type");

                modelo.addColumn("Publisher");
                modelo.addColumn("Genre");
                modelo.addColumn("Lent To");
                modelo.addColumn("Lent To");
                modelo.addColumn("Lend Date");
                modelo.addColumn("Return Date");
                modelo.addColumn("Amount Days");
                modelo.addColumn("Tolerance");
                modelo.addColumn("Max Tolerance");


                ResultSet res = DBConnection.ConnectDB.UserAllLendedItems(null,null,null,pToleranceYellow,pToleranceRed,null);

                         String data [] = new String[14];

                         while(res.next()){
                             data [0] = res.getString(5);
                             data [1] = res.getString(1);
                             data [2] = res.getString(2);
                             data [3] = res.getString(3);
                             data [4] = res.getString(4);//
                             data [5] = res.getString(6);
                             data [6] = res.getString(7);
                             data [7] = res.getString(8);
                             data [8] = res.getString(9);
                             data [9] = res.getString(10);
                             data [10] = res.getString(11);
                             data [11] = res.getString(12);
                             data [12] = res.getString(13);
                             data [13] = res.getString(14);
                             
                            
                            
                             modelo.addRow(data);
                         }

                         Queries_Table.setModel(modelo);    

             }    
            
           else if(filter_selection.equals("Status") && selection.equals("All Lended Items")){
                Queries_Table.removeAll();
                String pStatus = Parameter1_TextField.getText();
               
                
                DefaultTableModel modelo = new DefaultTableModel();
             
                modelo.addColumn("Status");
                modelo.addColumn("Title");
                modelo.addColumn("Edition");
                modelo.addColumn("Barcode");
                modelo.addColumn("Item Type");

                modelo.addColumn("Publisher");
                modelo.addColumn("Genre");
                modelo.addColumn("Lent To");
                modelo.addColumn("Lent To");
                modelo.addColumn("Lend Date");
                modelo.addColumn("Return Date");
                modelo.addColumn("Amount Days");
                modelo.addColumn("Tolerance");
                modelo.addColumn("Max Tolerance");


                ResultSet res = DBConnection.ConnectDB.UserAllLendedItems(null,null,null,null,null,pStatus);

                         String data [] = new String[14];

                         while(res.next()){
                             data [0] = res.getString(5);
                             data [1] = res.getString(1);
                             data [2] = res.getString(2);
                             data [3] = res.getString(3);
                             data [4] = res.getString(4);//
                             data [5] = res.getString(6);
                             data [6] = res.getString(7);
                             data [7] = res.getString(8);
                             data [8] = res.getString(9);
                             data [9] = res.getString(10);
                             data [10] = res.getString(11);
                             data [11] = res.getString(12);
                             data [12] = res.getString(13);
                             data [13] = res.getString(14);
                             
                            
                            
                             modelo.addRow(data);
                         }

                         Queries_Table.setModel(modelo);    

             }        
            
            
            
            
            
            
            
   
        }

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        } 

       }//GEN-LAST:event_Go_ButtonActionPerformed

    private void Queries_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Queries_ComboBoxActionPerformed
        
        String selection = Queries_ComboBox.getSelectedItem().toString();
        System.out.println(selection);
        try{
        
        if(selection.equals("Not Borrowed Items")){
            Parameter1_TextField.setVisible(false);
            Parameter2_TextField.setVisible(false);
            Go_Button.setVisible(false);
            ParametersText_Label.setText("");
            Queries_Table.removeAll();
            Total_TextField.setVisible(false);
            Parameters_Label.setVisible(false);
            Filter_Label.setVisible(false);
            Filter_ComboBox.setVisible(false);
            
                DefaultTableModel modelo = new DefaultTableModel();
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
            Parameter1_TextField.setText("");
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Select Top");
            Total_TextField.setVisible(false);
            Queries_Table.removeAll();
            Parameters_Label.setVisible(true);
            Filter_Label.setVisible(false);
            Filter_Label.setVisible(false);
            Filter_ComboBox.setVisible(false);            
            
            
            
            
            
        }
        else if(selection.equals("Most Borrowed Items Per Month")){
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(true);
            Parameter1_TextField.setText("");
            Parameter2_TextField.setText("");
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Times Borrowed             In Months");
            Total_TextField.setVisible(false);
            Queries_Table.removeAll();
            Parameters_Label.setVisible(true);
            Filter_Label.setVisible(false);
            Filter_Label.setVisible(false);
            Filter_ComboBox.setVisible(false);           
            
            
            
        }  

        else if(selection.equals("Total People to Whom Items are Loaned by Age")){
           
            Parameter2_TextField.setVisible(false);
            Parameter1_TextField.setVisible(false);
            Go_Button.setVisible(false);
            ParametersText_Label.setText("");
            Total_TextField.setVisible(false);
            Parameters_Label.setVisible(false);
            Filter_Label.setVisible(false);
            Filter_Label.setVisible(false);
            Filter_ComboBox.setVisible(false);            
            
            
            
            
            
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
        else if(selection.equals("All Items")){
           
            String pTitle = null;
            String pAuthorFirstName = null;
            String pAuthorLastName = null;
            String pPublisher = null;
            
            
            Parameter2_TextField.setVisible(false);
            Parameter1_TextField.setVisible(false);
            Go_Button.setVisible(false);
            ParametersText_Label.setText("");
            Total_TextField.setVisible(true);
            Parameters_Label.setVisible(false);
            Filter_Label.setVisible(true);
            Filter_ComboBox.removeAllItems();
            Filter_ComboBox.addItem("Title");
            Filter_ComboBox.addItem("Author");
            Filter_ComboBox.addItem("Publisher");
            Filter_ComboBox.setVisible(true);
            

            
            
            
            
            
            DefaultTableModel modelo = new DefaultTableModel();
             modelo.addColumn("Status");
             modelo.addColumn("Title");
             modelo.addColumn("Edition");
             modelo.addColumn("Barcode");
             modelo.addColumn("Type");
             modelo.addColumn("Publisher");
             modelo.addColumn("Genre");       
             modelo.addColumn("Author First Name");   
             modelo.addColumn("Author Last Name");  

             
                    ResultSet res = DBConnection.ConnectDB.UserAllItems(pTitle,pAuthorFirstName,pAuthorLastName,pPublisher);

                    String data [] = new String[9];

                    while(res.next()){
                        data [0] = res.getString(5);
                        data [1] = res.getString(1);                      
                        data [2] = res.getString(2);
                        data [3] = res.getString(3);
                        data [4] = res.getString(4);//
                        data [5] = res.getString(6);
                        data [6] = res.getString(7);
                        data [7] = res.getString(8);
                        data [8] = res.getString(9);
                          
                        modelo.addRow(data);
                    }
                    
                    Queries_Table.setModel(modelo);
                    
                    
                    int allItems = 0;
                    
                    ResultSet res2 = DBConnection.ConnectDB.UserAllItemsTotal();
                    while(res2.next()){
                        allItems = Integer.parseInt(res2.getString(1));
                    }
                    Total_TextField.setText("Total of Items: "+ allItems);
            
            
        }

         else if(selection.equals("All Lended Items")){
            String pPersonFirstName = "";
            String pPersonLastName = "";
            String amount_days = null  ;
            String toleranceYellow = null;
            String toleranceRed = null;
            String pStatus = "";
            
            Parameter2_TextField.setVisible(false);
            Parameter1_TextField.setVisible(false);
            Go_Button.setVisible(false);
            ParametersText_Label.setText("");
            Total_TextField.setVisible(true);
            Parameters_Label.setVisible(false);
            Filter_Label.setVisible(true);
            Filter_ComboBox.removeAllItems();
            Filter_ComboBox.addItem("Lent To");           
            Filter_ComboBox.addItem("Amount Days");
            Filter_ComboBox.addItem("Tolerance");
            Filter_ComboBox.addItem("Status");
            Filter_ComboBox.setVisible(true);
            

            
            DefaultTableModel modelo = new DefaultTableModel();
             
             modelo.addColumn("Status");
             modelo.addColumn("Title");
             modelo.addColumn("Edition");
             modelo.addColumn("Barcode");
             modelo.addColumn("Item Type");
             
             modelo.addColumn("Publisher");
             modelo.addColumn("Genre");
             modelo.addColumn("Lent To");
             modelo.addColumn("Lent To");
             modelo.addColumn("Lend Date");
             modelo.addColumn("Return Date");
             modelo.addColumn("Amount Days");
             modelo.addColumn("Tolerance");
             modelo.addColumn("Max Tolerance");
             
                    ResultSet res = DBConnection.ConnectDB.UserAllLendedItems(pPersonFirstName, pPersonLastName, amount_days ,toleranceYellow , toleranceRed, pStatus );

                    String data [] = new String[14];

                    while(res.next()){
                        data [0] = res.getString(5);
                        data [1] = res.getString(1);                      
                        data [2] = res.getString(2);
                        data [3] = res.getString(3);
                        data [4] = res.getString(4);//
                        data [5] = res.getString(6);
                        data [6] = res.getString(7);
                        data [7] = res.getString(8);
                        data [8] = res.getString(9);
                        data [9] = res.getString(10);
                        data [10] = res.getString(11);
                        data [11] = res.getString(12);
                        data [12] = res.getString(13);
                        data [13] = res.getString(14);          
                          
                        modelo.addRow(data);
                    }
                    
                    Queries_Table.setModel(modelo);
                    
                    
                    int allItems = 0;
                    
                    ResultSet res2 = DBConnection.ConnectDB.UserAllLendedItemsTotal();
                    while(res2.next()){
                        allItems = Integer.parseInt(res2.getString(1));
                    }
                    Total_TextField.setText("Total of Lended Items: "+ allItems);        
         
             
             
             
             
             
             
         
         
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
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
    }//GEN-LAST:event_Queries_ComboBoxActionPerformed

    private void Parameter1_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Parameter1_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Parameter1_TextFieldActionPerformed

    private void Filter_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_ComboBoxActionPerformed
      try{
       String query_selection = Queries_ComboBox.getSelectedItem().toString(); 
       String filter_selection = Filter_ComboBox.getSelectedItem().toString();
       
       if(query_selection.equals("All Items") && filter_selection.equals("Title")){
           Parameters_Label.setVisible(true);
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(false);
            Parameter1_TextField.setText("");
            Parameter2_TextField.setText("");
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Title Name");
       }
        
       else if(query_selection.equals("All Items") && filter_selection.equals("Author")){
            Parameters_Label.setVisible(true);
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(true);
            Parameter1_TextField.setText("");
            Parameter2_TextField.setText("");
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Author First Name   Author Last Name");
       }                                                
       
       else if(query_selection.equals("All Items") && filter_selection.equals("Publisher")){
           Parameters_Label.setVisible(true);
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(false);
            Parameter1_TextField.setText("");
            Parameter2_TextField.setText("");
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Publisher Name");
       }
       
       
       
       else if(query_selection.equals("All Lended Items") && filter_selection.equals("Lent To")){
            Parameters_Label.setVisible(true);
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(true);
            Parameter1_TextField.setText("");
            Parameter2_TextField.setText("");
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Person First Name   Person Last Name");
       }                                                
       
       
       else if(query_selection.equals("All Lended Items") && filter_selection.equals("Amount Days")){
            Parameters_Label.setVisible(true);
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(false);
            Parameter1_TextField.setText("");
            Parameter2_TextField.setText("");
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Amount Days");
       }       
       
       else if(query_selection.equals("All Lended Items") && filter_selection.equals("Tolerance")){
            Parameters_Label.setVisible(true);
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(true);
            Parameter1_TextField.setText("");
            Parameter2_TextField.setText("");
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Tolerance Min     Tolerance Max");
       }       
       
       
       
       else if(query_selection.equals("All Lended Items") && filter_selection.equals("Status")){
            Parameters_Label.setVisible(true);
            Parameter1_TextField.setVisible(true);
            Parameter2_TextField.setVisible(false);
            Parameter1_TextField.setText("");
            Parameter2_TextField.setText("");
            Go_Button.setVisible(true);
            ParametersText_Label.setText("Status Color Name");
       }       
       
       
       
       
       
       
       
      }
      catch(Exception e){
          
      }
       
        
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
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Menu().setVisible(true);
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
    private javax.swing.JLabel Admin_Label;
    private javax.swing.JButton AuthorCommit_Button;
    private javax.swing.JTextField AuthorEmail_TextField;
    private javax.swing.JTextField AuthorFirstName_TextField;
    private javax.swing.JTextField AuthorID_TextField;
    private javax.swing.JTextField AuthorLastName_TextField;
    private javax.swing.JTextField AuthorPhoneNumber_TextField;
    private javax.swing.JButton Author_Button;
    private javax.swing.JComboBox<String> Author_ComboBox;
    private javax.swing.JLabel Author_Email_Label;
    private javax.swing.JLabel Author_Email_Label1;
    private javax.swing.JLabel Author_First_Name_Label;
    private javax.swing.JLabel Author_Id_Label;
    private javax.swing.JLabel Author_Last_Name;
    private javax.swing.JTable Authors_Table;
    private javax.swing.JPanel Background_Panel;
    private javax.swing.JPanel Background_Panel1;
    private javax.swing.JPanel Background_Panel10;
    private javax.swing.JPanel Background_Panel11;
    private javax.swing.JPanel Background_Panel12;
    private javax.swing.JPanel Background_Panel13;
    private javax.swing.JPanel Background_Panel14;
    private javax.swing.JPanel Background_Panel15;
    private javax.swing.JPanel Background_Panel16;
    private javax.swing.JPanel Background_Panel2;
    private javax.swing.JPanel Background_Panel3;
    private javax.swing.JPanel Background_Panel4;
    private javax.swing.JPanel Background_Panel5;
    private javax.swing.JPanel Background_Panel6;
    private javax.swing.JPanel Background_Panel7;
    private javax.swing.JPanel Background_Panel8;
    private javax.swing.JPanel Background_Panel9;
    private javax.swing.JLabel Banner_Label;
    private javax.swing.JTextField BarbcodeItem_TextField;
    private javax.swing.JButton CloseAllCharts_Button;
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
    private javax.swing.JLabel Filter_Label;
    private javax.swing.JButton GenreCommit_Button;
    private javax.swing.JTextField GenreTypeDescription_TextField;
    private javax.swing.JTextField GenreTypeName_TextField;
    private javax.swing.JButton Genre_Button;
    private javax.swing.JComboBox<String> Genre_ComboBox;
    private javax.swing.JComboBox<String> Genre_ComboBox1;
    private javax.swing.JLabel Genre_Label;
    private javax.swing.JLabel Genre_Label1;
    private javax.swing.JLabel Genre_Label2;
    private javax.swing.JTable Genre_Table;
    private javax.swing.JButton Go_Button;
    private javax.swing.JCheckBox InsertAuthor_CheckBox;
    private javax.swing.JCheckBox InsertGenreType_CheckBox;
    private javax.swing.JCheckBox InsertItemType_CheckBox;
    private javax.swing.JCheckBox InsertPublisher_CheckBox;
    private javax.swing.JCheckBox InsertRelationType_CheckBox;
    private javax.swing.JCheckBox InsertStatusType_CheckBox;
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
    private javax.swing.JButton ItemTypeCommit_Button;
    private javax.swing.JTextField ItemTypeName_TextField;
    private javax.swing.JComboBox<String> ItemType_ComboBox;
    private javax.swing.JComboBox<String> ItemType_ComboBox1;
    private javax.swing.JLabel ItemType_Label;
    private javax.swing.JLabel ItemType_Label1;
    private javax.swing.JButton ItemTypes_Button;
    private javax.swing.JTable ItemTypes_Table;
    private javax.swing.JButton Lateral_Button1;
    private javax.swing.JButton Lateral_Button2;
    private javax.swing.JButton Lateral_Button3;
    private javax.swing.JButton Lateral_Button4;
    private javax.swing.JButton Lateral_Button5;
    private javax.swing.JButton Lateral_Button6;
    private javax.swing.JButton Lateral_Button7;
    private javax.swing.JTable LendItemPersons_Table;
    private javax.swing.JInternalFrame LendItem_InternalFrame;
    private javax.swing.JButton Lend_Button;
    private javax.swing.JTable LendedItems_Table;
    private javax.swing.JButton MainMenu_Button;
    private javax.swing.JPanel Menu_Panel;
    private javax.swing.JTextField Month_TextField;
    private javax.swing.JTextField Parameter1_TextField;
    private javax.swing.JTextField Parameter2_TextField;
    private javax.swing.JLabel ParametersText_Label;
    private javax.swing.JLabel Parameters_Label;
    private javax.swing.JLabel PersonEmail_Label;
    private javax.swing.JTextField PersonEmail_TextField;
    private javax.swing.JButton PublisherCommit_Button;
    private javax.swing.JTextField PublisherName_TextField;
    private javax.swing.JButton Publisher_Button;
    private javax.swing.JComboBox<String> Publisher_ComboBox;
    private javax.swing.JComboBox<String> Publisher_ComboBox2;
    private javax.swing.JLabel Publisher_Label1;
    private javax.swing.JLabel Publisher_Label2;
    private javax.swing.JTable Publisher_Table;
    private javax.swing.JButton Queries_Button;
    private javax.swing.JComboBox<String> Queries_ComboBox;
    private javax.swing.JInternalFrame Queries_InternalFrame;
    private javax.swing.JTable Queries_Table;
    private javax.swing.JInternalFrame ReceiveItem_InternalFrame;
    private javax.swing.JButton Receive_Button;
    private javax.swing.JTextField RedTolerance_TextField;
    private javax.swing.JInternalFrame RegisterAuthor_InternalFrame;
    private javax.swing.JInternalFrame RegisterGenreType_InternalFrame;
    private javax.swing.JInternalFrame RegisterItemType_InternalFrame;
    private javax.swing.JInternalFrame RegisterPublisher_InternalFrame;
    private javax.swing.JInternalFrame RegisterRelationType_InternalFrame;
    private javax.swing.JInternalFrame RegisterStatusType_InternalFrame;
    private javax.swing.JInternalFrame RegisterValues_InternalFrame;
    private javax.swing.JPanel RelationTypeCommitChanges_Panel;
    private javax.swing.JPanel RelationTypeCommitChanges_Panel1;
    private javax.swing.JPanel RelationTypeCommitChanges_Panel2;
    private javax.swing.JPanel RelationTypeCommitChanges_Panel3;
    private javax.swing.JPanel RelationTypeCommitChanges_Panel4;
    private javax.swing.JPanel RelationTypeCommitChanges_Panel5;
    private javax.swing.JButton RelationTypeCommit_Button;
    private javax.swing.JTextField RelationTypeName_TextField;
    private javax.swing.JButton RelationType_Button;
    private javax.swing.JComboBox<String> RelationType_ComboBox;
    private javax.swing.JLabel RelationType_Label;
    private javax.swing.JTable RelationType_Table;
    private javax.swing.JTable RelationTypes_Table;
    private javax.swing.JCheckBox RemoveAuthor_CheckBox;
    private javax.swing.JCheckBox RemoveGenreType_CheckBox;
    private javax.swing.JCheckBox RemoveItemType_CheckBox;
    private javax.swing.JCheckBox RemoveItem_CheckBox;
    private javax.swing.JCheckBox RemovePersonKnowsPerson_CheckBox;
    private javax.swing.JCheckBox RemovePublisher_CheckBox;
    private javax.swing.JCheckBox RemoveRelationType_CheckBox;
    private javax.swing.JCheckBox RemoveStatusType_CheckBox;
    private javax.swing.JLabel ReturnDate_Label;
    private javax.swing.JButton Return_Button;
    private javax.swing.JInternalFrame ReviewItem_InternalFrame;
    private javax.swing.JButton Review_Button;
    private javax.swing.JTable Review_Table;
    private javax.swing.JLabel SelectField_Label;
    private javax.swing.JLabel SelectField_Label1;
    private javax.swing.JLabel SelectField_Label10;
    private javax.swing.JLabel SelectField_Label11;
    private javax.swing.JLabel SelectField_Label12;
    private javax.swing.JLabel SelectField_Label13;
    private javax.swing.JLabel SelectField_Label2;
    private javax.swing.JLabel SelectField_Label3;
    private javax.swing.JLabel SelectField_Label4;
    private javax.swing.JLabel SelectField_Label5;
    private javax.swing.JLabel SelectField_Label6;
    private javax.swing.JLabel SelectField_Label7;
    private javax.swing.JLabel SelectField_Label8;
    private javax.swing.JLabel SelectField_Label9;
    private javax.swing.JComboBox<String> SelectIItem_ComboBox;
    private javax.swing.JLabel SelectITem_Label;
    private javax.swing.JLabel SelectITem_Label1;
    private javax.swing.JLabel SelectITem_Label2;
    private javax.swing.JLabel SelectItem_Label2;
    private javax.swing.JComboBox<String> SelectReview_ComboBox;
    private javax.swing.JLabel SelectStars_Label;
    private javax.swing.JComboBox<String> SelectStatistic_ComboBox;
    private javax.swing.JLabel Select_Label;
    private javax.swing.JLabel Select_Label2;
    private javax.swing.JButton Stadistics_Button;
    private javax.swing.JInternalFrame StatisticsQueries_InternalFrame;
    private javax.swing.JInternalFrame Statistics_InternalFrame;
    private javax.swing.JButton StatusCommit_Button;
    private javax.swing.JTextField StatusTypeDescription_TextField;
    private javax.swing.JTextField StatusTypeName_TextField;
    private javax.swing.JButton StatusType_Button;
    private javax.swing.JTable Status_Table;
    private javax.swing.JLabel Subtitle_Label;
    private javax.swing.JLabel Subtitle_Label1;
    private javax.swing.JLabel Subtitle_Label10;
    private javax.swing.JLabel Subtitle_Label11;
    private javax.swing.JLabel Subtitle_Label12;
    private javax.swing.JLabel Subtitle_Label13;
    private javax.swing.JLabel Subtitle_Label14;
    private javax.swing.JLabel Subtitle_Label15;
    private javax.swing.JLabel Subtitle_Label16;
    private javax.swing.JLabel Subtitle_Label2;
    private javax.swing.JLabel Subtitle_Label3;
    private javax.swing.JLabel Subtitle_Label4;
    private javax.swing.JLabel Subtitle_Label5;
    private javax.swing.JLabel Subtitle_Label6;
    private javax.swing.JLabel Subtitle_Label7;
    private javax.swing.JLabel Subtitle_Label8;
    private javax.swing.JLabel Subtitle_Label9;
    private javax.swing.JTextField TitleItem_TextField;
    private javax.swing.JLabel Title_Label;
    private javax.swing.JLabel Title_Label1;
    private javax.swing.JLabel Title_Label10;
    private javax.swing.JLabel Title_Label11;
    private javax.swing.JLabel Title_Label12;
    private javax.swing.JLabel Title_Label13;
    private javax.swing.JLabel Title_Label14;
    private javax.swing.JLabel Title_Label15;
    private javax.swing.JLabel Title_Label16;
    private javax.swing.JLabel Title_Label2;
    private javax.swing.JLabel Title_Label3;
    private javax.swing.JLabel Title_Label4;
    private javax.swing.JLabel Title_Label5;
    private javax.swing.JLabel Title_Label6;
    private javax.swing.JLabel Title_Label7;
    private javax.swing.JLabel Title_Label8;
    private javax.swing.JLabel Title_Label9;
    private javax.swing.JLabel ToleranceDays_Label;
    private javax.swing.JTextField Total_TextField;
    private javax.swing.JCheckBox UpdateAuthor_CheckBox;
    private javax.swing.JCheckBox UpdateGenreType_CheckBox;
    private javax.swing.JCheckBox UpdateItemType_CheckBox;
    private javax.swing.JCheckBox UpdateItem_CheckBox;
    private javax.swing.JCheckBox UpdatePublisher_CheckBox;
    private javax.swing.JCheckBox UpdateRelationType_CheckBox;
    private javax.swing.JCheckBox UpdateStatusType_CheckBox;
    private javax.swing.JLabel Upper_Banner;
    private javax.swing.JLabel Upper_Banner1;
    private javax.swing.JLabel Upper_Banner10;
    private javax.swing.JLabel Upper_Banner11;
    private javax.swing.JLabel Upper_Banner12;
    private javax.swing.JLabel Upper_Banner13;
    private javax.swing.JLabel Upper_Banner14;
    private javax.swing.JLabel Upper_Banner15;
    private javax.swing.JLabel Upper_Banner16;
    private javax.swing.JLabel Upper_Banner2;
    private javax.swing.JLabel Upper_Banner3;
    private javax.swing.JLabel Upper_Banner4;
    private javax.swing.JLabel Upper_Banner5;
    private javax.swing.JLabel Upper_Banner6;
    private javax.swing.JLabel Upper_Banner7;
    private javax.swing.JLabel Upper_Banner8;
    private javax.swing.JLabel Upper_Banner9;
    private javax.swing.JLabel Wallpaper_Label;
    private javax.swing.JTextField Year_TextField;
    private javax.swing.JTextField YellowTolerance_TextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
  byte[] photo = null;
  byte[] photo_item = null; 
  String filename = null;
  private ImageIcon format = null;

}
