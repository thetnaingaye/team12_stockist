<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Item Cart</title>
</head>
<body>
	<form:form method="POST" modelAttribute="cartList"
		action="${pageContext.request.contextPath}/usagerecord/viewcart">
		<div>
			<table style="cellspacing: 2; cellpadding: 2; border: 1; width: 50%">
				<tr>
					<td>Name: ${cartList.user.username}</td>
					<td></td>
				</tr>
				<tr>
					<td>Cart ID: ${cartList.cartId}</td>
					<td></td>
				</tr>

			</table>
		</div>
		<br />
		Customer Name: <form:input path="customerName" />
		<input type="submit" value="Checkout" />
		<table class="table table-striped"
			style="cellspacing: 2; cellpadding: 2; border: 1; width: 100%">
			<thead>
				<tr>
					<td align="center">Part ID</td>
					<td align="center">Description</td>
					<td align="center">Quantity</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${cartList.cartItemList}"  varStatus="loop">
					<tr>
						<td align="center">${i.product.partID}</td>
						<td align="center">${i.product.description}</td>
						<td align="center">${i.quantity}</td>
						<td align="center"><a class="btn btn-primary"
							href="${pageContext.request.contextPath}/usagerecord/viewcart/edit/${loop.index}">Amend</a></td>
						<td><a class="btn btn-danger"
							href="${pageContext.request.contextPath}/usagerecord/viewcart/delete/${loop.index}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form:form>
</body>
</html>