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
		AdminDB admindb =new AdminDB();
	
		admindb.courseList.add(course);
		
		
	}

	@Override
	public void deleteCourse() {
		// TODO Auto-generated method stub
		
	}

}
