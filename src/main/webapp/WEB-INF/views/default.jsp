<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temporary Test Page</title>
</head>
<body>
<div class="jumbotron text-center">
    <h1>Welcome to Stockist</h1>
  </div>


<p>List of test page</p>
<br/>
<table>
<tr><td><a href="${pageContext.request.contextPath}/mechanic/product/browse">Product-List.jsp GET</a></td></tr>
<tr><td><a href="${pageContext.request.contextPath}/usagerecord/viewcart">view-cart.jsp GET</a></td></tr>
<tr><td><a href="${pageContext.request.contextPath}/admin/supplier/list">Click here to try you have admin access</a></td></tr>
<tr><td><a href="${pageContext.request.contextPath}/admin/print/report">display-report.jsp GET</a></td></tr>
</table>

</body>
</html>