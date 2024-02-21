<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:choose>
        <c:when test="${empty energy.title}">
            <title>Add Energy</title>
        </c:when>
        <c:otherwise>
            <title>Edit Energy</title>
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
    <c:when test="${empty energy.title}">
        <c:url value="/editEnergy" var="var"/>
    </c:when>
</c:choose>
<c:if test="${!empty energy.id}">
    <form action="${var}" method="post">
        <input type="hidden" name="id" value="${energy.id}">
        <label for="title">Title</label>
        <input type="text" name="title" id="title" value="${energy.title}" required>
        <label for="cost">Cost</label>
        <input type="text" name="cost" id="cost" value="${energy.cost}" required>
        <label for="rate">Rate</label>
        <input type="text" name="rate" id="rate" value="${energy.rate}" required>
        <input type="submit" value="Edit energy">
    </form>
</c:if>
</body>
</html>