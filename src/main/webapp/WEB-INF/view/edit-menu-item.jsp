<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Edit Menu Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="component">
<br>
<br>

	<nav class="navbar navbar-dark bg-primary">
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
	${menuItem}
		<form:form method="post" modelAttribute="menuItem" action="edit-menu-item" name="menuItemForm">
			
				<form:hidden path="id"/>
				<fieldset class="form-group">
					<form:label path="name">Name</form:label>
					<form:input path="name" id="name" class="form-control"/>
					<form:errors path = "name" cssClass="text-warning" data-error-msg="Title is required"/>
				</fieldset>
				
				<div class="form-row">
				<fieldset class="form-group col-sm-2">
					<form:label path="price">Price(Rs.)</form:label>
					<form:input path="price" id="price" class="form-control"/>
					<form:errors path = "price" cssClass="text-warning" data-error-msg="Price is required"/>
				</fieldset>
				
				
				
				<fieldset class="form-group col-sm-2 form-check form-check-inline">
					<form:label path="active">Active</form:label><br>
					Yes<form:radiobutton path="active" value="Yes"/>
					No<form:radiobutton path="active" value="No"/>
					
				</fieldset>
				
				
				<fieldset class="form-group col-sm-2">
					<form:label path="dateOfLaunch">Date of Launch</form:label>
					<form:input path="dateOfLaunch" id="dateOfLaunch" date-date-format="dd/MM/yyyy" class="form-control"/>
					<form:errors path = "dateOfLaunch" cssClass="text-warning" data-error-msg="Launch Date required"/>
				</fieldset>
				
				<fieldset class="form-group col-sm-2">
					<form:label path="category">Category</form:label>
					<form:select path="category" class="form-control" required="required">
						<form:option path="category" value="Starters">Starters</form:option>
						<form:option path="category" value="Main Course">Main Course</form:option>
						<form:option path="category" value="Dessert">Dessert</form:option>
						<form:option path="category" value="Drinks">Drinks</form:option>
					</form:select>
				</fieldset>
				</div>

			<div class="checkbox col-sm-8">
				<div class="form-group check-box">
					<div class="col-sm-8">
					<form:checkbox path="freeDelivery" class="form-check-input" id="freeDelivery"/>
					<form:label path="freeDelivery" class="form-check-label pull-left" for="freeDelivery"> Free Delivery</form:label>
				</div>
				</div>
			</div>
			
			

			<div class="form-group">
						 <div class="row">
							 <div class="col-sm-12">
								 <button type="submit" class="btn btn-success pull-left">Save</button>
							 </div>
						 </div>
					 </div>
			</form:form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

	<script>
		$('#dateOfLaunch').datepicker({
			todayHighlight: true,
			format : 'mm/dd/yyyy'
			
		});
		
	</script>
</body>
</html>