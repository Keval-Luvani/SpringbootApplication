<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
   	<head>
       <title>Assignments</title>
       <style>
       table{
       	border-collapse: collapse;
       }
       </style>
    </head>
    <body>
       <jsp:include page="header.jsp" /><br><br>
       <h1>Assignments Data</h1>
       <table BORDER="1">
	      <tr>
		      <th>ID</th>
		      <th>Title</th>
		      <th>Score</th>
		      <th>Description</th>
		      <th>Due Date</th>
	      </tr>
	      <c:forEach items="${assignmentList}" var="assignment" varStatus="row">
    		<tr>
        	   <td>${row.count}</td>
		       <td>${assignment.getTitle()}</td>	
		       <td>${assignment.getScore()} </td>
		       <td>${assignment.getDescription()}</td>
		       <td>${assignment.getDueDate()} </td>
    		</tr>
		  </c:forEach>
	   </table>	
     </body>
</html>