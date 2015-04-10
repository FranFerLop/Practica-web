<%-- 
    Document   : control
    Created on : 20-mar-2015, 12:06:37
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control</title>
    </head>
    <body>
        <%
        String user = request.getParameter("user"); 
        String password = request.getParameter("password"); 
        
        if (user != null && !user.equalsIgnoreCase("") && password !=null && !password.equalsIgnoreCase("")) {
        %>
        <h1> Bienvenido <%=user%> </h1>
        
        <%
        } else {
        %>
        <h1> Datos incorrectos</h1>
        <%
        }
        %>
    </body>
</html>
