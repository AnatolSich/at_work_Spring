<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 5/05/2018
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List students</title>
</head>
<body>
<h1>List students</h1>
<table border="1">
    <tr>
        <th>Student ID</th>
        <th>Name</th>
        <th colspan="3">actions</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td><a href="/Book/${student.id}">List books</a></td>
            <td><a href="/Student/update/${student.id}">Update</a></td>
            <td><a href="/Student/delete/${student.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br><a href="/Student/add">Add student</a></br>
</body>
</html>
