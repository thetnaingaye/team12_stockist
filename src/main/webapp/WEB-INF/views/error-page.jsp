<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<h1>Error Page</h1>
<p>Application has encountered an error.</p>


<!--


Failed URL	: ${url}
User		: ${user.user.username}
Exception	: ${message}
<c:forEach items="${exception.stackTrace}" var="stackTrace">
${stackTrace}
</c:forEach>

 -->
</body>
</html>