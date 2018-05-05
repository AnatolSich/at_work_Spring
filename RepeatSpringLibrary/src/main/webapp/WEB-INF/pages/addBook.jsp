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
    <title>Add book</title>
</head>
<h1>Add book</h1>
<body>
<form:form action="/Book/add/${studentId}" method="post">
    <input type="text" name="title"/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
