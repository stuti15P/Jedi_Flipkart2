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
		
	

	

}
