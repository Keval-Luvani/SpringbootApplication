<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert Data</title>
</head>
<body>
	<form action="/conformation" method="post">	
		
		<label for="securitycode">password</label>
		<input name="securitycode" type="password" required="required" /><br>
		
		<button type="submit">Submit</button>
	</form>
</body>
</html>