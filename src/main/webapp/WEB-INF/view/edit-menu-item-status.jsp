<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Item Update Success</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="component">
<br>
<br>

	<nav class="navbar navbar-dark bg-primary" style="font-weight: bold;">
		<div class="container-fluid">
			<div class="navbar-header">
				<h3>truYum</h3>
			</div>
			<ul class="nav navbar-nav navbar-brand">
				<li class="active"><img style="padding-left: 30%" width="50"
					alt="Logo" src="/images/forkAndKnife.png"></li>
			</ul>
			<ul class="navbar-nav navbar-right nav-link mx-auto">
					<a href="/show-menu-list-admin" class=" btn btn-primary btn-lg active" role="button" aria-disabled="true">Menu</a>
			</ul>
			</div>
	</nav>

	<div class="col-sm-8 p-8" style="width: 70%;">
		<h2>Edit Menu Item Status</h2>
		<br>
		<br>
		<p class="text-success">Menu Item details saved successfully</p>
	</div>


</body>
</html>