<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 27/2/2026
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fettes Scavenger Hunt - Add a new Preset Route - Route Preview</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminDashboard.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminPresetPreview.css">
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
    <a href="${pageContext.request.contextPath}/AdminAddANewPresetServlet"><div class="functionContainer" id="selected"><img src="${pageContext.request.contextPath}/img/addRouteLocation.svg"><p>Add a new preset route</p></div></a>
    <a href="${pageContext.request.contextPath}/adminInterface/adminAddLocation.jsp"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/addRouteLocation.svg"><p>Add a new location</p></div></a>
    <a href="${pageContext.request.contextPath}/adminInterface/adminEditLocation.jsp"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/editALocation.svg"><p>Edit a location</p></div></a>
  </div>

</div>

<div class="main">

  <div class="navbar">
    <input type="image" src="${pageContext.request.contextPath}/img/backbuttonAdmin.svg" onclick="history.back()"/>
    <h2>New Route: ${headerName}</h2>
  </div>

  <div class="listoflocations">
    <ul>
      <c:forEach var="item" items="${listOfLocations}">
        <li>${item.getLocationID()}. ${item.getName()}</li>
      </c:forEach>
    </ul>

    <form action="${pageContext.request.contextPath}/AdminRoutePreviewSubmissionServlet">
      <input type="hidden" value="${formattedRoute}" name="formattedRoute">
      <input type="hidden" value="${headerName}" name="routeName">
      <input type="submit" class="submit" value="Confirm">
    </form>
  </div>

</div>

</body>
</html>
