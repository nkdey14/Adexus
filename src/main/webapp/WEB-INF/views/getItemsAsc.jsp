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
		<h3>Price low to high</h3>
		
			<table border='1' cellspacing='1' cellpadding='8'>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Stock</th>
				<th>Price</th>
			</tr>
			
			<%
				ResultSet rec = (ResultSet)request.getAttribute("itemsInAsc");
			
				while(rec.next()) {
			%>
			
			<tr>
				<td><%= rec.getInt(1)%></td>
				<td><%= rec.getString(2)%></td>
				<td><%= rec.getInt(3)%></td>
				<td><%= rec.getInt(4)%></td>				
			</tr>
			
			<% } %>
		</table>
		<br>
		<a href="getItemsController"><input type="button" value="Back"></a>
		<br>
	</div>
</body>
</html>