
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.MinecraftServers"%>
<% MinecraftServers server = (MinecraftServers) request.getAttribute("server"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Server</title>
        <link href="style.css" rel="stylesheet" type="text/css" >
    </head>
    <body>
        <p>
        <form name ="updateForm" action ="updateServer" method="get">
            <fieldset>
                <legend>Update Server</legend>
            <label class="field">Server ID:</label>
            <input type="text" name="id" value="<%= server.getServerID() %>" readonly/>
            <br>
            <label class="field">Server Name:</label>
            <input type="text" name="name" value="<%= server.getServerName() %>" />
            <br>
            <label class="field">Server IP:</label>
            <input type="text" name="ip" value="<%= server.getServerIP() %>" />
            <br>
            <label class="field">Average Players:</label>
            <input type="text" name="avg" value="<%= server.getAveragePlayers() %>" />
            <br>
            <label class="field">Server Type:</label>
            <input type="text" name="type" value="<%= server.getServerType() %>" />
            <br>
            <div class="center">
            <input type="submit" name="Submit" value="Update" />
            <input type="reset" name="Clear" value="Clear" />
            </div>
            </fieldset>
        </form>
    </p>
    </body>
</html>
