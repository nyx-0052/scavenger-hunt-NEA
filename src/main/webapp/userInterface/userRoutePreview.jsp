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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/userInterface/userRoutePreview.css">
</head>

<body>
<div class="navbar">
    <!--
Source - https://stackoverflow.com/a/8683553
Posted by Andrew Barber, modified by community. See post 'Timeline' for change history
Retrieved 2026-02-07, License - CC BY-SA 3.0
-->
    <input type="image" src="${pageContext.request.contextPath}/img/backbutton.svg" onclick="history.back()"/>
    <h2>${headerName}</h2>
</div>

<div class="listoflocations">
<ul>
<c:forEach var="item" items="${listOfLocations}">
  <li>${item.getLocationID()}. ${item.getName()}</li>
</c:forEach>
</ul>
    <div class="submit"><a href="UserMainNavServlet?chosenRoute=${listOfLocations}">Submit</a></div>
</div>
</body>
</html>
