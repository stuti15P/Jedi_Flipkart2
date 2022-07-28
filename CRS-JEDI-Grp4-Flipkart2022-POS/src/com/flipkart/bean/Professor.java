package com.flipkart.bean;

public class Professor extends User{
	

<<<<<<< HEAD

=======
>>>>>>> 763fe3f113ddef269777a46eb4ed73c7ba4219ac
	private String department;
	private String designation;
	
	
	/**
	 * @param professorId
	 * @param department
	 * @param designation
	 */
<<<<<<< HEAD

	

	public Professor(String userID,String name, String role, String password, String department, String designation) {

		super(userID, name, role, password);
		
//		this.professorId = professorId;
//		this.profName =profName;
=======

	public Professor(String userID,String name, String role, String password, String department, String designation) {

		super();
>>>>>>> 763fe3f113ddef269777a46eb4ed73c7ba4219ac

		this.department = department;
		this.designation = designation;
	}
	


<<<<<<< HEAD

	


=======
>>>>>>> 763fe3f113ddef269777a46eb4ed73c7ba4219ac
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
