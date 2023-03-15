<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Insert Data</title>
	</head>
	<body>
		<jsp:include page="header.jsp" /><br><br>
		<form:form action="update" method="post" modelAttribute="${role}">
			<form:input path="id" type="hidden" required="required" />
			
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" required="required" /><br>
			
			<form:label path="email">Email</form:label>
			<form:input path="email" type="email" required="required" disabled="true"/><br>
			<form:input path="email" type="hidden" equired="required" />
			
			<form:label path="mobileno">Mobile No.</form:label>
			<form:input path="mobileno" type="text" required="required" /><br>
			
			<span style="color:red;margin:0px;">${error}</span>
			
			<form:button>Update</form:button>
			
		</form:form>
		<a href='<c:url value="profile"/>' style="text-decoration: none; color:black;"><button>Back</button></a>
	</body>
</html>