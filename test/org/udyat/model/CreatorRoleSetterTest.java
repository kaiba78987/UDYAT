/**
 * 
 */
package org.udyat.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** This is a test for CreatorRoleSetter class.
 * @author Estrada Mart�nez, F.J.
 *
 */
public class CreatorRoleSetterTest {

	private User user;
	private Project project;
	private String username, projectName;
	private Long projectID;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.username="Pablo";
		this.projectName="Allan Parson's project";
		this.projectID=(long) 5;
		this.user=new User();
		this.user.setName(this.username);
		this.project=new Project();
		this.project.setId(this.projectID);;
		this.project.setTitle(this.projectName);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.username=null;
		this.projectName=null;
		this.projectID=null;
		this.user=null;
		this.project=null;
	}

	@Test (expected=UserRoleException.class)
	public void testSetRole () throws UserRoleException {
		UserRoleSetter setter = new CreatorRoleSetter();
		setter.setRole(user, project);
	}
	
}
