
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
<h2>Employee List</h2>
<br>
<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/create" var="createLink" />
<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/search" var="searchLink" />

<p>To Add New Employee Details <a href="<c:out value="${createLink}"/>">Click Here</a></p><br><br>
<p>To Search Employee Details <a href="<c:out value="${searchLink}"/>">Click Here</a></p><br><br>
<div>
<c:if test="${actionMessage ne null}">
		<c:out value="${actionMessage}" />
	</c:if>
	<c:if test="${employees eq null}">
		<strong>There Are no Records in the DB.</strong>
	</c:if>
	
	<c:if test="${employees ne null}">
		
<table align="center" width="80%" title="Current Employee List" border="2" cellpadding="2" >
<caption><strong>Current Employee List</strong></caption>
<tr>
<th>View</th>
<th>Delete</th>
<th>Last name</th>
<th>First name</th>
<th>Middle Initial</th>
<th>Email Address</th>
<th>Phone Number</th>
<th>Location</th>
</tr>
<c:forEach items="${employees}" var="bean" >
				<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/delete/${bean.id}" var="delLink" />
				<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/${bean.id}" var="viewLink" />	
				<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/phonenumbers/${bean.id}" var="numberLink" />
				<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/locations/${bean.id}" var="locationLink" />
				<tr>
					<td><a href="<c:out value="${delLink}" />">Delete</a></td>
					<td><a href="<c:out value="${viewLink}" />">View</a></td>
					<td><c:out value="${bean.lastname}" /></td>
					<td><c:out value="${bean.firstname}" /></td>
					<td><c:out value="${bean.middlename}" /></td>
					<td><c:out value="${bean.email}" /></td>					
					<td><a href="<c:out value="${numberLink}" />">Phone Numbers</a></td>
					<td><a href="<c:out value="${locationLink}" />">Locations</a></td>
				</tr>
			</c:forEach>
</table>
</c:if>
</div>
</body>
</html>