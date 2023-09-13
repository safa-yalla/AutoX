<%-- 
    Document   : index
    Created on : May 31, 2022, 11:46:07 AM
    Author     : Safa Nadeem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AutoX</title>
    <body>

    <c:if test="${not empty message}">
        <h1>Welcome ${message}</h1>
    </c:if>  

    <form method="post" action="register.jsp">  
    </form>
    <img src="images/lineup.jpeg" style="width:100%">

    <div class="container">
        <center>
            <h2>Manage your vehicles quickly and efficiently using AutoX, your cars' new best friend!</h2>
            <h3 style="text-align:  left;">Access our services:</h3>
        </center>
        <div class="buttons">
            <h3><a href="register.jsp" style=" color:lightblue;">Register a Vehicle</a></h3>
            <h3>    <a href="seeMine.jsp"style=" color:lightblue;">See My Vehicles</a></h3>
            <h3>    <a href="insurance.jsp"style=" color:lightblue;">Insurance Maintenance</a></h3>
        </div>
    </div>
    <%@ include file="footer.jsp" %>

</body>
</html>

