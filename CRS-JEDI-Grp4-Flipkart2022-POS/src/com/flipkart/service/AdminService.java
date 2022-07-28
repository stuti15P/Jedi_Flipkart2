package com.flipkart.service;

import com.flipkart.bean.Course;

public interface AdminService {

	//public List<RegisteredCourse> createGradeCard();
	
	public void approvedStudent();
	public void addProfessor();
	public void addCourseToCatalogue(Course course);
	public void deleteCourse();
	
}
