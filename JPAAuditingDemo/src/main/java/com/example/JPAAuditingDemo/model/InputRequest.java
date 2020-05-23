package com.example.JPAAuditingDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class InputRequest<T> {
	@JsonProperty(value = "userId",required = true)
	private String loggedInUser;
	private EmployeeEntity employee;
	public String getLoggedInUser() {
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	
	public EmployeeEntity getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "InputRequest [loggedInUser=" + loggedInUser + ",  employee=" + employee + "]";
	}
	
}
