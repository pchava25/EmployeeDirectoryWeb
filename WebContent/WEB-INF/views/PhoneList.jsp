
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
<h2>Phone List</h2>
<br>
<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/list" var="listLink" />


<p>To View Employee List <a href="<c:out value="${listLink}"/>">Click Here</a></p><br><br>

<div>
<c:if test="${actionMessage ne null}">
		<c:out value="${actionMessage}" />
	</c:if>
	<c:if test="${numbers eq null}">
		<strong>There Are no Records in the DB.</strong>
	</c:if>
	
	<c:if test="${numbers ne null}">
		
<table align="center" width="80%" title="Current Employee List" border="2" cellpadding="2" >
<caption><strong>Employee Phone Number List</strong></caption>

<tr>
<th>Phone ID</th>
<th>Phone Number</th>
<th>Phone Type</th>
</tr>
		
				<c:forEach items="${numbers}" var="bean" >					
				<tr>
					<td><c:out value="${bean.phoneid}" /></td>
					<td><c:out value="${bean.number}" /></td>
					<td><c:out value="${bean.phonetype}" /></td>
					
				</tr>
			</c:forEach>
</table>
</c:if>
</div>
</body>
</html>