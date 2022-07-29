package com.flipkart.bean;

public class Grade {
	
	private String studentId;
	private String courseId;
	int grade;
	
	
	/**
	 * @param courseId
	 * @param courseName
	 */
	
	public Grade(String studentId, String courseId, int grade) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.grade = grade;
	}
	
	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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

	
	
	

}
