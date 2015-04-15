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
        <h1>Usuario: <%= user.getNombre() %> </h1><br/>
        
<%
        if(user.getAdministrador().equals('1')){
%>
        <h2>Este usuario es administrador</h2><br/>
        <form name="listarUsuario" action ="MostrarUsuariosRed" method ="post">
            <input type="submit" value="Lista usuarios de la Red Social" />
        </form>
<%
        }       
%>
        <form name="anadirPost" action ="AnadirPostServlet" method ="post">
            <input type="submit" value="Anadir post" />
        </form>
        <a href="postearFormulario.jsp">Añadir post</a><br/>
        
        <a href="muroPost.jsp">Lista de post</a><br/>
        
        <input type="submit" value="Añadir amigo" name="add_amigo" /> <br/>
        
        <input type="submit" value="Eliminar amigo" name="delete_amigo"/><br/>
        
        <input type="submit" value="Grupos" name="grupos"/><br/>
        
    </body>
</html>
