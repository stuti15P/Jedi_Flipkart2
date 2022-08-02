/**
 * 
 */
package com.flipkart.exception;

/**
 * @author stuti.priyambda
 *
 */
public class CourseFoundException extends Exception {
	
private String courseId;
	
	/***
	 * Constructor
	 * @param courseCode
	 */
	public CourseFoundException(String courseId) {
		this.courseId = courseId;
	}
	

	/**
	 * Getter method
	 * @return course code
	 */
	public String getCourseCode() {
		return courseId;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override   
	public String getMessage() {
		return "Course with courseCode: " + courseId + " already present in catalog.";
	}
}