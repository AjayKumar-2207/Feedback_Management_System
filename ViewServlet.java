package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay", "root", "Ajay@2004");
            
            // Prepare SQL statement to retrieve feedback
            PreparedStatement ps = con.prepareStatement("SELECT customer_id, message FROM Feedback");
            ResultSet rs = ps.executeQuery();
            
            // Generate HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Feedback Records</title>");
            out.println("<style>");
            out.println("table {");
            out.println("  width: 80%;");
            out.println("  margin: 20px auto;");
            out.println("  border-collapse: collapse;");
            out.println("}");
            out.println("th, td {");
            out.println("  padding: 8px;");
            out.println("  text-align: left;");
            out.println("  border-bottom: 1px solid #ddd;");
            out.println("}");
            out.println("tr:hover {");
            out.println("  background-color: #f5f5f5;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Feedback Records</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>Customer ID</th><th>Message</th></tr>");
            
            // Iterate over result set and print rows
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("customer_id") + "</td>");
                out.println("<td>" + rs.getString("message") + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("<a href=\"success.jsp\">Return to Main Page</a>");
            out.println("</body>");
            out.println("</html>");
            
            // Close the connection
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Database error occurred: " + e.getMessage());
        }
    }
}
