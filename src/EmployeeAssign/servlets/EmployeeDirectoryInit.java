package EmployeeAssign.servlets;

import EmployeeAssign.utils.ApplicationUtil;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class EmployeeDirectoryInit
 */
public class EmployeeDirectoryInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(EmployeeDirectoryInit.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init(ServletConfig config){
    	logger.info("Initializing Employee Directory Enterprise Application");
    	
    	ResourceBundle rb = ResourceBundle
				.getBundle("EmployeeAssign.servlets.appresources");
		Enumeration<String> keys = rb.getKeys();
		Map<String, String> applicationProperties = new HashMap<String,String>();
        while (keys.hasMoreElements()) {
        	String key = keys.nextElement();
        	String value = rb.getString(key);
        	logger.info("Setting application resource property -- " + key + " : " + value);
        	applicationProperties.put(key, value);
        }
        ApplicationUtil.init(applicationProperties);
    }
 }
