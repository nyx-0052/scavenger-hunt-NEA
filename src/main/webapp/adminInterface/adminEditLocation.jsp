<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminEditLocation.css">
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
  <h2>Select the location you would like to edit:</h2>
  <div class="listofroutes">
    <c:forEach var="item" items="${listofLocations}">
      <a href="AdminEditingLocationServlet?id=${item.getLocationID()}"><div class="locationContainer">${item.getLocationID()}. ${item.getName()}</div></a>
    </c:forEach>
  </div>
</div>

<script>
  // user feedback
  if ("${EditLocationDatabaseFeedback}"=="1"){
    window.alert("Your changes have been successfully saved.");
  } else if ("${EditLocationDatabaseFeedback}"=="0"){
    window.alert("Your changes has not been successfully added. Please try again later.")
  }
</script>

</body>
</html>
