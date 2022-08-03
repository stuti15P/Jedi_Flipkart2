/**
 * 
 */
package com.flipkart.exceptions;

/**
 * @author saransh
 *
 */
@SuppressWarnings("serial")
public class ProfessorNotAddedException extends Exception {

	private int professorId;

	/**
	 * @param professorId
	 */
	public ProfessorNotAddedException(int professorId) {
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
		return "Professer with Professor Id: " + professorId + " not added.";
	}
	
}
