<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
	

<h3 align="left">Create Book</h3>
<form:form method="POST" modelAttribute="product" action="${pageContext.request.contextPath}/mechanic/product/create">
	<table style="cellspacing: 2; cellpadding: 2; border: 1; width:50%" >
		<tbody>
			<tr>
				<td>PartID</td>
				<td><form:input path="partID" /><br /><form:errors path="partID" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" /><br /><form:errors path="description" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Unit Price</td>
				<td><form:input path="unitPrice" /><br /><form:errors path="unitPrice" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Color<br /></td>
				<td><form:input path="color" /><br /><form:errors path="color" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Dimension</td>
				<td><form:input path="dimension" /><br /><form:errors path="dimension" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Manufacturer</td>
				<td><form:input path="manufacturer" /><br /><form:errors path="manufacturer" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Reorder Level</td>
				<td><form:input path="reorderLevel" /><br /><form:errors path="reorderLevel" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Minimum Reorder Quantity</td>
				<td><form:input path="minReorderQty" /><br /><form:errors path="minReorderQty" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Shelf Location</td>
				<td><form:input path="shelfLocation" /><br /><form:errors path="shelfLocation" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>SupplierID</td>
				<td><form:input path="supplierID" /><br /><form:errors path="supplierID" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><form:input path="unitsOnOrder" /><br /><form:errors path="unitsOnOrder" cssStyle="color:red" /><br /></td><td><br /><br /><br /></td>
			</tr>
		</tbody>
	</table>
	
	<input type="submit" value="Enter" class="btn btn-primary" style="position: relative; left: 34.25%;"/>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/mechanic/product/create" style="position: relative; left: -5%;">Reset</a>
</form:form>



