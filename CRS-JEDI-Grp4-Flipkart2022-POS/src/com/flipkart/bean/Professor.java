package com.flipkart.bean;

public class Professor extends User{
	

	private String professorId;
	private String department;
	private String designation;
	
	
	/**
	 * @param professorId
	 * @param department
	 * @param designation
	 */
	public Professor(String professorId, String department, String designation) {
		super();
		this.professorId = professorId;
		this.department = department;
		this.designation = designation;
	}


	/**
	 * @return the professorId
	 */
	public String getProfessorId() {
		return professorId;
	}


	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
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
