package com.flipkart.dao;
import com.flipkart.bean.User;
import com.flipkart.bean.Professor;
public interface AdminDaoInterface {
    public void addUser(User user);
    public void addProfessor(Professor professor);
    public void approveStudent(String userId);
    public void viewPendingApprovals();

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;

/**
 * @author stuti.priyambda
 *
 */
public interface AdminDaoInterface {


	/**
	 * Assign courses to Professor using SQL commands
	 * @param course
	 * @param professorId

	 */
	public void assignCourse(String courseId, String professorId) throws SQLException;


	/**
	 * View courses in the catalog
	 * @param catalogId: Catalog ID
	 * @return List of courses in the catalog
	 * @throws SQLException
	 */
	public List<Course> viewCourses() throws SQLException;


	/**
	 * Add Course using SQL commands
	 * @param course
	 * @throws CourseFoundException
	 */
	public void addCourse(Course course) throws SQLException;


	/**
	 * Fetch Students yet to approved using SQL commands
	 * @return List of Students yet to approved
	 */
	public List<Student> viewPendingAdmissions() throws SQLException ;

	/**
	 * Delete Course using SQL commands
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException
	 */
	public void deleteCourse(String courseId) throws SQLException;




	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundForApprovalException
	 */
	public void approveStudent(int studentId) throws SQLException;

	/**
	 * Add professor using SQL commands
	 * @param professor
	 * @throws ProfessorNotAddedException
	 * @throws UserIdAlreadyInUseException
	 */
	public void addProfessor(Professor professor) throws SQLException;

	/**
	 * Method to add user using SQL commands
	 * @param user
	 * @throws UserNotAddedException
	 * @throws UserIdAlreadyInUseException
	 */
	public void addUser(User user) throws SQLException;


	/**
	 * View professor in the institute
	 * @return List of the professors in the institute
	 */
	public List<Professor> viewProfessors() throws SQLException;

}
