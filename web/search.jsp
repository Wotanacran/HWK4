<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search servers</title>
        <link href="style.css" rel="stylesheet" type="text/css" >
    </head>
    <body>
        <div class="wrap"> <!--div to hold other divs-->

            <%@include file="includes/header.jsp" %>  <!-- Header -->

            <%@include file="includes/menu.jsp" %>  <!--Menu-->

            <div class="main">
                <h1>Search Servers</h1>
                <p>
                <form name="searchForm" action="search" method="get">
                    <fieldset>
                    <legend>Add A New Server</legend>
                    <label class="field">Search:</label>
                    <input type="text" name="searchVal" vaule="" />
                    
                    <br>
                    <div class="center">
                        <input type="submit" name="sumbit" value="Search" />
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
