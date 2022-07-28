
package com.flipkart.app;

import java.util.Scanner;

public class StudentCRS {
	
	
	
	
	public  void studentHelpmenu()
	{	
		
		
		
		while (CRSApplication.loggedin )
		{
			
			System.out.println(" ...............******  Student Portal ****** .............. ");
			
			
			System.out.println("1. Add Course");
			System.out.println("2. Drop Course");
			System.out.println("3. View Course");
			System.out.println("4. View Registered Courses");
			System.out.println("5. View grade card");
			System.out.println("6. Make Payment");
			System.out.println("7. Exit");
			Scanner sc = new Scanner(System.in);

			int choice = sc.nextInt();

			switch (choice) {
				case 1: 
						//addCourse();
						System.out.println("addCourse()");
						break;
						
				case 2:
						System.out.println("dropCourse()");
						//dropCourse();
						break;

				case 3:
						System.out.println("viewCourse()");
						//viewCourse();
						break;

				case 4:
						System.out.println("viewRegisteredCourse()");
						//viewRegisteredCourse();
						break;

				case 5:
						System.out.println("viewgradeCard()");
						//viewGradeCard();
						break;
						
				case 6:
						System.out.println("feePayment()");
						//feePayment();
						break;
				case 7:
					CRSApplication.loggedin = false;
					return;
						
				default:
						System.out.println("Invalid Input !!! ");
						break;
			}
		}
	}
	


}
