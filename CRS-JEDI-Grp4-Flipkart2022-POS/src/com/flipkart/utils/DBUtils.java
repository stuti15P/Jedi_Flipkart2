package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;
public class DBUtils {

	/**
	 * @param args
	 */
	
	  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	  static final String DB_URL = "jdbc:mysql://localhost/crsdatabase";

	   //  Database credentials
	   static final String USER = "root";
<<<<<<< HEAD
	   static final String PASS = "Blue_178760";

=======
	   static final String PASS = "Saransh@123";


	public static Connection getConnection() {
		// TODO Auto-generated method stub
			// JDBC driver name and database URL
		// Step 2
		 Connection conn = null;
		 PreparedStatement stmt = null;

		 try{
			 	// Step 3 Regiater Driver here and create connectio
				Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection
				conn = DriverManager.getConnection(DB_URL,USER,PASS);


		 }
		 catch(SQLException se){
				  //Handle errors for JDBC
				  se.printStackTrace();
		}
		 catch(Exception e){
		  //Handle errors for Class.forName
		  e.printStackTrace();
		}
		return conn;

	}//end main
	}
>>>>>>> ba61d0fea56c8254f18d5e05686be4fd7020f1a1

	public static Connection getConnection() {
		// TODO Auto-generated method stub
			// JDBC driver name and database URL
		// Step 2
		 Connection conn = null;
		 PreparedStatement stmt = null;

		 try{
			 	// Step 3 Regiater Driver here and create connectio
				Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection
				conn = DriverManager.getConnection(DB_URL,USER,PASS);


		 }
		 catch(SQLException se){
				  //Handle errors for JDBC
				  se.printStackTrace();
		}
		 catch(Exception e){
		  //Handle errors for Class.forName
		  e.printStackTrace();
		}
		return conn;

	}//end main
	}