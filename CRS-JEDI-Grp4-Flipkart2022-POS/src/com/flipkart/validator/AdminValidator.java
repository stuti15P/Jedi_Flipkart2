/**
 * 
 */
package com.flipkart.validator;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;



/**
 * @author stuti.priyambda
 *
 */
public class AdminValidator {
	
	/**
	 * Method to validate if newCourse is not already present in catalog
	 * @param newCourse
	 * @param courseList
	 * @return if newCourse is not already present in catalog
	 */
	public static boolean isValidNewCourse(Course newCourse, List<Course> courseList) {
		for(Course course : courseList) {
			if(newCourse.getCourseId().equalsIgnoreCase(course.getCourseId())) {
				return false; 
			}
		}
		return true;
	}
	
	/**
	 * Method to validate if dropCourse is already present in catalog
	 * @param dropCourseCode
	 * @param courseList
	 * @return if dropCourse is already present in catalog
	 */
	public static boolean isValidDropCourse(String dropCourseCode, List<Course> courseList) {
		for(Course course : courseList) {
			if(dropCourseCode.equalsIgnoreCase(course.getCourseId())) {
				return true; 
			}
		}
		return false;
	}
	
	
}
