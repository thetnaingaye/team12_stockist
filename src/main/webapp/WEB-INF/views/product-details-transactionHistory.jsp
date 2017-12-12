<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<h3>Product Details Page</h3>
</div>


<div>
	<h4 align="center"class="text-uppercase">${pList.description}</h4>
</div>


<h5 align="center" Style="color:red">${msgAlert}</h5>   <!-- Msg alert -->


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

<div class="row">
<div class="col-sm-4">Part ID</div><div class="col-sm-8">${pList.partID}</div>
<div class="col-sm-4">Description</div><div class="col-sm-8">${pList.description}</div>
<div class="col-sm-4">Unit Price</div><div class="col-sm-8">${pList.unitPrice}</div>
<div class="col-sm-4">Color</div><div class="col-sm-8">${pList.color}</div>
<div class="col-sm-4">Dimension</div><div class="col-sm-8">${pList.dimension}</div>
<div class="col-sm-4">Manufacturer</div><div class="col-sm-8">${pList.manufacturer}</div>
<div class="col-sm-4">Reorder Level</div><div class="col-sm-8">${pList.reorderLevel}</div>


<div class="col-sm-4">Minimum Reorder Quantity</div><div class="col-sm-8">${pList.minReorderQty}</div>
<div class="col-sm-4">Shelf Location</div><div class="col-sm-8">${pList.shelfLocation}</div>
<div class="col-sm-4">Supplier ID</div><div class="col-sm-8">${pList.supplierID}</div>
<div class="col-sm-4">Units In Stock</div><div class="col-sm-8">${pList.unitsInStock}</div>
<div class="col-sm-4">Units On Order</div><div class="col-sm-8">${pList.unitsOnOrder}</div>

<div class="col-sm-4">Discontinued</div><div class="col-sm-8">${pList.discontinued}</div>
</div>

<br />
<br />



<!-- Product BY Date Range -->
<div>
<form action="${pageContext.request.contextPath}/mechanic/product/details/filter">
  Filter Date:
  <input type="date" name="startdate">
  <input type="date" name="enddate">
  <input type="hidden" name="pid" value="${pList.partID}">
  <input type="submit">
</form>
</div>



<!-- Transaction History -->
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
					<!-- Iterating through the rList to print out the rList details specific to the tList -->
					<c:forEach var="p1" items="${rList}">
						<!-- If condition to print rList record only if transId is same -->
						<c:if test="${p.transId==p1.transID}">
							<td align="left">${p.transId}</td>
							<td align="left">${p.usedQty}</td>
							<td align="left">${p1.customerName}</td>
							<td align="left">${p1.dateUsed}</td>
						</c:if>



					</c:forEach>
				</tr>
			</c:forEach>






		</tbody>
	</table>
</c:if>


<div>
	<form:form action="${pageContext.request.contextPath}/mechanic/product/addtocart" method="POST">
		<input type="submit" class="btn btn-danger" value="Add">&nbsp;&nbsp;
		<input type="text" name="qty">
		<input id="cartPId" name="cartPId" type="hidden" value="${pList.partID}"/>
	</form:form>
</div>


