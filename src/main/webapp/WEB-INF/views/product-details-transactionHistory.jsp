<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<h3>Product Details Page</h3>
</div>


<div>
	<h4 align="center">${pList.description}</h4>
</div>
<div>PartId:${pList.partID}</div>
<div>Description:${pList.description}</div>
<div>UnitPrice:${pList.unitPrice}</div>
<div>Color:${pList.color}</div>
<div>Dimension:${pList.dimension}</div>
<div>Manufacturer:${pList.manufacturer}</div>
<div>ReorderLevel:${pList.reorderLevel}</div>
<div>MinimumReorderQuantity:${pList.minReorderQty}</div>
<div>ShelfLocation:${pList.shelfLocation}</div>
<div>SupplierID:${pList.supplierID}</div>
<div>UnitsInStock:${pList.unitsInStock}</div>
<div>UnitsOnOrder:${pList.unitsOnOrder}</div>
<div>Discontinued:${pList.discontinued}</div>
<br />
<br />
<div>
	<h4 align="center">Transaction History</h4>
</div>
<c:if test="${fn:length(tList) gt 0}">
	<table class="table table-striped"
		style="cellspacing: 2; cellpadding: 2; border: 1; width: 100%">
		<thead>
			<tr class="listHeading">
				<th>TransactionId</th>
				<th>UsedQuantity</th>
				<th>CustomerName</th>
				<th>DateUsed</th>

			</tr>
		</thead>
		<tbody>
			<!-- Iterating through tList.Printing transId and Usedquantity of product -->
			<c:forEach var="p" items="${tList}">
				<tr class="listRecord">

					<td align="left">${p.transId}</td>
					<td align="left">${p.usedQty}</td>
					<!-- Iterating through the rList to print out the rList details specific to the tList -->
					<c:forEach var="p1" items="${rList}">
						<!-- If condition to print rList record only if transId is same -->
						<c:if test="${p.transId==p1.transID}">

							<td align="left">${p1.customerName}</td>
							<td align="left">${p1.dateUsed}</td>
						</c:if>



					</c:forEach>
				</tr>
			</c:forEach>






		</tbody>
	</table>
</c:if>

<div align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/mechanic/product/checkout/${p.partID}.html">Add to Cart</a><div>