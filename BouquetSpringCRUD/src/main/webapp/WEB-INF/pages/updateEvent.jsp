<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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


<%--<c:url var="url" value="/event/updateEvent/${eventAttribute.id}"/>--%>

<form method="post" action="/event/updateEvent/${eventAttribute.id}">

    ID <input type="text" disabled=disabled name="id" value="<c:out value="${eventAttribute.id}"/>">
    EventName <input type="text" name="eventName" value="<c:out value="${eventAttribute.eventName}"/>">
    EventDate <input type="datetime-local" name="eventDate" value="<c:out value="${eventAttribute.eventDate}"/>">
    <input type="submit" value="Save">

</form>
</body>
</html>
