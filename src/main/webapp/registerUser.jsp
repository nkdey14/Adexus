<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body style="background-color:#ffebcd; font-size: 16px">
<div align="center">
		
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		  <a class="navbar-brand" href="#">Inventory Control System</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  </nav>
		
		<img src="https://1qkeyv41u1op36vgbm47q0i6-wpengine.netdna-ssl.com/wp-content/uploads/2019/08/Reporting-Tools-for-Inventory-Management.png" alt="background-image"><br>
		
		<h3>Register here.....</h3>
		
		<form action="userReg" method="post">
			<table>
				<tr>
					<td>Enter Username</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Enter Password</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="cnf_password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Sign up"></td><td><a href="login.jsp"><input type="button" value="Sign in"></a></td>
				</tr>
			</table>
		</form>
		
		<%
			if(request.getAttribute("status") != null) {
				
				out.println(request.getAttribute("status"));
			}
		%>
	</div>
</body>
</html>