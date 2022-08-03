/**
 * 
 */
package com.flipkart.service;

import com.flipkart.constants.GenderConstant;
import com.flipkart.constants.RoleConstant;
import com.flipkart.exceptions.StudentNotRegisteredException;
import org.apache.log4j.Logger;

import java.sql.SQLException;

import com.flipkart.bean.Student;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.utils.Utils;

/**
 * @author vishal, komal
 *
 */
public class StudentService implements StudentInterface {
	
	private static volatile StudentService instance = null;
	private static Logger logger = Logger.getLogger(StudentService.class);
	
	/**
	 * Default Constructor
	 */
	private StudentService() {
		
	}
	
	/**
	 * Method to make StudentService Singleton
	 */
	public static StudentService getInstance() {
		
		if(instance == null) {
			
			synchronized(StudentService.class) {
				
				instance = new StudentService();
			}
		}
		return instance;
	}
	
	StudentDaoInterface studentDaoOperation = StudentDaoOperation.getInstance();
	RegistrationDaoInterface registrationDaoOperation = RegistrationDaoOperation.getInstance();
	
	
	public static final Student student = new Student("userName",  "student@gmail.com",  "student",  RoleConstant.STUDENT,  101,  "phoneNo", GenderConstant.MALE,  "address", "branchName", 13, 2022, true);

	@Override
	public int register(Student student) throws StudentNotRegisteredException {

 		int studentId = Utils.generateId();

 		student.setStudentId(studentId);
 		
 		try {
 			studentId = studentDaoOperation.addStudent(student);
 		} catch (StudentNotRegisteredException e) {
 			throw e;
 		}
 		
 		

 		return studentId;
	}
	
	@Override
	public int getStudentId(int userId) {
		
		return studentDaoOperation.getStudentId(userId);
	}
	
	@Override
	public Boolean isApproved(int studentId) {
		
		return studentDaoOperation.isApproved(studentId);
	}
	
	@Override
	public Boolean isGenerated(int studentId) {

 		return null;
 	}
	
	@Override
	public boolean semesterRegistration(int semester, int studentId) throws SQLException {
		
		boolean check = registrationDaoOperation.semesterRegistration(semester, studentId);
		if(!check) {
 			boolean checkstatus = registrationDaoOperation.addSemester(semester, studentId);
 			if(checkstatus) {
 				return true;
 			} else {
 				logger.info("Semseter Registration is Failed, Please try again!");
 			}
 		}
 		return false;
 	}
}
