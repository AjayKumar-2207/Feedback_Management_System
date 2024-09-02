package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String customerId = request.getParameter("customer_id");
        String message = request.getParameter("message");

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay", "root", "Ajay@2004");

            // Prepare SQL statement to update feedback
            String sql = "UPDATE Feedback SET message=? WHERE customer_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, message);
            ps.setInt(2, Integer.parseInt(customerId));
            int result = ps.executeUpdate();

            // Check if the update was successful
            if (result > 0) {
                RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response);
            } else {
                out.println("No feedback found with the given Customer ID");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Database error occurred");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("Internal server error occurred");
        } finally {
            out.close();
        }
    }
}
