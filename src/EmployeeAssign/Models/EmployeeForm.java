package EmployeeAssign.Models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import EmployeeAssign.EJBs.Entity.*;

import java.util.Set;
import java.util.ArrayList;


public class EmployeeForm {

	private String id;
	
	
	
	private String lastname ;
	
	private String firstname;

	private String middlename;
	
	private String fullname ;

	private String email;
	
	private String jobtitle;
	
	private String supervisor_id;

	private String supervisor_fullname ;
		
	private String supervisor_email;
	
	private String supervisor_jobtitle;	
	
	private String phonetype;
	
	private String number;
	
	private String street;
	
	private String city;
	
	private String county;
	
	private String state;
	
	private String zip;
	
	private String  locationtype;
	
//	private String isSupervisor;
	
	//private boolean issupervisor;
	//private List<Supervisor> supervisorList= new ArrayList<Supervisor>();
	

	public EmployeeForm(Employee e,Phonenumber p,Location l,Supervisor s)
	{
		if(e!=null) {
			id=e.getId();
			lastname=e.getLastname();
			firstname=e.getFirstname();
			middlename=e.getMiddlename();
			email=e.getEmail();
			jobtitle=e.getJobtitle();
		}
		if(s!=null) {
			supervisor_id=s.getEmployee().getId();
			supervisor_fullname=s.getEmployee().getFirstname()+" "+s.getEmployee().getMiddlename()+" "+s.getEmployee().getLastname() ;	
			fullname=e.getFirstname()+" "+e.getMiddlename()+" "+e.getLastname() ;		
			supervisor_email=s.getEmployee().getEmail();	
			supervisor_jobtitle=s.getEmployee().getJobtitle();
		}
		if(p!=null) {
			number=p.getNumber();
			phonetype=p.getPhonetype();
		}
		if(l!=null) {
			street=l.getStreet();
			city=l.getCity();
			county=l.getCounty();
			state=l.getState();
			zip=l.getZip();
			locationtype=l.getLocationtype();
		}
		}
	public EmployeeForm()
	{
		
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	public void setLastname(String lastname)
	{
		this.lastname=lastname;
	}
	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String firstname)
	{
		this.firstname=firstname;
	}
	public String getMiddlename()
	{
		return middlename;
	}
	public void setMiddlename(String middlename)
	{
		this.middlename=middlename;
	}
	public String getFullname()
	{
		return fullname;
	}
	public void setFullname(String fullname)
	{
		this.fullname=fullname;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getJobtitle()
	{
		return jobtitle;
	}
	public void setJobtitle(String jobtitle)
	{
		this.jobtitle=jobtitle;
	}
	public String getSupervisor_id()
	{
		return supervisor_id;
	}
	public void setSupervisor_id(String supervisor_id)
	{
		this.supervisor_id=supervisor_id;
	}
	public String getSupervisor_fullname()
	{
		return supervisor_fullname;
	}
	public void setSupervisor_fullname(String supervisor_fullname)
	{
		this.supervisor_fullname=supervisor_fullname;
	}
	public String getSupervisor_email()
	{
		return supervisor_email;
	}
	public void setSupervisor_email(String supervisor_email)
	{
		this.supervisor_email=supervisor_email;
	}
	public String getSupervisor_jobtitle()
	{
		return supervisor_jobtitle;
	}
	public void setSupervisor_jobtitle(String supervisor_jobtitle)
	{
		this.supervisor_jobtitle=supervisor_jobtitle;
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public String getPhonetype()
	{
		return phonetype;
	}
	public void setPhonetype(String phonetype)
	{
		this.phonetype=phonetype;
	}
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street=street;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public String getCounty()
	{
		return county;
	}
	public void setCounty(String county)
	{
		this.county=county;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state=state;
	}
	public String getZip()
	{
		return zip;
	}
	public void setZip(String zip)
	{
		this.zip=zip;
	}
	public String getLocationtype()
	{
		return locationtype;
	}
	public void setLocationtype(String locationtype)
	{
		this.locationtype=locationtype;
	}
/*
	public boolean getIsSupervisor()
	{
		if(this.isSupervisor=="true")
		return true;
		else
			return false;					
	}
	public void setIsSupervisor(String IsSupervisor)
	{
		this.isSupervisor=isSupervisor;
	}	
	
	*/
}
