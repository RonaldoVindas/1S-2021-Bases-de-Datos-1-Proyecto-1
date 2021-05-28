package DBConnection;

/*
By:
    Renzo Barra
    Álvaro Moreira
    Ronaldo Vindas
*/


import java.awt.Image;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.ImageIcon;
import oracle.jdbc.OracleCallableStatement;

import java.sql.Types;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {
    private static Connection con;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="2296";
    private static final String url="jdbc:mysql://localhost:3306/pe";
    
    
    //=============Tabla: Genre ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////
    
    
    
    public static void insertGenre(String pname, String pdescription) throws SQLException{
       con = (Connection)DriverManager.getConnection(url, user, pass);
            CallableStatement stmt = con.prepareCall("{ call Control_Genre_InsertGenre(?,?)}");
            stmt.setString(1, pname);
            stmt.setString(2, pdescription);
            stmt.execute();

            
    }
    
   public static void removeGenre(int pId) throws SQLException{   
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Genre_RemoveGenre(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }    
    
    public static void updateGenre(int pId, String pname, String pdescription) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Genre_UpdateGenre(?,?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2, pname);
        stmt.setString(3, pdescription);
        stmt.execute();
            
    }
    
    public static String getGenreName(int pId) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Genre_getGenreName(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }   
    
     public static String getGenreDescription(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call call Control_Genre_getGenreDescription(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }      
    
    
    public static int getGenreId(String pName) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Genre_getGenreId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, pName);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }
    
     //=============Tabla: Item ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////
    
    public static void insertItem(String pTitle, String pEdition, byte[] pCover, String pBarcode, int pItemTypeId, int pStatusId, int pPublisherId ) throws SQLException{

        
       con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Control_Item_InsertItemA(?,?,?,?,?,?,?)}");
        stmt.setString(1, pTitle);
        stmt.setString(2, pEdition);
        stmt.setObject(3, pCover);
        stmt.setString(4, pBarcode);
        stmt.setInt(5,pItemTypeId );
        stmt.setInt(6, pStatusId);
        stmt.setInt(7, pPublisherId);
        
        
        //stmt.execute();        
       
       
        
        stmt.execute();

    }
    
    public static int insertItemB() throws SQLException{
  
       con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{? = call Control_Item_InsertItemB()}");
        stmt.registerOutParameter(1, Types.INTEGER);
        
        
        stmt.execute();        
          
        int r = stmt.getInt(1);
        System.out.println(r);
        return r; 
    }
    

    
    public static void removeItem(int pId) throws SQLException{   
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Item_RemoveItem(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }     
    
    public static void updateItem(int pId, String pTitle, String pEdition,  String pBarcode, int pItemTypeId, int pStatusId, int pPublisherId ) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Item_UpdateItem(?,?,?,?,?,?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2, pTitle);
        stmt.setString(3, pEdition);

        stmt.setString(4, pBarcode);
        stmt.setInt(5,pItemTypeId );
        stmt.setInt(6, pStatusId);
        stmt.setInt(7, pPublisherId);
               
        stmt.execute();          
    }
    
    
    public static void updateItemCover(int pId, byte[] pCover) throws SQLException{

       
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Control_Item_UpdateItemCover(?,?)}");
        stmt.setInt(1, pId);
        

        stmt.setBytes(2, pCover);

        stmt.execute();          
    }
    
    public static void updateItemStatus(int pId, int pStatusId) throws SQLException{         
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Item_UpdateItemStatus(?,?)}");
        stmt.setInt(1, pId);
        stmt.setInt(2, pStatusId);

        stmt.execute();          
    }
    
    
    public static int getItemId(String pName) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Item_getItemId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, pName);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    
    public static String getItemTitle(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Item_getItemTitle(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }      
    
    
    public static String getItemEdition(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Item_getItemEdition(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }           
    
    
    public static ImageIcon getItemCover(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Item_getItemCover(?)}");
       
        stmt.registerOutParameter(1, Types.BLOB);
        stmt.setInt(2, pId);
        stmt.execute();
        byte[] a = stmt.getBytes(1);
       
        ImageIcon r = new ImageIcon(a);
        ImageIcon resized_image =  new ImageIcon(r.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
        
        
        System.out.println(r.toString());     
        return resized_image;
    }
    
    public static String getItemBarcode(int pId) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Item_getItemBarcode(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }          
    
    public static int getItemItemType(int pId) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Item_getItemItemType(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    
    public static int getItemStatus(int pId) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Item_getItemStatus(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    public static int getItemPublisher(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Item_getItemPublisher(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }    
    
    
  //=============Tabla: ItemHasGenre ===========================================================================================================//////////////////////////////////////////
 //============================ Paquete ===================================================================================================================////////////////////////
        
    public static void insertItemHasGenre(int pItemId, int pGenreId) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_ItemHasGenre_InsertItemHasGenre(?,?)}");
        stmt.setInt(1, pItemId);
        stmt.setInt(2, pGenreId);
        stmt.execute();
            
    }
    
   public static void removeItemHasGenre(int pId) throws SQLException{ 

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_ItemHasGenre_RemoveItemHasGenre(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }    
    
    public static void updateItemHasGenre(int pItemId_old, int pItemId_new, int pGenreId) throws SQLException{

         
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_ItemHasGenre_UpdateItemHasGenre(?,?,?)}");
        stmt.setInt(1, pItemId_old);
        stmt.setInt(2, pItemId_new);
        stmt.setInt(3, pGenreId);
        stmt.execute();
            
    }
        
    public static int getItemHasGenreItemId(int pId) throws SQLException{      
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_ItemHasGenre_getItemHasGenreItemId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    public static int getItemHasGenreGenreId(int pId) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_ItemHasGenre_getItemHasGenreGenreId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    
//=============Tabla: ItemHasReview ===========================================================================================================//////////////////////////////////////////
 //============================ Paquete ===================================================================================================================////////////////////////
     
     public static void insertItemHasReview(int pItemId, int pReviewId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call control_ItemHasReview_InsertItemHasReview(?,?)}");
        stmt.setInt(1, pItemId);
        stmt.setInt(2, pReviewId);
        stmt.execute();
            
    }   
   public static void removeItemHasReview(int pId) throws SQLException{ 

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call control_ItemHasReview_RemoveItemHasReview(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }    
    
    public static void updateItemHasReview(int pItemId_old, int pItemId_new, int pReviewId) throws SQLException{

         
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call control_ItemHasReview_UpdateItemHasReview(?,?,?)}");
        stmt.setInt(1, pItemId_old);
        stmt.setInt(2, pItemId_new);
        stmt.setInt(3, pReviewId);
        stmt.execute();
            
    }
        
    public static int getItemHasReviewItemId(int pId) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_ItemHasReview_getItemHasReviewItemId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }
    
    public static int getItemHasReviewReviewId(int pId) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call control_ItemHasReview_getItemHasReviewReviewId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }    
    
    
//=============Tabla: ItemType ===========================================================================================================//////////////////////////////////////////
 //============================ Paquete ===================================================================================================================////////////////////////
    
    public static void insertItemType(String pName) throws SQLException{    
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_ItemType_InsertItemType(?)}");
        stmt.setString(1, pName);

        stmt.execute();
            
    }    
    
    public static void removeItemType(int pId) throws SQLException{ 
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_ItemType_RemoveItemType(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }    
    
    public static void updateItemType(int pItemId_old, String pName) throws SQLException{
         
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_ItemType_UpdateItemType(?,?)}");
        stmt.setInt(1, pItemId_old);
        stmt.setString(2, pName);
        stmt.execute();
            
    }    
    
    public static String getItemTypeName(int pId) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{? = call Control_ItemType_getItemTypeName(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
    }    
    
    public static int getItemTypeId(String pName) throws SQLException{
        
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_ItemType_getItemtypeId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, pName);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
    }    
    
    
        
    
    //=============Tabla: Person ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////
    
    
    
    public static void insertPerson(int pId, String pFirname, String pLasname, String pEmail, String pPassword, String pPhonenumber, String pDate, int pType) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Person_InsertPerson(?,?,?,?,?,?,?,?)}");
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
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Person_RemovePerson(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
        public static void updatePerson(int pId_old, String pFirname, String pLasname, String pEmail, String pPassword, String pPhonenumber, String pDate) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Person_UpdatePerson(?,?,?,?,?,?,?)}");
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
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person_getPersonId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, pEmail);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }
    
    public static int getPersonIdByNames(String pFirstName, String pLastName) throws SQLException{ 
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person_getPersonId2(?,?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, pFirstName);
        stmt.setString(3, pLastName);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }    
    
    
    
    
     public static String getPersonFirstName(int pId) throws SQLException{
  
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person_getPersonFirstName(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }   
    
    public static String getPersonLastName(int pId) throws SQLException{       
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person_getPersonLastName(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }  
    
    public static String getPersonEmail(int pId) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person_getPersonEmail(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }  
    
    //Función obsoleta:
    public static String getPersonPassword(int pId) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person_getPersonPassword(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }     
  
    public static String getPersonPhoneNumber(int pId) throws SQLException{
        
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person_getPersonPhoneNumber(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);
        stmt.execute();
        String r =  stmt.getString(1);

        System.out.println(r);
        return r; 

    }  
    
    public static Date getPersonBirthDay(int pId) throws SQLException{
        
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person_getPersonBirthDay(?)}");
       
        stmt.registerOutParameter(1, Types.DATE);
        stmt.setInt(2, pId);
        stmt.execute();
        Date r = stmt.getDate(1);
      
        System.out.println(r);
        return r; 

    }      
    
        
    public static int getPersonTypePersonId(int pId) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person_getPersonPersonType(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  
    
    
    //=============Tabla: Person1KnowsPerson2 ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////

    public static void insertPerson1KnowsPerson2(int pIdPerson1, int pIdPerson2, int pRelationType ) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Person1KnowsPerson2_InsertPer1KnowsPer2(?,?,?)}");
        stmt.setInt(1, pIdPerson1);
        stmt.setInt(2,pIdPerson2);
        stmt.setInt(3,pRelationType);


        stmt.execute();
     
    }

    
    public static void removePerson1KnowsPerson2(int pIdPerson1, int pIdPerson2) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Person1KnowsPerson2_RemovePer1KnowsPer2(?,?)}");
        stmt.setInt(1, pIdPerson1);
        stmt.setInt(2, pIdPerson2);
        
        stmt.execute();
     
    }   
    
    
    public static void updatePerson1KnowsPerson2(int pIdPerson1_old, int pIdPerson1, int pIdPerson2, int pRelationType ) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Person1KnowsPerson2_UpdatePer1KnowsPer2(?,?,?,?)}");
        stmt.setInt(1, pIdPerson1_old);
        stmt.setInt(2,pIdPerson1);
        stmt.setInt(3,pIdPerson2);
        stmt.setInt(4,pRelationType);

        stmt.execute();
     
    }
    
    public static int getPerson1KnowsPerson2Person1Id(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person1KnowsPerson2_getPer1KnowsPer2Person1Id(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }      
    
    
    public static int getPerson1KnowsPerson2Person2Id(int pId) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person1KnowsPerson2_getPer1KnowsPer2Person2Id(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }      

    public static int getPerson1KnowsPerson2RelationTypeId(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Person1KnowsPerson2_getPer1KnowsPer2RelTypeId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }          
    
    //=============Tabla: PersonCreatesItem ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    
    
   public static void insertPersonCreatesItem(int pIdPerson, int pIdItem) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonCreatesItem_InserPersonCreatesItem(?,?)}");
        stmt.setInt(1, pIdPerson);
        stmt.setInt(2,pIdItem);


        stmt.execute();
     
    }
    
    public static void removePersonCreatesItem(int pIdPerson, int pIdItem) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonCreatesItem_RemovePersonCreatesItem(?,?)}");
        stmt.setInt(1, pIdPerson);
        stmt.setInt(2, pIdItem);
        stmt.execute();
     
    }   
    
   public static void updatePersonCreatesItem(int pIdPerson_old, int pIdPerson_new, int pIdItem) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonCreatesItem_UpdatePersonCreatesItem(?,?,?)}");
        stmt.setInt(1, pIdPerson_old);
        stmt.setInt(2,pIdPerson_new);
        stmt.setInt(3,pIdItem);


        stmt.execute();
     
    }
        
    public static int getPersonCreatesItemPersonId(int pIdItem) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonCreatesItem_getPersonCreatesItemPersonId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pIdItem);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     
    
    public static int getPersonCreatesItemItemId(int pIdPerson) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonCreatesItem_getPersonCreatesItemItemId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pIdPerson);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }         
    
    //=============Tabla: PersonHasItem ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    
        
   public static void insertPersonHasItem(int pIdPerson, int pIdItem) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonHasItem_InsertPersonHasItem(?,?)}");
        stmt.setInt(1, pIdPerson);
        stmt.setInt(2,pIdItem);


        stmt.execute();
     
    }    
    
    public static void removePersonHasItem(int pIdPerson, int pIdITem) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonHasItem_RemovePersonHasItem(?, ?)}");
        stmt.setInt(1, pIdPerson);
        stmt.setInt(2, pIdITem);
         
        stmt.execute();
     
    }   
    
   public static void updatePersonHasItem(int pIdPerson_old, int pIdPerson_new, int pIdItem) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonHasItem_UpdatePersonHasItem(?,?,?)}");
        stmt.setInt(1, pIdPerson_old);
        stmt.setInt(2,pIdPerson_new);
        stmt.setInt(3,pIdItem);


        stmt.execute();
     
    }
        
    public static int getPersonHasItemPersonId(int pIdItem) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonHasItem_getPersonHasItemPersonId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pIdItem);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     
    
    public static int getPersonHasItemItemId(int pIdPerson) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonHasItem_getpersonhasitemItemId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pIdPerson);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }   
    
    
    
    //=============Tabla: PersonLendItem ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    
       
   public static void insertPersonLendItem(int pIdPerson1,int pIdPerson2, int pIdItem, String pReturnDate, int pToleranceDaysYellow, int pToleranceDaysRed) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonLendItem_InsertPersonLendItem(?,?,?,?,?,?)}");
        stmt.setInt(1, pIdPerson1);
        stmt.setInt(2,pIdPerson2);
        stmt.setInt(3, pIdItem);
        stmt.setString(4,pReturnDate);
        stmt.setInt(5,pToleranceDaysYellow);
        stmt.setInt(6,pToleranceDaysRed);

        stmt.execute();
     
    }        
    
    
   public static void removePersonLendItem(int pItem) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonLendItem_RemovePersonLendItem(?)}");
        stmt.setInt(1, pItem);
    

        stmt.execute();
     
    }            
    
public static void updatePersonLendItem(int ppersonid1_old, int ppersonid1_new,int ppersonid2_old,int ppersonid2_new, int pitem_id, String plend_date, String preturn_date, int ptoleranceDaysYellow, int ptoleranceDaysRed ) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonLendItem_UpdatePersonLendItem(?,?,?,?,?,?)}");
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
        con = (Connection)DriverManager.getConnection(url, user, pass);
       
        CallableStatement stmt = con.prepareCall("{ call Control_PersonLendItem_UpdatePersonLenItemRetDate(?,?,?)}");
        stmt.setInt(1, pperson1_id);
        stmt.setInt(2,pperson2_id);
        stmt.setDate(3, preturn_date);


        stmt.execute();       
    } 


    
    public static int getPersonLendItemPerson1Id(int pPerson2id ,int pIdItem) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonLendItem_getPersonLendItemPerson1Id(?,?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pPerson2id);
         stmt.setInt(3, pIdItem);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     

    public static int getPersonLendItemPerson2Id(int pPerson1id ,int pIdItem) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonLendItem_getPersonLendItemPerson2Id(?,?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pIdItem);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }     

    public static int getPersonLendItemItemId(int pPerson1id ,int pPerson2id) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonLendItem_getPersonLendItemItemId(?,?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }       
    
    public static Date getPersonLendLendDate(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonLendItem_getPersonLendItemLendDate(?,?,?)}");
       
        stmt.registerOutParameter(1, Types.DATE);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.execute();
        
        Date r = stmt.getDate(1);
        System.out.println(r);
        return r;
   

    }      
    
    public static Date getPersonLendReturnDate(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonLendItem_getPersonLendItemReturnDate(?,?,?)}");
       
        stmt.registerOutParameter(1, Types.DATE);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.execute();
        
        Date r = stmt.getDate(1);
        System.out.println(r);
        return r;
   

    }       
   
    public static int getPersonLendAmountDays(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonLendItem_getPersonLendItemAmountDays(?,?,?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pPerson1id);
        stmt.setInt(3, pPerson2id);
        stmt.setInt(4, pItemid);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }      

    public static int getPersonLendToleranceDaysYellow(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonLendItem_getPersonLendItemToleranceYellow(?,?,?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  


    public static int getPersonLendToleranceDaysRed(int pPerson1id ,int pPerson2id, int pItemid) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonLendItem_getPersonLendItemToleranceRed(?,?,?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pPerson1id);
         stmt.setInt(3, pPerson2id);
        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    
    //=============Tabla: PersonType ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    




    public static void insertPersonType(String pName) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonType_InsertPersonType(?)}");
        stmt.setString(1, pName);


        stmt.execute();
     
    }    
    
    public static void removePersonType(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonType_RemovePersonType(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updatePersonType(int pId, String pName) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_PersonType_UpdatePersonType(?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);



        stmt.execute();
     
    }

    public static int getPersonTypeId(String pName) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonType_getPersonTypeId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, pName);

        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static String getPersonTypeName(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_PersonType_getPersonTypeName(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);

        stmt.execute();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    }  
    
    
//=============Tabla: PersonType ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////       
    
    public static void insertPublisher(String pName) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Publisher_InsertPublisher(?)}");
        stmt.setString(1, pName);
        

        stmt.execute();
     
    }    
    
    public static void removePublisher(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Publisher_RemovePublisher(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updatePublisher(int pId, String pName) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Publisher_UpdatePublisher(?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);

        stmt.execute();
     
    }

    public static int getPublisherId(String pName) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Publisher_getPublisherId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, pName);

        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static String getPublisherName(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Publisher_getPublisherName(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);

        stmt.execute();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    }  
        
//=============Tabla: RelationType ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////        
    
    public static void insertRelationType(String pName) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_RelationType_InsertRelationType(?)}");
        stmt.setString(1, pName);


        stmt.execute();
     
    }    
    
    public static void removeRelationType(int pId) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_RelationType_RemoveRelationType(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updateRelationType(int pId, String pName) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_RelationType_UpdateRelationType(?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);



        stmt.execute();
     
    }

    public static int getRelationTypeId(String pName) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_RelationType_getRelationTypeId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, pName);

        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static String getRelationTypeName(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_RelationType_getRelationTypeName(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);

        stmt.execute();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    } 
    
//=============Tabla: Review ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    

    public static void insertReview(String pName) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Review_InsertReview(?)}");
        stmt.setString(1, pName);


        stmt.execute();
     
    }    
    
    public static void removeReview(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Review_RemoveReview(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updateReview(int pId, String pName) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Review_UpdateReview(?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);



        stmt.execute();
     
    }

    public static int getReviewId(int pStars) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Review_getReviewId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pStars);

        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static int getReviewStars(int pId) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Review_getReviewStars(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setInt(2, pId);

        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    } 

//=============Tabla: Status ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    


    public static void insertStatus(String pName, String pDescription) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Status_InsertStatus(?,?)}");
        stmt.setString(1, pName);
        stmt.setString(2, pDescription);

        stmt.execute();
     
    }    
    
    public static void removeStatus(int pId) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Status_RemoveStatus(?)}");
        stmt.setInt(1, pId);

        stmt.execute();
     
    }   
    
   public static void updateStatus(int pId, String pName, String pDescription ) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_Status_UpdateStatus(?,?,?)}");
        stmt.setInt(1, pId);
        stmt.setString(2,pName);
        stmt.setString(3,pDescription);


        stmt.execute();
     
    }

    public static int getStatusId(String pName) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Status_getStatusId(?)}");
       
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, pName);

        stmt.execute();
        
        int r = stmt.getInt(1);
        System.out.println(r);
        return r;
   

    }  

    public static String getStatusName(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{? = call Control_Status_getStatusName(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);

        stmt.execute();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    } 


    public static String getStatusDescription(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ ? = call Control_Status_getStatusDescription(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, pId);

        stmt.execute();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    } 
    
    
    
//=============Paquete: Loan_History  ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////      
    

   public static void insertLoanHistory(int pIdPerson1,int pIdPerson2, int pIdItem, String pReturnDate, int pToleranceDaysYellow, int pToleranceDaysRed) throws SQLException{  
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call Control_LoanHistory_InsertLoanHistory(?,?,?,?,?,?)}");
        stmt.setInt(1, pIdPerson1);
        stmt.setInt(2,pIdPerson2);
        stmt.setInt(3, pIdItem);
        stmt.setString(4,pReturnDate);
        stmt.setInt(5,pToleranceDaysYellow);
        stmt.setInt(6,pToleranceDaysRed);

        stmt.execute();
     
    }        
    
    

    
//=============Paquete: UserInterface ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////   

   
       public static String EncryptPassword(String pPassword) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{? = call EncryptPassword(?)}");
       
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setString(2, pPassword);

        stmt.execute();
        
        String r = stmt.getString(1);
        System.out.println(r);
        return r;
   

    } 

   
    public static ResultSet getCollection(int pId) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetCollection(?)}");

        stmt.setInt(1, pId);
        stmt.execute();
        
        
        ResultSet r = stmt.getResultSet();      
        System.out.println(r.toString());
        return r;
        
        }
       
   
    public static ResultSet getPublishers() throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetPublishers()}");

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();    
        System.out.println(r.toString());
        return r;
        
        }
    
    public static ResultSet getItemTypes() throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{ call UserInterface_Queries_GetItemTypes()}");
       
        stmt.execute();
        ResultSet r = stmt.getResultSet();    

        System.out.println(r.toString());
        return r;
        
        }
 
    public static ResultSet getGenres() throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetGenres()}");
       
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();    
        System.out.println(r.toString());
        return r;
        
        }    
    

    
    public static ResultSet getGenresWithDescription() throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetGenresWithDescription()}");
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();    
        System.out.println(r.toString());
        return r;
        
        }        
    
    public static ResultSet getRelationTypes() throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetRelationTypes()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }    

    
    public static ResultSet getStatus() throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetStatus()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }  
    
    public static ResultSet getAuthors() throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetAuthors()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }  

    
    public static ResultSet getKnownPeople(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetKnownPeople(?)}");
       
        
        stmt.setInt(1, pId);
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }        
    
    
    public static ResultSet getItems(int pId) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetItems(?)}");
       
        
        stmt.setInt(1, pId);
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }        
    
    public static ResultSet getLendedItems(int pId) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetLendedItems(?)}");
       
        
        stmt.setInt(1, pId);
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        } 
    
    
    
    public static ResultSet getCollectionWithNoReviews(int pId) throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_GetCollectionNoReviews(?)}");
       
        
        stmt.setInt(1, pId);
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }     
    
    public static ResultSet updateToleranceDays(int pId) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call UserInterface_Queries_UpdateToleranceDays(?)}");
       
        
        stmt.setInt(1, pId);
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }         
    
    //=============Tabla: Admin Queries ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    
    
    public static ResultSet AdminNotBorrowed() throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Admin_Queries_NotBorrowed()}");
       
        
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }      
    

    public static ResultSet AdminNotBorrowedTotal() throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Admin_Queries_NotBorrowedTotal()}");
       
        
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }     
    
    
    public static ResultSet AdminTopMostBorrowed(int pTop) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Admin_Queries_TopMostBorrowed(?)}");
       
        
        stmt.setInt(1, pTop);
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }        
    
    public static ResultSet AdminMostBorrowedPerMonth(int pTimes, int pMonths) throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Admin_Queries_TopMostBorrowedPerMonth(?,?)}");
       
        
        stmt.setInt(1, pTimes);
        stmt.setInt(2, pMonths);
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }    
    
    public static ResultSet AdminAgeOfPeopleLoan() throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Admin_Queries_AgeOfPeopleLoan()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }        
    
//=============Tabla: Statistics ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////        
    
   
    public static ResultSet StatisticTotalItemsByGenre() throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Statistics_Queries_TotalItemsPerGenre()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }       
    
    
    
    public static ResultSet StatistictotalLendedItemsNow() throws SQLException{

        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Statistics_Queries_TotalLendedItemsNow()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }   
    
    
    public static ResultSet StatistictotalLendedItems() throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Statistics_Queries_TotalLendedItems()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }   
    
    public static ResultSet StatistictotalLendedItemsByGenre() throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Statistics_Queries_TotalLendedItemsPerGenre()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }     
    
    public static ResultSet StatistictotalLendedItemsByAge() throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Statistics_Queries_TotalLendedItemAge()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }         
    
//=============Tabla: User Queries ===========================================================================================================//////////////////////////////////////////
    //============================ Paquete ===================================================================================================================////////////////////////    
    
    
    
 public static ResultSet UserAllItemsTotal() throws SQLException{

        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Users_Queries_AllItemsTotal()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }       
    
    
 public static ResultSet UserAllLendedItemsTotal() throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Users_Queries_AllLendedItemsTotal()}");
       
        

        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }        
    
 public static ResultSet UserAllItems(String pTitle, String pAuthorFirstName, String pAuthorLastName, String pPublisher ) throws SQLException{
        
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call Users_Queries_AllItems(?,?,?,?)}");
       
        
        stmt.setString(1, pTitle);
        stmt.setString(2, pAuthorFirstName);
        stmt.setString(3, pAuthorLastName);
        stmt.setString(4, pPublisher);

        
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }        
    
 public static ResultSet UserAllLendedItems(String pFirstName, String pLastName, String pNumberDays, String pToleranceYellow, String pToleranceRed, String pStatus ) throws SQLException{
        con = (Connection)DriverManager.getConnection(url, user, pass);
        CallableStatement stmt = con.prepareCall("{call User_Queries_AllLendedItems(?,?,?,?,?,?)}");
       
        
        stmt.setString(1, pFirstName);
        stmt.setString(2, pLastName);
        stmt.setString(3, pNumberDays);
        stmt.setString(4, pToleranceYellow);
        stmt.setString(5, pToleranceRed);
        stmt.setString(6, pStatus);
        
        stmt.execute();
        
        ResultSet r = stmt.getResultSet();  
        System.out.println(r.toString());
        return r;
        
        }        
        
    
    
    
    
    
    
    
    
    
    
    
}
