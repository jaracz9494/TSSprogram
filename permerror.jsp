<%-- 
    Document   : permerror
    Created on : 2017-05-24, 14:39:02
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
        
        <h1>403</h1>
        
        Brak uprawnień.<br> 
        <a href="../index.jsp" >Powrot</a>
    </body>
</html>
