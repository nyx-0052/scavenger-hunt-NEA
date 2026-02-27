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
  <title>Fettes Scavenger Hunt - Add a new Preset Route</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminDashboard.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminChooseYourLocation.css">
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
  <h2>1. Name your new route:</h2>
    <form onsubmit="return validation()" action="${pageContext.request.contextPath}/AdminRoutePreviewServlet" method="get">
      <label for="presetName">Enter your route name:</label>
      <input type="text" name="presetName" id="presetName" required>
      <h2>2. Choose your locations:</h2>
      <div class="listoflocations required">
      <c:forEach var="item" items="${listofLocations}">
        <div class="labelLocation">
          <label for="checkedlocation">${item.getLocationID()}. ${item.getName()}</label>
          <input type="checkbox" name="checkedlocation" value="${item.getLocationID()}">
        </div>
      </c:forEach>
      </div>
      <input type="submit" value="Submit">
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  if ("${AddRouteDatabaseFeedback}"=="1"){
    window.alert("Your route has been successfully added.");
  } else if ("${AddRouteDatabaseFeedback}"=="0"){
    window.alert("Your route has not been successfully added. Please try again later.")
  }

  function validation(){
    let userInputRouteName = document.getElementById("presetName").value.toUpperCase();
    if($('div.listoflocations.required :checkbox:checked').length > 1){
      <c:forEach var="item" items="${listOfPresetNames}">
        if("${item}"==userInputRouteName){
          window.alert("A route with this name already exists. Please check before resubmitting.")
          return false;
      }
      </c:forEach>
      return true;
    } else{
      window.alert("Please select two or more locations.")
      return false;
    }
  }
</script>
</body>
</html>
