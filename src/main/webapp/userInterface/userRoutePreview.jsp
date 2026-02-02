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
    <a href="${pageContext.request.contextPath}/UserRoutePresetsServlet"><img src="${pageContext.request.contextPath}/img/backbutton.svg" alt="backbutton"></a>
    <h2>${presetName}</h2>
</div>

<div class="listoflocations">
<ol>
<c:forEach var="item" items="${listOfLocationNames}">
  <li>${item}</li>
</c:forEach>
</ol>
    <div class="submit"><a href="UserMainNavServlet?chosenRouteName=${presetName}">Submit</a></div>
</div>
</body>
</html>
