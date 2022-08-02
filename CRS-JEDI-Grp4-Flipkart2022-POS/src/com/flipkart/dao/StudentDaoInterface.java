/**
 * 
 */
package com.flipkart.dao;

//import com.flipkart.exception.*;
//import javafx.util.Pair;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
//import java.util.collection;
/**
 * operations for the student dao interface
 */
public interface StudentDaoInterface {
    public String getUsername(String userID);
/**
 * @author stuti.priyambda
 *
 */
public interface StudentDaoInterface {

    public void preferenceUpdate(String userID, List<String> preference) ;
    public void addCourse(String userID, String courseID) ;
    public void dropCourse(String userID, String courseID);

    public List<String> viewEnrolledCourses(String userID);
    public void viewGrades(String userID);

    public boolean isRegistered(String userID);

    public boolean isFeePaymentStatus(String userID) ;

    public void setFeePaymentStatus(String userID, String mode, String refID, int amt) ;

    void newRegistration(String studentID, String password, String name, String batch, String address) ;

    Boolean checkApprovalStatus(String userID) ;
    public Boolean checkCourseAvailability(String courseID) ;
}