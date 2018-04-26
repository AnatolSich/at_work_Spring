<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Add bouquet</title>
</head>
<body>
<h1>Add bouquet</h1>

<form:form action="addBouquet" method="post">
    <table border="1">
        <tr>
            <th>bouquetName</th>
            <th>color</th>
            <th>cost</th>
            <th>delivery</th>
        </tr>
        <tr>
            <td><input type="text" name="bouquetName" value=""></td>
            <td><input type="text" name="color" value=""></td>
            <td><input type="checkbox" name="delivery"></td>
        </tr>
         <tr><input type="submit" value="Add bouquet"></tr>
    </table>

</form:form>

</body>
</html>
