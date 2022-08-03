package com.flipkart.dao;

import com.flipkart.bean.Student;
import com.flipkart.exceptions.StudentNotRegisteredException;

public interface StudentDaoInterface {

	/**
	 * Add Student to Database
	 * @param student
	 * @return
	 * @throws StudentNotRegisteredException
	 */
	int addStudent(Student student) throws StudentNotRegisteredException;

	/**
	 * Retrieve Student Id from User Id
	 * @param userId
	 * @return
	 */
	int getStudentId(int userId);

	/**
	 * Check if Student is Approved or not
	 * @param studentId
	 * @return
	 */
	boolean isApproved(int studentId);

}