package EmployeeAssign.Models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeSearchForm {

	private String searchTerm;

	private String searchType;

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
}
