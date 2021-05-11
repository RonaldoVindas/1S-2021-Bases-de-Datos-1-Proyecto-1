/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.awt.Image;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.ImageIcon;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;


public class ConnectDB {
    

    
    //=============Tabla: Genre ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////
    
    
    
    public static void insertGenre(String pname, String pdescription) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_genre.insert_genre(?,?)}");
        stmt.setString(1, pname);
        stmt.setString(2, pdescription);
        stmt.execute();
            
    }
    
   public static void removeGenre(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_genre.remove_genre(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }    
    
    public static void updateGenre(int pId, String pname, String pdescription) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_genre.update_genre(?,?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2, pname);
        stmt.setString(3, pdescription);
        stmt.execute();
            
    }
    
    public static String getGenreName(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_genre.getgenreName(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }   
    
     public static String getGenreDescription(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_genre.getgenreName(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }      
    
    
    public static int getGenreId(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_genre.get_genre_id(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setString(2, pName);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }
    
     //=============Tabla: Item ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////
    
    public static void insertItem(String pTitle, String pEdition, byte[] pCover, String pBarcode, int pItemTypeId, int pStatusId, int pPublisherId ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_item.insert_item(?,?,?,?,?,?,?)}");
        stmt.setString(1, pTitle);
        stmt.setString(2, pEdition);
        stmt.setObject(3, pCover, java.sql.Types.BLOB);
        stmt.setString(4, pBarcode);
        stmt.setInt(5,pItemTypeId );
        stmt.setInt(6, pStatusId);
        stmt.setInt(7, pPublisherId);
        
        
        stmt.execute();          
    }
    
    public static void removeItem(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_item.remove_item(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }     
    
    public static void updateItem(int pId, String pTitle, String pEdition,  String pBarcode, int pItemTypeId, int pStatusId, int pPublisherId ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
             
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_item.update_item(?,?,?,?,?,?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2, pTitle);
        stmt.setString(3, pEdition);
        //stmt.setObject(4, pCover, java.sql.Types.BLOB);
        stmt.setString(4, pBarcode);
        stmt.setInt(5,pItemTypeId );
        stmt.setInt(6, pStatusId);
        stmt.setInt(7, pPublisherId);
               
        stmt.execute();          
    }
    
    
    public static void updateItemCover(int pId, byte[] pCover) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
             
       
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_item.update_item_cover(?,?)}");
        stmt.setInt(1, pId);
        
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setBytes(2, pCover);

        stmt.execute();          
    }
    
    public static void updateItemStatus(int pId, int pStatusId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
             
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_item.update_item_status(?,?)}");
        stmt.setInt(1, pId);
        stmt.setInt(2, pStatusId);

        stmt.execute();          
    }
    
    
    public static int getItemId(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemId(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setString(2, pName);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    
    public static String getItemTitle(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemTitle(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }      
    
    
    public static String getItemEdition(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemEdition(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }           
    
    
    public static ImageIcon getItemCover(int pId) throws SQLException{
        
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        

        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemCoverImage(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.BLOB);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        byte[] a = stmt.getBytes(1);
       
        ImageIcon r = new ImageIcon(a);
        ImageIcon resized_image =  new ImageIcon(r.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
        
        
        System.out.println(r.toString());     
        return resized_image;
    }
    
    public static String getItemBarcode(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemBarcode(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }          
    
    public static int getItemItemType(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemItemType(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    
    public static int getItemStatus(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemStatus(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    public static int getItemPublisher(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemPublisher(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }    
    
    
  //=============Tabla: ItemHasGenre ===========================================================================================================//////////////////////////////////////////
 //============================ Paquete ===================================================================================================================////////////////////////
        
    public static void insertItemHasGenre(int pItemId, int pGenreId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_itemHasGenre.insert_itemHasGenre(?,?)}");
        stmt.setInt(1, pItemId);
        stmt.setInt(2, pGenreId);
        stmt.execute();
            
    }
    
   public static void removeItemHasGenre(int pId) throws SQLException{ 
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_itemHasGenre.remove_itemHasGenre(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }    
    
    public static void updateItemHasGenre(int pItemId_old, int pItemId_new, int pGenreId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
         
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_itemHasGenre.update_itemHasGenre(?,?,?)}");
        stmt.setInt(1, pItemId_old);
        stmt.setInt(2, pItemId_new);
        stmt.setInt(3, pGenreId);
        stmt.execute();
            
    }
        
    public static int getItemHasGenreItemId(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_itemHasGenre.getitemHasGenreitem_id(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    public static int getItemHasGenreGenreId(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_itemHasGenre.getitemHasGenregenre_id(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    
//=============Tabla: ItemHasReview ===========================================================================================================//////////////////////////////////////////
 //============================ Paquete ===================================================================================================================////////////////////////
     
     public static void insertItemHasReview(int pItemId, int pReviewId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_ItemHasReview.insert_ItemHasReview(?,?)}");
        stmt.setInt(1, pItemId);
        stmt.setInt(2, pReviewId);
        stmt.execute();
            
    }   
   public static void removeItemHasReview(int pId) throws SQLException{ 
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_ItemHasReview.remove_ItemHasReview(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }    
    
    public static void updateItemHasReview(int pItemId_old, int pItemId_new, int pReviewId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
         
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_ItemHasReview.update_ItemHasReview(?,?,?)}");
        stmt.setInt(1, pItemId_old);
        stmt.setInt(2, pItemId_new);
        stmt.setInt(3, pReviewId);
        stmt.execute();
            
    }
        
    public static int getItemHasReviewItemId(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_ItemHasReview.getItemHasReviewitem_id(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    public static int getItemHasReviewReviewId(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_ItemHasReview.getItemHasReviewreview_id(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }    
    
    
//=============Tabla: ItemType ===========================================================================================================//////////////////////////////////////////
 //============================ Paquete ===================================================================================================================////////////////////////
    
    public static void insertItemType(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_ItemType.insert_ItemType(?)}");
        stmt.setString(1, pName);

        stmt.execute();
            
    }    
    
    public static void removeItemType(int pId) throws SQLException{ 
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_ItemType.remove_ItemType(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }    
    
    public static void updateItemType(int pItemId_old, String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
         
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_ItemType.update_ItemType(?,?)}");
        stmt.setInt(1, pItemId_old);
        stmt.setString(2, pName);
        stmt.execute();
            
    }    
    
    public static String getItemTypeName(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_ItemType.getitemType_name(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
    }    
    
    public static int getItemTypeId(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_ItemType.get_itemtype_id(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setString(2, pName);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }    
    
    
        
    
    //=============Tabla: Person ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////
    
    
    
    public static void insertPerson(int pId, String pFirname, String pLasname, String pEmail, String pPassword, String pPhonenumber, String pDate, int pType) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_person.insert_person(?,?,?,?,?,?,?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pFirname);
        stmt.setString(3,pLasname);
        stmt.setString(4,pEmail);
        stmt.setString(5,pPassword);
        stmt.setString(6, pPhonenumber);
        stmt.setString(7, pDate);
        stmt.setInt(8, pType);

        stmt.execute();
     
    }
    
     public static void removePerson(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_person.remove_person(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
        public static void updatePerson(int pId_old, String pFirname, String pLasname, String pEmail, String pPassword, String pPhonenumber, String pDate) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_person.update_person(?,?,?,?,?,?,?)}");
        stmt.setInt(1, pId_old);
        stmt.setString(2, pFirname);
        stmt.setString(3, pLasname);
        stmt.setString(4, pEmail);
        stmt.setString(5, pPassword);
        stmt.setString(6, pPhonenumber);
        stmt.setString(7, pDate);

        stmt.execute();
     
    }
    
    
    

    
    public static int getPersonId(String pEmail) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonId(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setString(2, pEmail);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }
    
     public static String getPersonFirstName(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonFirstName(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }   
    
    public static String getPersonLastName(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonLastName(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }  
    
    public static String getPersonEmail(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonEmail(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }  
    
    
    public static String getPersonPassword(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonPassword(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }     
  
    public static String getPersonPhoneNumber(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonPhoneNumber(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }  
    
    public static Date getPersonBirthDay(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonBirthDay(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.DATE);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        Date r = stmt.getDate(1);

        
        
      
        System.out.println(r);
        return r; 

    }      
    
        
    public static int getPersonTypePersonId(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonPersonType(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  
    
    
    //=============Tabla: Person1KnowsPerson2 ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////

    public static void insertPerson1KnowsPerson2(int pIdPerson1, int pIdPerson2, int pRelationType ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_person1knowsperson2.insert_person1knowsperson2(?,?,?)}");
        stmt.setInt(1, pIdPerson1);
        stmt.setInt(2,pIdPerson2);
        stmt.setInt(3,pRelationType);


        stmt.execute();
     
    }

    
    public static void removePerson1KnowsPerson2(int pIdPerson1, int pIdPerson2) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_person1knowsperson2.remove_person1knowsperson2(?,?)}");
        stmt.setInt(1, pIdPerson1);
        stmt.setInt(2, pIdPerson2);
        
        stmt.execute();
     
    }   
    
    
    public static void updatePerson1KnowsPerson2(int pIdPerson1_old, int pIdPerson1, int pIdPerson2, int pRelationType ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_person1knowsperson2.update_person1knowsperson2(?,?,?,?)}");
        stmt.setInt(1, pIdPerson1_old);
        stmt.setInt(2,pIdPerson1);
        stmt.setInt(3,pIdPerson2);
        stmt.setInt(4,pRelationType);

        stmt.execute();
     
    }
    
    public static int getPerson1KnowsPerson2Person1Id(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person1knowsperson2.getper1knowsper2person1Id(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }      
    
    
    public static int getPerson1KnowsPerson2Person2Id(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person1knowsperson2.getper1knowsper2person2Id(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }      

    public static int getPerson1KnowsPerson2RelationTypeId(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person1knowsperson2.getper1knowsper2reltypeId(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }          
    
    //=============Tabla: PersonCreatesItem ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    
    
   public static void insertPersonCreatesItem(int pIdPerson, int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_personcreatesitem.insert_personcreatesitem(?,?)}");
        stmt.setInt(1, pIdPerson);
        stmt.setInt(2,pIdItem);


        stmt.execute();
     
    }
    
    public static void removePersonCreatesItem(int pIdPerson) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_personcreatesitem.remove_personcreatesitem(?)}");
        stmt.setInt(1, pIdPerson);

        stmt.execute();
     
    }   
    
   public static void updatePersonCreatesItem(int pIdPerson_old, int pIdPerson_new, int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_personcreatesitem.insert_personcreatesitem(?,?,?)}");
        stmt.setInt(1, pIdPerson_old);
        stmt.setInt(2,pIdPerson_new);
        stmt.setInt(3,pIdItem);


        stmt.execute();
     
    }
        
    public static int getPersonCreatesItemPersonId(int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personcreatesitem.getpersoncreatesitemPersonID(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pIdItem);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     
    
    public static int getPersonCreatesItemItemId(int pIdPerson) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personcreatesitem.getpersoncreatesitemItemID(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pIdPerson);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }         
    
    //=============Tabla: PersonHasItem ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    
        
   public static void insertPersonHasItem(int pIdPerson, int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_personhasitem.insert_personhasitem(?,?)}");
        stmt.setInt(1, pIdPerson);
        stmt.setInt(2,pIdItem);


        stmt.execute();
     
    }    
    
    public static void removePersonHasItem(int pIdPerson, int pIdITem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_personhasitem.remove_personhasitem(?, ?)}");
        stmt.setInt(1, pIdPerson);
        stmt.setInt(2, pIdITem);
         
        stmt.execute();
     
    }   
    
   public static void updatePersonHasItem(int pIdPerson_old, int pIdPerson_new, int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_personhasitem.update_personhasitem(?,?,?)}");
        stmt.setInt(1, pIdPerson_old);
        stmt.setInt(2,pIdPerson_new);
        stmt.setInt(3,pIdItem);


        stmt.execute();
     
    }
        
    public static int getPersonHasItemPersonId(int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personhasitem.getpersonhasitemPersonID(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pIdItem);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     
    
    public static int getPersonHasItemItemId(int pIdPerson) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personhasitem.getpersonhasitemItemID(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pIdPerson);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }   
    
    
    
    //=============Tabla: PersonLendItem ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    
       
   public static void insertPersonLendItem(int pIdPerson1,int pIdPerson2, int pIdItem, String pReturnDate, int pToleranceDaysYellow, int pToleranceDaysRed) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_personlenditem.insert_personlenditem(?,?,?,?,?,?)}");
        stmt.setInt(1, pIdPerson1);
        stmt.setInt(2,pIdPerson2);
        stmt.setInt(3, pIdItem);
        stmt.setString(4,pReturnDate);
        stmt.setInt(5,pToleranceDaysYellow);
        stmt.setInt(6,pToleranceDaysRed);

        stmt.execute();
     
    }        
    
    
   public static void removePersonLendItem(int pItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_personlenditem.remove_personlenditem(?)}");
        stmt.setInt(1, pItem);
    

        stmt.execute();
     
    }            
    
public static void updatePersonLendItem(int ppersonid1_old, int ppersonid1_new,int ppersonid2_old,int ppersonid2_new, int pitem_id, String plend_date, String preturn_date, int ptoleranceDaysYellow, int ptoleranceDaysRed ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_personlenditem.update_personlenditem(?,?,?,?,?,?)}");
        stmt.setInt(1, ppersonid1_old);
        stmt.setInt(2,ppersonid1_new);
        stmt.setInt(3, ppersonid2_old);
        stmt.setInt(4,ppersonid2_new);
        stmt.setInt(5, pitem_id);
        stmt.setString(6,plend_date);
        stmt.setString(7,preturn_date);
        stmt.setInt(8, ptoleranceDaysYellow);
        stmt.setInt(9, ptoleranceDaysRed);


        stmt.execute();       
    } 



public static void updatePersonLendItemReturnDate(int pperson1_id, int pperson2_id, Date preturn_date ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
       
        CallableStatement stmt = con.prepareCall("{ call control_personlenditem.update_personlenditemRetDate(?,?,?)}");
        stmt.setInt(1, pperson1_id);
        stmt.setInt(2,pperson2_id);
        stmt.setDate(3, preturn_date);


        stmt.execute();       
    } 


    
    public static int getPersonLendItemPerson1Id(int pPerson2id ,int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personlenditem.getpersonlenditemPerson1ID(?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson2id);
         stmt.setInt(3, pIdItem);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     

    public static int getPersonLendItemPerson2Id(int pPerson1id ,int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personlenditem.getpersonlenditemPerson2ID(?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pIdItem);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     

    public static int getPersonLendItemItemId(int pPerson1id ,int pPerson2id) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personlenditem.getpersonlenditemItemID(?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }       
    
    public static Date getPersonLendLendDate(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personlenditem.getpersonlenditemLendDate(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.DATE);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        Date r = stmt.getDate(1);
        System.out.println(r);
        return r;
   

    }      
    
    public static Date getPersonLendReturnDate(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personlenditem.getpersonlenditemReturnDate(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.DATE);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        Date r = stmt.getDate(1);
        System.out.println(r);
        return r;
   

    }       
   
    public static int getPersonLendAmountDays(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personlenditem.getpersonlenditemAmountDays(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }      

    public static int getPersonLendToleranceDaysYellow(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personlenditem.getpersonlenditemToleranceDY(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  


    public static int getPersonLendToleranceDaysRed(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_personlenditem.getpersonlenditemToleranceDR(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    
    //=============Tabla: PersonType ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    




    public static void insertPersonType(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_PersonType.insert_PersonType(?)}");
        stmt.setString(1, pName);


        stmt.execute();
     
    }    
    
    public static void removePersonType(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_PersonType.remove_PersonType(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updatePersonType(int pId, String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_PersonType.update_PersonType(?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);



        stmt.execute();
     
    }

    public static int getPersonTypeId(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_PersonType.getpersontypeId(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setString(2, pName);

        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static String getPersonTypeName(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_PersonType.getpersontypeId(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);

        stmt.executeQuery();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    }  
    
    
//=============Tabla: PersonType ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////       
    
    public static void insertPublisher(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_publisher.insert_publisher(?)}");
        stmt.setString(1, pName);


        stmt.execute();
     
    }    
    
    public static void removePublisher(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_publisher.remove_publisher(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updatePublisher(int pId, String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_publisher.update_publisher(?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);



        stmt.execute();
     
    }

    public static int getPublisherId(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_publisher.getpublisherId(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setString(2, pName);

        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static String getPublisherName(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_publisher.getpublisherName(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);

        stmt.executeQuery();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    }  
        
//=============Tabla: RelationType ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////        
    
    public static void insertRelationType(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_relationtype.insert_relationtype(?)}");
        stmt.setString(1, pName);


        stmt.execute();
     
    }    
    
    public static void removeRelationType(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_relationtype.remove_relationtype(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updateRelationType(int pId, String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_relationtype.update_relationtype(?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);



        stmt.execute();
     
    }

    public static int getRelationTypeId(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_relationtype.getrelationtypeId(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setString(2, pName);

        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static String getRelationTypeName(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_relationtype.getrelationtypeName(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);

        stmt.executeQuery();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    } 
    
//=============Tabla: Review ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    

    public static void insertReview(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_review.insert_review(?)}");
        stmt.setString(1, pName);


        stmt.execute();
     
    }    
    
    public static void removeReview(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_review.remove_review(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updateReview(int pId, String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_review.update_review(?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);



        stmt.execute();
     
    }

    public static int getReviewId(int pStars) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_review.getreviewId(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pStars);

        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static int getReviewStars(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_review.getrelationtypeName(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);

        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    } 

//=============Tabla: Status ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    


    public static void insertStatus(String pName, String pDescription) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_status.insert_status(?,?)}");
        stmt.setString(1, pName);
        stmt.setString(2, pDescription);

        stmt.execute();
     
    }    
    
    public static void removeStatus(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_status.remove_status(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updateStatus(int pId, String pName, String pDescription ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_status.update_status(?,?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);
        stmt.setString(3,pDescription);


        stmt.execute();
     
    }

    public static int getStatusId(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_status.getstatusId(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setString(2, pName);

        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static String getStatusName(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_status.getstatusName(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);

        stmt.executeQuery();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    } 


    public static String getStatusDescription(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_status.getstatusDescription(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);

        stmt.executeQuery();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    } 
    
    
    
//=============Paquete: Loan_History  ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////      
    

   public static void insertLoanHistory(int pIdPerson1,int pIdPerson2, int pIdItem, String pReturnDate, int pToleranceDaysYellow, int pToleranceDaysRed) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_loan_history.insert_loan_history(?,?,?,?,?,?)}");
        stmt.setInt(1, pIdPerson1);
        stmt.setInt(2,pIdPerson2);
        stmt.setInt(3, pIdItem);
        stmt.setString(4,pReturnDate);
        stmt.setInt(5,pToleranceDaysYellow);
        stmt.setInt(6,pToleranceDaysRed);

        stmt.execute();
     
    }        
    
    
   public static void removeLoanHistory(int pItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_loan_history.remove_loan_history(?)}");
        stmt.setInt(1, pItem);
    

        stmt.execute();
     
    }            
    
public static void updateLoanHistory(int ppersonid1_old, int ppersonid1_new,int ppersonid2_old,int ppersonid2_new, int pitem_id, String plend_date, String preturn_date, int ptoleranceDaysYellow, int ptoleranceDaysRed ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_loan_history.update_loan_history(?,?,?,?,?,?)}");
        stmt.setInt(1, ppersonid1_old);
        stmt.setInt(2,ppersonid1_new);
        stmt.setInt(3, ppersonid2_old);
        stmt.setInt(4,ppersonid2_new);
        stmt.setInt(5, pitem_id);
        stmt.setString(6,plend_date);
        stmt.setString(7,preturn_date);
        stmt.setInt(8, ptoleranceDaysYellow);
        stmt.setInt(9, ptoleranceDaysRed);


        stmt.execute();       
    } 



public static void updateLoanHistoryReturnDate(int pperson1_id, int pperson2_id,String preturn_date ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_loan_history.update_loan_historyRetDate(?,?,?)}");
        stmt.setInt(1, pperson1_id);
        stmt.setInt(2,pperson2_id);
        stmt.setString(3, preturn_date);


        stmt.execute();       
    } 


    
    public static int getLoanHistoryPerson1Id(int pPerson2id ,int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_loan_history.getloan_historyPerson1ID(?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson2id);
         stmt.setInt(3, pIdItem);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     

    public static int getLoanHistoryPerson2Id(int pPerson1id ,int pIdItem) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_loan_history.getloan_historyPerson2ID(?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pIdItem);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     

    public static int getLoanHistoryItemId(int pPerson1id ,int pPerson2id) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_loan_history.getloan_historyItemID(?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }       
    
    public static Date getLoanHistoryLendDate(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_loan_history.getloan_historyLendDate(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.DATE);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        Date r = stmt.getDate(1);
        System.out.println(r);
        return r;
   

    }      
    
    public static Date getLoanHistoryReturnDate(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_loan_history.getloan_historyReturnDate(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.DATE);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        Date r = stmt.getDate(1);
        System.out.println(r);
        return r;
   

    }       
   
    public static int getLoanHistoryAmountDays(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_loan_history.getloan_historyAmountDays(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }      

    public static int getLoanHistoryToleranceDaysYellow(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_loan_history.getloan_historyToleranceDY(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  


    public static int getLoanHistoryToleranceDaysRed(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_loan_history.getloan_historyToleranceDR(?,?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    

    
//=============Paquete: UserInterface ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////   

    public static ResultSet getCollection(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.Getcollection(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.setInt(2, pId);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }
       
   
    public static ResultSet getPublishers() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetPublishers()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }
    
    public static ResultSet getItemTypes() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetItemTypes()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }
 
    public static ResultSet getGenres() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetGenres()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }    
    

    
    public static ResultSet getGenresWithDescription() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetGenresWithDescription()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }        
    
    public static ResultSet getRelationTypes() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetRelationTypes()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }    

    
    public static ResultSet getStatus() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetStatus()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }  
    
    public static ResultSet getAuthors() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetAuthors()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }  

    
    public static ResultSet getKnownPeople(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetKnownPeople(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }        
    
    
    public static ResultSet getItems(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetItems(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }        
    
    public static ResultSet getLendedItems(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetLendedItems(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        } 
    
    
    
    public static ResultSet getCollectionWithNoReviews(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.GetcollectionNoReviews(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }     
    
    public static ResultSet updateToleranceDays(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call UserInterface_package.updateToleranceDays(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }         
    
    //=============Tabla: Admin Queries ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    
    
    public static ResultSet AdminNotBorrowed() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call admin_queries.NotBorrowed()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }      
    

    public static ResultSet AdminNotBorrowedTotal() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call admin_queries.NotBorrowedTotal()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }     
    
    
    public static ResultSet AdminTopMostBorrowed(int pTop) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call admin_queries.TopMostBorrowed(?)}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.setInt(2, pTop);
        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }        
    
    public static ResultSet AdminMostBorrowedPerMonth(int pTimes, int pMonths) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call admin_queries.MostBorrowedPerMonth(?,?)}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.setInt(2, pTimes);
        stmt.setInt(3, pMonths);
        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }    
    
    public static ResultSet AdminAgeOfPeopleLoan() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call admin_queries.AgeOfPeopleLoan()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }        
    
//=============Tabla: Statistics ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////        
    
   
    public static ResultSet StatisticTotalItemsByGenre() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call Statistics_Queries.totalBookGenre()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }       
    
    
    
    public static ResultSet StatistictotalLendedItemsNow() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call Statistics_Queries.totalLendedBookNow()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }   
    
    
    public static ResultSet StatistictotalLendedItems() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call Statistics_Queries.totalLendedBook()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }   
    
    public static ResultSet StatistictotalLendedItemsByGenre() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call Statistics_Queries.totalLendedBookGenre()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }     
    
    public static ResultSet StatistictotalLendedItemsByAge() throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call Statistics_Queries.totalLendedBookAge()}");
       
        stmt.registerOutParameter(1, OracleTypes.CURSOR);

        stmt.executeQuery();
        
        ResultSet r = ((OracleCallableStatement)stmt).getCursor(1);
        System.out.println(r.toString());
        return r;
        
        }         
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
