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
<title>Insert title here</title>
</head>
<body>
	<h3>${customerNameError}</h3>
	<div class="scrollbar-thumb"
		style="overflow-x: auto; overflow-y: auto;">
		<table class="table table-striped"
			style="cellspacing: 2; cellpadding: 2; border: 1; width: 100%">
			<thead>
				<tr class="listHeading">
					<th>Part No.</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Reorder Qty</th>
					<th>Min. Order Qty</th>
					<th>Ordered Qty</th>
					<th>Price</th>
				</tr>
			</thead>


			<c:forEach var="map" items="${orderListMap}">
				<div class="col-md-offset-5">
					<c:out
						value="Inventory Reorder Report for Supplier ${map.key.supplierID}"></c:out>
				</div>
				<c:forEach var="p" items="${map.value}">
					<tr class="listRecord">
						<td align="left">${p.partID}</td>
						<td align="left">${p.unitPrice}</td>
						<td align="left">${p.unitsInStock}</td>
						<td align="left">${p.reorderLevel}</td>
						<td align="left">${p.minReorderQty}</td>
						<td align="left">${p.unitsOnOrder}</td>
						<td align="left">${p.unitPrice * p.unitsOnOrder}</td>
					</tr>
				</c:forEach>

			</c:forEach>

		</table>
		<div class="col-md-offset-5">
			<c:out value="~End Of Report~"></c:out>
		</div>
		<c:if test="${empty message}">
			<form:form method="POST"
				action="${pageContext.request.contextPath}/admin/print/report">
				<input type="submit" value="GenerateReport" />
			</form:form>
		</c:if>
	</div>
</body>
</html>