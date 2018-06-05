//This class validates the input given in the createemployee jsp

package EmployeeAssign.Validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import EmployeeAssign.Models.EmployeeForm;
import EmployeeAssign.EJBs.Session.*;
import EmployeeAssign.utils.*;
//import gmartinc.EmployeeDirectory.utils.FormValidations;



public class EmployeeDetailsValidator implements Validator
{
		public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return EmployeeForm.class.equals(clazz);
	}

	public void validate(Object obj, Errors e)
	{
		
		
		EmployeeForm emp = (EmployeeForm)obj;
		boolean idExists;
		boolean emailExists;
		boolean inPhoneFormat;
		boolean inEmployeeIdFormat;
		boolean inEmailFormat;
		boolean inLastnameFormat;
		boolean inFirstnameFormat;	
		boolean nosupervisors;
		
		inEmployeeIdFormat=validateEmployeeId(emp.getId());
		inEmailFormat=validateEmail(emp.getEmail());
		inPhoneFormat=validatePhoneNumber(emp.getNumber());
		inLastnameFormat=validateName(emp.getLastname());
		inFirstnameFormat=validateName(emp.getFirstname());
		
		EmployeeListEJBRemote elm=null;
		
		try {
			elm = (EmployeeListEJBRemote)ApplicationUtil.getEjbReference("EmployeeListEjb");
		}
		catch (NamingException ex) {
			ex.printStackTrace();
		}
		
		idExists=elm.employeeExists(emp.getId());		
		emailExists=elm.emailExists(emp.getEmail());
		//nosupervisors=elm.noSupervisors();
		
		if ((emp.getSupervisor_id()) == null || (emp.getSupervisor_id().equals(""))) 
			{
			e.rejectValue("supervisor_id", "requiredvalue", "The value is required.or the Employee has to be a supervisor himself enter the employee id in in this field");
			}
		else {	
			
			if(!validateEmployeeId(emp.getSupervisor_id()))
			{
				if(elm.noSupervisors(emp.getSupervisor_id()))					
					e.rejectValue("supervisor_id", "requiredvalue", "The Supervisor does not exist.");
				else
					e.rejectValue("id", "EmployeeIdnotinformat", "Not a valid EmployeeId ");
				
			}
			}
			
		
		
		if ((emp.getId()) == null || (emp.getId().equals(""))) 
			e.rejectValue("id", "requiredvalue", "The value is required.");
		else {
			if(idExists)		
			e.rejectValue("id", "valuealreadyexists", "The id already exists, value has to be unique");
			if(!inEmployeeIdFormat)
			e.rejectValue("id", "EmployeeIdnotinformat", "Not a valid EmployeeId ");
		}
		
		if ((emp.getLastname()) == null || (emp.getLastname().equals(""))) 
			e.rejectValue("lastname", "requiredvalue", "The value is required.");
		else if(!inLastnameFormat)
			e.rejectValue("lastname", "allalphabets", "The value has to be All Alphabets");
			
		
		if ((emp.getFirstname()) == null || (emp.getFirstname().equals(""))) 
			e.rejectValue("firstname", "requiredvalue", "The value is required.");
		else if(!inFirstnameFormat)
			e.rejectValue("firstname", "allalphabets", "The value has to be All Alphabets");
		
		if ((emp.getEmail()) == null || (emp.getEmail().equals(""))) 
			e.rejectValue("email", "requiredvalue", "The value is required.");
		else {
			if(emailExists)		
				e.rejectValue("email", "valuealreadyexists", "The email already exists, value has to be unique");
			if(!inEmailFormat)
				e.rejectValue("email", "Emailnotinformat", "Not a valid Email Address ");

		}
		if ((emp.getNumber()) == null || (emp.getNumber().equals(""))) 
			e.rejectValue("number", "requiredvalue", "The value is required.");
		else {		
		if(!inPhoneFormat)
			e.rejectValue("number", "mustbeintheform", "Phone Number must be in the form (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890 ");
		}
	}
	public static boolean validateName(String obj){  
		boolean inFormat ;  

		Pattern pattern = Pattern.compile("^[a-zA-Z]+");
	      Matcher matcher = pattern.matcher(obj);
	 
	      if (matcher.matches()) {
	    	  inFormat=true;
	      }
	      else
	      {
	      inFormat=false;
	      }
		return inFormat;
	  	}  

	public static boolean validateEmail(String obj){  
		boolean inFormat ;  

		Pattern pattern = Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$",Pattern.CASE_INSENSITIVE);
	      Matcher matcher = pattern.matcher(obj);
	 
	      if (matcher.matches()) {
	    	  inFormat=true;
	      }
	      else
	      {
	      inFormat=false;
	      }
		return inFormat;
	  	}  
	public boolean validatePhoneNumber(String obj)
	{
		boolean inFormat;
		//(123)456-7890, 123-456-7890, 1234567890, (123)-456-7890 
		Pattern pattern = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");
	      Matcher matcher = pattern.matcher(obj);
	 
	      if (matcher.matches()) {
	    	  inFormat=true;
	      }
	      else
	      {
	      inFormat=false;
	      }
		return inFormat;
		
	}
	public boolean validateEmployeeId(String obj)
	{
		boolean inFormat;
		//xxx-xx-xxxx, xxxxxxxxx, xxx-xxxxxx; xxxxx-xxxx
		Pattern pattern1 = Pattern.compile("^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$");
		Pattern pattern2 = Pattern.compile("^\\d{9}$");
		Pattern pattern3 = Pattern.compile("^\\d{3}[- ]?\\d{6}$");
		Pattern pattern4 = Pattern.compile("^\\d{5}[- ]?\\d{4}$");

		Matcher matcher1 = pattern1.matcher(obj);
		Matcher matcher2 = pattern2.matcher(obj);
		Matcher matcher3 = pattern3.matcher(obj);
		Matcher matcher4 = pattern4.matcher(obj);
	 
	      if (matcher1.matches()||matcher2.matches()||matcher3.matches()||matcher4.matches()) {
	    	  inFormat=true;
	      }
	      else
	      {
	      inFormat=false;
	      }
		return inFormat;
		
	}
		
}
	

			

