<%-- 
    Document   : postearFormulario
    Created on : 21-mar-2015, 18:26:04
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pw.entity.Tusuario"%>
<!DOCTYPE html>
<%
  Tusuario user = (Tusuario) session.getAttribute("user");
%>
<html>
    <head>
        <title>Postear</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        Usuario: <%= user.getNombre() %> <br/>
        <form method="get" action="PostearServlet" name="formulario">
            Escriba aqu&iacute; su post... <br/>
            <textarea name="postear" rows="4" cols="20"/></textarea><br/>
            <input type="file" name="imagen" value="" /><br/>
            <input type="submit" value="Postear" name="submit" />
        </form>
    </body>
</html>
