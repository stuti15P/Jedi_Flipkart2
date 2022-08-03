package com.flipkart.service;

import java.sql.SQLException;
import java.util.Vector;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exceptions.CourseNotFoundException;

public interface ProfessorInterface {

	/**
	 * 
	 * @param studentId
	 * @param courseCode
	 * @param gpa
	 * @param semesterId
	 * @return
	 * @throws SQLException 
	 */
	boolean addGrade(int studentId, int courseCode, double gpa) throws SQLException;

	/**
	 * 
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	Vector<EnrolledStudent> viewEnrolledStudents(int professorId) throws SQLException;

	/**
	 * 
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewCourses(int professorId) throws SQLException;

	/**
	 * 
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewAvailableCourses() throws SQLException;

	/**
	 * 
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	String getProfessorById(int professorId) throws SQLException;

	/**
	 * 
	 * @param professorId
	 * @param courseSelectedId
	 * @return
	 * @throws SQLException 
	 * @throws CourseNotFoundException
	 */
	boolean addCourse(int professorId, int courseSelectedId) throws SQLException, CourseNotFoundException;

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	int getProfessorId(int userId) throws SQLException;

	/**
	 * 
	 * @param professorId
	 * @return
	 * @throws SQLException
	 */
	Vector<EnrolledStudent> getNotGradedStudents(int professorId) throws SQLException;

}