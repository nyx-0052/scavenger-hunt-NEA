<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 4/3/2026
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Fettes Scavenger Hunt - QR Code</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminDashboard.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminQRCode.css">
</head>
<body>
<div class="dashboardNavBar">
  <img src="${pageContext.request.contextPath}/img/fettes_logo_nav.png" class="navLogo">
  <h3 class="navTitle">Fettes Scavenger Hunt</h3>

  <div class="sectionContainer">
    <h4>Data Analysis</h4>
    <a href="${pageContext.request.contextPath}/AdminDataAnalysisServlet"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/chartsAndData.svg"><p>Charts and Data</p></div></a>
  </div>

  <div class="sectionContainer">
    <h4>Management</h4>
    <a href="${pageContext.request.contextPath}/AdminAddANewPresetServlet"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/addRouteLocation.svg"><p>Add a new preset route</p></div></a>
    <a href="${pageContext.request.contextPath}/AdminAddALocationServlet"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/addRouteLocation.svg"><p>Add a new location</p></div></a>
    <a><div class="functionContainer" id="selected"><img src="${pageContext.request.contextPath}/img/editALocation.svg"><p>Edit a location</p></div></a>
  </div>

</div>

<div class="main">
  <div class="navbar">
    <input type="image" src="${pageContext.request.contextPath}/img/backbuttonAdmin.svg" onclick="history.back()" id="backButton"/>
  </div>
  <div class="QRContent">
    <h1>${param.id}. ${param.name}</h1>
    <div id="qrcode"></div>
  </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/qrcodejs/1.0.0/qrcode.min.js"></script>
<script>
  const encodeText = "FettesScavengerHuntLocationQRCODE="+${param.id};
  var qrcode = new QRCode(document.getElementById("qrcode"), {
    text: encodeText,
    width: 500,
    height: 500,
    colorDark : "#44290C",
    colorLight : "#D3A1AB",
    correctLevel : QRCode.CorrectLevel.H
  });
</script>
</script>
</body>
</html>
