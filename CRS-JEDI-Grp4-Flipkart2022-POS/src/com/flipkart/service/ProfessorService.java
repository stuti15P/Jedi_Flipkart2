/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

/**
 * @author stuti.priyambda
 *
 */
public interface ProfessorService {
	
	public boolean addGrade(String studentId, String courseId, int grade);
	public List<EnrolledStudent> viewEnrolledStudents(String profId);
	public List<Course> viewOwnCourse(String profId);
	
	
}
