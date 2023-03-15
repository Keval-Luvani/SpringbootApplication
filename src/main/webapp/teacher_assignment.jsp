<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
   	<head>
       <title>Assignments</title>
    </head>
    <body>
    	<jsp:include page="header.jsp" /><br><br>
       <h1>Assignments Data</h1>
       <table BORDER="1" style="border-collapse: collapse;">
	      <tr>
		      <th>ID</th>
		      <th>Title</th>
		      <th>Score</th>
		      <th>Description</th>
		      <th>Due Date</th>
		      <th>Action</th>
	      </tr>
	      <c:forEach items="${assignmentList}" var="assignment" varStatus="row">
    		<tr>
        	   <td>${row.count}</td>
		       <td>${assignment.getTitle()}</td>	
		       <td>${assignment.getScore()} </td>
		       <td>${assignment.getDescription()}</td>
		       <td>${assignment.getDueDate()} </td>
		       <td>
		       	 <a href='<c:url value="/assignment/update${assignment.getId()}"></c:url>'>Update</a>
		         <a href='<c:url value="/assignment/delete${assignment.getId()}"></c:url>'>Delete</a>
		       </td>  
    		</tr>
		  </c:forEach>
	   </table>
       <a href='<c:url value="/assignment/create"></c:url>'>Create Assignment</a>	
     </body>
</html>