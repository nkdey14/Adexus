<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Item Details</title>
</head>
<body>
<div align="center">
		<h3>Update Item Details</h3>
		
		<form action="update" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="id" value="<%= request.getAttribute("id")%>"></td>
				</tr>
				<tr>
					<td>New Stock</td>
					<td><input type="text" name="stock" value="<%= request.getAttribute("stock")%>"></td>
				</tr>
				<tr>
					<td>New Price</td>
					<td><input type="text" name="price" value="<%= request.getAttribute("price")%>"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>