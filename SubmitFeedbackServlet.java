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
 * Servlet implementation class SubmitFeedbackServlet
 */
@WebServlet("/SubmitFeedbackServlet")
public class SubmitFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay", "root", "Ajay@2004");
            
            // Retrieve parameters from the request
            int customerId = Integer.parseInt(request.getParameter("customer_id"));
            String message = request.getParameter("message");
            
            // Prepare SQL statement to insert feedback
            String sql = "INSERT INTO Feedback (customer_id, message) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.setString(2, message);
            
            // Execute the insert operation
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                // Forward to success page if insert was successful
                RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response);
            } else {
                // Notify if the insert failed
                out.println("Error occurred while submitting feedback");
            }
            
            // Close the connection
            con.close();
        } catch (SQLException e) {
            // Handle SQL errors
            e.printStackTrace();
            out.println("Database error occurred: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Handle class not found error
            e.printStackTrace();
            out.println("Internal server error occurred: " + e.getMessage());
        } finally {
            out.close();
        }
    }
}
