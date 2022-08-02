package com.flipkart.service;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
public interface AdminService {

	//public List<RegisteredCourse> createGradeCard();
	
	public void approveStudent(String useId);
	public void addProfessor(Professor professor);
	public void addCourseToCatalogue(Course course);
	public void viewCourseCatalog();
	public void deleteCourse(String courseId);
	
}
