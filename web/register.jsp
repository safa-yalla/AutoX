<%-- 
    Document   : register.jsp
    Created on : May 29, 2022, 4:26:16 PM
    Author     : Safa Nadeem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AutoX</title>
    </head>
    <body>

<h2>Enter details to register your vehicle</h2>

<form action="<%=request.getContextPath()%>/register" method="post">
    <div align="center">

        <table style="color:white;">

            <tr>
                <td>Vin Number</td>
                <td><input type="text" name="vin_no" /></td>
            </tr>
            <tr>
                <td>Plate Number</td>
                <td><input type="text" name="plate_no" /></td>
            </tr>
            <tr>
                <td>Manufacturer</td>
                <td><input type="text" name="manufacturer" /></td>
            </tr>
            <tr>
                <td>Model</td>
                <td><input type="text" name="model_no" /></td>
            </tr>
            <tr>
                <td>Registration date(yyyy/MM/dd)</td>
                <td><input type="text" name="reg_date" /></td>
            </tr>
        </table>
        <div class="button">
            <input type="submit" value="Submit" /></div>
    </div>
</form>
<c:if test="${not empty message}">
    <center><h3>${message}</h3>
    <a href="loginApp.jsp">Log in</a>
    <a href="signUp.jsp">Sign up</a></center>
</c:if> 
    <%@ include file="footer.jsp" %>

</body>
</html>
