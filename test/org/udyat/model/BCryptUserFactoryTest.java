/**
 * 
 */
package org.udyat.model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.udyat.model.User;


/** This is a test for BCryptUserFactory class.
 * @author Estrada Martínez, F.J.
 *
 */
public class BCryptUserFactoryTest {

	private UserFactory factory;
	private String username, password, email;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.factory = new BCryptUserFactory();
		this.username="Pablo";
		this.password="patata";
		this.email="pablo@gmail.com";
			}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.factory=null;
		this.username=null;
		this.password=null;
		this.email=null;
	}

	@Test
	public void testCreateUser () {
		User user1=factory.createUser(username, password, email);
		User user2=new User (username, password, email);
		// System.out.println("User 1 password: "+user1.getPassword());
		// System.out.println("User 2 password: "+user2.getPassword());
		assertEquals(user1, user2);
		assertFalse(user1.getPassword().equals(user2.getPassword()));
	}

	@Test (expected=IllegalArgumentException.class)
	public void testCreateUserExceptions () {
		factory.createUser("",  password,  email);
		factory.createUser(username,  "",  email);
		factory.createUser(username, password, "");
		factory.createUser(username,  password, "pepe.com");
	}
	
}
