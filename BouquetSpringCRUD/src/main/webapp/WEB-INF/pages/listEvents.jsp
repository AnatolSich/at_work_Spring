<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 15/03/2018
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of events</title>
</head>
<body>
<h1>List of events</h1>
<table border="1">
    <tr>
        <th>Event Name</th>
        <th>Event Date</th>
        <th>Reg. Date</th>
        <th colspan="3">Actions</th>
    </tr>
    <c:forEach items="${events}" var="event">
        <tr>
            <td>${event.eventName}</td>
            <td>${event.eventDate}</td>
            <td>${event.regDate}</td>
            <td><a href="/event/updateEvent/${event.id}">Update</a></td>
            <td><a href="/event/deleteEvent/${event.id}">Delete</a></td>
            <td><a href="/bouquet/bouquetsByEvent/${event.id}">List of bouquets</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/event/addEvent">Add event</a>
</body>
</html>
