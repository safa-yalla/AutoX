<%-- 
    Document   : signUp
    Created on : May 30, 2022, 2:02:07 PM
    Author     : Safa Nadeem
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>

        <h2>Enter your details</h2>

        <form action="<%=request.getContextPath()%>/signUp" method="post">
            <div align="center">

                <table style="color:white;">

                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="f_name" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="l_name" /></td>
                    </tr>
                    <tr>
                        <td>Nationality</td>
                        <td><input type="text" name="nationality" /></td>
                    </tr>
                    <td>Username</td>
                    <td><input type="text" name="username" /></td>
                    </tr>
                    </tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                    </tr>
                </table>
                <input type="submit" value="Submit" />
            </div>
        </form>
    <c:if test="${not empty message}">
        <center><h3>${message}</h3></center>

    </c:if> 
    <%@ include file="footer.jsp" %>

</body>
</html>
