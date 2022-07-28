/**
 * 
 */
package com.flipkart.bean;

/**
 * @author stuti.priyambda
 *
 */
public class EnrolledStudent {
	private String courseId;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	private String courseName;
	private int studentId;

}

