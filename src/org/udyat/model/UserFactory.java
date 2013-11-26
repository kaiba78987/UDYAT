/**
 * 
 */
package org.udyat.model;

/** This interface defines the abstract methods for user factoriess.
 * @author Estrada Martínez, F.J.
 *
 */
public interface UserFactory {

	/**
	 * Creates a new initialized user. Its password is encrypted by the especific factory.
	 * @param name The user name.
	 * @param password The password.
	 * @param email The e-mail address.
	 * @return The user object.
	 * @throws IllegalArgumentException If any field is invalid.
	 */
	public User createUser (String name, String password, String email) throws IllegalArgumentException;
	
}
