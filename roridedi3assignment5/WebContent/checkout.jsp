<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JHU Annual Software Development Seminar</title>
    <link rel="stylesheet" href="conferences.css">
</head>
<body>

 	<img width="100%" src="jhubanner.jpg" />
	<h2 style="color: #0000A0">JOHNS HOPKINS ANNUAL SOFTWARE
		DEVELOPMENT SEMINAR</h2>
	<div class="line"></div>
	<br>


 		<p>Hello ${registration.firstName}</p>
		<p>You are registered as a ${registration.employmentStatus}</p>
		<p>Your email will be sent to: ${registration.email}</p>


    <hr width="99%" color="#C4C2C2">
    <br>
    <form action="registerConfirmation" method ="post">
    <table class="ccTable">
        <legend>Credit Card Payment</legend>
        <tr>
            <td>Credit Card Type</td>
            <td>
                <input type="radio" name="cardType" value="visa" checked/>VISA
                <input type="radio" name="cardType" value="masterCard"/>Master Card
                <input type="radio" name="cardType" value="discover"/>Discover
            </td>
        </tr>
        <tr>
            <td>Credit Card Number</td>
            <td>
                <input type="text" name="ccNumber" required id="ccNumber" >
            </td>
        </tr>
        <tr>
            <td>Credit Card Expiration Date</td>
            <td>
                <input type="text" name="expiration" required id="expiration" >
            </td>
        </tr>
    </table>
    <br>
    </form>
<form method="POST" action="EmailServlet" >
		<input type="submit" value="Confirm Registration"> 
	</form>
</body>
</html>
