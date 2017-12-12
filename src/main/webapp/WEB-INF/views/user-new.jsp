
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New User Page</h3>
<p>${useralreadyexists}</p>
<form:form method="POST" modelAttribute="user"
	action="${pageContext.request.contextPath}/admin/user/create.html">
	<form:errors />

	<table>
		<tbody>

			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><form:input path="username" class="form-control" /> <form:errors
						path="username" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" class="form-control" /> <form:errors
						path="password" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>

			<tr>
				<td>User Role</td>
				<td><form:select path="userRole" class="form-control">
						<option value="mechanic">mechanic</option>
						<option value="admin">admin</option>
						<option value="inactive">inactive</option>
					</form:select></td>
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
