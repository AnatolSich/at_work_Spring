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
    <title>Update student</title>
</head>
<body>
<h1>Update student</h1>
<form:form action="/Student/update/${student.id}" method="post">
    <input type="text" name="name" value="${student.name}"/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
