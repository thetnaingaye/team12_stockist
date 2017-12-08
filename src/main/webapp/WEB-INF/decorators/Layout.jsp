<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/darkly/bootstrap.min.css" />
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/lumen/bootstrap.min.css" />--%>

<!-- jQuery library -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 2;
	border-radius: 0;
}



</style>
<decorator:head />
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">STOCKIST IMS</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="">Home</a></li>
				<li><a href="/team12_stockist/product/list">View
						Products</a></li>
				<li><a href="/team12_stockist/product/login1">log in</a></li>

			</ul>
		</div>
	</nav>

	<div>
		<decorator:body />
	</div>

	<footer>
		<br />
		<hr />
		<p>
			&copy;
			<c:set var="testDate" value="<%=new java.util.Date() %>" />
			<fmt:formatDate pattern="y" value="${testDate}" />

			- ISS NUS SA45 - V0.1
		</p>
	</footer>

</body>
</html>
