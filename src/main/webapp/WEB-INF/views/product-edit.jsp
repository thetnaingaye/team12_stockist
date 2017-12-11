<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div><h3>Update Product Page</h3></div>

<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/mechanic/product/edit/${product.partID}">		
	
	<!-- product table to update -->
	<table>						
		<tbody>
			
			<tr>
				<td>product id:</td>
				<td><form:input path="partID" readonly="true"/></td>	<!-- set product PartID(primary key) readonly -->
				<td></td>
			</tr>
			<tr>
				<td>product Name:</td>
				<td><form:input path="description" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Unit price:</td>
				<td><form:input path="unitPrice" /></td>
				<td></td>
			</tr>
			<tr>
				<td>color</td>
				<td><form:input path="color" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Dimension</td>
				<td><form:input path="dimension" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Manufacturer</td>
				<td><form:input path="manufacturer" /></td>
				<td></td>
			</tr>
			<tr>
				<td>ReorderLevel</td>
				<td><form:input path="reorderLevel" /></td>
				<td></td>
			</tr>
			<tr>
				<td>MinReorderQty</td>
				<td><form:input path="minReorderQty" /></td>
				<td></td>
			</tr>
			<tr>
				<td>ShelfLocation</td>
				<td><form:input path="shelfLocation" /></td>
				<td></td>
			</tr>
			<tr>
				<td>SupplierID</td>
				<td><form:input path="supplierID" /></td>
				<td></td>
			</tr>
			<tr>
				<td>UnitsInStock</td>
				<td><form:input path="unitsInStock" /></td>
				<td></td>
			</tr>
			<tr>
				<td>UnitsOnOrder</td>
				<td><form:input path="unitsOnOrder" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Discontinued</td>
				<td><form:input path="discontinued" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="edit" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

