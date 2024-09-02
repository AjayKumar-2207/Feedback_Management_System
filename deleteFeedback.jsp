<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Feedback</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #00c6ff, #0072ff);
        margin: 0;
        padding: 0;
    }
    
    .container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }
    
    h2 {
        text-align: center;
        color: #343a40;
    }
    
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    
    input[type="text"], input[type="submit"] {
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ddd;
        border-radius: 4px;
        width: 100%;
    }
    
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
    }
    
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    
    .action-links {
        text-align: center;
        margin-top: 20px;
    }
    
    .action-links a {
        margin: 0 10px;
        padding: 10px 20px;
        text-decoration: none;
        color: #ffffff;
        background-color: #007bff;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }
    
    .action-links a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Delete Feedback</h2>
        <form action="DeleteServlet" method="post">
            <label for="customer_id">Customer ID:</label>
            <input type="text" id="customer_id" name="customer_id" required>
            <input type="submit" value="Delete Feedback">
        </form>
        <div class="action-links">
            <a href="submitFeedback.jsp">Submit New Feedback</a>
            <a href="updateFeedback.jsp">Update Feedback</a>
            <a href="viewFeedback.jsp">View Feedback</a>
        </div>
    </div>
</body>
</html>
