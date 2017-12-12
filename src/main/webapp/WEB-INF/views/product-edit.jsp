<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div><h3>Update Product Page</h3></div>

<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/mechanic/product/edit/${product.partID}">		
	
	<!-- product table to update -->
	<table style="cellspacing: 2; cellpadding: 2; border: 1; width:50%" >
<tbody>	
			<tr>
				<td>PartID:</td>
				<td><form:label path="partID" />${product.partID}</td><td><form:errors path="partID" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description" /></td><td><form:errors path="description" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Unit Price:</td>
				<td><form:input path="unitPrice" pattern="^\d{0,2}+$" /></td><td><form:errors path="unitPrice" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Color:<br /></td>
				<td><form:input path="color" /></td><td><form:errors path="color" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Dimension:</td>
				<td><form:input path="dimension" /></td><td><form:errors path="dimension" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Manufacturer:</td>
				<td><form:input path="manufacturer" /></td><td><form:errors path="manufacturer" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Reorder Level:</td>
				<td><form:input path="reorderLevel" pattern="^\d+$"/></td><td><form:errors path="reorderLevel" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Minimum Reorder Quantity:</td>
				<td><form:input path="minReorderQty" pattern="^\d+$"/></td><td><form:errors path="minReorderQty" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Shelf Location:</td>
				<td><form:input path="shelfLocation" /></td><td><form:errors path="shelfLocation" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>SupplierID:</td>
				<td><form:input path="supplierID" /></td><td><form:errors path="supplierID" cssStyle="color:red" /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>UnitSInOrder:</td>
				<td><form:input path="unitsOnOrder" pattern="^\d+$"/></td><td><form:errors path="unitsOnOrder" cssStyle="color:red" /><br /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>UnitsInStock:</td>
				<td><form:input path="unitsInStock" pattern="^\d+$"/></td><td><form:errors path="unitsInStock" cssStyle="color:red" /><br /></td><td><br /><br /><br /></td>
			</tr>
			<tr>
				<td>Discontinue:</td>
				<td>
					<form:select path="discontinued" >
						<form:option value = "0">True</form:option>
              			<form:option value = "1">False</form:option>
					</form:select>
				</td>
				<td><form:errors path="discontinued" cssStyle="color:red" /><br /></td><td><br /><br /><br /></td>
			</tr>
		</tbody>
	</table>

<!-- pattern="^\d{1}$" -->

<br/>
<br/>

<input type="submit" value="Edit" class="btn btn-primary" style="position: relative; left: 34.25%;"/>
</form:form>
				
			