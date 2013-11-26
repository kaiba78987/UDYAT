/**
 * 
 */
package org.udyat.model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** This is a test for UserHandler class.
 * @author Estrada Martínez, F.J.
 *
 */
public class UserHandlerTest {

	private User user;
	private Project project;
	private UserFactory factory;
	private String username, password, email, projectName;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.factory = new BCryptUserFactory();
		this.username="Pablo";
		this.password="patata";
		this.email="pablo@gmail.com";
		this.projectName="Allan parson's project";
		this.user = factory.createUser(username,  password,  email);
		this.project=new Project (this.projectName, null);
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
		this.user=null;
		this.project=null;
	}

	@Test
	public void testSetParticipantRole () throws UserRoleException {
		UserHandler handler=UserHandler.createHandler(UserRole.PARTICIPANT);
				handler.setRole(this.user, this.project);
				assertTrue(this.user.getParticipatedProjects().contains(this.project));
				assertTrue(this.project.getParticipants().contains(this.user));
				assertFalse(this.user.getContributedProjects().contains(this.project));
				assertFalse(this.project.getContributors().contains(this.user));
				assertFalse(this.user.getManagedProjects().contains(this.project));
				assertFalse(this.project.getAdministrators().contains(this.user));
				assertFalse(this.user.getOwnProjects().contains(this.project));
				assertFalse(this.project.getCreator()==this.user);
	}
	
	@Test
	public void testSetContributorRole () throws UserRoleException {
		UserHandler handler=UserHandler.createHandler(UserRole.CONTRIBUTOR);
				handler.setRole(this.user, this.project);
				assertTrue(this.user.getParticipatedProjects().contains(this.project));
				assertTrue(this.project.getParticipants().contains(this.user));
				assertTrue(this.user.getContributedProjects().contains(this.project));
				assertTrue(this.project.getContributors().contains(this.user));
				assertFalse(this.user.getManagedProjects().contains(this.project));
				assertFalse(this.project.getAdministrators().contains(this.user));
				assertFalse(this.user.getOwnProjects().contains(this.project));
				assertFalse(this.project.getCreator()==this.user);
	}
	
	@Test
	public void testSetAdministratorRole () throws UserRoleException {
		UserHandler handler=UserHandler.createHandler(UserRole.ADMINISTRATOR);
				handler.setRole(this.user, this.project);
				assertTrue(this.user.getParticipatedProjects().contains(this.project));
				assertTrue(this.project.getParticipants().contains(this.user));
				assertTrue(this.user.getContributedProjects().contains(this.project));
				assertTrue(this.project.getContributors().contains(this.user));
				assertTrue(this.user.getManagedProjects().contains(this.project));
				assertTrue(this.project.getAdministrators().contains(this.user));
				assertFalse(this.user.getOwnProjects().contains(this.project));
				assertFalse(this.project.getCreator()==this.user);
	}
	
	@Test (expected=UserRoleException.class)
	public void testSetCreatorRole () throws UserRoleException {
		UserHandler handler=UserHandler.createHandler(UserRole.CREATOR);
				handler.setRole(this.user, this.project);
					}
	
	@Test (expected=UserRoleException.class)
	public void testCreatorBlocked () throws UserRoleException {
		this.project.setCreator(this.user);
		UserHandler handler = UserHandler.createHandler(UserRole.PARTICIPANT);
		handler.setRole(this.user,  this.project);;
	}
	
}
