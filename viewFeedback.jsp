<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Policies</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #4CAF50, #3366FF);
    margin: 0;
    padding: 0;
  }

  h1 {
    text-align: center;
    margin-top: 50px;
    color: #fff;
  }

  form {
    width: 300px;
    margin: 0 auto;
    text-align: center;
    margin-top: 50px;
  }

  input[type="submit"] {
    background-color: #fff;
    color: #3366FF;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }

  input[type="submit"]:hover {
    background-color: #4CAF50;
    color: #fff;
  }

  table {
    width: 80%;
    margin: 20px auto;
    border-collapse: collapse;
  }

  th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }

  tr:hover {
    background-color: #f5f5f5;
  }

  .highlight {
    background-color: #ffc107; /* Yellow */
  }
  a{
  style-type:none;
  }
#sanju{
text-align:center;
}

</style>
</head>
<body>
<div id='sanju'>
<h1>View Feedbacks</h1>

<form action="ViewServlet" method="get">
  <input type="submit">
</form>
</div>
 
            
</body>
</html>
