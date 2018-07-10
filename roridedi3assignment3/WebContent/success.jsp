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
		<p>
			Hello
			<%=request.getParameter("name")%></p>
		<p>
			You are registered as a
			<%=request.getParameter("employmentstatus")%></p>
		<p>
			Your email will be sent to:
			<%=request.getParameter("email")%></p>

		<table border="">
			<tr>
				<th>Your Courses</th>
				<th>Cost</th>

			</tr>
			<%
				String[] courses = request.getParameterValues("courses");
				request.setAttribute("rahmanCourses", courses);
				String statuzz = request.getParameter("employmentstatus");
				String price = "0";
				if (statuzz.equalsIgnoreCase("student")) {
					System.out.println("STUDENT");
					price = "1000";
				} else if (statuzz.equalsIgnoreCase("employee")) {
					 price = "850";
				} else if (statuzz.equalsIgnoreCase("other")) {
					price = "1350";
				}
				request.setAttribute("price", price);
				String hotel=request.getParameter("vehicle");

				if(hotel !=null){
					request.setAttribute("hotelprice", "185");
				}else{
					request.setAttribute("hotelprice", "0");
				}
				
				int numberOfCourses=courses.length;
				int cost=numberOfCourses * Integer.valueOf(price);
				System.out.println(cost);
				request.setAttribute("cost", cost);


			%>
			<c:forEach var="course" items='${rahmanCourses}'>
				<tr>
					<td>${course}</td>
					<td>$${price}</td>
				</tr>
			</c:forEach>
				<tr>
				<td>Hotel Accommodation</td>
				<td>$${hotelprice}</td>
			</tr>
					<tr>
				<td>Total</td>
				<td>$${cost}</td>
			</tr>
		
		</table>

	</div>
	<div>
    <button onclick="back()">Back</button>
</div>

<script>
    function back() {
        window.history.back();
    }
</script>
</body>
</html>