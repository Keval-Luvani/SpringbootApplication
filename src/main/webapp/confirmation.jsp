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
		<form action="/confirmation" method="post">	
			
			<label for="securitycode">password</label>
			<input name="securitycode" type="password" required="required" /><br>
			
			<span>${error}</span>
			<c:if test="${error}"><br></c:if>	
			
			<button type="submit">Submit</button>
		</form>
		<a href='<c:url value="register"/>' style="text-decoration: none; color:black;"><button>Back</button></a>
	</body>
</html>