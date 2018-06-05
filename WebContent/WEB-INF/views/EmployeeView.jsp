<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h2><c:out value="${employeeForm.fullname}" /></h2> 
<div>
<strong>Employee Information </strong>
<p>
ID : <c:out value="${employeeForm.id}" /><br/>
Email : <c:out value="${employeeForm.email}" /> <br/>
Job Title : <c:out value="${employeeForm.jobtitle}" /> <br/>
</p>
</div>
<div>
<strong>Supervisor Information </strong><br/>
<p>
<c:out value="${employeeForm.supervisor_fullname}" /> <br/>
Email : <c:out value="${employeeForm.supervisor_email}" /><br/>
Job Title : <c:out value="${employeeForm.supervisor_jobtitle}" />
</p>
</div> 
<div>
<strong> Office Information</strong>
<p>
<b>Employee Office Address :</b><br/>
Street : <c:out value="${employeeForm.street}" /><br/>
City : <c:out value="${employeeForm.city}" /><br/>
County : <c:out value="${employeeForm.county}" /><br/>
State : <c:out value="${employeeForm.state}" /><br/>
Zip : <c:out value="${employeeForm.zip}" /><br/>
<b>Employee Office Phone Number</b><br/>
Number : <c:out value="${employeeForm.number}" />
</p>
</div>

(<a href="<c:url value="/EmployeeDirectoryMvc/EmployeeDirectory/list" />">Back to Employee List</a>)
