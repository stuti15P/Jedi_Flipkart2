/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

/**
 * @author stuti.priyambda
 *
 */
public interface UserDaoInterface {
	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userId
	 * @param password
	 * @return Verify credentials operation status
	 * @throws UserNotFoundException
	 */
	public boolean verifyCredentials(String userId, String password) throws UserNotFoundException; // throws UserNotFoundException;
	

}
