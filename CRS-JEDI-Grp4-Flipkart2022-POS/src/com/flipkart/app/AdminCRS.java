/**
 * 
 */
package com.flipkart.app;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.flipkart.bean.Course;
import com.flipkart.service.AdminServiceImpl;
import com.flipkart.bean.Professor;
import com.flipkart.app.CRSApplication;
import com.flipkart.bean.Student;
import com.flipkart.bean.Grade;
/**
 * @author stuti.priyambda
 *
 */
public class AdminCRS {

	Scanner sc = new Scanner(System.in);
	AdminServiceImpl adminserviceimpl =new AdminServiceImpl();
	/**
	 * Method to Create Admin Menu
	 */
	public void adminHelpMenu() throws SQLException {
		
		while(CRSApplication.loggedin ) {
			System.out.println("*****........... Admin Menu .......*****");
			System.out.println("1. View course in catalog");
			System.out.println("2. Add Course to catalog");
			System.out.println("3. Delete Course from catalog");
			System.out.println("4. Approve Students");
			System.out.println("5. View Pending Approvals");
			System.out.println("6. Add Professor");
			System.out.println("7. Assign Professor To Courses");
			System.out.println("8. Generate Report Card");
			System.out.println("9. Logout");
			System.out.println("*******...............*************............*********");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				viewCoursesInCatalogue();
				break;
				
			case 2:
				addCourseToCatalogue();
				break;
				
			case 3:
				removeCourse();
				break;
				
			case 4:
				approveStudent();
				break;
			
			case 5:
				viewPendingApprovals();
				break;
			
			case 6:
				addProfessor();
				break;
			
			case 7:
				assignCourseToProfessor();
				break;
				
			case 8:
				generateReportCard();
				break;
			
			case 9:
				CRSApplication.loggedin = false;
				return;

			default:
				System.out.println("Invalid Input !!!!");
			}
		}
	}
	
	
	private List<Course> viewCoursesInCatalogue() throws SQLException {
		//System.out.println("view course catalogue");
		List<Course> courseList = adminserviceimpl.viewCourseCatalog();
		if(courseList.size() == 0) {
			System.out.println("No course in the catalogue!");
			return courseList;
		}
		System.out.println(String.format("%20s | %20s | %20s | %20s","COURSE ID", "COURSE NAME", "INSTRUCTOR", "COURSE CREDIT"));
		for(Course course : courseList) {
			System.out.println(String.format("%20s | %20s | %20s | %20s", course.getCourseId(), course.getCourseName(), course.getProfessorId(), course.getCourseCredits()));
		}
		return courseList;

		//return adminserviceimpl.viewCourseCatalog();
	}
	
	private void generateReportCard() 
	{
//
//		List<Grade> grade_card=null;
//		boolean isReportGenerated = true;
//
//		Scanner in = new Scanner(System.in);
//
//		System.out.println("\nEnter the StudentId for report card generation : ");
//		String studentId = in.next();
//
//		try
//		{
//			adminserviceimpl.setGeneratedReportCardTrue(studentId);
//			if(isReportGenerated) {
//				grade_card = registrationInterface.viewGradeCard(studentId);
//				System.out.println(String.format("%-20s %-20s %-20s","COURSE CODE", "COURSE NAME", "GRADE"));
//
//				if(grade_card.isEmpty())
//				{
//					System.out.println("You haven't registered for any course");
//					return;
//				}
//
//				for(Grade obj : grade_card)
//				{
//					System.out.println(String.format("%-20s %-20s %-20s",obj.getCrsCode(), obj.getCrsName(),obj.getGrade()));
//				}
//			}
//			else
//				System.out.println("Report card not yet generated");
//		}
//		catch (SQLException e)
//		{
//
//			System.out.println(e.getMessage());
//		}
//
	}

	/**
	 * Method to assign Course to a Professor
	 */
	private void assignCourseToProfessor() {
		
		System.out.println("\nAssign professor ");
	}

	/**
	 * Method to add Professor to DB
	 */
	private void addProfessor() {
		
		System.out.println("Add Professor");
		 Professor professor = new Professor();

		System.out.println("Enter Professor Name:");
		String professorName = sc.next();
		professor.setName(professorName);

		System.out.println("Enter Department:");
		String department = sc.next();
		professor.setDepartment(department);

		System.out.println("Enter Designation:");
		String designation = sc.next();
		professor.setDesignation(designation);

		System.out.println("Enter User Id:");
		String userId = sc.next();
		professor.setUserID(userId);

		System.out.println("Enter Password:");
		String password = sc.next();
		professor.setPassword(password);
		adminserviceimpl.addProfessor(professor);


	}

	/**
	 * Method to view Students who are yet to be approved
	 * @return List of Students whose admissions are pending
	 */
	
	/**
	 * Method to approve a Student using Student's ID
	 */
	private void approveStudent() {
		System.out.println("-----------Approve Student-----------");
		System.out.println("Enter Student ID: ");
		String studentId = sc.next();

		adminserviceimpl.approveStudent(studentId);
		System.out.println("Approve students");
		
	}

//	/**
//	 * Method to add Course to catalogue
//	 * @throws CourseExistsAlreadyException
//	 */
	private void addCourseToCatalogue() throws SQLException {

		System.out.println("Check1");
		List<Course> courseList = adminserviceimpl.viewCourseCatalog();
		System.out.println("Check2");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter ID of the course");
		String courseId = sc.nextLine();
		System.out.println("Please Enter Name of the course");
		String courseName = sc.nextLine();
		System.out.println("Please Enter Instructor Id");
		String professorId = sc.nextLine();
		System.out.println("Please Enter coursecredit");
		int courseCredit = sc.nextInt();

		Course newcourse = new Course(courseId, courseName, professorId, courseCredit);
		System.out.println("going to add Course ");
		adminserviceimpl.addCourseToCatalogue(newcourse, courseList);
		System.out.println("**** course Added!!  ******");

	}
	

//	/**
//	 * Method to delete Course from catalogue
//	 * @throws CourseNotFoundException
//	 */
	private void removeCourse() throws SQLException{
		//System.out.println("Remove course");
		List<Course> courseList = adminserviceimpl.viewCourseCatalog();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter ID of the course to remove!!");
		String courseId = sc.nextLine();
		adminserviceimpl.deleteCourse(courseId, courseList);

	}



	private void viewPendingApprovals()
	{
		adminserviceimpl.viewPendingAdmissions();
	}
	
}
