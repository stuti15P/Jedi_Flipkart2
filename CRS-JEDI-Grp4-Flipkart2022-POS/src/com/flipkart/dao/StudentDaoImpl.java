package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBUtils;
//import com.mysql.cj.conf.ConnectionUrlParser.Pair;
//import com.flipkart.exception.CourseAlreadyRegistered;
//import com.flipkart.exception.CourseNotPresentException;
//import com.flipkart.exception.UserAlreadyExist;
//import com.flipkart.exception.UserNotFoundException;
//import com.flipkart.exception.*;
import com.mysql.cj.protocol.Resultset;
//import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.app.CRSApplication.*;
//import static com.flipkart.constants.SQLQueriesConstants.*;

public class StudentDaoImpl implements StudentDaoInterface{

    PreparedStatement preparedStatement;
    Connection connection =DBUtils.getConnection();
    /**
     * get the username
     * @param userID
     * @return
     */
    public String getUsername(String userID) {
        String username = "";
        try {
	        preparedStatement = connection.prepareStatement(SQLQueriesConstant.SHOW_STUDENT);
	        preparedStatement.setString(1, userID);
	        ResultSet rs = preparedStatement.executeQuery();
	        
	        while (rs.next()) {
	            username = rs.getString("studentname");
	        }
        }
    	catch (Exception e){
    		System.out.println(e);
    	}
        finally {}
        return username;
    }

    /**
     * update the preference of the courses
     * @param userID
     * @param preference
     * @throws SQLException
     * @throws CourseAlreadyRegistered
     * @throws CourseNotPresentException
     * @throws CourseLimitExceededException
     * @throws SeatNotAvailableException
     */
    @Override
    public void preferenceUpdate(String userID, List<String> preference)  {
            Integer count = this.getNumberOfEnrolledCourses(userID);

       
            try {preparedStatement = connection.prepareStatement(SQLQueriesConstant.UPDATE_PREFERENCE);
            for (int i=0;i<6;i++) {
                preparedStatement.setString(i+1,preference.get(i));
            }
            preparedStatement.setString(7,userID);
            int row = preparedStatement.executeUpdate();
            if(row!=0) {
                System.out.println("Your Courses are Registered!");
                
                    for(int i=0;i<4;i++) {
                        this.addCourse(preference.get(i),userID);
                    }

            }
            }
        	catch (Exception e){
        		System.out.println(e);
        	}

    }

    /**
     * add course to registered
     * @param userID
     */
    @Override
    public void addCourse(String courseID,String userID) {
        try {
            Integer count = this.getNumberOfEnrolledCourses(userID);
//            if(count>=6){
//                throw new CourseLimitExceededException(count);
//            }
            this.checkCourseAvailability(courseID);
            PreparedStatement stmt = connection.prepareStatement(SQLQueriesConstant.ADD_TO_REGISTER);
            stmt.setString(1,courseID);
            stmt.setString(2,userID);
            int row = stmt.executeUpdate();
            if(row!=0) {
                System.out.println("Added Course: " + courseID);
                //incrementCourseStrength(courseID);

            }
        }
    	catch (Exception e){
    		System.out.println(e);
    	}
    }

    /**
     * increment course strength
     * @param courseID
     */
//    private void incrementCourseStrength(String courseID) {
//    	try {
//            PreparedStatement stm = connection.prepareStatement(SQLQueriesConstant.INCREMENT_COURSE_STRENGTH);
//            stm.setString(1,courseID);
//            stm.executeUpdate();
//            System.out.println("its happening");
//    	}
//    	catch (Exception e){
//    		System.out.println(e);
//    	}
//        
//    }

    /**
     * drop the course
     * @param userID
     */
    @Override
    public void dropCourse(String userID, String courseID) {
    	try {
        
            preparedStatement = connection.prepareStatement(SQLQueriesConstant.DROP_FROM_REGISTER);

            preparedStatement.setString(1,userID);
            preparedStatement.setString(2,courseID);

            int status = preparedStatement.executeUpdate();
            if(status!=0) {
                System.out.println("Course: " + courseID + " Dropped!");
                //decrementCourseStrength(courseID);
            }
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}
        
    }

    /**
     * decrement course strength
     * @param courseID
     */
//    private void decrementCourseStrength(String courseID) {
//    	try {
//        
//            PreparedStatement stm = connection.prepareStatement(SQLQueriesConstant.DECREMENT_COURSE_STRENGTH);
//            stm.setString(1,courseID);
//            stm.executeUpdate();
//    	}
//    	catch (Exception e){
//    		System.out.println(e);
//    	}
//        
//
//    }

    /**
     * view list of Enrolled courses
     * @param userID
     * @return
     */
    @Override
    public List<String> viewEnrolledCourses(String userID) {
    	
        List<String> enrolledCourses = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQLQueriesConstant.VIEW_ENROLLED_COURSES);
            preparedStatement.setString(1,userID);
            System.out.println("Your registered courses are: ");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                enrolledCourses.add(rs.getString("courseCode"));
//                System.out.println(rs.getString("courseid") + ": " + rs.getString("grade"));
                System.out.println("Student ID: " + userID + " -> Course ID: " + rs.getString("courseCode"));
            }
        }
    	catch (Exception e){
    		System.out.println(e);
    	}
        
        return enrolledCourses;
    }

    /**
     * to check whether course is registered
     * @param userID
     * @return
     */

    public boolean isRegistered(String userID){
    	try {
        
            PreparedStatement stmt = connection.prepareStatement(SQLQueriesConstant.SHOW_STUDENT);
            stmt.setString(1,userID);
            ResultSet rs = stmt.executeQuery();
            return rs.getBoolean("isregistered");
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}
         return false;
        
    }

    /**
     * to check Fee payment status
     * @param userID
     * @return
     * @throws UserNotFoundException
     */
    public boolean isFeePaymentStatus(String userID) {
    	
        
            try{
            	PreparedStatement stmt = connection.prepareStatement(SQLQueriesConstant.GET_FEES_STATUS);
            stmt.setString(1,userID);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return rs.getBoolean("feesPaymentStatus");
            }
            else {
//                throw new UserNotFoundException(userID);
            }
            }
        	catch (Exception e){
        		System.out.println(e);
        	}
            return false;
        
    }

    /**
     * Report Payment
     * @param userID
     * @throws UserNotFoundException
     */
    public void reportPayment(String userID) {
       
//            preparedStatement = connection.prepareStatement(SQLQueriesConstant.REPORT_PAYMENT);
//            preparedStatement.setString(1,userID);
//            int row = preparedStatement.executeUpdate();
//            if(row > 0) {
//
//            }
        
        
    }

    /**
     * set the fee payment status
     * @param userID
     * @param mode
     * @param refID
     * @param amt
     * @throws UserNotFoundException
     */
    public void setFeePaymentStatus(String userID, String mode, String refID, int amt)  {
        
//            String sql = ADD_PAYMENT;
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setString(1,refID);
//            stmt.setString(2,userID);
//            stmt.setInt(3,amt);
//            stmt.setString(4,mode);
//            int row = stmt.executeUpdate();
//            if(row > 0) {
//                System.out.println("Reference ID:" + refID + "Fees Paid Successfully for StudentID:" + userID + "using " + mode);
//                this.reportPayment(userID);
//
//            }
        
    }

    /**
     * To register the new student
     * @param studentID
     * @param password
     * @param name
     * @param batch
     * @param address
     */
    @Override
    public void newRegistration(String studentID, String password, String name, String batch, String address) {
//        AdminDAOInterface adminDAOInterface = new AdminDAOOperation();
//        adminDAOInterface.addUser(new User(studentID,name,"student",password));
//        
//            preparedStatement = connection.prepareStatement(SQLQueriesConstant.NEW_REGISTER_STUDENT);
//            preparedStatement.setString(1,studentID);
//            preparedStatement.setString(2,name);
//            preparedStatement.setString(3,batch);
//            preparedStatement.setString(4,address);
//            int row = preparedStatement.executeUpdate();
//            if(row > 0) {
//                System.out.println("New Registration Done!");
//            }

        
    }

    /**
     * to check Approval status
     * @param userID
     * @return
     */
    @Override
    public Boolean checkApprovalStatus(String userID){
       
//            preparedStatement = connection.prepareStatement(SQLQueriesConstant.GET_APPROVAL_STATUS);
//            preparedStatement.setString(1,userID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet.next()) {
//                return resultSet.getBoolean("isapproved");
//            }
    	return true;
            
    }

    /**
     * to view grades
     * @param userID
     * @return
     */
    @Override
    public void viewGrades(String userID) {
//        List<Pair<String,String>> grd = new ArrayList<>();
////            String sql = VIEW_ENROLLED_COURSES;
////            PreparedStatement stmt = connection.prepareStatement(sql);
////            stmt.setString(1,userID);
////            System.out.println("------ Grade Card -------");
////            ResultSet rs = stmt.executeQuery();
////            while(rs.next()){
////                grd.add(new Pair <String,String> (rs.getString("courseid"),rs.getString("grade")));
//////                System.out.println(rs.getString("courseid") + ": " + rs.getString("grade"));
////            }
//        
//        return grd;
    }

    /**
     * to check course Availability
     * @param courseID
     * @return
     * @throws CourseNotPresentException
     * @throws com.flipkart.exception.SeatNotAvailableException
     */
    public Boolean checkCourseAvailability(String courseID) {
//            preparedStatement = connection.prepareStatement(SQLQueriesConstant.CHECK_COURSE_AVAILABILITY);
//            preparedStatement.setString(1,courseID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            int seats=0;
//            seats=seatsavaliable(courseID);
            return true;
        
    }

    /**
     * to check seat availiblity
     * @param courseID
     * @return
     */

    private int seatsavaliable(String courseID) {
    	int ans=0;
//            preparedStatement = connection.prepareStatement(SQLQueriesConstant.CHECK_COURSE_AVAILABILITY);
//            int ans=0;
//        preparedStatement.setString(1,courseID);
//        ResultSet rs = preparedStatement.executeQuery();
//        while(rs.next()){
//            ans = Integer.parseInt(rs.getString("coursestrength"));
//        }

        return ans;

    }

    /**
     * get Number of Enrolled courses
     * @param studentID
     * @return
     */

    public Integer getNumberOfEnrolledCourses(String studentID){
//            preparedStatement = connection.prepareStatement(SQLQueriesConstant.GET_NUMBER_OF_ENROLLED_COURSES);
//            preparedStatement.setString(1,studentID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet.next()){
//                Integer count = resultSet.getInt(1);
//                return count;
//            }      
        return 0;
    }
}