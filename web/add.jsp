<%-- 
    Document   : add
    Created on : Oct 27, 2015, 2:02:28 PM
    Author     : Tyler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Server</title>
        <link href="style.css" rel="stylesheet" type="text/css" >
    </head>
    <body>
        <h1>Add A New Server</h1>
        <table>
        <form name ="addForm" action ="addServer" method="get">
            
            <tr>
                <td><label>Server Name:</label></td>
                <td><input type="text" name="name" value="" /></td>
            </tr>
            <br>
            <tr>
                <td><label>Server IP:</label></td>
                <td><input type="text" name="ip" value="" /></td>
            </tr>
            <br>
            <tr>
            <td><label>Average Players:</label></td>
            <td><input type="text" name="avg" value="" /></td>
            </tr>
            <br>
            <tr>
            <td><label>Server Type:</label></td>
            <td><input type="text" name="type" value="" /></td>
            </tr>
            <br>
            <tr>
            <td><input type="submit" name="Submit" value="sumbit" /></td>
            <td><input type="reset" name="Clear" value="clear" /></td>
            </tr>
        </form>
    </body>
</html>
