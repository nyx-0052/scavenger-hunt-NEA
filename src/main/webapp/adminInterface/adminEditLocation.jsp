<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 24/2/2026
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Fettes Scavenger Hunt - Edit a location</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminDashboard.css">
</head>
<body>
<div class="dashboardNavBar">
  <img src="${pageContext.request.contextPath}/img/fettes_logo_nav.png" class="navLogo">
  <h3 class="navTitle">Fettes Scavenger Hunt</h3>

  <div class="sectionContainer">
    <h4>Data Analysis</h4>
    <a href="${pageContext.request.contextPath}/adminInterface/adminDataAnalysis.jsp"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/chartsAndData.svg"><p>Charts and Data</p></div></a>
  </div>

  <div class="sectionContainer">
    <h4>Management</h4>
    <a href="${pageContext.request.contextPath}/adminInterface/adminAddPreset.jsp"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/addRouteLocation.svg"><p>Add a new preset route</p></div></a>
    <a href="${pageContext.request.contextPath}/adminInterface/adminAddLocation.jsp"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/addRouteLocation.svg"><p>Add a new location</p></div></a>
    <a href="${pageContext.request.contextPath}/adminInterface/adminEditLocation.jsp"><div class="functionContainer" id="selected"><img src="${pageContext.request.contextPath}/img/editALocation.svg"><p>Edit a location</p></div></a>
  </div>

</div>

</body>
</html>
