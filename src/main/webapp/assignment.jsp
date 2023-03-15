<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Insert Assignment Data</title>
	</head>
	<body>
	
		<form:form action="submit" method="post" modelAttribute="assignment">
			<form:input path="id" type="hidden" required="required" />
			
			<form:label path="title">Title</form:label>
			<form:input path="title" type="text" required="required" /><br>
			
			<form:label path="description">Description</form:label>
			<form:textarea path="description" rows="2" cols="30" required="required" /><br>
			
			<form:label path="score">Score</form:label>
			<form:input path="score" type="score" required="required" /><br>
			
			<form:label path="dueDate">Due Date</form:label>
			<form:input path="dueDate" type="date" min="${todayDate}" required="required" /><br>
			
			<form:input path="teacher" type="hidden" required="required" />
			
			<span style="color:red">${error}</span>
			
			<form:button>Submit</form:button>
		</form:form>
		<a href='<c:url value="/teacher/assignments"/>' style="text-decoration: none; color:black;"><button>Back</button></a>
	</body>
</html>