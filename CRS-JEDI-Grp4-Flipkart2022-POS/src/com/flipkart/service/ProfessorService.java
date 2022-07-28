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
	
	public boolean addGrade(int studentId, String courseId, int grade);
	public List<EnrolledStudent> viewEnrolledStudents(int profId);
	public List<Course> viewOwnCourse(int profId);
	
	
}
