package com.flipkart.bean;

public class Course {

	private String courseId;
	private String courseName;
	private String professorId;
	private int courseCredits;
	
	
	/**
	 * @param courseId
	 * @param courseName
	 * @param assignedProfessor
	 * @param courseCredits
	 */
	public Course(String courseId, String courseName, String professorId, int courseCredits) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.professorId = professorId;
		this.courseCredits = courseCredits;
	}


	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}


	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}


	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	 * @return the courseCredits
	 */
	public int getCourseCredits() {
		return courseCredits;
	}


	/**
	 * @param courseCredits the courseCredits to set
	 */
	public void setCourseCredits(int courseCredits) {
		this.courseCredits = courseCredits;
	}
	
	
	

}
