/**
 * 
 */
package org.udyat.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** This is a test for ContributorRoleSetter class.
 * @author Estrada Martínez, F.J.
 *
 */
public class ContributorRoleSetterTest {

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

	@Test
	public void testSetRole () throws UserRoleException {
		UserRoleSetter setter = new ContributorRoleSetter();
		setter.setRole(user, project);
		assertTrue(user.getParticipatedProjects().contains(project));
		assertTrue(project.getParticipants().contains(user));
		assertTrue(user.getContributedProjects().contains(project));
		assertTrue(project.getContributors().contains(user));
		assertFalse(user.getManagedProjects().contains(project));
		assertFalse(project.getAdministrators().contains(user));
	}
	
	@Test (expected=NullPointerException.class)
	public void testSetRoleExceptions () throws UserRoleException {
		UserRoleSetter setter=new ContributorRoleSetter();
		setter.setRole(user, null);
		setter.setRole(null, project);
	}

}
