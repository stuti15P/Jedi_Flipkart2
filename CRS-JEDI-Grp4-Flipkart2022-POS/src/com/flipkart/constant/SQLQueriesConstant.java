package com.flipkart.constant;

public class SQLQueriesConstant {
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
