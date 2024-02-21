<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GAMES</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #333;
            margin-top: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        a {
            text-decoration: none;
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h2>Games</h2>

<table>
    
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Year</th>
    <th>Cost</th>
    <th>Rate</th>
    <th>Action</th>
</tr>

<c:forEach var="game" items="${games}">
    <tr>
        <td>${game.id}</td>
        <td>${game.title}</td>
        <td>${game.year}</td>
        <td>${game.cost}</td>
        <td>${game.rate}</td>
        <td>
            <a href="edit/${game.id}">Edit</a>
            <a href="delete/${game.id}">Delete</a>
        </td>
    </tr>
</c:forEach>
</table>

<h2>Add</h2>
<c:url value="/addGame" var="add"/>
<a href="${add}">Add new game</a>

<a href="${pageContext.request.contextPath}/main-page">Go to Main Page</a>

</body>
</html>