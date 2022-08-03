package com.flipkart.dao;

import java.util.Vector;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exceptions.CourseAlreadyExistsException;
import com.flipkart.exceptions.CourseNotDeletedException;
import com.flipkart.exceptions.CourseNotFoundException;
import com.flipkart.exceptions.ProfessorHasNotGradedException;
import com.flipkart.exceptions.ProfessorNotAddedException;
import com.flipkart.exceptions.ProfessorNotDeletedException;
import com.flipkart.exceptions.ProfessorNotFoundException;
import com.flipkart.exceptions.StudentNotFoundException;
import com.flipkart.exceptions.StudentNotFoundForApprovalException;
import com.flipkart.exceptions.UserIdAlreadyInUseException;
import com.flipkart.exceptions.UserNotAddedException;

public interface AdminDaoInterface {

	/**
	 * 
	 * @param professor
	 * @throws ProfessorNotAddedException
	 * @throws UserIdAlreadyInUseException
	 */
	void addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException;

	/**
	 * 
	 * @return
	 */
	Vector<Professor> viewProfessor();

	/**
	 * 
	 * @param professorId
	 * @throws ProfessorNotDeletedException
	 * @throws ProfessorNotFoundException
	 */
	void deleteProfessor(int professorId) throws ProfessorNotFoundException, ProfessorNotDeletedException;

	/**
	 * 
	 * @param studentId
	 * @throws StudentNotFoundForApprovalException
	 */
	void approveStudentRegistration(int studentId) throws StudentNotFoundForApprovalException;

	/**
	 * 
	 * @param course
	 * @throws CourseAlreadyExistsException 
	 */
	void addCourse(Course course) throws CourseAlreadyExistsException;

	/**
	 * 
	 * @return
	 */
	Vector<Course> viewCourse();

	/**
	 * 
	 * @param courseId
	 * @throws CourseNotDeletedException 
	 * @throws CourseNotFoundException 
	 */
	void deleteCourse(int courseId) throws CourseNotFoundException, CourseNotDeletedException;

	/**
	 * 
	 * @param user
	 * @throws UserIdAlreadyInUseException 
	 * @throws UserNotAddedException 
	 */
	void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

	/**
	 * 
	 * @param studentId
	 */
	void setIsGenerateGrade(int studentId);

	/**
	 * 
	 * @return
	 */
	Vector<Student> viewPendingAdmissions();

	/**
	 * 
	 * @param studentId
	 * @param semesterId
	 * @throws StudentNotFoundException
	 * @throws ProfessorHasNotGradedException
	 * @return
	 */
	Vector<GradeCard> generateGradeCard(int studentId) throws StudentNotFoundException, ProfessorHasNotGradedException;

}