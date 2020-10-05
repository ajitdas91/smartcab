<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Reports</title>
	</head>
	<body>
		<h2>Reports</h2>
		<form action="${pageContext.request.contextPath}/genreports.htm" method="post">
			Cab Id: <select name="cabId">
						<c:forEach items="${cabIds}" var="id">
							<option value="${id}">${id}</option>
						</c:forEach>				
					</select>
					<br/>
			<input type="submit" value="Generate"/>		
		</form>
	</body>
</html>