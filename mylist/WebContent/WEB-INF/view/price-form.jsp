<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Capture Price Details</title>
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
			<h2>Joe Public - Price Manager</h2>		
		</div>
		<div id="container">
			<h3>Save Price</h3>
			<form:form action="savePrice" modelAttribute="price" method="POST">
	
				<table>
					<tbody>
						<tr>
							<td><label>Price:</label></td>
							<td><form:input path="price"/></td>
						</tr>
						<tr>
							<td><label>Date Of Purchase:</label></td>
							<td>
								<fmt:formatDate var="fmtDate" value="${dateOfPurchase}" pattern="dd/MM/yyyy H:mm:ss"/>
								<input type="text" name="dateOfPurchase" value="${fmtDate}"/>
							</td>
						</tr>
						<tr>
							<td><label>Product:</label></td>
							<td>
								<form:select path="product">
									<form:options items="${products}" itemValue="id" itemLabel="name" />
								</form:select>								
							</td>
						</tr>
						<tr>
							<td><label>Retailer:</label></td>
							<td>
								<form:select path="retailer">
									<form:options items="${retailers}" itemValue="id" itemLabel="name"/>
								</form:select>
							</td>
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
				<a href="${pageContext.request.contextPath}/price/list">Back to Prices List</a>
			</p>
		</div>
	</div>
	
</body>
</html>