/**
 * 
 */
package org.udyat.model;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** This is a test for ExcludeRoleSetter class.
 * @author Estrada Martínez, F.J.
 *
 */
public class ExcludeRoleSetterTest {

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
		UserRoleSetter setter=new AdministratorRoleSetter();
		setter.setRole(this.user, this.project);
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
		UserRoleSetter setter = new ExcludeRoleSetter();
		setter.setRole(user, project);
		assertFalse(user.getParticipatedProjects().contains(project));
		assertFalse(project.getParticipants().contains(user));
		assertFalse(user.getContributedProjects().contains(project));
		assertFalse(project.getContributors().contains(user));
		assertFalse(user.getManagedProjects().contains(project));
		assertFalse(project.getAdministrators().contains(user));
	}
	
	@Test (expected=NullPointerException.class)
	public void testSetRoleExceptions () throws UserRoleException {
		UserRoleSetter setter=new ExcludeRoleSetter();
		setter.setRole(user, null);
		setter.setRole(null, project);
	}

}
