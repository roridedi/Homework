<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.line {
	border-top: 5px solid grey;
	flex-grow: 1;
	margin: 0;
	width: 100%
}
</style>
<meta charset="UTF-8">
<title>JHU Successful Registration Form</title>
</head>
<body>
	<img width="100%" src="jhubanner.jpg" />
	<h2 style="color: #0000A0">JOHNS HOPKINS ANNUAL SOFTWARE
		DEVELOPMENT SEMINAR</h2>
	<div class="line"></div>
	<br>

	<div>
		<p>Hello ${registration.firstName}</p>
		<p>You are registered as a ${registration.employmentStatus}</p>
		<p>Your email will be sent to: ${registration.email}</p>

		<table border="">
			<tr>
				<th>Your Courses</th>
				<th>Cost</th>

			</tr>
			<c:forEach var="course" items='${registration.courses}'>
				<tr>
					<td>${course.courseName}</td>
					<td>$${registration.price}</td>

					<td><form name="deleteCourse" action="RegistrationServlet"
							method="POST">
							<input type="hidden" name="action" value='${course.courseName}' />
							<input type="submit" value="Remove" />
						</form></td>
					<!-- <td><button class="remove" value='${course.courseName}' onclick="deleteRow(this)">Remove</button></td> -->
					<!--<td><input type="button" value="Remove Item"
						onclick="deleteRow(this)"></td>  -->




				</tr>
			</c:forEach>
			<tr>
				<td>Hotel Accommodation</td>
				<td>$${registration.hotelPrice}</td>
			</tr>
			<tr>
				<td>Total</td>
				<td>$${registration.total}</td>
			</tr>

		</table>

	</div>

	<form action="index.html">
		<input type="hidden" name="action" value="edit"> 
			<input type="submit" value="Back"> 
			<input type="submit" value="Edit Information"> 
			<input type="submit" value="Add More Courses">
	</form>
<!-- 
<form method="POST" action="EmailServlet" >
		<input type="submit" value="Confirm Registration"> 
	</form>
 -->	
 <form method="GET" action="PaymentServlet" >
		<input type="submit" value="Proceed To Checkout"> 
	</form>
	<script>
		function back() {
			window.history.back();
		}

		function deleteRow(o) {
			//no clue what to put here?
			var p = o.parentNode.parentNode;
			p.parentNode.removeChild(p);
		}
	</script>
</body>
</html>