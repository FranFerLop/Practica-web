<%-- 
    Document   : postear
    Created on : 17-mar-2015, 13:47:10
    Author     : Sergio
--%>

<%@page import="java.util.List"%>
<%@page import="pw.entity.Tpost"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //preguntar al profesor si el post pasado por parametro en postearFormulario se sigue manteniendo
    String post = request.getParameter("postear");
%>

<html>
    <head>
        <title>Postear</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Ha guardado el siguiente post: </h1><br/>
        
        <h2><%=post%></h2><br/>
        <a href="principal.jsp"></a>
    </body>
</html>
