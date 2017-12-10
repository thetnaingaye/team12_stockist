<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Edit Cart Item</title>
</head>
<body>
	<form:form method="POST" modelAttribute="cartItem"
		action="${pageContext.request.contextPath}/usagerecord/edit/${cartItem.product.partID }">
		<div>
			<table style="cellspacing: 2; cellpadding: 2; border: 1; width: 50%">
				<tr>
					<td>Name: ${cartItem.product.description}</td>
					<td></td>
				</tr>
				<tr>
					<td>Quantity: ${cartItem.quantity}</td>
					<td></td>
				</tr>
			</table>
			<input type="submit" value="Update" />
	</form:form>
</body>
</html>