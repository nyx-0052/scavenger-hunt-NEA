<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 13/2/2026
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navigation</title>
    <style>
        .map {
            max-width: 1391px;
            max-height: 1399px;
            overflow: scroll;
        }

        #imageWrapper{
            position: relative;
            zoom: 1;
        }

        .backgroundImage{
            display: block;
        }

        .locationMarker{
            height: 100px;
            width: 100px;
        }

        <c:forEach var="item" items="${route}">
        #id${item.getLocationID()}{
            position: absolute;
            bottom: ${1399-item.getYcoord()}px;
            left: ${item.getXcoord()-50}px;
        }
        </c:forEach>
    </style>
</head>

<body>
<button type="button" onclick="zoomIn()">+</button>
<button type="button" onclick="zoomOut()">-</button>

<div class="map">
<div id="imageWrapper">
    <img src="${pageContext.request.contextPath}/img/schoolMap.jpg" class="backgroundImage">

<c:forEach var="item" items="${route}">
    <img src="${pageContext.request.contextPath}/img/locationMarker.svg" class="locationMarker" id="id${item.getLocationID()}">
</c:forEach>
</div>
</div>

<script src="https://unpkg.com/@panzoom/panzoom@4.6.1/dist/panzoom.min.js"></script>
<script>
    const element = document.getElementById("imageWrapper");
    const panzoom = Panzoom(element,{
        contain: "outside"
    });

    function zoomIn(){
        panzoom.zoomIn();
    }

    function zoomOut(){
        panzoom.zoomOut();
    }

</script>
</body>
</html>
