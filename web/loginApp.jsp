<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>AutoX</title>
        <link href="styles/app.css" rel="stylesheet" type="text/css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Comfortaa:wght@300&family=Gentium+Plus&family=Maven+Pro&display=swap" rel="stylesheet">

    </head>
    <body>
<h1>AutoX</h1>
        <h3>Vehicle Management System</h3>
        <div align="center">
            <div className="nav_left">
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
            </div>
        </li>
    </ul>
    <h2>All your vehicles in one place</h2>

    <form action="<%=request.getContextPath()%>/loginApp" method="post">
        <table style="color:white;">
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
    <c:if test="${not empty message}">
        <center><h3>${message}<br>Please sign up first</h3></center>
        <a href="signUp.jsp">Sign up</a>
    </c:if> 
</div>
</div>
<div style="background-color: #242526;margin-top: 300px;">
    <center>
        <p>Contact us:<br><a href='mailto:safas1@amitydubai.ae' style=" color:lightblue;">Safa Silat</a></p></center>
</div>
</body>
</html>