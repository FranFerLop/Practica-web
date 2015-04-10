<%-- 
    Document   : index
    Created on : 20-mar-2015, 10:59:23
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form name="frmUsuario" action ="autenticacion" method ="post">
        User Name
        <input id ="txtUserName" name="user" type="text" maxlength="20"/>
        Password
        <input id ="txtUserPas" name="password" type="password"/>
        <input id ="btnGuardar" value="Logearse" type="submit"/>
        </form>
       
    </body>
</html>

