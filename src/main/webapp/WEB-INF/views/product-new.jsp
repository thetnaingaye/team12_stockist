<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
	

<h3 align="left">New Product Entry</h3>
<form:form method="POST" modelAttribute="product" action="${pageContext.request.contextPath}/admin/product/create">
	<table style="border: 10; width: 50%; display: flex; align-items: center">
		<tbody>
			<tr>
				<td>PartID</td>
				<td><form:input path="partID" class="form-control" />&nbsp;&nbsp;
				<form:errors path="partID" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" class="form-control" />&nbsp;&nbsp;
				<form:errors path="description" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>Unit Price</td>
				<td><form:input path="unitPrice" class="form-control" />&nbsp;&nbsp;
				<form:errors path="unitPrice" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>Color<br /></td>
				<td><form:input path="color" class="form-control" />&nbsp;&nbsp;
				<form:errors path="color" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>Dimension</td>
				<td><form:input path="dimension" class="form-control" />&nbsp;&nbsp;
				<form:errors path="dimension" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>Manufacturer</td>
				<td><form:input path="manufacturer" class="form-control" />&nbsp;&nbsp;
				<form:errors path="manufacturer" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>Reorder Level</td>
				<td><form:input path="reorderLevel" class="form-control" />&nbsp;&nbsp;
				<form:errors path="reorderLevel" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>Minumum Reorder Quantity</td>
				<td><form:input path="minReorderQty" class="form-control" />&nbsp;&nbsp;
				<form:errors path="minReorderQty" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>Shelf Location</td>
				<td><form:input path="shelfLocation" class="form-control" />&nbsp;&nbsp;
				<form:errors path="shelfLocation" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>SupplierID</td>
				<td><form:input path="supplierID" class="form-control" />&nbsp;&nbsp;	
				<form:errors path="supplierID" cssStyle="color:red" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
				<td>Quantity</td>
				<td><form:input path="unitsOnOrder" class="form-control" />&nbsp;&nbsp;
				<form:errors path="unitsOnOrder" cssStyle="color:red" /></td>
			</tr>
		</tbody>
	</table>
	
	<input type="submit" value="Enter" class="btn btn-primary" style="position: relative; left: 34.25%;"/>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/product/create" style="position: relative; left: -5%;">Reset</a>
</form:form>



