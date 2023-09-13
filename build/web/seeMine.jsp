<%-- 
    Document   : mine
    Created on : Jun 4, 2022, 9:50:37 PM
    Author     : Safa Nadeem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AutoX</title>
        
    </head>
    <body>

        <h2>Your vehicles:</h2>
                <div align="center">

            <%
                Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/electronics?useSSL=false","root","Safnad2212");
                Statement statement = connection.createStatement() ;
                HttpSession sess = request.getSession(false); //use false to use the existing session
        String uname = (String) sess.getAttribute("username");
                ResultSet resultset =
                statement.executeQuery("select * from registered where uname ='"+uname+"'") ;
                
            %>
                <table cellpadding="5" cellspacing="5" border="1"style="color:white;background-color: #242526;">

		<tr>
			<th>Username</th>
                        <th>Vin Number</th>
			<th>Plate number</th>
                        <th>Manufacturer</th>
			<th>Model Number</th>
                        <th>Registration Date</th>
                        <th>Expiration Date</th>
			

		</tr>
           <% while(resultset.next()){ %>
           <TR>
                <TD> <%= resultset.getString(1) %></td>
               <TD> <%= resultset.getString(2) %></TD>
               <TD> <%= resultset.getString(3) %></TD>
               <TD> <%= resultset.getString(4) %></TD>
               <TD> <%= resultset.getString(5) %></TD>
               <TD> <%= resultset.getString(6) %></TD>
               <TD> <%= resultset.getString(7) %></TD>
          </TR>
           <% } %>
               </TABLE>
                </div>
        <%@ include file="footer.jsp" %>

    </body>
</html>
