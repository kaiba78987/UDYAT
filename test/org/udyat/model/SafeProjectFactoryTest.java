/**
 * 
 */
package org.udyat.model;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** This is a test for SafeProjctFactory class.
 * @author Estrada Martínez, F.J.
 *
 */
public class SafeProjectFactoryTest {

	private ProjectFactory factory;
	private User creator;
	private String username, email, projectName;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.username="Pablo";
		this.email="pablo@gmail.com";
		this.projectName="Allan Parson's project";
		this.creator = EasyMock.createMock(User.class);
		EasyMock.expect(this.creator.getName()).andReturn(this.username);
		EasyMock.expect(this.creator.getEmail()).andReturn(this.email);
		EasyMock.replay(this.creator);;
		this.factory = new SafeProjectFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.username=null;
		this.email=null;
		this.projectName=null;
		this.creator=null;
		this.factory=null;
	}

	@Test
	public void testCreateProject () {
		Project project = this.factory.createProject(this.projectName, this.creator);
		assertEquals(project.getTitle(), this.projectName);
		assertEquals(project.getCreator().getName(), this.username);
		assertEquals(project.getCreator().getEmail(), this.email);
	}
	
}
