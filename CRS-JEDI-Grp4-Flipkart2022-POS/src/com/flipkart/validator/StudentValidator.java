/**
 * 
 */
package com.flipkart.validator;

import java.util.Vector;

import com.flipkart.bean.Course;
import com.flipkart.exceptions.CourseNotFoundException;

/**
 * @author Bhajan
 *
 */
public class StudentValidator {

	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @param registeredCourseList  
	 * @return 
	 * @throws CourseNotFoundException
	 */
	public static boolean isRegistered(int courseId, int studentId, Vector<Course> registeredCourseList) throws CourseNotFoundException {
		
		for(Course course : registeredCourseList) {
			if(courseId == course.getCourseId()) {
				return true; 
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param courseCode
	 * @param availableCourseList
	 * @return 
	 */
	public static boolean isValidCourseCode(int courseId, Vector<Course> availableCourseList) {
		
		for(Course course : availableCourseList) {
			if(courseId == course.getCourseId()) {
				return true; 
			}
		}
		return false;
	}
}
