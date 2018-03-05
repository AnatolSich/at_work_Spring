<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 2/23/2018
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student manager</title>
</head>
<body>
<div>
    <h1>Student manager</h1>
    <c:if test="${!empty students}">
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>External</th>
                <th>Created date</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td><c:if test="${student.external==true}">+</c:if></td>
                    <td>${student.createDate}</td>
                    <td><a href="/updateStudent/${student.id}">Update student</a></td>
                    <td><a href="/deleteStudent/${student.id}">delete student</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<p><a href="/addStudent">Add student</a></p>
</body>
</html>
