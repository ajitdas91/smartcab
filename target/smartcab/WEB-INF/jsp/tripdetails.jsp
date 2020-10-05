<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Trip Details</title>
	</head>
	<body>
		<h1>Trip Details</h1>
		<form:form commandName="tripCmd">
			<p style="color:red;">
				<form:errors path="*"/>
			</p>			
			<br/>
			<h2>Booking Details</h2>
			<br style="border: 1px"/>
			<table>
				<tr>
					<td>Source:</td>
					<td>						
						${tripCmd.source}
						<form:hidden path="source"/>
					</td>
				</tr>
				<tr>
					<td>Destination:</td>
					<td>
						${tripCmd.dest}
						<form:hidden path="dest"/>
					</td>
				</tr>
				<tr>
					<td>Capacity:</td>
					<td>
						${tripCmd.capacity}
						<form:hidden path="capacity"/>
					</td>
				</tr>
				<tr>
					<td>Cab Id:</td>
					<td>
						${tripCmd.cabId}
						<form:hidden path="cabId"/>
					</td>
				</tr>
				<tr>
					<td>Driver Name:</td>
					<td>
						${tripCmd.driverName}
						<form:hidden path="driverName"/>
					</td>
				</tr>
				<tr>
					<td>Area:</td>
					<td>
						${tripCmd.area}
						<form:hidden path="area"/>
					</td>
				</tr>
			</table>
			<h2>Contact Details</h2>
			<table>
				<tr>
					<td>Name:</td>
					<td>
						<form:input path="name"/>
					</td>
				</tr>
				<tr>
					<td>Mobile:</td>
					<td>
						<form:input path="contactMobile"/>
					</td>
				</tr>
				<tr>
					<td>Proof:</td>
					<td>
						<form:select path="idType">
							<c:forEach items="${supportedProofTypes}" var="proofType">
								<form:option value="${proofType}">${proofType}</form:option>
							</c:forEach>				
						</form:select>
						&nbsp;
						<form:input path="idValue"/>
					</td>
				</tr>
				<tr>
					<td>Waiting Time:</td>
					<td>
						<form:input path="waitingTime"/>
					</td>
				</tr>				
				<tr>
					<td>Emergency Contact:</td>
					<td>
						<form:input path="emergencyContact"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="proceed"/>
					</td>
				</tr>
			</table>
		</form:form>			
	</body>
</html>

