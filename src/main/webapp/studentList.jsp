<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
   	<head>
       <title>Users</title>
    </head>
    <body>
       <h1>Teacher Data</h1>
       <table BORDER="1">
	      <tr>
		      <th>ID</th>
		      <th>Name</th>
		      <th>Email</th>
		      <th>Mobile No.</th>
	      </tr>
	      <c:forEach items="${studentList}" var="student" varStatus="row">
	      	<tr>
        	   <td>${row.count}</td>
		       <td>${student.getName()}</td>	
		       <td>${student.getEmail()} </td>
		       <td>${student.getMobileno()} </td>  
	    	</tr>
		  </c:forEach>
	   </table>	
     </body>
</html>