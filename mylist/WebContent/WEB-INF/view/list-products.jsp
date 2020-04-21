<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers List</title>

<!-- Now reference our style sheet -->
<!-- ${pageContext.request.contextPath} gives us the path to our application so that Spring knows where to go and look -->
<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Joe Public - Products Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- put new button: Add Retailer -->
			<!-- "window.location.href='showFormForAdd';" calls our Spring Controller Mapping -->
			<input type="button" value="Add Product" onClick="window.location.href='showFormForAdd'; return false;" class="add-button" />
			
			<!--  add a search box -->
            <form:form action="search" method="GET">
                Search retailer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			
			<!-- add html table here -->
			<table>
				<tr>
					<th> Name</th>
					<th> Brand Name</th>
					<th> Description</th>
					<th> Action</th>
				</tr>
				<!-- Loop over and print customers -->
				<c:forEach var="tempProduct" items="${products}">
					<c:url var="updateLink" value="/product/showUpdateForm">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					<c:url var="deleteLink" value="/product/deleteProduct">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					<tr>
						<td>${tempProduct.name}</td>
						<td>${tempProduct.brandName}</td>
						<td>${tempRetailer.description}</td>
						<!-- Update product link -->
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onClick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
			</p>
		</div>
	</div>
</body>
</html>