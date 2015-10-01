<%-- 
    Document   : main
    Created on : 28 вер. 2015, 18:57:07
    Author     : Юра
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    </head>
    <body>
             
        <h1>Hello <%= request.getSession(false).getAttribute("username") %></h1>
    </body>
</html>
