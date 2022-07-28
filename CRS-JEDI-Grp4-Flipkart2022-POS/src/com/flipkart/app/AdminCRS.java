/**
 * 
 */
package com.flipkart.app;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.service.AdminServiceImpl;


/**
 * @author stuti.priyambda
 *
 */
public class AdminCRS {

	Scanner in = new Scanner(System.in);
	AdminServiceImpl adminserviceimpl =new AdminServiceImpl();
	/**
	 * Method to Create Admin Menu
	 */
	public void adminHelpMenu(){
		
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
			
			int choice = in.nextInt();
			
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
				viewPendingAdmissions();
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
	
	private void generateReportCard() 
	{
		
		System.out.println("\nthe StudentId for report card generation : ");
		
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
		

	}

	/**
	 * Method to view Students who are yet to be approved
	 * @return List of Students whose admissions are pending
	 */
	
	/**
	 * Method to approve a Student using Student's ID
	 */
	private void approveStudent() {
		
		
		System.out.println("Approve students");
		
	}

	/**
	 * Method to delete Course from catalogue
	 * @throws CourseNotFoundException 
	 */
	private void removeCourse() {
		System.out.println("Remove course");
	}
	
	/**
	 * Method to add Course to catalogue
	 * @throws CourseExistsAlreadyException 
	 */
	private void addCourseToCatalogue() {
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
		adminserviceimpl.addCourseToCatalogue(newcourse);
		System.out.println("course Added!!");

	}
	
	private void viewPendingAdmissions()
	{
		System.out.println("viewPendingAdmissions()");
	}
	private void viewCoursesInCatalogue() {
		System.out.println("view course catalogue");
	}
}
