<%-- 
    Document   : login
    Created on : 2017-04-11, 19:26:22
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
        logowanie
        <form action="j_security_check" method="POST">
            Username:<input type="text" name="j_username" /><br />
            Password:<input type="password" name="j_password" /><br />
            <input type="submit" value="Login" />
        </form>
        <br />
    </body>
</html>
