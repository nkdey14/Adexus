<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Item Registration</title>
</head>
<body>
<div align="center">		
		<h3>Enter New Item details here.....</h3><br>
		
		<form action="saveReg" method="post">
			<table>
				<tr>
					<td>Id</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Stock</td>
					<td><input type="text" name="stock"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price"></td>
				</tr>
	  		    <tr>
					<td></td>
					<td><input type="submit" value="Save"></td>
				</tr>   
			</table>
		</form>
		
		<%
			if(request.getAttribute("msg") != null) {
				
				out.println(request.getAttribute("msg"));
			}
		%>
	</div>
</body>
</html>