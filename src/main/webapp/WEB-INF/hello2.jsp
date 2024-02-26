<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% var items = (Iterable<String>) request.getAttribute("items"); %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Servlet Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
            <% for (String item : items) { %>
            <li>
                <%= item %>
            </li>
            <% } %>
        </ul>
    </body>
</html>