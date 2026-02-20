<%--
  Created by IntelliJ IDEA.
  User: elsa_lty
  Date: 19/2/2026
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QR Code scanner</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/userInterface/userQRCodeScanner.css">
</head>

<body>
<div class="navbar">
<input type="image" src="${pageContext.request.contextPath}/img/backbutton.svg" onclick="history.back()"/>
<h2>Scan me!</h2>
</div>

<ol>
    <li>Click on Camera Permissions.</li>
    <li>Grant access to device's camera.</li>
    <li>Select preferred camera and click Start Scanning to begin!</li>
</ol>


<button onclick="cameraPerms()" id="cameraPerms">Camera Permissions</button>
<div id="listCameras"></div>

<!--For generating the QR code scanner and result-->
<div id="reader"></div>
<div id="scannedResult"></div>

<script src="https://unpkg.com/html5-qrcode" type="text/javascript"></script>
<script>
    async function cameraPerms(){
        <!--Toggles visibility of button off after clicked; clears up UI and prevents user from repeatedly getting list of devices-->
        document.getElementById("cameraPerms").style.display="none";

        <!--Gets all possible cameras from device and generates 1) a dropdown menu with those cameras as options 2) button to launch scanner-->
        var devices = await Html5Qrcode.getCameras();
        if (devices.length == 0){
            alert("No cameras available.");
        } else{
            var devicesInsert="";
            for (var i=0; i<devices.length; i++){
                var nameOfDevice = devices[i].label;
                devicesInsert += "<option value="+ i + ">"+ nameOfDevice + "</option>"
            }
            document.getElementById('listCameras').innerHTML=
                "<h4>Choose from the following cameras: ("+ devices.length+")</h4>"+
                "<select id='cameras'>" +
                devicesInsert + "</select>" + "<button onclick='startScanning()'>Start Scanning</button>"
        }
    }
    <!--Launches QR code scanner-->
    async function startScanning() {
        <!--Retrieves selected camera from menu and sets as cameraId (to be passed into the constructor)-->
        var retrievedValue = parseInt(document.getElementById("cameras").value);
        var devices = await Html5Qrcode.getCameras(); // await is needed as the next line relies on this, and it needs some time to execute
        var cameraId = devices[retrievedValue].id;

        <!-- constructs QR code scanner -->
        const html5QrCode = new Html5Qrcode("reader");
        await html5QrCode.start(cameraId,
            {
                aspectRatio: 1,
                fps: 10,
                qrbox: { width: 300, height: 300 },
                rememberLastUsedCamera: true
            },
            (result) => {
                document.getElementById('scannedResult').innerHTML = "<h3>Success!</h3>"
                html5QrCode.stop()
                html5QrCode.clear()
            })
            .catch((err) => {
                console.log(err);
            });
    }
</script>
</body>
</html>
