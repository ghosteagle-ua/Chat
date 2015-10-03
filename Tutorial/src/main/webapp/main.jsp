<%-- 
    Document   : main
    Created on : 28 вер. 2015, 18:57:07
    Author     : Юра
--%>

<%@page import="com.mycompany.tutorial.AcountService"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    </head>
    <body style="padding-left: 3%; padding-right: 3%; padding-top: 1.5%; padding-bottom: 1.5%; ">
        
        <div id="header" style="position: relative; width: 100%; display: inline-block; height: 15%;">
            <h1 style="display: inline-block; float: left; margin: 1.5%"><%= request.getSession(false).getAttribute("username") %></h1>
            
            <div style="position: relative; display: inline-block; float: right;margin: 1.5%;">
                <form method="POST" action="logout">
                    <input type="submit" value="Logout" style="color: red; background-color: white; border-color: white; font-size: 1.6em;"/>
                </form>
            </div>
        </div>
            
        <% 
            AcountService acountService = AcountService.getInstance();
            String username = (String)request.getSession().getAttribute("username");
            Set<String> friends = acountService.getUserProfile(username).getFriends();
        %>
            
            
        <div id="content" style="position: relative; display: inline-block; width: 100%; height: 100%; padding: 2.5%">
            <div id="friends-panel" style="position: relative; display: inline-block; width: 30%; height: 100%; float: left">
                <h1 style="margin: 1.5%">FRIENDS:</h1>
                
                <form>
                    
                    <% for(String s : friends){%>
                        <div style="position: relative; margin-top: 1.0%">
                            <h3><%= s%></h3>
                        </div>
                    <%}%>
                </form>
                
            </div>
            
        </div>

    </body>
</html>
