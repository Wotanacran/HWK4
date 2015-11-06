<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Server</title>
        <link href="style.css" rel="stylesheet" type="text/css" >
    </head>
    <body>
        <div class="wrap"> <!--div to hold other divs-->

            <%@include file="includes/header.jsp" %>  <!-- Header -->

            <%@include file="includes/menu.jsp" %>  <!--Menu-->

            <div class="main">
                <p>
                <form name ="addForm" action ="addServer" method="get">
                    <fieldset>
                        <legend>Add A New Server</legend>
                        <label class="field">Server Name:</label>
                        <input type="text" name="name" value="" />
                        <br>
                        <label class="field">Server IP:</label>
                        <input type="text" name="ip" value="" />
                        <br>
                        <label class="field">Average Players:</label>
                        <input type="text" name="avg" value="" />
                        <br>
                        <label class="field">Server Type:</label>
                        <input type="text" name="type" value="" />
                        <br>
                        <div class="center">
                            <input type="submit" name="Submit" value="Submit" />
                            <input type="reset" name="Clear" value="Clear" />
                        </div>
                    </fieldset>
                </form>
                </p>
            </div>
            <%@include file="includes/footer.jsp" %><!--Footer-->

        </div> <!--close wrap div-->
    </body>
</html>