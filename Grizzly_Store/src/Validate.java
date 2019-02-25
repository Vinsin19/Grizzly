import java.sql.*;
import javax.servlet.annotation.*;

public class Validate
 {
     public static boolean checkUser(String usernme,String passwrd) 
     {
      boolean st =false;
      try{

         Class.forName("com.mysql.jdbc.Driver");

 	     Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/grizzly_store","root","password-1");
         PreparedStatement ps =con.prepareStatement
                             ("select * from log_det where Username=? and Password=?");
         ps.setString(1, usernme);
         ps.setString(2, passwrd);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}