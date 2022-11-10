<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="WEB-INF/views/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Item By Price Range</title>
</head>
<body>
<div align="center">
		<h3>Search Item By Price Range</h3><br>
		
		<form action="findItemByPrice" method="post">
			<table>
				<tr>
					<td>Enter the Lowest Price</td>
					<td><input type="text" name="low_price"></td>
				</tr>
				<tr>
					<td>Enter the Highest Price</td>
					<td><input type="text" name="high_price"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Search"></td><td><a href="findItem.jsp"><input type="button" value="Back"></a></td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>