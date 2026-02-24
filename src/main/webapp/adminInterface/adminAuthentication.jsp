<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 23/1/2026
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Fettes Scavenger Hunt - Authentication</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/adminInterface/adminAuthentication.css">
</head>

<body>
<form action="${pageContext.request.contextPath}/AdminAuthenticationServlet" method="post">
    <label for="password">Please enter the password to continue:</label>
    <input type="password" name="password" id="password" required>
    <div id="wrongInput"></div>
    <input type="submit" value="Log in">
</form>

<script>
    if ("${incorrect}"==="1"){
        document.getElementById("wrongInput").innerHTML= "<p>Incorrect. Please try again.</p>"
    }
</script>

</body>
</html>
