<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 21/2/2026
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>${locationObject.getLocationID()}. ${locationObject.getName()}</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/userInterface/userLocationWebpage.css">
</head>
<body>
<h1>${locationObject.getLocationID()}.</h1>
<h2>${locationObject.getName()}</h2>
<p>${locationObject.getDescp()}</p>
<br>
<h4>Curious? Find out more:</h4>
<a href="${locationObject.getSchoolLink()}">${locationObject.getSchoolLink()}</a>

<form action="">
  <div class="qnaContainer">
    <h4 class="qnaHeader">? QNA</h4>
    <h4>${locationObject.getQuestion()}</h4>

    <div class="option">
      <input type="radio" id="option1" name="qna" value="1" required>
      <label for="option1">${locationObject.getOption1()}</label> <br>
    </div>

    <div class="option">
      <input type="radio" id="option2" name="qna" value="2">
      <label for="option2">${locationObject.getOption2()}</label>  <br>
    </div>

    <div class="option">
      <input type="radio" id="option3" name="qna" value="3">
      <label for="option3">${locationObject.getOption3()}</label>  <br>
    </div>
    <input type="submit">
  </div>
</form>
</body>
</html>
