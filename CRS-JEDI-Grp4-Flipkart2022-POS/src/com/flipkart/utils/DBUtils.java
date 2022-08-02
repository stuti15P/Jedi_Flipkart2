package com.flipkart.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.constant.SQLQueriesConstant;
//import com.flipkart.utils.DBUtils;

public class DBUtils {

	/**
	 * @param args
	 */
	
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  static final String DB_URL = "jdbc:mysql://localhost/CRSDataBase";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "Blue_178769";
	   
	   private static Connection connection = null;
		
		public static Connection getConnection() {
		// TODO Auto-generated method stub
				   
				   try{
					   
					   Class.forName("com.mysql.jdbc.Driver");

					   // Step 4 make/open  a connection 
					   
					      System.out.println("Connecting to database...");
					      connection = DriverManager.getConnection(DB_URL,USER,PASS);
					   
					   }catch(SQLException se){
					      se.printStackTrace();
					   }catch(Exception e){
					      //Handle errors for Class.forName
					      e.printStackTrace();
//					   }finally{
//					      //finally block used to close resources
//					      try{
//					         if(stmt!=null)
//					            stmt.close();
//					      }catch(SQLException se2){
//					      }// nothing we can do
//					      try{
//					         if(connection!=null)
//					            connection.close();
//					      }catch(SQLException se){
//					         se.printStackTrace();
//					      }//end finally try
					   }//end try
					   //System.out.println("Goodbye!");
					   return connection;
					}

	}

