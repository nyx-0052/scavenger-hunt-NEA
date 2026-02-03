<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 3/2/2026
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fettes Scavenger Hunt - Your Route</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/userInterface/userYourRoute.css">
</head>
<div class="navbar">
    <a href="${pageContext.request.contextPath}//UserChooseYourLocationServlet"><img src="${pageContext.request.contextPath}/img/backbutton.svg" alt="backbutton" class="backbutton"></a>
    <h2>Your Route</h2>
</div>

<body>
<h4>Drag and drop to reorder the route...</h4>

<form>
    <ul id="draggableList">
        <c:forEach var="item" items="${chosenLocations}">
            <li class="list-group-item">
                <img src="${pageContext.request.contextPath}/img/moveicon.svg" class="myHandle">
                    ${item.getLocationID()}. ${item.getName()}
            </li>
        </c:forEach>
    </ul>
    <input type="submit" value="Confirm">
</form>

<script src="https://cdn.jsdelivr.net/npm/sortablejs@1.15.2/Sortable.min.js"></script>
<script>
    var list = document.getElementById("draggableList");
    var sortable = Sortable.create(list, {
        animation: 150
    });
</script>
</body>
</html>
