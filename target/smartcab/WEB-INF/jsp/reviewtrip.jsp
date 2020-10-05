<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Review your Trip!</title>
	</head>
	<body>
		<h2>Review Trip</h2>
		<form:form action="${pageContext.request.contextPath}/confirmtrip.htm" commandName="trip">
			<form:hidden path="source"/>
			<form:hidden path="dest"/>
			<form:hidden path="capacity"/>
			<form:hidden path="cabId"/>
			<form:hidden path="driverName"/>
			<form:hidden path="mobile"/>
			<form:hidden path="area"/>
			<form:hidden path="name"/>
			<form:hidden path="contactMobile"/>
			<form:hidden path="emergencyContact"/>
			<h2>Booking Information</h2>
			<table>
				<tr>
					<td>Source:</td>
					<td>${trip.source}</td>
				</tr>
				<tr>
					<td>Destination:</td>
					<td>${trip.dest}</td>
				</tr>
				<tr>
					<td>Capacity:</td>
					<td>${trip.capacity}</td>
				</tr>
			</table>
			<h2>Cab Information</h2>
			<table>
				<tr>
					<td>Driver Name:</td>
					<td>${trip.driverName}</td>
				</tr>
				<tr>
					<td>Area:</td>
					<td>${trip.area}</td>
				</tr>
			</table>
			<h2>Contact Information</h2>
			<table>
				<tr>
					<td>Name:</td>
					<td>${trip.name}</td>
				</tr>
				<tr>
					<td>Contact Mobile:</td>
					<td>${trip.contactMobile}</td>
				</tr>
				<tr>
					<td>Emergency Contact:</td>
					<td>${trip.emergencyContact}</td>
				</tr>
			</table>
			<input type="submit" value="Confirm"/>		
		</form:form>		
	</body>
</html>


