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
	private String courseName;
	private String studentId;
	
	
	
	public EnrolledStudent(String courseId, String courseName, String studentId) {
		this.courseId=courseId;
		this.courseName=courseName;
		this.studentId=studentId;
		// TODO Auto-generated constructor stub
	}
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
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}

