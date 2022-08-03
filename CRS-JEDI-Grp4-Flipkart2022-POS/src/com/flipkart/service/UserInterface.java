package com.flipkart.service;

import com.flipkart.exceptions.ConfirmPasswordException;
import com.flipkart.exceptions.OldPasswordNotValidException;
import com.flipkart.exceptions.UserNotFoundException;

public interface UserInterface {

	/**
	 * @param userId
	 * @return
	 */
	String getRoleOfUser(String userEmailId);

	/**
	 * @param emailId
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 */
	boolean validateUser(String emailId, String password) throws UserNotFoundException;

	/**
	 * 
	 * @param userEmailId
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmNewPassword
	 * @throws UserNotFoundException 
	 */
	void updatePassword(String userEmailId, String oldPassword, String newPassword, String confirmNewPassword) throws UserNotFoundException, OldPasswordNotValidException, ConfirmPasswordException;
 

	/**
	 * 
	 * @param userEmailId
	 * @return
	 */
	int getUserId(String userEmailId);

}