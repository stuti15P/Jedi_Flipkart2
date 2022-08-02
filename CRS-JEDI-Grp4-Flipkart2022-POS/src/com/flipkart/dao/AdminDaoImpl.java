package com.flipkart.dao;
import com.flipkart.bean.User;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.utils.DBUtils;
import com.flipkart.bean.Professor;
//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDaoImpl implements AdminDaoInterface {
	Connection connection = DBUtils.getConnection();

	private PreparedStatement statement = null;

	public void addUser(User user) {
		try {
			String query = "insert into user(userid,role,name,password) values (?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getUserID());
			statement.setString(2, user.getRole());
			statement.setString(3, user.getName());
			statement.setString(4, user.getPassword());

			int row = statement.executeUpdate();
			System.out.println("User added at: " + row);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addProfessor(Professor professor) {
		this.addUser(professor);
		statement = null;
		try {
			String query = "insert into Professor(professorId,department,Designation) values (?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, professor.getUserID());
			statement.setString(2, professor.getDepartment());
			statement.setString(3, professor.getDesignation());
			int row = statement.executeUpdate();
			System.out.println("Professor Added at: " + row);
		} catch (SQLException se) {
			System.out.println("Add Professor Failed.");
		}

	}

	public void approveStudent(String userId) {
		String query = "update student set isApproved = 1 where studentid = ?";
		try {
			statement = connection.prepareStatement(query);

			statement.setString(1, userId);
			int row = statement.executeUpdate();
			System.out.println("Student with Students id: " + userId + " Approved");
		} catch (SQLException se) {
			System.out.println("Approve Student: Failed");
		}
	}

	public void viewPendingApprovals() {
		List<Student> pendingRequests = new ArrayList<>();
		try {
			statement = connection.prepareStatement("select student.studentId,user.name,student.branch from student join user on user.userId = student.studentid where student.isApproved = 0;");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Pending: StudentID: " + resultSet.getString(1) + "   Student Name: " + resultSet.getString(2) + " Student Branch: " + resultSet.getString(3));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void assignCourse(String courseId, String professorId) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Course> viewCourses() throws SQLException {
		statement = null;
		List<Course> courseList = new ArrayList<>();

		try {
			String sql = SQLQueriesConstant.VIEW_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Course course = new Course();
				course.setCourseId(resultSet.getString(1));
				course.setCourseName(resultSet.getString(2));
				course.setProfessorId(resultSet.getString(3));
				course.setCourseCredits(resultSet.getInt(4));
				courseList.add(course);

			}
		} catch (SQLException e) {
			System.out.println("Printing Exception Stack Trace!!");
			e.printStackTrace();
			System.out.println("Done!");
		}

		return courseList;
	}

	@Override
	public void addCourse(Course course) throws SQLException {
		statement = null;
		try {
			System.out.println("Debug 2: AdminDaoImpl, addCourse");
			String sql = SQLQueriesConstant.ADD_COURSE_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, course.getCourseId());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getProfessorId());
			statement.setInt(4, course.getCourseCredits());
			//statement.setInt(3, 1);
			int row = statement.executeUpdate();

			//System.out.println(row + " course added");
			if (row == 0) {
				System.out.println("Course with courseId: " + course.getCourseId() + "not added to catalog.");
				//throw new CourseFoundException(course.getCourseCode());
			}

			System.out.println("Course with courseId: " + course.getCourseId() + " is added to catalog.");

		} catch (SQLException e) {
			System.out.println("An error has occurred. AdminDaoImpl, addCourse");
			e.printStackTrace();
		}


	}

	@Override
	public void deleteCourse(String courseId) throws SQLException {
		statement = null;
		try {
			String sql = SQLQueriesConstant.DELETE_COURSE_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, courseId);
			int row = statement.executeUpdate();

			System.out.println(row + " entries deleted.");
			if (row == 0) {
				System.out.println(courseId + " not in catalog!");
				//throw new CourseNotFoundException(courseId);
			}

			System.out.println("Course with courseCode: " + courseId + " deleted.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void generateReportCard(){

	};
}