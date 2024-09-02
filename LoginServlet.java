package test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PrintWriter out=response.getWriter();
            
            
            try {
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","Ajay@2004");
                
                String userName=request.getParameter("userName"); // Changed parameter name
                String password=request.getParameter("password"); // Changed parameter name
                PreparedStatement ps=con.prepareStatement("select * from ajay where username=? and password=?");
                ps.setString(1, userName);
                ps.setString(2, password);
                ResultSet rs= ps.executeQuery();
                if(rs.next()) {
                    RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
                    rd.forward(request,response);
                } else {
                    // Redirect to an error page or display an error message
                    out.println("Invalid username or password");
                }
            } catch (SQLException e) {
                // Handle database connection or query errors
                e.printStackTrace();
                // Redirect to an error page or display an error message
                
                out.println("Database error occurred");
            }  
            
            
            
            
        } catch(ClassNotFoundException e) {
            // Handle class not found exception
            e.printStackTrace();   
            // Redirect to an error page or display an error message
            PrintWriter out=response.getWriter();
            out.println("Internal server error occurred");
        }
    }
}

