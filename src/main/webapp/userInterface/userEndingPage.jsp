<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 22/2/2026
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Well Done!</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/userInterface/userEndingPage.css">
</head>

<body>
<h1>Thank you for participating in this scavenger hunt!</h1>
<h1>Here's your final score:</h1>

<div class="points">
    <img src="${pageContext.request.contextPath}/img/points.svg">
    <div id="pointsCounter"></div>
</div>

<script>
    var pointsCounter = document.getElementById("pointsCounter");
    const cookies = document.cookie.split('; ');
    for (const cookie of cookies) {
        const [name, value] = cookie.split('=');
        if (name === "user_points") {
            pointsCounter.innerHTML = "<h1>" + value + "</h1>";
        }
    }
</script>
</body>
</html>
