<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 1/2/2026
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fettes Scavenger Hunt - Route Preview </title>
</head>
<body>
<ol>
<c:forEach var="item" items="${listOfLocationNames}">
  <li>${item}</li>
</c:forEach>
</ol>
</body>
</html>
