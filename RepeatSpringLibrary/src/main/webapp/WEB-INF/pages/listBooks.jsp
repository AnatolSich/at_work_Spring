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
    <title>List books</title>
</head>
<body>
<h1>List books (studentId = ${studentId})</h1>
<table border="1">
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>StudentId</th>
        <th colspan="2">actions</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.student.id}</td>
            <td><a href="/Book/update/${book.id}/${studentId}">Update</a></td>
            <td><a href="/Book/delete/${book.id}/${studentId}">Delete</a></td>
        </tr>
    </c:forEach>

</table>
<br><a href="/Book/add/${studentId}">Add book</a></br>
<br><a href="/">List students</a></br>
</body>
</html>
