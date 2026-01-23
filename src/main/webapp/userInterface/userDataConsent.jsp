<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 23/1/2026
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fettes Scavenger Hunt - Data Consent </title>
    <link rel="stylesheet" type="text/css" href="../style/userDataConsent.css">
</head>

<body>
<h2>Thank you for visiting Fettes College today.</h2>
<h2>Just a wee request before we start...</h2><br>
<p>In order to improve our future school events, we are hoping to collect data from our users.</p>
<p><strong>All data is collected anonymously.</strong></p>
<ul>
    <li><b>What type of data is collected:</b> your age, gender, reason for visiting Fettes and current school.</li>
    <li><b>How it will be stored:</b> in a local database.</li>
    <li><b>Who it will be shared with:</b> relevant staff members from our admissions and marketing department.</li>
    <li><b>What we do with the data:</b> it will be only used internally to improve future school events and tours.</li>
</ul>
<p>By clicking agree, you are consenting to having your data stored and used for the above purposes.</p>

<button onclick="consent()">I consent</button>
<button onclick="noConsent()">I do NOT consent</button>
<p>We thank you again for your help and time to make future events enjoyable for everyone.</p>
</body>

<script>
    function consent(){
        if(confirm("By proceeding, you are confirming that you are either over the age of 13, or have parental consent.")){
            window.location = "userDataCollectionForm.jsp";
        }
    }

    function noConsent(){
        window.location = "userRoutePlanning.jsp";
    }
</script>
</html>
