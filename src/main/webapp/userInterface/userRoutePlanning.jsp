<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 23/1/2026
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fettes Scavenger Hunt - Route Planning </title>
    <link rel="stylesheet" type="text/css" href="../style/userInterface/userRoutePlanning.css">
</head>
<body>
<h1>What do you want to do today?</h1>
<p>Choose your path:</p>
<button onclick="launchRoutePresets()" class="presetbutton">Choose from presets..</button>
<button onclick="launchRouteCustomisation()" class="custombutton">Customise a route...</button>
</body>

<script>
    function launchRoutePresets(){
        window.location = "userRoutePreset.jsp";
    }

    function launchRouteCustomisation(){
        window.location = "userChooseYourLocation.jsp"
    }
</script>
</html>
