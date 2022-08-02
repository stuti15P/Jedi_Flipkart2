package com.flipkart.service;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.sql.SQLException;
import com.flipkart.dao.*;



public class StudentServiceImpl implements StudentService{

    StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

    /**
     * Print Login Message
     * @param userID
     */
    @Override
    public void loginMsg(String userID){
        String username = studentDaoImpl.getUsername(userID);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Student - " + username + "(" + userID + ") has logged in at time " + localDateTime);
    }

    /**
     * Student Course Registration
     * @param userID
     * @throws SQLException
     * @throws CourseAlreadyRegistered
     * @throws CourseNotPresentException
     * @throws SeatNotAvailableException
     */
    @Override
    public void registerCourses(String userID)  {
        List<String> preference = new ArrayList<>();

//        AdminDaoInterface adminDAOInterface = new AdminDaoImpl();
//        adminDAOInterface.showCourses();
        
            System.out.println("Select four primary and two alternative courses using CourseID: ");
            Scanner in = new Scanner(System.in);
            for(int i=1;i<=6;i++) {
                System.out.println("Preference " + i + ". Enter CourseID: ");
                String courseID = in.next();
                studentDaoImpl.checkCourseAvailability(courseID);
                    preference.add(courseID);
                
            }
            studentDaoImpl.preferenceUpdate(userID,preference);
        
    }

    /**
     * Add Course by Student
     * @param userID
     * @throws CourseAlreadyRegistered
     * @throws CourseNotPresentException
     */
    @Override
    public void addCourse(String userID)  {
        showCourses();
        System.out.println("Enter CourseID to add Course: ");
        Scanner in = new Scanner(System.in);
        String courseID = in.next();
  
        	studentDaoImpl.addCourse(courseID,userID);
            System.out.println("Course Added with CourseID: " + courseID);
        

    }

    /**
     * Drop Course by Student
     * @param userID
     * @throws CourseNotPresentException
     */
    @Override
    public void dropCourse(String userID) {
        List<String> enrolledCourses = studentDaoImpl.viewEnrolledCourses(userID);
        System.out.println("Enter CourseID to drop Course: ");
        Scanner in = new Scanner(System.in);
               String courseID = in.next();
        studentDaoImpl.dropCourse(userID,courseID);
    }

    /**
     * View Student Enrolled Courses
     * @param userID
     */
    @Override
    public void viewEnrolledCourses(String userID) {
    	studentDaoImpl.viewEnrolledCourses(userID);
    }

    /**
     * Pay Fees
     * @param userID
     */
    @Override
    public void payFees(String userID){
        
            if(studentDaoImpl.isFeePaymentStatus(userID)) {
//                throw new FeesAlreadyPaid(userID);
            }
            if(!studentDaoImpl.isRegistered(userID)) {
//                throw new StudentNotRegistered(userID);
            }
            System.out.println("Select Payment Method: ");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. Net Banking");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            switch (input) {
                case 1:
                	studentDaoImpl.setFeePaymentStatus(userID,"Credit Card",userID,100);
                    break;

                case 2:
                	studentDaoImpl.setFeePaymentStatus(userID,"Debit Card",userID,100);
                    break;

                case 3:
                	studentDaoImpl.setFeePaymentStatus(userID,"Net Banking",userID,100);
                    break;

                default:
                    System.out.println("Invalid Selection");
            }

    }

    /**
     * View Grade Card
     * @param userID
     */
    @Override
    public void viewGradeCard(String userID) {
        System.out.println("Student Grades");
//        List<Pair<String,String>> enrolledCourses = studentDAOInterface.viewGrades(userID);
//        for(int i=0;i<enrolledCourses.size();i++) {
//            System.out.println("CourseID: " + enrolledCourses.get(i).getKey() + " --> Grade: " + enrolledCourses.get(i).getValue());
//        }

    }

    /**
     * New Registration
     * @param studentID
     * @param password
     * @param name
     * @param batch
     * @param address
     * @throws UserAlreadyExist
     * @throws UserNotAdded
     */
    @Override
    public void newRegistration(String studentID, String password, String name, String batch, String address) {
   
    	studentDaoImpl.newRegistration(studentID,password,name,batch,address);
       
    }

    /**
     * Show Course Catalog
     */
    @Override
    public void showCourses() {
//        AdminDAOInterface adminDAOInterface = new AdminDAOOperation();
//        adminDAOInterface.showCourses();
    }

    /**
     * Check Student Approval Status
     * @param userID
     * @return
     * @throws UserNotFoundException
     * @throws StudentNotApproved
     */
    @Override
    public Boolean checkApprovalStatus(String userID) {
        Boolean approvalStatus = studentDaoImpl.checkApprovalStatus(userID);
        if(!approvalStatus){
            return false;
        }else{
            return true;
        }

    }

}