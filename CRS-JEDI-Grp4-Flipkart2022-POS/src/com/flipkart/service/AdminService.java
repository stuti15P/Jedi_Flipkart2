package com.flipkart.service;
import com.flipkart.bean.Professor;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;

public interface AdminService {

	//public List<RegisteredCourse> createGradeCard();
	
	public void approvedStudent();
	public void addProfessor(Professor professor);
	public void addCourseToCatalogue(Course newCourse, List<Course> courseList) throws SQLException;
	public List<Course> viewCourseCatalog() throws SQLException;
	public void deleteCourse(String courseId, List<Course> courseList) throws SQLException;
	
}
