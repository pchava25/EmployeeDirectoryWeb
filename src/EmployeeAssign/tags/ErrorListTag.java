package EmployeeAssign.tags;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * This custom tag will print out a list of errors based on the Collection
 * object passed in.
 * 
 * @author Greg Martin
 * 
 */
public class ErrorListTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PageContext pc;
	private Iterator<String> iterator;
	private Collection<String> errorCollection;

	/**
	 * Set the Collection object that contains errors
	 * 
	 * @param collection
	 */
	public void setErrors(Collection<String> collection) {
		this.errorCollection = collection;
	}

	/*
	 * Set the page contect
	 * 
	 * @see
	 * javax.servlet.jsp.tagext.Tag#setPageContext(javax.servlet.jsp.PageContext
	 * )
	 */
	public void setPageContext(PageContext pc) {
		this.pc = pc;
	}

	/*
	 * Handle any starting actions
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {
		// check if there are errors
		if (errorCollection == null) {
			throw new JspTagException("No collection with name "
					+ errorCollection + " found");
		}
		iterator = errorCollection.iterator();
		if (iterator.hasNext()) {
			// start the error section
			try {
				pc.getOut().write("<fieldset>");
				pc.getOut()
						.write("<legend><b>The request could not be processed due to the following errors:</b></legend>");
				pc.getOut().write("<ul>");
				pc.setAttribute("error", "<li>" + (String) iterator.next()
						+ "</li>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}

	/*
	 * This is the part that will be called over and over again
	 * 
	 * @see javax.servlet.jsp.tagext.IterationTag#doAfterBody()
	 */
	public int doAfterBody() throws JspException {
		if (iterator.hasNext()) {
			pc.setAttribute("error", "<li>" + (String) iterator.next()
					+ "</li>");
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}

	/*
	 * Ending of the iteration
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	public int doEndTag() throws JspException {
		try {
			pc.getOut().write("</ul>");
			pc.getOut().write("</fieldset>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}