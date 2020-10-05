<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cab Trips</title>
	</head>
	<body>	
		<h1>Cab Trips</h1>
		<b>Trips for Cab : ${id}</b>&nbsp;Download : &nbsp;<a href="${pageContext.request.contextPath}/genreports.htm?cabId=${id}&view=xl">(xl)</a> &nbsp; <a href="${pageContext.request.contextPath}/genreports.htm?cabId=${id}&view=pdf">(pdf)</a>
		<table>
			<tr>
				<th>Cab Id</th>
				<th>Source</th>
				<th>Destination</th>
			</tr>					
			<c:forEach items="${trips}" var="trip">
				<tr>
					<td>${trip.cabId}</td>
					<td>${trip.source}</td>
					<td>${trip.dest}</td>
				</tr>
			</c:forEach>
		</table>			
	</body>
</html>



