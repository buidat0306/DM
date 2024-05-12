<%-- 
    Document   : update
    Created on : Jan 31, 2024, 8:45:45 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update  Human</title>
</head>
<body>
    <h1>Update Human</h1>
    <form action="human-action" method="post">
        <input type="hidden" name="action" value="add">
        <!-- Input fields for adding a new human -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="dob">DOB:</label>
        <input type="date" id="dob" name="dob" required><br>
        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br>
        <label for="type">Type:</label>
        <input type="text" id="type" name="type" required><br>
        <input type="submit" value="Add">
    </form>
</body>
</html>
