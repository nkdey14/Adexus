<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="WEB-INF/views/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Item By Name</title>
</head>
<body>
<div align="center">
		<h3>Search Item By Name</h3><br>
		
		<form action="findItemByName" method="post">
			<table>
				<tr>
					<td>Enter the Item Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Search"></td><td><a href="findItem.jsp"><input type="button" value="Back"></a></td>
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