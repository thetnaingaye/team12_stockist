
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Supplier Record</h3>
<form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/admin/supplier/create.html">
	<table>
		<tbody>
			<tr>
				<td>Supplier ID</td>
				<td><form:input path="supplierID" /></td>
			</tr>
			<tr>
				<td>Company Name</td>
				<td><form:input path="companyName" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="contactNumber" /></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><form:input path="address" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
