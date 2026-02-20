<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 28/1/2026
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fettes Scavenger Hunt - Route Presets </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/userInterface/userRoutePresets.css">
</head>

<body>
<div class="navbar">
    <input type="image" src="${pageContext.request.contextPath}/img/backbutton.svg" onclick="history.back()" alt="back button"/>
    <h2>Route Presets</h2>
</div>

<div class="listofroutes">
        <c:forEach var="item" items="${listOfPresetNames}">
            <div><a href="UserRoutePreviewFromPresetsServlet?preset=${item}">${item}</a></div>
        </c:forEach>
</div>
</body>
</html>