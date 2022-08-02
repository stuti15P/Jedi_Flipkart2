/**
 * 
 */
package com.flipkart.service;
import com.flipkart.service.AdminDB;
import com.flipkart.service.AdminService;
import com.flipkart.service.ProfessorDB;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoImpl;



/**
 * @author stuti.priyambda
 *
 */
public class AdminServiceImpl implements AdminService{
	AdminDB admindb =new AdminDB();
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

	public void viewPendingAdmissions() {
		adminDaoImpl.viewPendingApprovals();
	}

}
