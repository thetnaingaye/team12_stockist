
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New User Page</h3>
<form:form method="POST" modelAttribute="user"
	action="${pageContext.request.contextPath}/admin/user/create.html">
	<table>
		<tbody>
			<tr>
				<td>User ID</td>
				<td><form:input path="id" class="form-control" /></td>
			</tr>
			<tr>
			<td><br /></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><form:input path="username" class="form-control" /></td>
			</tr>
			<tr>
			<td><br /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" class="form-control" /></td>
			</tr>
			<tr>
			<td><br /></td>
			</tr>
			<tr>
				<td>User Role</td>
				<td><form:input path="userRole" class="form-control" /></td>
			</tr>
<tr>
			<td><br /></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
