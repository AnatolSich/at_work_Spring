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
    <title>Add student</title>
</head>
<h1>Add student</h1>
<body>
<form:form action="/Student/add" method="post">
    <input type="text" name="name"/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
