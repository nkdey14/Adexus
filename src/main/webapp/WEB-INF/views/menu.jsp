<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	img{
		width:30%;
		height: 30%;
	}
</style>
</head>
<body style="background-color:#ffebcd; font-size: 17px">
<!--  
		<h2>Inventory Control System</h2><br>
		
		<a href="saveReg"><input type="button" value="Enter Item details"></a>
		<a href="getItemsController"><input type="button" value="Items List"></a>
		<a href="findItem.jsp"><input type="button" value="Search Item"></a>
		<a href="logoutController"><input type="button" value="Logout"></a>
		
		<br>
		<br>
		-->
		<div align="center">
		
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		  <a class="navbar-brand" href="#"><i class="fa fa-eercast" style="font-size:48px;color:red"></i></a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNavDropdown">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="saveReg">New Item<span class="sr-only"></span></a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="getItemsController">Items<span class="sr-only"></span></a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="findItem.jsp">Search Item<span class="sr-only"></span></a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="logoutController">Logout<span class="sr-only"></span></a>
		      </li>
		    </ul>
		  </div>
		</nav>
		
		<img src="https://1qkeyv41u1op36vgbm47q0i6-wpengine.netdna-ssl.com/wp-content/uploads/2019/08/Reporting-Tools-for-Inventory-Management.png" alt="background-image">
		
	</div>	
	<br>
</body>
</html>