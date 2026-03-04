<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 3/3/2026
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Fettes Scavenger Hunt - Editing ${chosenLocation.getLocationID()}. ${chosenLocation.getName()}</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminDashboard.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminEditingLocation.css">
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
    <h2>Editing ${chosenLocation.getLocationID()}. ${chosenLocation.getName()}:</h2>
    <a href="${pageContext.request.contextPath}/adminInterface/adminQRCode.jsp?id=${chosenLocation.getLocationID()}&name=${chosenLocation.getName()}"><div id="qrCodeButtonWrapper"><img src="${pageContext.request.contextPath}/img/QRCode.svg" id="qrCodeButton"><h4>Get QR Code</h4></div></a>
  </div>

  <div class="editing">
  <form onsubmit="return validation()" action="${pageContext.request.contextPath}/AdminEditALocationSubmissionServlet" method="get">
    <div>
        <input type="hidden" value="${chosenLocation.getLocationID()}" name="locationID">
        <span>
          <label for="locationName">Name:</label>
          <input type="text" name="locationName" id="locationName" required> <br>
        </span>

      <span>
          <label>Physical Location:</label><br>
          <span class="coordinateGroup">
          <label for="xcoordValue">x coordinate:</label>
          <label id="xcoordValue"></label>
          <input type="hidden" value="" id="xcoordValueServer" name="xcoordValue"><br>
        </span>

        <span class="coordinateGroup">
          <label for="ycoordValue">y coordinate:</label>
          <label id="ycoordValue"></label>
          <input type="hidden" value="" id="ycoordValueServer" name="ycoordValue"><br>
          </span>
        </span>

      <span>
          <label for="descp">Description:</label><br>
          <textarea id="descp" name="descp" rows="4" cols="50" required></textarea><br>
        </span>

      <span>
          <label for="schoolLink">School Link:</label>
          <input type="text" name="schoolLink" id="schoolLink" required><br>
        </span>
    </div>

    <div>
        <span>
          <label for="question">Question:</label>
          <input type="text" name="question" id="question" required><br>
        </span>

      <span>
          <label for="option1Value">Option 1:</label>
          <input type="text" name="option1" id="option1Value" required><br>
        </span>
      <span>
          <label for="option2Value">Option 2:</label>
          <input type="text" name="option2" id="option2Value" required><br>
        </span>
      <span>
          <label for="option3Value">Option 3:</label>
          <input type="text" name="option3" id="option3Value" required><br>
        </span>

      <span>
          <label>Correct Option:</label>
          <input type="radio" id="1" name="correctOption" value="1" required>
          <label for="1">1</label>
          <input type="radio" id="2" name="correctOption" value="2" required>
          <label for="2">2</label>
          <input type="radio" id="3" name="correctOption" value="3" required>
          <label for="3">3</label>
        </span>

    </div>

    <input type="submit">
  </form>

  <div class="coordinatesSelection">
    <h3>Click on the location below to get the coordinates:</h3>
    <div id="imageWrapper">
      <img src="${pageContext.request.contextPath}/img/locationMarker.svg" id="locationMarker">
      <img src="${pageContext.request.contextPath}/img/schoolMap.jpg" id="schoolMap">
    </div>
  </div>
  </div>
</div>

<script>
  // 1. pre-filling user input into textboxes, radio buttons and location marker
  document.getElementById("locationName").value = "${chosenLocation.getName()}";
  document.getElementById("descp").value = "${chosenLocation.getDescp()}";
  document.getElementById("schoolLink").value = "${chosenLocation.getSchoolLink()}";
  document.getElementById("question").value = "${chosenLocation.getQuestion()}"
  document.getElementById("option1Value").value="${chosenLocation.getOption1()}"
  document.getElementById("option2Value").value="${chosenLocation.getOption2()}"
  document.getElementById("option3Value").value="${chosenLocation.getOption3()}"
  document.getElementById("${chosenLocation.getCorrectOption()}").checked = true;

  // for coordinates and location marker
  const schoolMap = document.getElementById("schoolMap");
  // image dimensions - for scaling
  var cw=schoolMap.clientWidth // window image height
  var ch=schoolMap.clientHeight
  var iw=schoolMap.naturalWidth // original image height
  var ih=schoolMap.naturalHeight
  // for displaying in labels
  var labelX = ${chosenLocation.getXcoord()}/iw*cw;
  var labelY = ${chosenLocation.getYcoord()}/ih*ch;
  document.getElementById("xcoordValue").innerText = Math.round(labelX);
  document.getElementById("ycoordValue").innerText = Math.round(labelY);
  // for sending to server (setting value for hidden input values)
  document.getElementById("xcoordValueServer").value = ${chosenLocation.getXcoord()};
  document.getElementById("ycoordValueServer").value = ${chosenLocation.getYcoord()};

  // initial position location marker
  document.getElementById("locationMarker").style.bottom = Math.round(cw-labelY)+"px";
  var scalePosition = 50*cw/iw;
  document.getElementById("locationMarker").style.left = Math.round(labelX-scalePosition)+"px";

  // 2. picking and updating coordinates (and labels) using map:
  // Source - https://stackoverflow.com/a/58568016
  // Posted by Wolfgang Fahl, modified by community. See post 'Timeline' for change history
  // Retrieved 2026-03-02, License - CC BY-SA 4.0
  // https://stackoverflow.com/questions/34867066/javascript-mouse-click-coordinates-for-image
  document.getElementById("schoolMap").addEventListener('click', function (event) {
    // https://stackoverflow.com/a/288731/1497139
    var bounds = this.getBoundingClientRect(); // size of school map image
    // WHAT THE LABEL SHOWS -> distance of whole page to cursor - page to the edge of image
    var labelX = event.pageX - bounds.left;
    var labelY = event.pageY - bounds.top;
    // image dimensions - for scaling
    var cw=this.clientWidth // window image height
    var ch=this.clientHeight
    var iw=this.naturalWidth // original image height
    var ih=this.naturalHeight

    // WHAT THE DB STORES -> cursor position/scaled image height * original image height (scaled)
    var databaseX=labelX/cw*iw;
    var databaseY=labelY/ch*ih;

    // for displaying in labels
    document.getElementById("xcoordValue").innerText = Math.round(labelX);
    document.getElementById("ycoordValue").innerText = Math.round(labelY);
    // for sending to server (setting value for hidden input values)
    document.getElementById("xcoordValueServer").value = Math.round(databaseX);
    document.getElementById("ycoordValueServer").value = Math.round(databaseY);
    // for positioning a location marker in the map
    document.getElementById("locationMarker").style.bottom = Math.round(cw-labelY)+"px";
    var scalePosition = 50*cw/iw;
    document.getElementById("locationMarker").style.left = Math.round(labelX-scalePosition)+"px";
  });

  // 3. validation:
  function validation(){
      // 3.1 if any changes have been made
      if(
      document.getElementById("locationName").value == "${chosenLocation.getName()}"&&
      document.getElementById("descp").value == "${chosenLocation.getDescp()}" &&
      document.getElementById("schoolLink").value == "${chosenLocation.getSchoolLink()}"&&
      document.getElementById("question").value == "${chosenLocation.getQuestion()}" &&
      document.getElementById("option1Value").value=="${chosenLocation.getOption1()}" &&
      document.getElementById("option2Value").value=="${chosenLocation.getOption2()}"&&
      document.getElementById("option3Value").value=="${chosenLocation.getOption3()}"&&
      document.querySelector('input[name="correctOption"]:checked').value== ${chosenLocation.getCorrectOption()}&&
      document.getElementById("xcoordValueServer").value == ${chosenLocation.getXcoord()} &&
      document.getElementById("ycoordValueServer").value == ${chosenLocation.getYcoord()}
      ){
          window.alert("No changes have been made.")
          return false;
      }
      // 3.2 url is valid
      let url = document.getElementById("schoolLink").value;
      try {
        let givenURL = new URL (url);
      } catch (error) {
        window.alert("The link provided is not valid. Please check before resubmitting.")
        return false;
      }
      return true;
  }
</script>
</body>
</html>