<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="component bg-dark text-white">
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
					<a href="/show-menu-list-customer" class=" btn btn-primary btn-lg active" role="button" aria-disabled="true">Menu</a>
					<a href="/show-cart?userId=1" class=" btn btn-primary btn-lg active" role="button" aria-disabled="true">Cart</a>
			</ul>
			</div>
	</nav>
	
	<div class="col-sm-8 p-8" style="width: 70%;">
		<table class="tablecenterheadCSS table table-striped ">
			<caption>
				<h2>Cart</h2>
			</caption>
			
			<div class="text-center text-success">
			<c:if test="${removeCartItemStatus==true}">
				<c:out value="Item removed from Cart sucessfully"></c:out>
			</c:if>
			</div>
			
			
			<div class="text-center text-success">
			<c:if test="${addCartStatus==true}">
				<c:out value="Item added to Cart Sucessfully"></c:out>
			</c:if>
			</div>
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
				<th></th>
			</tr>
			
			
			<tbody>
			<c:forEach items="${cartItems}" var="cart">
				<tr>
					<td>${cart.name}</td>
					
					<td>${cart.freeDelivery}</td>
					<td>Rs.${cart.price}</td>
					<td><a type="button text-center" class="btn btn-warning" href="/remove-cart-item?menuItemId=${cart.id}">Delete</a></td>
				</tr>
			</c:forEach>
			
			<tr>
				<th></th>
				<th>Total</th>
				<th>Rs. ${total}</th>
			</tr>
		</tbody>
		</table>
	</div>
</body>
</html>