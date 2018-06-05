<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
    	<title>Employee Search</title>
  	</head>

<body>
	<h2>Employee Search</h2>
		
	<c:if test="${actionMessage ne null}">
		<c:out value="${actionMessage}" />
	</c:if>
		
	<form:form modelAttribute="employeeSearchForm" action="search" method="post">
		<table border="0" cellspacing="3" cellpadding="0" align="center">
			<tr>
				<td align="right"><form:label for="searchTerm" path="searchTerm" cssErrorClass="error">Search Text :</form:label></td>
				<td align="left"><form:input path="searchTerm" size="20" maxlength="70" /> <form:errors path="searchTerm" /></td>	
			</tr>
			<tr>
				<td align="right"><form:label for="searchType" path="searchType" cssErrorClass="error">Search In :</form:label></td>
				<td align="left">
					<form:select path="searchType">
						<form:option name="lastname" value="lastname" >Last Name</form:option>
						<form:option name="firstname" value="firstname" >First Name</form:option>
						<form:option name="phonenumbers" value="phonenumbers" >Phone Number</form:option>						
					</form:select> 
				 	<form:errors path="searchType" />
				</td>	
			</tr>				
		</table>
		<hr />
		<div align="center">
			<input type="submit" /> |
			<input type="reset" />
		</div>		
	</form:form>
  </body>
</html>