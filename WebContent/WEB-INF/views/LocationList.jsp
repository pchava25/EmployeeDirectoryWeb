
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/spring" prefix="spring" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<h1 align="center">Employee Directory</h1>
<br>
<h2>Location List</h2>
<br>
<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/list" var="listLink" />


<p>To View Employee List <a href="<c:out value="${listLink}"/>">Click Here</a></p><br><br>

<div>
<c:if test="${actionMessage ne null}">
		<c:out value="${actionMessage}" />
	</c:if>
	<c:if test="${locations eq null}">
		<strong>There Are no Records in the DB.</strong>
	</c:if>
	
	<c:if test="${locations ne null}">
		
<table align="center" width="80%" title="Current Employee List" border="2" cellpadding="2" >
<caption><strong>Employee Location List</strong></caption>

<tr>
<th>Location ID</th>
<th>Street</th>
<th>City</th>
<th>County</th>
<th>State</th>
<th>Zip</th>
<th>Location Type</th>
</tr>
		
				<c:forEach items="${locations}" var="bean" >					
				<tr>
					<td><c:out value="${bean.locationid}" /></td>
					<td><c:out value="${bean.street}" /></td>
					<td><c:out value="${bean.city}" /></td>
					<td><c:out value="${bean.county}" /></td>
					<td><c:out value="${bean.state}" /></td>
					<td><c:out value="${bean.zip}" /></td>
					<td><c:out value="${bean.locationtype}" /></td>		
					
				</tr>
			</c:forEach>
</table>
</c:if>
</div>
</body>
</html>