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
		<form:form action="/register" method="post" modelAttribute="registrationData">
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" required="required" /><br>
			
			<form:label path="email">Email</form:label>
			<form:input path="email" type="email" required="required" /><br>
			
			<form:label path="password">Password</form:label>
			<form:input path="password" type="password" required="required" /><br>
			
			<form:label path="confirmPassword">Confirm Password</form:label>
			<form:input path="confirmPassword" type="password" required="required" /><br>
			
			<form:label path="mobileno">Mobile No.</form:label>
			<form:input path="mobileno" type="text" required="required" /><br>
			
			<form:label path="role">Role</form:label>
			<form:radiobutton path="role" value="ROLE_TEACHER"/>Teacher
			<form:radiobutton path="role" value="ROLE_STUDENT"/>Student <br>
			
			<span style="color:red">${error}</span>
			<form:button>Register</form:button>
			
		</form:form>
		<a href='<c:url value="login"/>' style="text-decoration: none; color:black;"><button>Back</button></a>
	</body>
</html>