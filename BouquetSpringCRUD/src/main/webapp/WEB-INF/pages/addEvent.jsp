<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 15/03/2018
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add event</title>
</head>
<body>
<h1>
    Add event
</h1>
<form:form action="addEvent" method="post">
    <table border="1">
        <tr>
            <td>Event name</td>
            <td><input type="text" name="eventName"></td>
        </tr>
        <tr>
            <td>Event date</td>
            <td><input type="date" name="eventDate" value="${datePattern}"></td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
