package test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UpdateFeedbackServlet
 */
@WebServlet("/UpdateFeedbackServlet")
public class UpdateFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            PrintWriter out = response.getWriter();
            
            try {
                // Establish a connection to the database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay", "root", "Ajay@2004");
                
                // Retrieve parameters from the request
                int feedbackId = Integer.parseInt(request.getParameter("feedback_id"));
                String message = request.getParameter("message");
                
                // Prepare SQL statement to update feedback message
                String sql = "UPDATE Feedback SET message = ? WHERE feedback_id = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, message);
                ps.setInt(2, feedbackId);
                
                // Execute the update operation
                int rowsAffected = ps.executeUpdate();
                
                if (rowsAffected > 0) {
                    // Forward to success page if update was successful
                    RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                    rd.forward(request, response);
                } else {
                    // Notify if no rows were affected
                    out.println("No feedback entry found with the provided ID");
                }
                
                // Close the connection
                con.close();
            } catch (SQLException e) {
                // Handle SQL errors
                e.printStackTrace();
                out.println("Database error occurred");
            }
        } catch (ClassNotFoundException e) {
            // Handle class not found error
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            out.println("Internal server error occurred");
        }
    }
}
