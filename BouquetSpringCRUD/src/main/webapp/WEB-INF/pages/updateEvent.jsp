<%@ page import="java.util.Date" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 15/03/2018
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update event</title>
</head>
<body>
<h1>Update event</h1>
<c:url var="url" value="/event/updateEvent/${eventAttribute.id}"/>

<form:form method="post" action="${url}" modelAttribute="eventAttribute">
    <table border="1">
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/> </td>
        </tr>
        <tr>
            <td><form:label path="eventName">Event Name</form:label></td>
            <td><form:input path="eventName"/></td>
        </tr>
        <tr>
            <td><form:label path="eventDate">Event Date</form:label></td>
            <td><form:input path="eventDate"/></td>
        </tr>
    </table>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
