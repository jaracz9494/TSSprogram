<%-- 
    Document   : change
    Created on : 2017-05-24, 15:54:43
    Author     : Dominik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="base.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zmiany</title>
    </head>
    <body> 
        <jsp:useBean id="wartosci" class="base.DAOchange" scope="session"/>
        
        <h1>Tutaj nastąpią zmiany w bazie</h1>
        
        <form action="${pageContext.request.contextPath}/myservlet" method="post">
            <p>Zmien lub zostaw mieszkanca:       
                <input type="text" name="name" value="${wartosci.mieszk}" />
            </p>
            <p>Zmien lub zostaw jego adres:       
                <input type="text" name="adress" value="${wartosci.adr}" />
            </p>
            <input type="submit" name="update" value="zmien" />
        </form>
    </body>
</html>
