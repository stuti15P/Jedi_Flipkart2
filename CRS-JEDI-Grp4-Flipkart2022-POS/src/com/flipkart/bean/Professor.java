package com.flipkart.bean;

public class Professor extends User{
	

<<<<<<< HEAD
	
=======
	private int professorId;
	private String profName;
	

>>>>>>> refs/remotes/origin/master
	private String department;
	private String designation;
	
	
	/**
	 * @param professorId
	 * @param department
	 * @param designation
	 */
<<<<<<< HEAD
	public Professor(String userID,String name, String role, String password, String department, String designation) {
		super();
=======
	public Professor(int professorId, String profName, String department, String designation) {
		super();
		this.professorId = professorId;
		this.profName =profName;
>>>>>>> refs/remotes/origin/master
		this.department = department;
		this.designation = designation;
	}


<<<<<<< HEAD
=======
	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}


	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the profName
	 */
	public String getProfName() {
		return profName;
	}

	/**
	 * @param profName the profName to set
	 */
	public void setProfName(String profName) {
		this.profName = profName;
	}

	
>>>>>>> refs/remotes/origin/master

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
