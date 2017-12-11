
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit User Page</h3>
<form:form method="POST" modelAttribute="user"
	action="${pageContext.request.contextPath}/admin/user/edit/${users.id}.html">
	<table>
		<tbody>
			<tr>
				<td>User ID</td>
				<td><form:input class="form-control" path="id" readyonly="true" /></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><form:input class="form-control" path="username" /></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input class="form-control" path="password" /></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td>User Role</td>
				<td><form:input class="form-control" path="userRole" /></td>
			</tr>

			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
