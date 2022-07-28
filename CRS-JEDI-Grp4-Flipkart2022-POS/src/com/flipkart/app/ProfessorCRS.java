
/**
 * 
 */


package com.flipkart.app;
import java.util.Scanner;
/**
 * @author stuti.priyambda
 *
 */
public class ProfessorCRS {

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
                         break;
                     case 2:
                    	 System.out.println("Add grades");
                         break;
                    case 3:
                    	System.out.println("show course catalog");
                        break;
                    case 0:
        				CRSApplication.loggedin = false;
        				return;


                    default:
                        System.out.println("***** Invalid Input *****");
                 }
             

        }
    }
}

