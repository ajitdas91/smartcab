<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Book A Cab!</title>
	</head>
	<body>
		<h1>Get a Cab</h1>
		<form action="${pageContext.request.contextPath}/findcab.htm" method="post">
			<table>
				<tr>
					<td>Source:</td>
					<td>
						<input type="text" name="source"/>
					</td>
				</tr>
				<tr>
					<td>Destination:</td>
					<td>
						<input type="text" name="dest"/>
					</td>
				</tr>
				<tr>
					<td>Capacity:</td>
					<td>
						<select name="capacity">
							<option value="4">4 Seat</option>
							<option value="5">5 Seat</option>
							<option value="6">6 Seat</option>
							<option value="7">7 Seat</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Find"/>
					</td>
				</tr>
			</table>		
		</form>		
	</body>
</html>

