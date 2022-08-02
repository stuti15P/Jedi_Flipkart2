package com.flipkart.service;

import com.flipkart.bean.Student;
//import com.flipkart.exception.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Service Interface for Student
 */
public interface StudentService {
    /**
     * Print Login Message
     * @param userID
     */
    public void loginMsg(String userID);

    /**
     * Student Course Registration
     * @param userID
     * @throws SQLException
     * @throws CourseAlreadyRegistered
     * @throws CourseNotPresentException
     * @throws SeatNotAvailableException
     */
    public void registerCourses(String userID);

    /**
     * Add Course by Student
     * @param userID
     * @throws CourseAlreadyRegistered
     * @throws CourseNotPresentException
     */
    public void addCourse(String userID);

    /**
     * Drop Course by Student
     * @param userID
     * @throws CourseNotPresentException
     */
    public void dropCourse(String userID);

    /**
     * View Student Enrolled Courses
     * @param userID
     */
    public void viewEnrolledCourses(String userID);

    /**
     * Pay Fees
     * @param userID
     */
    public void payFees(String userID);

    /**
     * View Grade Card
     * @param userID
     */
    void viewGradeCard(String userID);

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
    void newRegistration(String studentID, String password, String name, String batch, String address);

    /**
     * Show Course Catalog
     */
    void showCourses();

    /**
     * Check Student Approval Status
     * @param userID
     * @return
     * @throws UserNotFoundException
     * @throws StudentNotApproved
     */
    Boolean checkApprovalStatus(String userID);
}