/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;

import com.flipkart.constants.NotificationTypeConstant;
import com.flipkart.dao.NotificationDaoInterface;
import com.flipkart.dao.NotificationDaoOperation;

/**
 * @author komal
 *
 */
public class NotificationService implements NotificationInterface {
	
	private static volatile NotificationService instance = null;
	
	/**
	 * Default Constructor
	 */
	private NotificationService() {
		
	}
	
	/**
	 * Method to make NotificationService Singleton
	 */
	public static NotificationService getInstance() {
		
		if(instance == null) {
			
			synchronized(NotificationService.class) {
				
				instance = new NotificationService();
			}
		}
		return instance;
	}
	
	NotificationDaoInterface notificationDaoOperation = NotificationDaoOperation.getInstance();

	@Override
	public int sendPaymentNotification(NotificationTypeConstant type, int studentId, int modeOfPayment, double amount, int referenceId) throws SQLException {
		
		return notificationDaoOperation.sendPaymentNotification(type, studentId, referenceId, amount, modeOfPayment);
	}
    
    @Override
	public int sendRegistrationNotification(NotificationTypeConstant type, int studentId) throws SQLException {

    	return notificationDaoOperation.sendRegistrationNotification(type, studentId);
    }

    @Override
	public int sendApprovalNotification(NotificationTypeConstant type, int studentId) throws SQLException {

    	return notificationDaoOperation.sendApprovalNotification(type, studentId);
    }
}
