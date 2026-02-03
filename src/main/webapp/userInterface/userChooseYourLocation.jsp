<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 28/1/2026
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fettes Scavenger Hunt - Choose your Locations...</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/userInterface/userChooseYourLocation.css">
</head>
<body>
<div class="navbar">
    <a href="${pageContext.request.contextPath}/userInterface/userRoutePlanning.jsp"><img src="${pageContext.request.contextPath}/img/backbutton.svg" alt="backbutton"></a>
    <h2>Choose your locations...</h2>
</div>

<div class="listoflocations required">
    <form onsubmit="return validation()" action="${pageContext.request.contextPath}/UserYourRouteServlet" method="get">
        <c:forEach var="item" items="${listofLocations}">
            <div class="labelLocation">
                <label for="checkedlocation">${item.getLocationID()}. ${item.getName()}</label>
                <input type="checkbox" name="checkedlocation" value="${item.getLocationID()}">
            </div>
        </c:forEach>
        <input type="submit" value="Submit">
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function validation(){
        // Source - https://stackoverflow.com/a/30055382
        // Posted by Luca Fagioli, modified by community. See post 'Timeline' for change history
        // Retrieved 2026-02-03, License - CC BY-SA 3.0
        if($('div.listoflocations.required :checkbox:checked').length > 1){
            return true;
        } else{
            window.alert("Please select two or more locations.")
            return false;
        }
    }
</script>
</body>
</html>
