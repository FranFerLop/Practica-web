<%-- 
    Document   : principal
    Created on : 21-mar-2015, 21:18:47
    Author     : Sergio
--%>

<%@page import="pw.entity.Tusuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%
    Tusuario user;
    user = (Tusuario)session.getAttribute("user");
    if(user==null){
%>        
<jsp:forward page="control.jsp" />

<%
    }

 %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Red social</title>
    </head>
    <body>
        <img src=""/>
        <h1>Usuario: <%= user.getNombre() %> </h1>
        
        <a href="postearFormulario.jsp">Añadir post</a>
        
        <a href="muroPost.jsp">Lista de post</a>
        
        <input type="submit" value="Añadir amigo" name="add_amigo" /> <br/>
        
        <input type="submit" value="Eliminar amigo" name="delete_amigo"/>
        
        <input type="submit" value="Grupos" name="grupos"/>
        
    </body>
</html>
