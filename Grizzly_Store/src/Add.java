import java.io.IOException;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
@WebServlet("/Add_prod") 

public class Add extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        
        String productid = request.getParameter("prod_id");
        String category = request.getParameter("prod_cat");
        String productname = request.getParameter("prod_name");
        String description = request.getParameter("prod_desc");
        String price  = request.getParameter("prod_price");
        String rating = request.getParameter("prod_rating");
        PrintWriter out  = response.getWriter();
        
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost:3306/grizzly_store";
         try{
             Class.forName("com.mysql.jdbc.Driver");

            final String USER = "root";
            final String PASS = "password-1";
        
            Connection conn = null;
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

         String sql;
         sql ="SELECT name FROM product WHERE name= ?";   
         PreparedStatement pstmt = conn.prepareStatement(sql);
         
        pstmt.setString(1,productname);
       
        
        ResultSet rs = pstmt.executeQuery();
        boolean data  = rs.next();
        if(data)
        {
            HttpSession session=request.getSession();
            response.sendRedirect("Product.jsp");
            out.print("already present");
            session.setAttribute("Msg","Already Present");
        }
        else
        {
           dao d = new dao();
           d.myconnection();
            System.out.println("In Dao");
            d.addproduct(productid,category,productname,description,price,rating);
            System.out.println("Added Sucesss");
            HttpSession session=request.getSession();
            System.out.println("Session ok");
            response.sendRedirect("Product.jsp");
            System.out.println("Redirect ok");
            out.println("<script>");
             out.println("alert('Sucess');");
             
               out.println("</script>");
            session.setAttribute("sucess","Product " + productname + "added sucessfully");
        }

    }   
    catch(SQLException | ClassNotFoundException se)
    {
        se.printStackTrace();
        out.print(se.getMessage());
    }
        
    }

}

    
     