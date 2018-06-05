<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details Creation</title>
</head>

<body>


<h1 align="center">Employee Directory</h1>
<br>
<h2>Employee Details Creation</h2>
<br>

<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/list" var="listLink" />

<p>To Go Back To Employee List <a href="<c:out value="${listLink}"/>">Click Here</a></p>
<br>
<div>
<c:if test="${actionMessage ne null}">
		<c:out value="${actionMessage}" />
	</c:if>
	
	
<form:form modelAttribute="employeeForm" action="submit"  method="post">
<fieldset title="info">
<legend><b>Employee Information</b></legend>
<div>
<table>
<tr>
	<td align="right"><form:label for="id" path="id" cssErrorClass="error">*Employee ID :</form:label></td>
	<td align="left"><form:input path="id" size="30" maxlength="11" minlength="9" /> </td><td align="left"><form:errors path="id" /></td>	
</tr>
<tr>
	<td align="right"><form:label for="firstname" path="firstname" cssErrorClass="error">*First Name :</form:label></td>
	<td align="left"><form:input path="firstname" size="30" maxlength="20" /> </td><td align="left"><form:errors path="firstname" /></td>	
</tr>
<tr>
	<td align="right"><form:label for="lastname" path="lastname" cssErrorClass="error">*Last Name :</form:label></td>
	<td align="left"><form:input path="lastname" size="30" maxlength="20" /></td><td align="left"> <form:errors path="lastname" /></td>	
</tr>
<tr>
	<td align="right"><form:label for="middlename" path="middlename" cssErrorClass="error">Middle Name :</form:label></td>
	<td align="left"><form:input path="middlename" size="30" maxlength="20" /></td><td align="left"> <form:errors path="middlename" /></td>	
</tr>
<tr>
	<td align="right"><form:label for="email" path="email" cssErrorClass="error">*Email Address :</form:label></td>
	<td align="left"><form:input path="email" size="30" maxlength="30" /></td><td align="left"> <form:errors path="email" /></td>	
</tr>
<tr>
	<td align="right"><form:label for="jobtitle" path="jobtitle" cssErrorClass="error">Job Title :</form:label></td>
	<td align="left"><form:input path="jobtitle" size="30" maxlength="20" /> </td><td align="left"><form:errors path="jobtitle" /></td>	
</tr>
<tr>
	<td align="right"><form:label id="superidlabel" for="supervisor_id" path="supervisor_id" cssErrorClass="error">*Supervisor ID :</form:label></td>
	<td align="left"><form:input id="superid"  path="supervisor_id" size="11" maxlength="11" /> </td><td align="left"><form:errors path="supervisor_id" /></td>	
</tr>
					
</table>
</div>
<legend><b>*Phone Number</b></legend>
<div>

<table>
<tr>
	<td align="right"><form:label for="number" path="number" cssErrorClass="error">Number :</form:label></td>
	<td align="left"><form:input path="number" size="14" maxlength="14" minlength="10" /></td><td align="left"> <form:errors path="number" /></td>	
</tr>
<tr>
	<td align="right"><form:label for="phonetype" path="phonetype" cssErrorClass="error">Phone Type :</form:label></td>
	<td align="left">
					<form:select path="phonetype">
						<form:option name="Office" value="Office" >Office</form:option>
						<form:option name="Home" value="Home" >Residence</form:option>
						<form:option name="Cell" value="Cell">Cell</form:option>
					</form:select> 
				 	<form:errors path="phonetype" />
				</td>	
</tr>
</table></div>
<legend><b>Location</b></legend>
<div>
<table>
<tr>
	<td align="right"><form:label for="street" path="street" cssErrorClass="error">Street :</form:label></td>
	<td align="left"><form:input path="street" size="30" maxlength="30" /></td><td align="left"> <form:errors path="street" /></td>	
</tr><tr>
	<td align="right"><form:label for="city" path="city" cssErrorClass="error">City :</form:label></td>
	<td align="left"><form:input path="city" size="30" maxlength="30" /></td><td align="left"><form:errors path="city" /></td>	
</tr>
<tr>
	<td align="right"><form:label for="county" path="county" cssErrorClass="error">County :</form:label></td>
	<td align="left"><form:input path="county" size="30" maxlength="30" /></td><td align="left"> <form:errors path="county" /></td>	
</tr>
<tr>
	<td align="right"><form:label for="state" path="state" cssErrorClass="error">State :</form:label></td>
	<td align="left"><form:input path="state" size="30" maxlength="30" /></td><td align="left"> <form:errors path="state" /></td>	
</tr>
<tr>
	<td align="right"><form:label for="zip" path="zip" cssErrorClass="error">Zip :</form:label></td>
	<td align="left"><form:input path="zip" size="30" maxlength="30" /></td><td align="left"> <form:errors path="zip" /></td>	
</tr>

<tr>
	<td align="right"><form:label for="locationtype" path="locationtype" cssErrorClass="error">Location Type</form:label></td>
	<td align="left">
					<form:select path="locationtype">
						<form:option name="Office" value="Office" >Office</form:option>
						<form:option name="Perminant Residence" value="Perminant Residence" >Permanent Residence</form:option>
						<form:option name="Temporary Residence" value="Temporary Residence">Temporary Residence</form:option>
					</form:select> 
				 	<form:errors path="locationtype" />
				</td>	
</tr>
</table>
</div>
<br>
<div align="center"><table><tr>
 <td><input type="submit" id="save"  width=30px value="Save" align="middle"></td> 
</tr></table>
</div>
</fieldset>
</form:form>
</div>
</body>
</html>