<%-- 
    Document   : loginerror
    Created on : 2017-04-11, 19:26:33
    Author     : Dominik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@ page session="true"%>
        <% session.invalidate(); %>

        
        Bledne dane.<br> 
        <a href="../index.jsp" >Powrot</a>
    </body>
</html>
