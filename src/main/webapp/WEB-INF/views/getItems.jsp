<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Details</title>
</head>
<body>
<div align="center">
		<h3>Item Details</h3>
		
			<table border='1' cellspacing='1' cellpadding='8'>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Stock</th>
				<th>Price</th>
			</tr>
			
			<%
				ResultSet result = (ResultSet)request.getAttribute("itemByPrice");
			
				while(result.next()) {
			%>
			
			<tr>
				<td><%= result.getInt(1)%></td>
				<td><%= result.getString(2)%></td>
				<td><%= result.getInt(3)%></td>
				<td><%= result.getInt(4)%></td>				
			</tr>
			
			<% } %>
		</table>
		<br>
		<a href="findItemByPrice.jsp"><input type="button" value="Back"></a>
	</div>
</body>
</html>