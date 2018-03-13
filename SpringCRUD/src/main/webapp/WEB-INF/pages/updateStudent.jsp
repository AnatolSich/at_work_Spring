<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 26/02/2018
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update student</title>
</head>
<body>
<c:url var="url" value="/updateStudent/${studentAttribute.id}"/>

<form:form method="post" action="${url}" modelAttribute="studentAttribute">
    <table border="1">
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/> </td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>External:</td>
            <td><form:checkbox path="external"/></td>
        </tr>
    </table>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
