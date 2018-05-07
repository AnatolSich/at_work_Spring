<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 5/05/2018
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update book</title>
</head>
<body>
<h1>Update book</h1>
<form:form action="/Book/update/${book.id}/${studentId}" method="post">
    <input type="text" name="title" value="${book.title}"/>
    <input type="text" name="studentId" value="${book.student.id}"/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
