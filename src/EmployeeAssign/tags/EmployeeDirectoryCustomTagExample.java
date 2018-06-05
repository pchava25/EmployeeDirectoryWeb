package EmployeeAssign.tags;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/**
 * This class is an example of a custom tag. This custom tag prints out a name
 * and date in a div tag.
 * 
 * @author Greg Martin
 * 
 */
public class EmployeeDirectoryCustomTagExample implements Tag, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -903540214752703185L;
	private PageContext pc = null;
	private Tag parent = null;
	private String name = null;

	public void setPageContext(PageContext p) {
		pc = p;
	}

	public void setParent(Tag t) {
		parent = t;
	}

	public Tag getParent() {
		return parent;
	}

	public void setName(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	/*
	 * All the main work is handled here, during the start tag.
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {
		try {
			// print a box with some identification information in it
			pc.getOut().write(
					"<div style=\"border-style: dashed;width:300px;\">");
			if (name != null && !name.equals("")) {
				pc.getOut().write("<b>Name</b>: " + name + "<br>");
			} else {
				pc.getOut().write("<b>Unknown User</b><br>");
			}
			pc.getOut().write(
					"<b>IP</b>: " + pc.getRequest().getRemoteHost() + "<br>");
			pc.getOut().write(
					"<b>Date</b>: " + (new java.util.Date()).toString()
							+ "<br>");
			pc.getOut().write("</div>");
		} catch (IOException e) {
			throw new JspTagException("An IOException occurred.");
		}
		return SKIP_BODY;
	}

	/*
	 * Method to run during the end tag
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	/*
	 * Release any objects
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#release()
	 */
	public void release() {
		pc = null;
		parent = null;
		name = null;
	}
}