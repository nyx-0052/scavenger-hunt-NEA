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
  <title>Fettes Scavenger Hunt - Add a new Location</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminDashboard.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminAddLocation.css">
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
    <a href="${pageContext.request.contextPath}/adminInterface/adminAddLocation.jsp"><div class="functionContainer" id="selected"><img src="${pageContext.request.contextPath}/img/addRouteLocation.svg"><p>Add a new location</p></div></a>
    <a href="${pageContext.request.contextPath}/adminInterface/adminEditLocation.jsp"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/editALocation.svg"><p>Edit a location</p></div></a>
  </div>

</div>
<div class="main">
    <form onsubmit="return validation()" action="">
      <div>
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
          <label for="descp">Description:</label>
          <input type="text" name="descp" id="descp" required><br>
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
          <input type="text" name="option1Value" id="option1Value" required><br>
        </span>
        <span>
          <label for="option2Value">Option 2:</label>
          <input type="text" name="option2Value" id="option2Value" required><br>
        </span>
        <span>
          <label for="option3Value">Option 3:</label>
          <input type="text" name="option3Value" id="option3Value" required><br>
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

  <div>
    <h3>Click on the location below to get the coordinates:</h3>
    <a href="#">
      <img src="${pageContext.request.contextPath}/img/schoolMap.jpg" id="schoolMap" ismap>
    </a>
  </div>

</div>

<script>
  // COORDINATES:
  let schoolMap = document.getElementById("schoolMap");

  schoolMap.addEventListener("click", function(){
    // for getting coordinates from URL
    const params = window.location.hash;
    console.log(params)
    const coordArray = params.match(/\d+/g);
    // for displaying in labels
    document.getElementById("xcoordValue").innerText = coordArray[0]*2;
    document.getElementById("ycoordValue").innerText = coordArray[1]*2;

    // for sending to server (setting value for hidden input values)
    document.getElementById("xcoordValueServer").innerText = coordArray[0]*2;
    document.getElementById("ycoordValueServer").innerText = coordArray[1]*2;
  });

  // VALIDATION:
  function validation(){
    if(document.getElementById("xcoordValueServer").innerText==="" || document.getElementById("ycoordValueServer").innerText===""){
      window.alert("Please click on your location on the map to select the coordinates.")
      return false;
    } else {
      let url = document.getElementById("schoolLink").value;
      try {
        let givenURL = new URL (url);
      } catch (error) {
        window.alert("The link provided is not valid. PLease check before resubmitting.")
        return false;
      }
      return false;
    }
  }
</script>

</body>
</html>