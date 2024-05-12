<%-- 
    Document   : list
    Created on : Jan 31, 2024, 9:07:43 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of Humans</title>
</head>
<body>
    <h1>List of Humans</h1>

    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>Type</th>
            </tr>
        </thead>
        <tbody>
            <% List<Human> humanList = (List<Human>) request.getAttribute("humanList");
               if (humanList != null && !humanList.isEmpty()) {
                   for (Human human : humanList) { %>
                       <tr>
                           <td><%= human.getName() %></td>
                           <td><%= new SimpleDateFormat("yyyy-MM-dd").format(human.getDob()) %></td>
                           <td><%= human.getGender() %></td>
                           <td><%= human.getType() %></td>
                       </tr>
                   <% }
               } else { %>
                   <tr>
                       <td colspan="4">No humans found.</td>
                   </tr>
               <% } %>
        </tbody>
    </table>
</body>
</html>
