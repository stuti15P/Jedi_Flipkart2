package com.flipkart.bean;

public class Professor extends User{
	

<<<<<<< HEAD
	
=======
	private int professorId;
	private String profName;
	

<<<<<<< HEAD
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> 60b3fd156248dc144caa8be73b9b988c92f9c47b
	private String department;
	private String designation;
	
	
	/**
	 * @param professorId
	 * @param department
	 * @param designation
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	public Professor(String userID,String name, String role, String password, String department, String designation) {
		super();
=======
=======
>>>>>>> 60b3fd156248dc144caa8be73b9b988c92f9c47b
	public Professor(int professorId, String profName, String department, String designation) {
		super();
		this.professorId = professorId;
		this.profName =profName;
<<<<<<< HEAD
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> 60b3fd156248dc144caa8be73b9b988c92f9c47b
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

	
<<<<<<< HEAD
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> 60b3fd156248dc144caa8be73b9b988c92f9c47b

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
