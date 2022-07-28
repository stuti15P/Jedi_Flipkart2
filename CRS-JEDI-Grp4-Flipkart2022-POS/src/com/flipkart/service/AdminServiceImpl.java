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
		System.out.println("check1");
		AdminDB admindb =new AdminDB();
		System.out.println("check2");
		admindb.courseList.add(course);
		System.out.println("check3");
		
		
	}

	@Override
	public void deleteCourse() {
		// TODO Auto-generated method stub
		
	}

}
