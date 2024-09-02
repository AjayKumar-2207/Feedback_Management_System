<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #ffffff;
        }
    
    h1 {
        color: #343a40;
        margin-bottom: 20px;
    }
    
    .container {
        max-width: 700px;
        margin: 50px auto;
        padding: 30px;
        
        background: linear-gradient(to right, #343a40, #ffffff); 
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        text-align: center;
    }
    
    p {
        color: #495057;
        font-size: 1.1em;
        margin-bottom: 30px;
    }
    
    .nav-links {
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 15px;
    }
    
    a {
        display: inline-block;
        padding: 12px 25px;
        text-decoration: none;
        color: #ffffff;
        background-color: #007bff;
        border-radius: 5px;
        font-size: 1.1em;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }
    
    a:hover {
        background-color: #0056b3;
        transform: translateY(-2px);
    }
    
    a:active {
        background-color: #004494;
        transform: translateY(0);
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Operation Successful</h1>
        <p>Your request has been processed successfully.</p>
        
        <div class="nav-links">
            <a href="submitFeedback.jsp">Submit Feedback</a>
            <a href="viewFeedback.jsp">View Feedback</a>
            <a href="updateFeedback.jsp">Update Feedback</a>
            <a href="deleteFeedback.jsp">Delete Feedback</a>
        </div>
    </div>
</body>
</html>
