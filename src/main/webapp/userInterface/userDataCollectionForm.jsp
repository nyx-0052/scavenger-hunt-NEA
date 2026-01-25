<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 23/1/2026
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fettes Scavenger Hunt - Data Collection Form</title>
</head>
<body>
<form onsubmit = "return validation()">
    <fieldset>
        <legend>Age:</legend>
        <input type="radio" id="below11" name="age" value="1" required>
        <label for="below11">11 or below</label>
        <br>
        <input type="radio" id="12to15" name="age" value="2">
        <label for="12to15">12 to 15</label>
        <br>
        <input type="radio" id="16to18" name="age" value="3">
        <label for = "16to18">16 to 18</label>
        <br>
        <input type="radio" id="above19" name="age" value="4">
        <label for="above19">19 or above</label>
    </fieldset>

    <fieldset>
        <legend>Gender:</legend>
        <input type="radio" id="male" name="gender" value="1" required>
        <label for="male">Male</label>
        <br>
        <input type="radio" id="female" name="gender" value="2">
        <label for="female">Female</label>
        <br>
        <input type="radio" id="other" name="gender" value="3">
        <label for="other">Other</label>
    </fieldset>

    <fieldset>
        <legend>Reason for Visit:</legend>
        <input type="radio" id="openday" name="reasonforvisit" value="1" required>
        <label for="openday">Open Day</label>
        <br>
        <input type="radio" id="schooltour" name="reasonforvisit" value="2">
        <label for="schooltour">School Tour</label>
        <br>
        <input type="radio" id="externalevent" name="reasonforvisit" value="3">
        <label for="externalevent">External Event</label>
        <br>
        <input type="radio" id="transition" name="reasonforvisit" value="4">
        <label for="transition">Transition/Scholarship</label>
        <br>
        <input type="radio" id="otherreasonforvisit" name="reasonforvisit" value="5">
        <label for="otherreasonforvisit">Others</label>
        <input type="text" id="otherreasonforvisittext">
        <br>
    </fieldset>

    <fieldset>
        <legend>Current School:</legend>
        <input type="radio" id="fettesprep" name="currentschool" value="1" required>
        <label for="fettesprep">Fettes Prep</label>
        <br>
        <input type="radio" id="local" name="currentschool" value="2">
        <label for="local">Local</label>
        <br>
        <input type="radio" id="international" name="currentschool" value="3">
        <label for=“international”>International</label>
        <br>
        <input type="radio" id="othercurrentschool" name="currentschool" value="4">
        <label for="othercurrentschool">Others</label>
        <input type="text" id="othercurrentschootext">
    </fieldset>

    <input type="submit">
</form>


<script>
    function validation(){
        let textbox;
        if (document.querySelector('input[name="reasonforvisit"]:checked').value== 5){
            textbox = document.getElementById("otherreasonforvisittext");
            if(textbox.value === ""){
                window.alert("Please fill in the textbox.")
                return false;
            }
        } else if (document.querySelector('input[name="currentschool"]:checked').value == 4){
            textbox = document.getElementById("othercurrentschooltext");
            if(textbox.value === ""){
                window.alert("Please fill in the textbox.")
                return false;
            }
        } else {
            return true;
        }
    }
</script>

</body>
</html>
