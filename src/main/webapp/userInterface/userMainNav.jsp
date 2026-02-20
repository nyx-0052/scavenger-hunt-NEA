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
    <title>Fettes Scavenger Hunt - Navigation</title>
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
    <div id="pointsCounter"></div>
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
    <button onclick="openSidebar()" id="routeSidebarButton"><img src="${pageContext.request.contextPath}/img/routeSidebar.svg"></button>
    <button onclick="openQRCodeScanner()" class="QRcode"><img src="${pageContext.request.contextPath}/img/QRCode.svg"></button>
</div>

<div id="routeSideBarContainer">
    <div id="routeSideBarContent">
    <span id="routeSideBarClose">X</span>
    <h2>Your Route</h2>
    <ul>
        <c:forEach var="item" items="${route}">
            <li>${item.getLocationID()}. ${item.getName()}</li>
        </c:forEach>
    </ul>
    </div>
</div>


<script src="https://unpkg.com/@panzoom/panzoom@4.6.1/dist/panzoom.min.js"></script>
<script>
    // Part (a) School map
    // mapControls: zooming in and out of map
    const element = document.getElementById("imageWrapper");
    const panzoom = Panzoom(element,{
        contain: "outside"
    });
    panzoom.zoomIn();

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

    // Part (b) Route sidebar
    var sidebar = document.getElementById("routeSideBarContainer");
    // to toggle visibility
    var sidebarOpenButton = document.getElementById("routeSidebarButton");
    function openSidebar(){
        sidebar.style.display="block";
    }
    var sidebarCloseButton = document.getElementById("routeSideBarClose");
    sidebarCloseButton.onclick= function(){
        sidebar.style.display="none";
    }

    window.onclick = function(event) {
        if (event.target == sidebar) {
            sidebar.style.display = "none";
        }
    }

    // Part (c) QR Code scanner
    function openQRCodeScanner(){
        window.location = "${pageContext.request.contextPath}/userInterface/userQRCodeScanner.jsp"
    }

    // Part (d) Total Points counter
    var pointsCounter = document.getElementById("pointsCounter");
    const cookies = document.cookie.split('; ');
    for (const cookie of cookies) {
        const [name, value] = cookie.split('=');
        if (name === "user_points") {
            pointsCounter.innerHTML = "<h2>" + value + "</h2>";
        }
    }
</script>
</body>
</html>
