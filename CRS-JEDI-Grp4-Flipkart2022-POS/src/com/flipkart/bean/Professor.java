package com.flipkart.bean;
import com.flipkart.bean.User;

public class Professor extends User  {
	private String department;
	private String designation;
	
	
	/**
	 * @param department
	 * @param designation
	 */

	public Professor() {}
	public Professor(String professorID, String name, String department, String designation ) {

		setUserID(professorID);
		setName(name);
		this.department = department;
		this.designation = designation;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {return department;
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
