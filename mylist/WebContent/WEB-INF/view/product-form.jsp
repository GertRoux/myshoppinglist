<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Capture Product Details</title>
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
			<h2>Joe Public - Product Manager</h2>		
		</div>
		<div id="container">
			<h3>Save Product</h3>
			<form:form action="saveProduct" modelAttribute="product" method="POST">
	
				<!-- need to associate this data with product id -->
				<form:hidden path="id"/>
				
				<table>
					<tbody>
						<tr>
							<td><label>Product Name:</label></td>
							<td><form:input path="name"/></td>
						</tr>
						<tr>
							<td><label>Brand Name:</label></td>
							<td><form:input path="brandName"/></td>
						</tr>
						<tr>
							<td><label>Description:</label></td>
							<td><form:input path="description"/></td>
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
				<a href="${pageContext.request.contextPath}/product/list">Back to Products List</a>
			</p>
		</div>
	</div>
</body>
</html>