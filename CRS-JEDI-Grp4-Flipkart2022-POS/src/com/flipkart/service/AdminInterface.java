package com.flipkart.service;

import java.util.Vector;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
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

/**
 * @author saransh
 *
 */
public interface AdminInterface {

	/**
	 * @return
	 */
	Vector<Professor> viewProfessor();

	/**
	 * @return
	 */
	Vector<Course> viewCourse();

	/**
	 * @param professor
	 * @throws UserIdAlreadyInUseException
	 * @throws ProfessorNotAddedException
	 */
	void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

	/**
	 * @param professorId
	 * @throws ProfessorNotDeletedException
	 * @throws ProfessorNotFoundException
	 */
	void deleteProfessor(int professorId) throws ProfessorNotFoundException, ProfessorNotDeletedException;

	/**
	 * @param studentId
	 */
	void setIsGenerateGrade(int studentId);

	/**
	 * 
	 * @param studentId
	 * @param pendingStudents
	 * @throws StudentNotFoundForApprovalException
	 */
	void approveStudentRegistration(int studentId, Vector<Student> pendingStudents) throws StudentNotFoundForApprovalException;

	/**
	 * 
	 * @return
	 */
	Vector<Student> viewPendingAdmissions();

	/**
	 * 
	 * @param course
	 * @param courseList
	 * @throws CourseAlreadyExistsException
	 */
	void addCourse(Course course, Vector<Course> courseList) throws CourseAlreadyExistsException;

	/**
	 * 
	 * @param courseId
	 * @param courseList
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException
	 */
	void deleteCourse(int courseId, Vector<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException;
	
	/**
	 * @param studentId
	 * @throws ProfessorHasNotGradedException 
	 * @throws StudentNotFoundException 
	 */
	void generateGradeCard(int studentId) throws StudentNotFoundException, ProfessorHasNotGradedException;

}