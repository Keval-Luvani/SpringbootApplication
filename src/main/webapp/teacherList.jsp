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
	      <c:forEach items="${teacherList}" var="teacher" varStatus="row">
	      	<tr>
        	   <td>${row.count}</td>
		       <td>${teacher.getName()}</td>	
		       <td>${teacher.getEmail()} </td>
		       <td>${teacher.getMobileno()} </td>  
	    	</tr>
		  </c:forEach>
	   </table>	
     </body>
</html>