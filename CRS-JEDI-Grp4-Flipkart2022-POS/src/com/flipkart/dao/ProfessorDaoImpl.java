package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBUtils;

/**
 * @author Bhajan 
 */
public class ProfessorDaoImpl implements ProfessorDaoInterface {

	private static volatile ProfessorDaoImpl instance=null;
	private ProfessorDaoImpl()
	{
		
	}
	
	public static ProfessorDaoImpl getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(ProfessorDaoImpl.class){
				instance=new ProfessorDaoImpl();
			}
		}
		return instance;
	}
	@Override
	public List<Course> getCoursesByProfessor(String profId) {
		Connection connection=DBUtils.getConnection();
		List<Course> courseList=new ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_COURSES);
			
			statement.setString(1, profId);
			//System.out.println("ErrorBeforeExe!!!");
			ResultSet results=statement.executeQuery();// 
			//System.out.println("ErrorAfterExe!!!");
			while(results.next())
			{
				courseList.add(new Course(results.getString("courseId"),results.getString("courseName"),results.getString("professorId"),results.getInt("courseCredits")));
			}
		}
		catch(SQLException e)
		{
			//logger.error(e.getMessage());
			System.out.println(e.getMessage());
			
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseList;
		
	}

	@Override
	public List<EnrolledStudent> getEnrolledStudents(String userId) {
		Connection connection=DBUtils.getConnection();
		List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_ENROLLED_STUDENTS);
			statement.setString(1, userId);
			
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				//public EnrolledStudent(String courseCode, String courseName, int studentId) 
				//System.out.println("EnrolledStudent");
				//System.out.print(.getCourseId()+" ");
				//enrolledStudents.add(new EnrolledStudent());
				enrolledStudents.add(new EnrolledStudent(results.getString("courseId"),results.getString("courseName"),results.getString("studentId")));
				
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return enrolledStudents;
	}
	
	public Boolean addGrade(String studentId,String courseCode,int grade) {
		//Connection connection=DBUtils.getConnection();
		DBUtils connectionSetup = new DBUtils();
	    Connection connection = connectionSetup.getConnection();
		try {
			//System.out.println("Inside try!!!");
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.ADD_GRADE);
			statement.setString(1, studentId);
			statement.setString(2, courseCode);
			statement.setInt(3, grade);
			//System.out.println("Before execute St!!!");
			int row = statement.executeUpdate();
			//System.out.println("After!!!");
			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	public String getProfessorById(String profId)
	{
		String prof_Name = null;
		Connection connection=DBUtils.getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_PROF_NAME);
			
			statement.setString(1, profId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			prof_Name = rs.getString(1);
			
		}
		catch(SQLException e)
		{
			System.out.println("Error4!!!");
		}
		finally
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return prof_Name;
	}
}