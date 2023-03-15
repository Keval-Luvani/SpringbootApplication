<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>header</title>
	</head>
	<body>
		<a href="<c:url value="assignments" />"><span style="margin-right : 20px;"> Assignments </span></a>
		<a href="<c:url value="profile" />"><span style="margin-right : 20px;"> Profile </span></a>
		<a href="<c:url value="/signout" />"><span > Logout </span></a>
	</body>
</html>