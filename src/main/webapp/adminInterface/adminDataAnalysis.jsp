<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 23/2/2026
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fettes Scavenger Hunt - Charts and Data</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminDashboard.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/adminInterface/adminDataAnalysis.css">
</head>
<body>
<div class="dashboardNavBar">
    <img src="${pageContext.request.contextPath}/img/fettes_logo_nav.png" class="navLogo">
    <h3 class="navTitle">Fettes Scavenger Hunt</h3>

    <div class="sectionContainer">
        <h4>Data Analysis</h4>
        <a><div class="functionContainer" id="selected"><img src="${pageContext.request.contextPath}/img/chartsAndData.svg"><p>Charts and Data</p></div></a>
    </div>

    <div class="sectionContainer">
        <h4>Management</h4>
        <a href="${pageContext.request.contextPath}/AdminAddANewPresetServlet"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/addRouteLocation.svg"><p>Add a new preset route</p></div></a>
        <a href="${pageContext.request.contextPath}/AdminAddALocationServlet"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/addRouteLocation.svg"><p>Add a new location</p></div></a>
        <a href="${pageContext.request.contextPath}/adminInterface/adminEditLocation.jsp"><div class="functionContainer"><img src="${pageContext.request.contextPath}/img/editALocation.svg"><p>Edit a location</p></div></a>
    </div>

</div>

<div class="main">
    <div class="chartContainer">
        <h4>Age</h4>
        <div id="ageChart" class="chart"></div>
    </div>
    <div class="chartContainer withOthers">
        <h4>Reason for Visit</h4>
        <div id="reasonForVisitChart" class="chart"></div>
        <form action="${pageContext.request.contextPath}/adminInterface/adminDataAnalysisOthers.jsp">
            <input type="hidden" name="header" value="Reason for Visiting">
            <input type="hidden" name="listOfValues" value="${reasonForVisitOther}">
            <input type="submit" value="Explore Others...">
        </form>
    </div>
    <div class="chartContainer">
        <h4>Gender</h4>
        <div id="genderChart" class="chart"></div>
    </div>
    <div class="chartContainer withOthers">
        <h4>Current School</h4>
        <div id="currentSchoolChart" class="chart"></div>
        <form action="${pageContext.request.contextPath}/adminInterface/adminDataAnalysisOthers.jsp">
            <input type="hidden" name="header" value="Current School">
            <input type="hidden" name="listOfValues" value="${currentSchoolOther}">
            <input type="submit" value="Explore Others...">
        </form>
    </div>
</div>

<script src="https://cdn.plot.ly/plotly-3.3.0.min.js" charset="utf-8"></script>
<script>
    var chartColors = ['#80314D', '#D3A1AB', '#CF5882', '#A61875', '#5D2A4C']
    var layout = {
        margin: { t: 20, b: 20, l: 20, r: 20 },
        automargin: true,
        paper_bgcolor: '#F0F0EA',
        legend: {
            font: {
                color: '#44290C',
                family: 'Verdana',
            }
        }
    }
    // AGE chart
    var data = [{
        values: ${ageData},
        labels: ['11 or below', '12 to 15', '16 to 18', '19 or above'],
        type: 'pie',
        marker:{
            colors: chartColors
        }
    }];
    Plotly.newPlot('ageChart', data, layout, {responsive: true});

    // REASON FOR VISIT chart
    var data = [{
        values: ${reasonForVisitData},
        labels: ['Open Day', 'School Tour', 'External Event', 'Transition/Scholarship', 'Others'],
        type: 'pie',
        marker:{
            colors: chartColors
        }
    }];
    Plotly.newPlot('reasonForVisitChart', data, layout, {responsive: true});

    // GENDER chart
    var data = [{
        values: ${genderData},
        labels: ['Male', 'Female', 'Other'],
        type: 'pie',
        marker:{
            colors: chartColors
        }
    }];
    Plotly.newPlot('genderChart', data, layout, {responsive: true});

    // CURRENT SCHOOL chart
    var data = [{
        values: ${currentSchoolData},
        labels: ['Fettes Prep', 'Local', 'International', 'Others'],
        type: 'pie',
        marker:{
            colors: chartColors
        }
    }];
    Plotly.newPlot('currentSchoolChart', data, layout, {responsive: true});
</script>
</body>
</html>
