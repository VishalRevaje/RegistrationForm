<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Certificate</title>
    <style>
        .certificate {
            text-align: center;
            margin-top: 50px;
            font-family: 'Georgia', serif;
            border: 3px solid #4CAF50;
            padding: 20px;
            width: 80%;
            margin: auto;
        }
        .certificate h1 {
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <div class="certificate">
        <h1>Certificate of Registration</h1>
        <p>Congratulations, <strong><%= request.getAttribute("name") %></strong>!</p>
        <p>You have successfully been registered as an employee in our system.</p>
    </div>
</body>
</html>