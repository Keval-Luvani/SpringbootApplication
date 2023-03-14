<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert Data</title>
</head>
<body>
	<span>Name : </span>
	<span>${user.getName()}</span><br>
	<span>Email : </span>
	<span>${user.getEmail()}</span><br>
	<span>Role : </span>
	<span>${role}</span><br>
	<span>Mobile No : </span>
	<span>${user.getMobileno()}</span><br>
	<a href="update">updateProfile</a>
</body>
</html>