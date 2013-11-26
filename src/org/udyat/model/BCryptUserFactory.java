/**
 * 
 */
package org.udyat.model;

import org.udyat.crypto.BCrypt;

/** This class produces users by encrypting their passwords with BCrypt algorithm.
 * @author Estrada Martínez, F.J.
 *
 */
public class BCryptUserFactory implements UserFactory {

	// The number of rounds for the algorithm BCrypt.
	private final int rounds=12;
	
	/* (non-Javadoc)
	 * @see org.udyat.model.UserFactory#createUser(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public User createUser(String name, String password, String email)
			throws IllegalArgumentException {
		// All arguments must be filled.
		if ((name.equals("")) | (password.equals("")) | (email.equals("")) | (name==null) | (password==null) | (email==null)) throw new IllegalArgumentException ("One or more arguments are invalid.");
		// Hash the password and constructs the user.
		String hashpw = BCrypt.hashpw(password, BCrypt.gensalt(this.rounds));
		return new User (name, hashpw, email);
	}

}
