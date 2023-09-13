<%-- 
    Document   : insurance
    Created on : Jun 5, 2022, 5:48:15 PM
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
        <h2>Enter your insurance details: </h2>

        <form action="<%=request.getContextPath()%>/insurance" method="post">
            <div align="center">

                <table style="color:white;">

                    <tr>
                        <td>Vin Number</td>
                        <td><input type="text" name="vin_no" /></td>
                    </tr>
                    <tr>
                        <td>Policy Number</td>
                        <td><input type="text" name="policy_no" /></td>
                    </tr>
                    <tr>
                        <td>Type of Insurance</td>
                        <td><input type="text" name="type_of_insurance" /></td>
                    </tr>
                    <td>Issue date (yyyy/MM/dd)</td>
                    <td><input type="text" name="issue_date" /></td>
                    </tr>
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
