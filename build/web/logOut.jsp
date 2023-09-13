<%-- 
    Document   : logOuy
    Created on : Jun 2, 2022, 9:27:31 PM
    Author     : Safa Nadeem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AutoX</title>
    </head>
    <body>
        <%
            HttpSession sess = request.getSession();

            if (sess.getAttribute("username") == null){
                System.out.print("Already logged out");
                response.sendRedirect("index.jsp");
            }
            else {
                sess.setAttribute("username", null);
                sess.invalidate();
                response.sendRedirect("index.jsp");
            }
        %>    </body>
</html>
