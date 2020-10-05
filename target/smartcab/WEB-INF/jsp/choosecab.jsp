<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Select Cab</title>
	</head>
	<body>
		<h1>Pick Cab of your choice</h1>
		<c:choose>
			<c:when test="${cabs ne null}">
				<table>		
					<tr>
						<th>Cab Id</th>
						<th>Driver Name</th>
						<th>Location</th>
					</tr>
					<c:forEach items="${cabs}" var="cab">
						<tr>
							<td>
								<a href="${pageContext.request.contextPath}/tripdetails.htm?id=${cab.cabId}&src=${cabdetails.source}&destination=${cabdetails.dest}&cap=${cabdetails.capacity}">
								${cab.cabId}
								</a>
							</td>
							<td>${cab.driverName}</td>					
							<td>${cab.area}</td>
						</tr>		
					</c:forEach>			
				</table>
			</c:when>
			<c:otherwise>
				<p style="color: red;"> 
					<h2>No cabs Available!</h2>
				</p>
			</c:otherwise>
		</c:choose>
	</body>
</html>