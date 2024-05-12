<%-- 
    Document   : delete
    Created on : Jan 31, 2024, 8:45:30 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Human</title>
</head>
<body>
    <h1>Delete Human</h1>
    <form action="human-action" method="post">
        <input type="hidden" name="action" value="delete">
        <p>Are you sure you want to delete this human?</p>
        <input type="submit" value="Delete">
    </form>
</body>
</html>