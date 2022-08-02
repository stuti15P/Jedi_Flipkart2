/**
 * 
 */
package com.flipkart.app;
import com.flipkart.app.StudentCRS;
import com.flipkart.app.ProfessorCRS;
import com.flipkart.app.AdminCRS;

import java.sql.SQLException;

/**
 * @author stuti.priyambda
 *
 */



import java.util.Scanner;


public class CRSApplication {
	
	static boolean loggedin =false;

	public static void helpMenu()
	{
		System.out.println("******************* Welcome! to the CRS Application **********************");
		System.out.println("Press 1 for login");
		System.out.println("Press 2 for Student Registeration");
		System.out.println("Press 3 for password Updation");
		System.out.print("Press 0 to exit ");
	}
	
	public static void main(String[] args) throws SQLException {
		helpMenu();  
		Scanner in = new Scanner(System.in);
        int userInp = in.nextInt();  
        CRSApplication crsapp = new CRSApplication();
        
        while(userInp != 0)
        {
        	
        	switch(userInp)
        	{
        		case 1:  //Login
        			crsapp.login();
        			break;
        		case 2:     //Student Registration
        			//crsapp.studentRegistration();
        			break;
        		case 3:  
        			//crsapp.passwordUpdation();
        			break;
        		
        		default:
        			System.out.println("Invalid Input!! Please give valid input.");
        			break;
        			
        	
        	}	//Switch case 
        	helpMenu();
        	userInp = in.nextInt();
        	
        }  //While-loop
          
	}
	
	
	public static void roleMenu()
	{
		
		System.out.println("Press 1 for Student");
		System.out.println("Press 2 for Professor");
		System.out.println("Press 3 for Admin");
		System.out.println("*****..........................*******");
	}
	
	public void login() throws SQLException
	{
		Scanner in= new Scanner(System.in);
		
		String userId, password;
		
		System.out.println("**************** Login System!!! ****************");
		System.out.println("Please Enter your UserId");
		userId= in.next();
		System.out.println("Please Enter your Password");
		password =in.next();
		boolean status =true;     // Login Done.
		
		System.out.println("Login Suceesful!!");
		
		// need to verify the credentials       ------------>
		if(status) {
			loggedin =true;
			System.out.println("Please Enter the Role");
			roleMenu();
			
			int user = in.nextInt();
			
			switch(user) {
			
			case 1:
				// Student part
				StudentCRS stucrs =new StudentCRS();
				stucrs.studentHelpmenu();
				
			case 2 :
				// PROF PART
				ProfessorCRS profcrs =new ProfessorCRS();
				profcrs.professorHelpMenu();
				
			case 3 :
				AdminCRS admincrs =new AdminCRS();
				admincrs.adminHelpMenu();
			
			}
		}
		
		
		else {
			
			System.out.println("Invalid Credentials");
		}  
		
		
			
				
	}
	
	public void passwordUpdation() {
		
		Scanner in = new Scanner(System.in);
		
		String userId, oldPassword, newPassword;
		
		System.out.println("Update Password");
		
		System.out.println("Email");
		userId= in.next();
		System.out.println("Enter old Password");
		oldPassword =in.next();
		boolean status =false;
		
		//Write code to verify userID  with oldPassword.  -------->
		//If success 
		status =true;
		if(status) {
			System.out.println("Enter new Password");
			newPassword = in.next();
			
			// need to update it in system   -------->
				
		}
		
		else {
			System.out.println("Enter correct password/Email");
		}
		
		
		
	}
	
	
	public void studentRegistration()
	{
		String stuId,stuName,password,stuBranch;
		int stuSem;
		Scanner sc=new Scanner(System.in);

		System.out.println("************* Welcome to Student Registration Portal ***************");
		System.out.println("Please Enter Your StudentId");
		stuId =sc.nextLine();
		System.out.println("Please Enter Your Name");
		stuName=sc.nextLine();
		System.out.println("Please Enter Your password");
		password=sc.next();
		System.out.println("Please Enter Your Branch");
		stuBranch =sc.nextLine();
		System.out.println("Please Enter Your Semester");
		stuSem =sc.nextInt();
		

		//String newStudentId = studentService.register(stuId, stuName, password, stuBranch, stuSem);
		System.out.println("Send Notification of Registration Status!! ");
		
	}
	
	
	
	
	

}
