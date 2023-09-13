<%-- 
    Document   : header.jsp
    Created on : Jul 5, 2022, 2:36:19 PM
    Author     : Safa Nadeem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>AutoX</title>
         <link href="styles/app.css" rel="stylesheet" type="text/css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Comfortaa:wght@300&family=Gentium+Plus&family=Maven+Pro&display=swap" rel="stylesheet">

    </head>
    <body>
        <h1>AutoX</h1>
        <h3>Vehicle Management System</h3>
        <ul>
            <li><a class="active" href="/Vehicle_Management">Home</a></li>
            <li><a href="about.jsp">About</a></li>
            <li class="dropdown">
                <a href="#" class="dropbtn">Features</a>
                <div class="dropdown-content">
                    <a href="register.jsp">Register a Vehicle</a>
                    <a href="seeMine.jsp">See My Vehicles</a>
                    <a href="insurance.jsp">Insurance Maintenance</a>
                </div>
            <li style="float:right;"><a href="loginApp.jsp">Log in</a></li>
            <li style="float:right;"><a href="logOut.jsp">Log out</a></li>
            <li style="float:right;"><a href="signUp.jsp">Sign up</a></li>
        </li>
    </ul>
    </body>
</html>
