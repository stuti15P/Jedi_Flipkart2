/**
 * 
 */
package com.flipkart.constant;

/**
 * @author stuti.priyambda
 *
 */
public class SQLQueriesConstant {
	
	
		
		//AdminDao Queries
		public static final String DELETE_COURSE_QUERY = "delete from course where courseId = ?";
		public static final String ADD_COURSE_QUERY = "insert into course(courseId, courseName, professorId, courseCredit) values (?, ?, ?, ?)";
		public static final String VIEW_COURSE_QUERY = "select courseId, courseName, professorId, courseCredit from course";
		public static final String ASSIGN_COURSE_QUERY = "update Course set professorId = ? where courseId = ?";
		public static final String VERIFY_CREDENTIALS="select password from user where userId = ?";
		
		//@bhajan Written for Prof.
		public static final String GET_COURSES="select * from course where professorId=?";
		public static final String GET_ENROLLED_STUDENTS="select course.courseId,course.courseName,registeredcourse.studentId from course inner join registeredcourse on course.courseId = registeredcourse.courseCode where course.professorId = ? order by course.courseId";
		public static final String ADD_GRADE="insert into registeredcourse(studentId, coursecode, gradeConstant) values (?, ?, ?)";//"update registeredcourse set GradeConstant=? where courseCode=? and studentId=?";
		public static final String GET_PROF_NAME = "select name from user where userId = ?";
		
		

		    public static final String NEW_REGISTER_STUDENT = "INSERT INTO student (studentid,studentname,studentbatch,address) VALUES (?,?,?,?)";
		    public static final String REGISTER_USER = "INSERT INTO user VALUES (?,?,?)";
		    public static final String UPDATE_PREFERENCE = "UPDATE student SET preference1 = ?, preference2 = ?, preference3 = ?, " +
		            "preference4 = ?, preference5 = ?, preference6 = ? WHERE studentid = ?";
		    public static final String SHOW_STUDENT = "SELECT * FROM student where studentid = ?";
		    public static final String SHOW_ADMIN = "SELECT * FROM admin WHERE adminid = ?";
		    public static final String SHOW_PROFESSOR = "SELECT * FROM professor WHERE professorId = ?";
		    public static final String ADD_TO_REGISTER = "INSERT INTO registeredcourse (courseCode,studentId) VALUES (?,?)";
		    public static final String INCREMENT_COURSE_STRENGTH ="UPDATE course SET coursestrength=coursestrength+1 WHERE courseCode =? ";
		    public static final String DECREMENT_COURSE_STRENGTH ="UPDATE course SET coursestrength=coursestrength-1 WHERE courseCode =? ";
		    public static final String DROP_FROM_REGISTER = "delete from registeredcourse where studentId = ? and courseCode = ?";
		    public static final String VIEW_ENROLLED_COURSES = "SELECT * FROM registeredcourse WHERE studentid = ?";
		    public static final String ADD_PAYMENT = "INSERT INTO paymentmode VALUES (?,?,?,?,now())";
		    public static final String GET_FEES_STATUS = "select feesPaymentStatus from student where studentid = ?";
		

	

}
