/**
 * 
 */
package org.udyat.model;

/** This exceptions is throwed as result of an attempt to change an user role.
 * @author Estrada Martínez, F.J.
 *
 */
public class UserRoleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UserRoleException() {
	}

	/**
	 * @param message
	 */
	public UserRoleException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UserRoleException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UserRoleException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UserRoleException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
