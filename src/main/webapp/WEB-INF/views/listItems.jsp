<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Items</title>
</head>
<body>
<div align="center">
		<h3>List of Items</h3><br>
		
		<a href="sortItemsInAsc"><input type="button" value="Price low to high"></a>
		<a href="sortItemsInDesc"><input type="button" value="Price high to low"></a>
		
		<br><br>
		
		<table border='1' cellspacing='1' cellpadding='8'>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Stock</th>
				<th>Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<%
				ResultSet res = (ResultSet)request.getAttribute("result");
			
				while(res.next()) {
			%>
			
			<tr>
				<td><%= res.getInt(1)%></td>
				<td><%= res.getString(2)%></td>
				<td><%= res.getInt(3)%></td>
				<td><%= res.getInt(4)%></td>
				
				<td><a href="update?id=<%= res.getInt(1)%>&stock=<%= res.getInt(3)%>&price=<%= res.getInt(4)%>"><button class="btn"><i class='fas fa-edit' style='font-size:20px'></i></button></a></td>
				<td><a href="delete?id=<%= res.getInt(1)%>"><button class="btn"><i class="fa fa-trash"></i></button></a></td>
			</tr>
			
			<% } %>

		</table>
		
			<%
				if(request.getAttribute("msg") != null) {
					
					out.println(request.getAttribute("msg"));
				}
			%>
			<br>
	</div>
	<br>
</body>
</html>