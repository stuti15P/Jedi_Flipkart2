package com.flipkart.constant;

public class SQLQueriesConstant {
	//ProfessorDao queries
	
			public static final String UPDATE_PASSWORD="update user set password=? where userId = ? ";
			public static final String VERIFY_CREDENTIALS="select password from user where userId = ?";
			public static final String GET_ROLE="select role from user where userId = ?;";
			public static final String GET_COURSES="select * from course where professorId=?";
			public static final String GET_ENROLLED_STUDENTS="select course.courseId,course.courseName,registeredcourse.studentId from course inner join registeredcourse on course.courseId = registeredcourse.courseCode where course.professorId = ? order by course.courseId";
			public static final String ADD_GRADE="insert into registeredcourse(studentId, coursecode, gradeConstant) values (?, ?, ?)";//"update registeredcourse set GradeConstant=? where courseCode=? and studentId=?";
			public static final String GET_PROF_NAME = "select name from user where userId = ?";
}
