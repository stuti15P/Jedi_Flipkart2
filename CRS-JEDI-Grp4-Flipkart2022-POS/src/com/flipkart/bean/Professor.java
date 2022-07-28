package com.flipkart.bean;

public class Professor extends User{
	
	private String department;
	private String designation;
	
	
	/**
	 * @param professorId
	 * @param department
	 * @param designation
	 */


	

	public Professor(String userID,String name, String role, String password, String department, String designation) {

		super(userID, name, role, password);
		
//		this.professorId = professorId;
//		this.profName =profName;


		this.department = department;
		this.designation = designation;
	}
	


	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}


	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}


	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	

}
