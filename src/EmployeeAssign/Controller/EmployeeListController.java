//the controller is used to separate the logic from presentation 
package EmployeeAssign.Controller;

import java.util.Set;
import java.util.Vector;
import java.util.*;
import javax.naming.NamingException;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import EmployeeAssign.Models.*;
import EmployeeAssign.utils.ApplicationUtil;
import EmployeeAssign.EJBs.Entity.*;
import EmployeeAssign.EJBs.Session.EmployeeListEJBRemote;
import EmployeeAssign.Validator.EmployeeDetailsValidator;

@Controller
@RequestMapping(value="/EmployeeDirectory")
public class EmployeeListController {


	
	
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
		if (binder.getTarget() instanceof EmployeeForm) {			 
             binder.setValidator(new EmployeeDetailsValidator());
		}
    }
	
	@RequestMapping(method=RequestMethod.GET)
	public String redirect() {
		
		return "redirect:/EmployeeDirectoryMvc/EmployeeDirectory/list";
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView getEmployeeList() 
	{
		ModelAndView mav = new ModelAndView();
		
		EmployeeListEJBRemote dao=null;
		
		try {
			dao = (EmployeeListEJBRemote)ApplicationUtil.getEjbReference("EmployeeListEjb");
		} catch (NamingException e) {
			e.printStackTrace();
		}      
        	 
    	    mav.setViewName("/EmployeeList");
    	    if(dao.getAllEmployees().isEmpty())
    	    	 mav.addObject("actionMessage", "No employees were found.");
            mav.addObject("employees", dao.getAllEmployees());
            
        
        return mav;
	}
	
	@RequestMapping(value="phonenumbers/{id}",method=RequestMethod.GET)
	public ModelAndView getPhonenumberList(@PathVariable  String id) 
	{
		ModelAndView mav = new ModelAndView();
		
		EmployeeListEJBRemote dao=null;
		
		try {
			dao = (EmployeeListEJBRemote)ApplicationUtil.getEjbReference("EmployeeListEjb");
		} catch (NamingException e) {
			e.printStackTrace();
		}      
        	 
    	    mav.setViewName("/PhoneList");
    	    if(dao.getPhonenumbers(id).isEmpty())
   	    	 mav.addObject("actionMessage", "No phonenumbers were found.");
           
            mav.addObject("numbers", dao.getPhonenumbers(id));        	
        
        return mav;
	}

	@RequestMapping(value="locations/{id}",method=RequestMethod.GET)
	public ModelAndView getLocationList(@PathVariable  String id) 
	{
		ModelAndView mav = new ModelAndView();
		
		EmployeeListEJBRemote dao=null;
		
		try {
			dao = (EmployeeListEJBRemote)ApplicationUtil.getEjbReference("EmployeeListEjb");
		} catch (NamingException e) {
			e.printStackTrace();
		}      
        	 
    	    mav.setViewName("/LocationList");
    	    if(dao.getLocations(id).isEmpty())
   	    	 mav.addObject("actionMessage", "No locations were found.");
           
            mav.addObject("locations", dao.getLocations(id));        	
        
        return mav;
	}

	@RequestMapping(value="search", method=RequestMethod.GET)
	public ModelAndView searchEmployeeCriteria() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/EmployeeSearch");
        mav.addObject(new EmployeeSearchForm());
        return mav;
	}
	
	@RequestMapping(value="search", method=RequestMethod.POST)
	public String searchCourses(@Valid EmployeeSearchForm employeeSearchForm, BindingResult result, Model model) {
		EmployeeListEJBRemote dao=null;
		Set<Employee> employee = null;
		if (!result.hasErrors()) {
			System.out.println("SEARCH INFO: " + employeeSearchForm.getSearchType() + " : " + employeeSearchForm.getSearchTerm());
			try {
				dao = (EmployeeListEJBRemote)ApplicationUtil.getEjbReference("EmployeeListEjb");
				employee = dao.searchEmployee(employeeSearchForm.getSearchType(), employeeSearchForm.getSearchTerm());
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		if (employee != null && !employee.isEmpty()) {
			model.addAttribute("employees", employee);
			return "/EmployeeList";	
		} else {
			if (!result.hasErrors()) model.addAttribute("actionMessage", "No employees were found that matched your search.");
			model.addAttribute(employeeSearchForm);
			return "/EmployeeSearch";
		}
	}

	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable  String id, Model model) 
	{

		EmployeeListEJBRemote dao=null;
		
		try {
			dao = (EmployeeListEJBRemote)ApplicationUtil.getEjbReference("EmployeeListEjb");

			dao.removeEmployee(id);
		} catch (NamingException e) {
			e.printStackTrace();
		}				

	    return "redirect:/EmployeeDirectoryMvc/EmployeeDirectory/";		
	}
	

	@RequestMapping(value="create", method=RequestMethod.GET)
	public String getCreateEmployee(Model model,ModelMap mm) {
		
		model.addAttribute(new EmployeeForm());
		return "/CreateEmployee";			
	}
	
	
	@RequestMapping(value="submit",method=RequestMethod.POST)
	public String createEmployeeDetails(@Valid EmployeeForm employeeForm, BindingResult result, Model model) 
	{		
		EmployeeListEJBRemote dao=null;
		if (!result.hasErrors())
		{
			try
			{			

			dao = (EmployeeListEJBRemote)ApplicationUtil.getEjbReference("EmployeeListEjb");
			Employee e = new Employee();
			
			Phonenumber p=new Phonenumber();			
			p.setNumber(employeeForm.getNumber());
			p.setPhonetype(employeeForm.getPhonetype());
			
			System.out.println(p);
			if(p==null||p.equals(null)) {
				throw new Exception("phonenumber is null");
			}
			Location l=new Location();
			l.setStreet(employeeForm.getStreet());
			l.setCity(employeeForm.getCity());
			l.setCounty(employeeForm.getCounty());
			l.setState(employeeForm.getState());
			l.setZip(employeeForm.getZip());
			l.setLocationtype(employeeForm.getLocationtype());
			
			System.out.println(l);
			if(l==null||l.equals(null)) {
				throw new Exception("location is null");
			}
			
			Supervisor s=new Supervisor();
					
			s.setSid(employeeForm.getSupervisor_id());	
			if(dao.getSupervisor(employeeForm.getSupervisor_id())==null)
				dao.createSupervisor(s);
			Set<Location> ls = new HashSet<Location>();
			Set<Phonenumber> ps=new HashSet<Phonenumber>();
			e.setId(employeeForm.getId());
			e.setLastname(employeeForm.getLastname());
			e.setFirstname(employeeForm.getFirstname());
			e.setMiddlename(employeeForm.getMiddlename());
			e.setEmail(employeeForm.getEmail());
			e.setJobtitle(employeeForm.getJobtitle());
			e.setLastname(employeeForm.getLastname());
			e.setLastname(employeeForm.getLastname());
			e.setSupervisor1(s);
			e.setLocations(ls);
			e.setPhonenumbers(ps);
			dao.createEmployee(e);	
				
			System.out.println(e);
			if(e==null||e.equals(null)) {
				throw new Exception("employee is null");
			}
				//p.setEmployee(e);
				dao.createPhonenumber(p);
				//l.setEmployee(e);
				dao.createLocation(l);
				
				e.addPhonenumber(p);
				e.addLocation(l);
				
				dao.updateLocation(l);
				dao.updatePhonenumber(p);
				//e.getLocations().add(l);
				//e.getPhonenumbers().add(p);
				
				dao.updateEmployee(e);
				
				model.addAttribute("employeeForm");
			} catch (Exception e) {
				e.printStackTrace();
			}	

			return "redirect:/EmployeeDirectoryMvc/EmployeeDirectory";
		}
		else {
			model.addAttribute("employeeForm");			
			model.addAllAttributes(result.getAllErrors());

			return "/CreateEmployee";
		}			
					
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable String id, Model model) throws Exception {
		
		
		Employee employee=null;
		Phonenumber phone=null;
		Location loc=null;
		Supervisor supervisor=null;

		EmployeeListEJBRemote dao=null;
		
		try {
			dao = (EmployeeListEJBRemote)ApplicationUtil.getEjbReference("EmployeeListEjb");
			employee= dao.getEmployee(id);
			if(dao.getOfficeLocation(employee)!=null)
				loc=dao.getOfficeLocation(employee);
			if(dao.getOfficeNumber(employee)!=null)
				phone=dao.getOfficeNumber(employee);	
			supervisor=employee.getSupervisor1();			
		} catch (NamingException e) {
			e.printStackTrace();			
		}
		
		if (employee == null) {
			throw new Exception("Employee " + id + " not found.");
		}
		else{
		EmployeeForm employeeForm = new EmployeeForm(employee,phone,loc,supervisor);
			if(employeeForm==null){
				throw new Exception("Employee Form for employee id " + id + " not found.");
			}else{
			model.addAttribute(employeeForm);
			}
		}
		return "/EmployeeView";
	}
	
}
