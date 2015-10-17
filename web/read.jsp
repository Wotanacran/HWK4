<%-- 
    Document   : read
    Created on : Oct 16, 2015, 8:16:43 PM
    Author     : Tyler Hodgson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Minecraft Servers</h1>
        <%= table %>
    </body>
</html>
