<%-- 
    Document   : listaUsuariosRed
    Created on : 15-abr-2015, 14:21:53
    Author     : Sergio
--%>
<%@page import="java.util.List"%>
<%@page import="pw.entity.Tusuario"%>
<%@page import="pw.ejb.TusuarioFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Tusuario user;
    List<Tusuario> lista = (List<Tusuario>)session.getAttribute("listaUsuarios");
    user = (Tusuario)session.getAttribute("user");
    if(user==null||lista==null){
%>        
<jsp:forward page="control.jsp" />

<%
    }

 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios de la red social</title>
    </head>
    <body>
        <h1>Usuarios:</h1>
<%
        for(Tusuario u:lista){
%>
        <h2> <%= u.getNombre() %> </h2><br/>
<%
        }
%>
        <a href="principal.jsp">Volver a la página principal</a>
    </body>
</html>
