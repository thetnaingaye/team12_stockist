<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width: 400px; margin-left: auto; margin-right: auto;">

	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST" >

	<c:if test="${param.error !=null }">
		<i style="color:red">Sorry! You entered invalid username/password.</i>

	</c:if>
		<c:if test="${param.logout !=null }">
		<i style="color:green">You have been logged out.</i>
	</c:if>
	

	<table class="table">

		<tr>
			<td style="border-top: none;">USER NAME</td>
			<td style="border-top: none;"><input class="form-control"
				type="text" id="username" name="username" value="sum" /></td>

		</tr>

		<tr>
			<td style="border-top: none;">PASSWORD</td>
			<td style="border-top: none;"><input class="form-control"
				type="password" id="password" name="password" value="1234" /></td>
		</tr>

		<tr>
			<td style="border-top: none;"></td>
			<td style="border-top: none;"><input class="btn btn-primary"
				type="submit" value="Login" /></td>
		</tr>
	</table>

	</form:form>
</div>
