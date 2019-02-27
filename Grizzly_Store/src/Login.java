import java.io.*;
import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/login")
public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String usernme = request.getParameter("usernme");
        String passwrd = request.getParameter("passwrd");
        
        if(Validate.checkUser(usernme, passwrd))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Product.jsp");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("Index.Html");
           rs.include(request, response);
        }
    }  
}