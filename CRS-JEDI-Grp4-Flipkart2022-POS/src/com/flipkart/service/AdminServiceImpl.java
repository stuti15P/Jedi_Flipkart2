/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Course;

/**
 * @author stuti.priyambda
 *
 */
public class AdminServiceImpl implements AdminService{
	AdminDB admindb =new AdminDB();

	@Override
	public void approvedStudent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourseToCatalogue(Course course) {
		// TODO Auto-generated method stub
		admindb.courseList.add(course);
		
	}

	@Override
	public void deleteCourse(String courseId) {
		// TODO Auto-generated method stub
		for (Course course: admindb.courseList) 
		{
			if(course.getCourseId().equals(courseId))
			{
				admindb.courseList.remove(course);
				break;
			}
		  // code block to be executed
		} 
		
	}

	@Override
	public void viewCourseCatalog() {
		// TODO Auto-generated method stub
		for (Course course: admindb.courseList) 
		{
			System.out.println(course.getCourseId() + " "+ course.getCourseName());
		  // code block to be executed
		} 
		
		
	}

}
