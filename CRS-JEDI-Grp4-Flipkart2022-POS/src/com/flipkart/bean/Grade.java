package com.flipkart.bean;

public class Grade {
	
	private String courseId;
	private String courseName;
	
	/**
	 * @param courseId
	 * @param courseName
	 */
	public Grade(String courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
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
	
	
	

}
