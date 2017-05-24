<%-- 
    Document   : index
    Created on : 2017-04-11, 19:09:32
    Author     : Dominik
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<sql:query var="rs" dataSource="jdbc/bazaTestowa">
select login from users
</sql:query>



<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>strona admina</title>
        
        <style>
            
        table, th, td {
            border: 1px solid black;
        }
        
        </style>
        
    </head>
    
    <body>
        <%@page import="java.util.List"%>
        <%@page import="service.*"%>
        <%@page import="base.*"%>
        
        
        <%
            DataList d = new DataList(); 
            List<String> mieszkancy = d.wyswietlanie_mieszkancow();
            List<String> miejscowosci = d.wyswietlanie_miejscowosci();                     
            
        %>
 
        
        <h1 style="color: green">Witaj ADMIN</h1>
        
         
        <c:forEach var="row" items="${rs.rows}">
            ${row.login}<br>
        </c:forEach>
            <br>
        
        
        <jsp:useBean id="zmianabazy" class="service.Actions" scope="session"/>
            <table>
                <tr> <th>Uzytkownicy:</th> </tr>
                <c:forEach items="${zmianabazy.wypiszUzytk}" var="name" varStatus="loopStatus">
                    <tr style="${loopStatus.index % 2 == 0 ? 'background-color: #ffff3b' : 'background-color: #ff9c27'}">
                    <td>${name}</td>
                    </tr>
                </c:forEach>
            </table>
        
        <br>
        
        <table>
                <tr> 
                    <th>Mieszkaniec:</th> 
                    <th>Miejscowosc:</th> 
                </tr>
        <%  String kolor;
            for (int i=0; i<mieszkancy.size() || i<miejscowosci.size(); i++) {
                if (i%2==0) kolor="#b3ffdb";
                else kolor="#7dff7a";
        %>
                <tr style="background-color: <%out.print(kolor);%>">
                    <td>
                        <%
                        out.println(mieszkancy.get(i));   
                        %>
                    </td>
                
                
                    <td>
                        <%
                        out.println(miejscowosci.get(i));    
                        %>
                    </td>
                
                
                <td>
                    <form action="${pageContext.request.contextPath}/myservlet" method="post">   
                        <button name="<%out.print(i);%>" type="submit" value="<%out.print(mieszkancy.get(i) + " " + miejscowosci.get(i));%>">usun</button>             
                    </form>
                </td>
                
                <td>
                    <form action="${pageContext.request.contextPath}/myservlet" method="post">   
                        <button name="change" type="submit" value="<%out.print(i);%>">zmien</button>             
                    </form>
                </td>
                
                </tr>
                <%
                               
            }
            
            
            
        %>
            </table>
        
        <br>
        

        
        <form action="${pageContext.request.contextPath}/myservlet" method="post">
            <input type="submit" name="dodstat" value="dodaj statycznie" />
            <input type="submit" name="usunstat" value="usun statycznie" />          
        </form>
            
        <form action="${pageContext.request.contextPath}/myservlet" method="post">
            <p>Wpisz mieszkanca:       
                <input type="text" name="name" />
            </p>
            <p>Wpisz jego adres:       
                <input type="text" name="adress" />
            </p>
            <input type="submit" name="dodajMA" value="dodaj" />
        </form>
        <br>   
            
        <a href="${pageContext.request.contextPath}/index.jsp">powrot</a>
        <br>
        <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
        <br>
        
    </body>
</html>
