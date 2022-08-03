/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.constants.NotificationTypeConstant;
import com.flipkart.constants.PaymentModeConstant;
import com.flipkart.constants.SQLQueriesConstant;
import com.flipkart.utils.DBUtils;
import com.flipkart.utils.Utils;
import org.apache.log4j.Logger;

/**
 * @author saranash
 *
 */
public class NotificationDaoOperation implements NotificationDaoInterface {

	private static volatile NotificationDaoOperation instance = null;
	private static Logger logger = Logger.getLogger(NotificationDaoOperation.class);
	Connection connection = DBUtils.getConnection();
	private PreparedStatement statement = null;
	
	/**
	 * Default Constructor
	 */
	private NotificationDaoOperation()
	{

	}
	
	/**
	 * Method to make NotificationDaoOperation Singleton
	 * @return
	 */
	public static NotificationDaoOperation getInstance() {
		
		if(instance == null) {
			
			synchronized(NotificationDaoOperation.class) {
				
				instance = new NotificationDaoOperation();
			}
		}
		return instance;
	}
	
	/**
	 * 
	 * @param type
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 * @return
	 */
	@Override
	public int sendPaymentNotification(NotificationTypeConstant type, int studentId, int referenceId, double amount, int modeOfPayment) throws SQLException {
		Connection connection = DBUtils.getConnection();
		statement = null;
		int notificationId = Utils.generateId();
		
		try {
			String sql = SQLQueriesConstant.ADD_NOTIFICATION;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, notificationId);
 			statement.setInt(2, studentId);
 			statement.setString(3, type.toString());
 			statement.setInt(4, referenceId);
 			statement.setString(5, "Payment is successful of Amount - Rs. " + amount + " through " + PaymentModeConstant.getPaymentMode(modeOfPayment).toString() + ".");
 		    statement.executeUpdate();
 		    logger.info("Payment is successful of Amount - Rs. " + amount + " through " + PaymentModeConstant.getPaymentMode(modeOfPayment).toString() + ".");
		} catch (SQLException e) {
			logger.error("Error: " + e.getMessage());
		} finally {
 			statement.close();
 			connection.close();
 		}
		
		return notificationId;
	}
	
	/**
	 * 
	 * @param type
	 * @param studentId
	 * @return
	 */
	@Override
	public int sendRegistrationNotification(NotificationTypeConstant type, int studentId) throws SQLException {
		Connection connection = DBUtils.getConnection();
		statement = null;
		int notificationId = Utils.generateId();
		
		try {
			String sql = SQLQueriesConstant.ADD_NOTIFICATION;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, notificationId);
 			statement.setInt(2, studentId);
 			statement.setString(3, type.toString());
 			statement.setInt(4, 0);
 			statement.setString(5, "Registration is successful for Student Id: " + studentId);
 		    statement.executeUpdate();
 		    logger.info("Registration is successful for Student Id: " + studentId);
		} catch (SQLException e) {
			logger.error("Error: " + e.getMessage());
		} finally {
 			statement.close();
 			connection.close();
 		}
		
		return notificationId;
	}
	
	/**
	 * 
	 * @param type
	 * @param studentId
	 * @return
	 */
	@Override
	public int sendApprovalNotification(NotificationTypeConstant type, int studentId) throws SQLException {
		Connection connection = DBUtils.getConnection();
		statement = null;
		int notificationId = Utils.generateId();
		
		try {
			String sql = SQLQueriesConstant.ADD_NOTIFICATION;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, notificationId);
 			statement.setInt(2, studentId);
 			statement.setString(3, type.toString());
 			statement.setInt(4, 0);
 			statement.setString(5, "Student with Student Id: " + studentId + " is approved successfully.");
 		    statement.executeUpdate();
 		    logger.info("Student with Student Id: " + studentId + " is approved successfully.");
		} catch (SQLException e) {
			logger.error("Error: " + e.getMessage());
		} finally {
 			statement.close();
 			connection.close();
 		}
		
		return notificationId;
	}
	
}
