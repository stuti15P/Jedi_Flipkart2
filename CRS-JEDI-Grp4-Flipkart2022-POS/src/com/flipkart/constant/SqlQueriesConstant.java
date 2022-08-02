/**
 * 
 */
package com.flipkart.constant;

/**
 * @author stuti.priyambda
 *
 */
public class SqlQueriesConstant {
	
	public class SQLQueriesConstants {
		
		//AdminDao Queries
		public static final String DELETE_COURSE_QUERY = "delete from course where courseId = ?";
		public static final String ADD_COURSE_QUERY = "insert into course(courseId, courseName, professorId, courseCredit) values (?, ?, ?, ?)";
		public static final String VIEW_COURSE_QUERY = "select courseId, courseName, professorId, courseCredit from course";
		public static final String ASSIGN_COURSE_QUERY = "update Course set professorId = ? where courseId = ?";
		public static final String VERIFY_CREDENTIALS="select password from user where userId = ?";
	}

}
