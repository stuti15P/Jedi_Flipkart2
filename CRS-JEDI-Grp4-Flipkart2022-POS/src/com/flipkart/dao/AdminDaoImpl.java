package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.SqlQueriesConstant.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDaoInterface{
	
	private PreparedStatement statement = null;
	Connection connection = DBUtils.getConnection();
	
	@Override
	public void assignCourse(String courseId, String professorId) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> viewCourses() throws SQLException{
		statement = null;
		List<Course> courseList = new ArrayList<>();
	
		try {	
			String sql = SQLQueriesConstants.VIEW_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {

				Course course = new Course();
				course.setCourseId(resultSet.getString(1));
				course.setCourseName(resultSet.getString(2));
				course.setProfessorId(resultSet.getString(3));
				course.setCourseCredits(resultSet.getInt(4));
				courseList.add(course);

			}
		}catch (SQLException e) {
			System.out.println("Printing Exception Stack Trace!!");
	         e.printStackTrace();
	         System.out.println("Done!");
	      }
		
		return courseList; 
	}

	@Override
	public void addCourse(Course course) throws SQLException{
		statement = null;
		try {
			System.out.println("Debug 2: AdminDaoImpl, addCourse");
			String sql = SQLQueriesConstants.ADD_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, course.getCourseId());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getProfessorId());
			statement.setInt(4, course.getCourseCredits());
			//statement.setInt(3, 1);
			int row = statement.executeUpdate();
			
			//System.out.println(row + " course added");
			if(row == 0) {
				System.out.println("Course with courseId: " + course.getCourseId() + "not added to catalog.");
				//throw new CourseFoundException(course.getCourseCode());
			}
			
			System.out.println("Course with courseId: " + course.getCourseId() + " is added to catalog."); 
			
		}catch (SQLException e) {
			System.out.println("An error has occurred. AdminDaoImpl, addCourse");
	         e.printStackTrace();
	      }
		
		
	}
	
	
	
	@Override
	public void deleteCourse(String courseId) throws SQLException{
		statement = null;
		try {
			String sql = SQLQueriesConstants.DELETE_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,courseId);
			int row = statement.executeUpdate();
			
			System.out.println(row + " entries deleted.");
			if(row == 0) {
				System.out.println(courseId + " not in catalog!");
				//throw new CourseNotFoundException(courseId);
			}

			System.out.println("Course with courseCode: " + courseId + " deleted.");
			
		}catch (SQLException e) {
	         e.printStackTrace();
	      }
//catch(SQLException se) {
//			
//			logger.error(se.getMessage());
//			throw new CourseNotDeletedException(courseCode);
//		}
	}

	
	
	

	@Override
	public List<Student> viewPendingAdmissions() throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void approveStudent(int studentId) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor(Professor professor) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(User user) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Professor> viewProfessors() throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

}


