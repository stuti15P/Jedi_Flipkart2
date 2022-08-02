
/**
 * 
 */


package com.flipkart.app;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.service.ProfessorServiceImpl;
/**
 * @author stuti.priyambda
 *
 */
public class ProfessorCRS {

	
	ProfessorServiceImpl professorServiceImpl = new ProfessorServiceImpl();
    public void professorHelpMenu(){
        while(CRSApplication.loggedin){
        	
            System.out.println("...........***** Professor Portal *****.............");
            System.out.println("1. View Enrolled Students");
            System.out.println("2. Assign Grades");
            System.out.println("3. View Course Catalog");
            System.out.println("0. to exit/Logout");
            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();
			
			switch(choice) {
					case 1:
                    	 System.out.println("Show Enrolled Students");
                    	 showEnrolledStudents();
                         break;
                     case 2:
                    	 System.out.println("Add grades");
                    	 addGrades();
                         break;
                    case 3:
                    	System.out.println("show course catalog");
                    	viewOwnCourse();
                        break;
                    case 0:
        				CRSApplication.loggedin = false;
        				return;


                    default:
                        System.out.println("***** Invalid Input *****");
                 }
        }

   }
    
    
    
    public void showEnrolledStudents() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter your userID");
    	String profId = sc.nextLine();
        	
    	List<EnrolledStudent> enrolledStudent = professorServiceImpl.viewEnrolledStudents(profId);
    	for (EnrolledStudent student : enrolledStudent) {
    		 
            // Print all elements of ArrayList
            System.out.print(student.getStudentId()+" ");
            System.out.print(student.getCourseId()+" ");
            System.out.println(student.getCourseName());
            
        }
    } 
    
public void addGrades() {
    	
    	Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter studentID to add grade");
		String studentId = sc.nextLine();
		System.out.println("Please Enter Id of the course");
		String courseId = sc.nextLine();
		System.out.println("Please grade this student for the given course");
		int grade = sc.nextInt();
//		System.out.println("Please enter unique Id to confirm");
//		int id = sc.nextInt();
    	professorServiceImpl.addGrade(studentId, courseId, grade);
    	
    }
    public void viewOwnCourse() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter your userID");
    	String profId = sc.nextLine();
    	List<Course> course = professorServiceImpl.viewOwnCourse(profId);
    	for(Course c:course)
    	{
    		System.out.print(c.getProfessorId()+" ");
            System.out.print(c.getCourseId()+" ");
            System.out.print(c.getCourseName()+" ");
            System.out.println(c.getCourseCredits());
    	}
    }
    
}