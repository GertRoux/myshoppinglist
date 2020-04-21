<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Capture Retailer Details</title>
<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css" />
	  <link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Joe Public - Retailer Manager</h2>		
		</div>
		<div id="container">
			<h3>Save Retailer</h3>
			<form:form action="saveRetailer" modelAttribute="retailer" method="POST">
	
				<!-- need to associate this data with retailer id -->
				<form:hidden path="id"/>
				
				<table>
					<tbody>
						<tr>
							<td><label>Retailer Name:</label></td>
							<td><form:input path="name"/></td>
						</tr>
						<tr>
							<td><label>Address Line 1:</label></td>
							<td><form:input path="address.line1"/></td>
						</tr>
						<tr>
							<td><label>Address Line 2:</label></td>
							<td><form:input path="address.line2"/></td>
						</tr>
						<tr>
							<td><label>Address Town:</label></td>
							<td><form:input path="address.town"/></td>
						</tr>
						<tr>
							<td><label>Address City:</label></td>
							<td><form:input path="address.city"/></td>
						</tr>
						<tr>
							<td><label>Address Postal Code:</label></td>
							<td><form:input path="address.postalCode"/></td>
						</tr>
						<tr>
							<td><label>Phone Number:</label></td>
							<td><form:input path="phoneNumber"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/retailer/list">Back to Retailers List</a>
			</p>
		</div>
	</div>
</body>
</html>