/**
 * 
 */
package com.flipkart.exceptions;

/**
 * @author komal
 *
 */
@SuppressWarnings("serial")
public class ProfessorIdAlreadyInUseException extends Exception {

	private int professorId;

	/**
	 * @param professorId
	 */
	public ProfessorIdAlreadyInUseException(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * Getter Method
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Professor Id: " + professorId + " is already in use.";
	}
}
