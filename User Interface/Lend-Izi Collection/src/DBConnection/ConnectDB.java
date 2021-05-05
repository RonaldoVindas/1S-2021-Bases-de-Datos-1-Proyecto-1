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
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.ImageIcon;
import oracle.jdbc.OracleTypes;


public class ConnectDB {
    
    
    
    //=============Tabla: Person ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////
    
    
    
    public static void insertPerson(int pId, String pFirname, String pLasname, String pEmail, String pPassword, String pPhonenumber, String pDate) throws SQLException{
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
        stmt.setInt(8, 1);

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
    
        public static void updatePerson(int pId_old, int pId_new, String pFirname, String pLasname, String pEmail, String pPassword, String pPhonenumber, String pDate) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_person.insert_person(?,?,?,?,?,?,?,?)}");
        stmt.setInt(1, pId_old);
        stmt.setInt(2, pId_new);
        stmt.setString(3, pFirname);
        stmt.setString(4, pLasname);
        stmt.setString(5, pEmail);
        stmt.setString(6, pPassword);
        stmt.setString(7, pPhonenumber);
        stmt.setString(8, pDate);

        stmt.execute();
     
    }
    
    
    

    
    public static int getPersonId(String pEmail) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonId(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonFirstName(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonLastName(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonEmail(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonPassword(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonPhoneNumber(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonBirthDay(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.getpersonPersonType(?)");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  
    
    
    //=============Tabla: Genre ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////
    
    
    
    public static void insertGenre(String pname, String pdescription) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_genre.insert_genre(?,?)");
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
        CallableStatement stmt = con.prepareCall("{ call control_genre.update_genre(?,?,?)");
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_genre.getgenreName(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_genre.getgenreName(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_person.get_genre_id(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ call control_item.insert_item(?,?,?,?,?,?,?)");
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
    
    public static void updateItem(int pId, String pTitle, String pEdition, byte[] pCover, String pBarcode, int pItemTypeId, int pStatusId, int pPublisherId ) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
             
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_item.update_item(?,?,?,?,?,?,?,?)");
        stmt.setInt(1, pId);
        stmt.setString(2, pTitle);
        stmt.setString(3, pEdition);
        stmt.setObject(4, pCover, java.sql.Types.BLOB);
        stmt.setString(5, pBarcode);
        stmt.setInt(6,pItemTypeId );
        stmt.setInt(7, pStatusId);
        stmt.setInt(8, pPublisherId);
               
        stmt.execute();          
    }
    
    
    public static void updateItemCover(int pId, byte[] pCover) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
             
       
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ call control_item.update_item_cover(?,?)");
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
        CallableStatement stmt = con.prepareCall("{ call control_item.update_item_status(?,?)");
        stmt.setInt(1, pId);
        stmt.setInt(2, pStatusId);

        stmt.execute();          
    }
    
    
    public static int gettemId(String pName) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemId(?)");
       
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.setString(2, pName);
        stmt.executeQuery();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    
    public static String getitemTitle(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemTitle(?)");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }      
    
    
    public static String getitemEdition(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemEdition(?)");
       
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
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemCoverImage(?)");
       
        stmt.registerOutParameter(1, OracleTypes.BLOB);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        
        byte[] a = stmt.getBytes(1);
        
        ImageIcon r = new ImageIcon(a);
        ImageIcon resized_image =  new ImageIcon(r.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
        
        
        System.out.println(r.toString());
        return resized_image;
    }
    
    public static String getitemBarcode(int pId) throws SQLException{
        String host = "jdbc:oracle:thin:@localhost:1521:DBRONALDO";
        String uName = "PE";
        String uPass = "PE";
        
        
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_item.getitemBarcode(?)");
       
        stmt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmt.setInt(2, pId);
        stmt.executeQuery();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }          
    
}
