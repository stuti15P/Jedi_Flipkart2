/**
 * 
 */
package com.flipkart.service;
import com.flipkart.service.AdminDB;
import com.flipkart.service.AdminService;
import com.flipkart.service.ProfessorDB;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Course;


/**
 * @author stuti.priyambda
 *
 */
public class AdminServiceImpl implements AdminService{
	public AdminDB admindb =new AdminDB();
	public ProfessorDB professorDB = new ProfessorDB();
	@Override
	public void approvedStudent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		professorDB.professorList.put(4,professor);
		System.out.println("Professor Added!");

		
	}

	@Override
	public void addCourseToCatalogue(Course course) {
		// TODO Auto-generated method stub
		System.out.println("check1");
		System.out.println("check2");
		admindb.courseList.add(course);
		System.out.println("check3");
		
		
	}

	@Override
	public void deleteCourse() {
		// TODO Auto-generated method stub
		
	}

}
