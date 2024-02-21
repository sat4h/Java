<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:choose>
        <c:when test="${empty game.title}">
            <title>Add Game</title>
        </c:when>
        <c:otherwise>
            <title>Edit Game</title>
        </c:otherwise>
    </c:choose>

<style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            margin-top: 20px;
            max-width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<c:choose>
    <c:when test="${empty game.title}">
        <c:url value="/edit" var="var"/>
    </c:when>
</c:choose>
<c:if test="${!empty game.id}">
    <form action="${var}" method="post">
        <input type="hidden" name="id" value="${game.id}">
        <label for="title">Title</label>
        <input type="text" name="title" id="title" value="${game.title}" required>
        <label for="year">Year</label>
        <input type="text" name="year" id="year" value="${game.year}" required>
        <label for="cost">Cost</label>
        <input type="text" name="cost" id="cost" value="${game.cost}" required>
        <label for="rate">Rate</label>
        <input type="text" name="rate" id="rate" value="${game.rate}" required>
        <input type="submit" value="Edit game">
    </form>
</c:if>
</body>
</html>