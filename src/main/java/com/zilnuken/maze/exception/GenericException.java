/**
 * 
 */
package com.zilnuken.maze.exception;

/**
 * Generic Exception of Maze App.
 * 
 * @author edwardm
 *
 */
public class GenericException extends Exception {
	/**
	 * Serial UUID.
	 */
	private static final long serialVersionUID = -5418429885274363155L;

	/**
	 * Default Constructor.
	 * 
	 * @param message
	 *            Message to exception.
	 */
	public GenericException(String message) {
		super(message);
	}

}
