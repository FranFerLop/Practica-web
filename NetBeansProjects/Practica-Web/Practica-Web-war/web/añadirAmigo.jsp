<%-- 
    Document   : anadirAmigo
    Created on : 17-mar-2015, 16:54:46
    Author     : Francisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Anadir Amigo</title>
    </head>
    <body>
        
        <h1>Añadiendo amigo...</h1>
        <form name = "anadirAmigo" action="InvitarAmigo" method="post">
            <table>
                <tbody>
                    <tr>
                        <tr><h3>Indique el correo de tu amigo:</h3></tr>
                        <tr>
                            <td><input type="text" name="correo" value=""/></td>
                            <td><input type="submit" name="btEnviat" value="Invitar"</td>
                        </tr>
                    </tr>
                </tbody>            
            </table>
        </form>
    </body>
</html>
