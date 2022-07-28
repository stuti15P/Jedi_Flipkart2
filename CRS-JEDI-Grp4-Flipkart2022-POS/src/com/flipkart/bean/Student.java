package com.flipkart.bean;

public class Student extends User {
	

	private String studentId;
	private String studentName;
	private String branch;
	private int semester;
	
	/**
	 * @param studentId
	 * @param branch
	 * @param semester
	 */
	public Student(String studentId, String studentName, String branch, int semester) {
		super();
		this.studentId = studentId;
		this.studentName =studentName;
		this.branch = branch;
		this.semester = semester;
	}
	
	
	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

	
	
}
