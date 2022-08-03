/**
 * 
 */
package com.flipkart.application;

import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.flipkart.bean.Student;
import com.flipkart.service.NotificationInterface;
import com.flipkart.service.NotificationService;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentService;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserService;
import com.flipkart.constants.GenderConstant;
import com.flipkart.constants.RoleConstant;
import com.flipkart.exceptions.ConfirmPasswordException;
import com.flipkart.exceptions.CourseLimitExceededException;
import com.flipkart.exceptions.CourseNotFoundException;
import com.flipkart.exceptions.OldPasswordNotValidException;
import com.flipkart.exceptions.ProfessorAlreadyRegisteredException;
import com.flipkart.exceptions.SeatNotAvailableException;
import com.flipkart.exceptions.StudentNotRegisteredException;
import com.flipkart.exceptions.UserNotFoundException;
import com.flipkart.utils.Utils;

/**
 * @author saranshjain
 *
 */
public class CRSApplicationMenu {

	CRSApplicationMenu crsApplicationMenu = new CRSApplicationMenu();
	static UserInterface userService = UserService.getInstance();
	static StudentInterface studentService = StudentService.getInstance();
	static ProfessorInterface professorService = ProfessorService.getInstance();
	static NotificationInterface notificationService = NotificationService.getInstance();
	static Scanner sc = new Scanner(System.in);
	static boolean loggedin = false;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int userInput;
		
		try {
			while(true) {
				
				createMainMenu();
				
				userInput = sc.nextInt();
				
				switch(userInput) {
				
				case 1:
					userLogin();
					break;
				case 2:
					registerStudent();
					break;
				case 3:	
					updatePassword();
					break;
				case 4:
					exit();
					break;
				default:
					System.out.println("Invalid Input !");
				}
				
				if (userInput == 4) {
					break;
				}
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
		
	}
	
	/**
	 * Method to Create Main Menu
	 */
	private static void createMainMenu()
	{
        System.out.println("#------------------------Welcome to Course Registration System------------------------#");
        
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. Update Password");
        System.out.println("4. Exit");
        
        System.out.print("Enter User Input: ");
	}
	
	/**
	 * User Login
	 * @throws CourseNotFoundException 
	 * @throws SQLException 
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceededException 
	 * @throws ProfessorAlreadyRegisteredException 
	 */
	private static void userLogin() throws CourseLimitExceededException, SeatNotAvailableException, SQLException, CourseNotFoundException, ProfessorAlreadyRegisteredException {
		
		try {
			System.out.println("-----------------Login------------------");
			
			String userEmailId, userPassword;
			
			System.out.println("Enter Email ID: ");
			userEmailId = sc.next();
			
			System.out.println("Enter Password: ");
			userPassword = sc.next();
			
			loggedin = userService.validateUser(userEmailId, userPassword);
			
			if(loggedin) {
				
				DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				LocalDateTime dateObj = LocalDateTime.now();
				String formattedDate = dateObj.format(formatObj);
				String role = userService.getRoleOfUser(userEmailId);
				RoleConstant userRole = RoleConstant.stringToRole(role);
				int userId = userService.getUserId(userEmailId);
				
				switch (userRole) {
				
				case ADMIN: 
					System.out.println(formattedDate + " Login Successful.");
					CRSAdminMenu.createAdminMenu();
					break;
				case STUDENT: 
					int studentId = studentService.getStudentId(userId);
					boolean isApproved = studentService.isApproved(studentId);
					if(isApproved) {
						System.out.println(formattedDate + " Login Successful.");
						CRSStudentMenu.createStudentMenu(studentId); 
					} else {
						System.out.println("Failed to login, you have not been approved by the administrator!");
						loggedin = false;
					}
					break;
				case PROFESSOR: 
					try {
						int professorId = professorService.getProfessorId(userId);
						System.out.println(formattedDate + " Login Successful.");
						CRSProfessorMenu.createProfessorMenu(professorId);
						break;
					} catch (SQLException e) {
						System.out.println("Error: " + e.getMessage());
					}
				}
			}
			else {
				
				System.out.println("Invalid Credentials !");
			}
		} catch (UserNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * Student Registration
	 */
	private static void registerStudent() {
		
		try {
			System.out.println("---------------Student Registration-------------");
			
			int userId = Utils.generateId();
			
			String studentName, studentEmailId, studentPassword, studentPhoneNo, studentBranch, studentAddress;
			int studentBatch, studentGender;
			GenderConstant gender;
			
			Student student = new Student();
			sc.nextLine();
			
			System.out.println("Enter Student Name: ");
			studentName = sc.next();
			student.setUserName(studentName);
			
			System.out.println("Enter Student Email ID: ");
			studentEmailId = sc.next();
			student.setUserEmailId(studentEmailId);
			
			System.out.println("Enter Student Password: ");
			studentPassword = sc.next();
			student.setUserPassword(studentPassword);
			
			System.out.println("Enter Student Gender: \t 1. Male \t 2.Female \t 3.Other");
			studentGender = sc.nextInt();
			gender = GenderConstant.getName(studentGender);
			student.setGender(gender);
			
			System.out.println("Enter Student Branch: ");
			studentBranch = sc.next();
			student.setBranchName(studentBranch);
			
			System.out.println("Enter Student Batch (Graduation Year): ");
			studentBatch = sc.nextInt();
			student.setBatch(studentBatch);
			
			sc.nextLine();
			
			System.out.println("Enter Student Address: ");
			studentAddress = sc.next();
			student.setAddress(studentAddress);
			
			System.out.println("Enter Student Phone Number: ");
			studentPhoneNo = sc.next();
			student.setPhoneNo(studentPhoneNo);
			
			student.setUserId(userId);
			student.setRole(RoleConstant.STUDENT);
		
			studentService.register(student);
			
		} catch (StudentNotRegisteredException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * Password Updation
	 */
	private static void updatePassword() throws OldPasswordNotValidException, UserNotFoundException, ConfirmPasswordException {
		
		try {
			
			System.out.println("------------------Update Password--------------------");
			
			String userEmailId, oldPassword, newPassword, confirmNewPassword;
			
			System.out.println("Enter Email Id: ");
			userEmailId = sc.next();
			
			System.out.println("Enter Current Password: ");
			oldPassword = sc.next();
			
			System.out.println("Enter New Password: ");
			newPassword = sc.next();
			
			System.out.println("Confirm New Password: ");
			confirmNewPassword = sc.next();
			
			userService.updatePassword(userEmailId, oldPassword, newPassword, confirmNewPassword);
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	/**
	 * Exiting from the System
	 */
	private static void exit() {
		
		System.out.println("\nThanks for your visit !");
	}
}
