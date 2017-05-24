<%-- 
    Document   : logout
    Created on : 2017-05-07, 17:54:12
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

Uzytkownik '<%=request.getRemoteUser()%>' został pomyślnie wylogowany.

<% session.invalidate(); %>

<br/><br/>
<a href="index.jsp">Wciśnij aby wrócić</a>
    </body>
</html>
