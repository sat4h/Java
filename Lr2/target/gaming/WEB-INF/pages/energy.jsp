<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ENERGY</title>
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

<h2>Energy</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Cost</th>
        <th>Rate</th>
        <th>Action</th>
    </tr>
    <c:forEach var="energy" items="${energyList}">
        <tr>
            <td>${energy.id}</td>
            <td>${energy.title}</td>
            <td>${energy.cost}</td>
            <td>${energy.rate}</td>
            <td>
                <a href="editEnergy/${energy.id}">Edit</a>
                <a href="deleteEnergy/${energy.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/addEnergy" var="addUrl"/>
<a href="${addUrl}">Add new energy</a>

<h2>Back to Games</h2>
<c:url value="/games" var="games"/>
<a href="${games}">Back to Games</a>

</body>
</html>