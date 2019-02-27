import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class dao {
	
	
	public Connection myconnection()
	{
		try{
			 Class.forName("com.mysql.jdbc.Driver");


		//  Database credentials
			final String USER = "root";
			final String PASS = "password-1";
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			final String DB_URL = "jdbc:mysql://localhost:3306/grizzly_store";
		
			Connection conn = null;
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			return conn;
		
	}
		
		catch(SQLException | ClassNotFoundException se)
		{
		    se.printStackTrace();

		} 

		Connection con = null;
		return con;
		
}
	
	public void addproduct(String p_id,String cat,String name,String desc,String price,String rating) throws SQLException
	{
		String sql = "INSERT INTO product(p_id,category,name,description,price,rating) VALUES(?,?,?,?,?,?);";
		Connection d = myconnection();
		PreparedStatement pstmt = d.prepareStatement(sql);
		pstmt.setString(1, p_id);
		pstmt.setString(2, cat);
		pstmt.setString(3, name);
		pstmt.setString(4, desc);
		pstmt.setString(5,price);
		pstmt.setString(6,rating);
		
		System.out.println(pstmt.toString());
		pstmt.executeUpdate();
	}
}