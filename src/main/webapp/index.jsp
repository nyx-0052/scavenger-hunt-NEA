<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Fettes Scavenger Hunt</title>
  <link rel="stylesheet" type="text/css" href="style/startingpage.css">
</head>

<body>
<img class="startinglogo" src="img/fettes_logo.png" alt="Logo of Fettes College">
<h1>Welcome to the Fettes College Scavenger Hunt!</h1>
<br>
<p>Who are you?</p>
<p>I am a...</p>
<button onclick="launchAdminAuthentication()" class="adminbutton">Admin</button>
<button onclick="launchUserDataConsent()" class="userbutton">User</button>
</body>

<script>
  function launchAdminAuthentication(){
    window.location = "adminInterface/adminAuthentication.jsp";
  }

  function launchUserDataConsent(){
    window.location = "userInterface/userDataConsent.jsp"
  }
</script>

</html>