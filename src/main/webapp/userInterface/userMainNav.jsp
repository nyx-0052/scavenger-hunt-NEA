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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/userInterface/userMainNav.css">
    <style>
        /* Internal CSS for Part (a): for positioning location markers and popups*/
        <c:forEach var="item" items="${route}">
        #locationMarker${item.getLocationID()} {
            position: absolute;
            bottom: ${1399-item.getYcoord()}px;
            left: ${item.getXcoord()-50}px;
        }
        #locationPopup${item.getLocationID()} {
            position: absolute;
            bottom: ${1399-item.getYcoord()+100}px;
            left: ${item.getXcoord()-80}px;
        }
        </c:forEach>
    </style>
</head>

<body>
<!-- Upper menu bar; part (d) total point counter here -->
<div class="upperMenuBar">
    <h2>Cookie points displayed here</h2>
    <img src="${pageContext.request.contextPath}/img/points.svg">
</div>

<!-- Main content; part (a) school map here -->
<div class="map">
<div id="imageWrapper">
    <img src="${pageContext.request.contextPath}/img/schoolMap.jpg" class="backgroundImage">

    <c:forEach var="item" items="${route}">
        <div class="popup" onclick="popUp('locationPopup${item.getLocationID()}')">
        <img src="${pageContext.request.contextPath}/img/locationMarker.svg" class="locationMarker" id="locationMarker${item.getLocationID()}">
        <span class="popuptext" id="locationPopup${item.getLocationID()}">${item.getLocationID()}. ${item.getName()}</span>
        </div>
    </c:forEach>
</div>
    <div class="mapControls">
        <button type="button" onclick="zoomIn()">+</button>
        <button type="button" onclick="zoomOut()">-</button>
    </div>
</div>

<!-- Lower menu bar; part (b) route sidebar & (c) QR code scanner here -->
<div class="lowerMenuBar">
    <button onclick="" class="routeSidebar"><img src="${pageContext.request.contextPath}/img/routeSidebar.svg"></button>
    <button onclick="" class="QRcode"><img src="${pageContext.request.contextPath}/img/QRCode.svg"></button>
</div>


<script src="https://unpkg.com/@panzoom/panzoom@4.6.1/dist/panzoom.min.js"></script>
<script>
    // Part (a) School map
    // mapControls: zooming in and out of map
    const element = document.getElementById("imageWrapper");
    const panzoom = Panzoom(element,{
        contain: "outside"
    });
    function zoomIn() {
        panzoom.zoomIn();
    }
    function zoomOut(){
        panzoom.zoomOut();
    }

    // Location Popups: toggling visibility on click
    function popUp(LocationPopUpID) {
        var popup = document.getElementById(LocationPopUpID);
        popup.classList.toggle("show");
    }
</script>
</body>
</html>
