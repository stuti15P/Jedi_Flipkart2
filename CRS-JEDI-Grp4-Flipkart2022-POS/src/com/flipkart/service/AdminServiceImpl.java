/**
 * 
 */
package com.flipkart.service;
import com.flipkart.service.AdminDB;
import com.flipkart.service.AdminService;
import com.flipkart.service.ProfessorDB;
import com.flipkart.validator.AdminValidator;
import com.flipkart.bean.Professor;
import com.flipkart.dao.AdminDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoImpl;



/**
 * @author stuti.priyambda
 *
 */
public class AdminServiceImpl implements AdminService{
	AdminDB admindb =new AdminDB();
	AdminDaoImpl adminDaoImpl =new AdminDaoImpl();


	public ProfessorDB professorDB = new ProfessorDB();
	AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
	@Override
	public void approveStudent(String userId) {
		// TODO Auto-generated method stub
		adminDaoImpl.approveStudent(userId);

	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		adminDaoImpl.addProfessor(professor);
//		System.out.println("Professor Added!");


	}

//	@Override
//	public void addCourseToCatalogue(Course course) {
//		// TODO Auto-generated method stub
//		admindb.courseList.add(course);
//
//	}

	@Override
	public void addCourseToCatalogue(Course newCourse, List<Course> courseList) throws SQLException {

		if(!AdminValidator.isValidNewCourse(newCourse, courseList)) {
			System.out.println("courseId: " + newCourse.getCourseId() + " already present in catalog!");

		}
		System.out.println("Debug 1: AdminServiceImpl, addCourseToCatalogue");
		try {
			adminDaoImpl.addCourse(newCourse);
		}
		catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public void deleteCourse(String courseId, List<Course> courseList) throws SQLException {
		if(!AdminValidator.isValidDropCourse(courseId, courseList)) {
			System.out.println("courseCode: " + courseId + " not present in catalog!");
			//throw new CourseNotFoundException(courseId);
		}

		try {
			adminDaoImpl.deleteCourse(courseId);
		}
		catch(SQLException e) {
			throw e;
		}

	}
//throws SQLException
	@Override
	public List<Course> viewCourseCatalog() throws SQLException {
//		for (Course course: admindb.courseList)
//		{
//			System.out.println(course.getCourseId() + " "+ course.getCourseName());
//		  // code block to be executed
//		}
//		List<Course> courseList = new ArrayList<>();
//		try
//		{
//			courseList = AdminDaoImpl.viewCourses();
//		}
//
		return adminDaoImpl.viewCourses();


	}

	public void viewPendingAdmissions() {
		adminDaoImpl.viewPendingApprovals();
	}

}
