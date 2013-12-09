/**
 * 
 */
package org.udyat.model;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** This is a test for SafeModelFactory class
 * @author Estrada Martínez, F.J.
 *
 */
public class SafeModelFactoryTest {

	private Project project;
	private String projectName, modelName;
	private Long projectID;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.projectName="Allan Parson's project";
		this.projectID=(long) 154;
		this.modelName="Top model";
		this.project = EasyMock.createMock(Project.class);
		EasyMock.expect(this.project.getId()).andReturn(this.projectID);
		EasyMock.expect(this.project.getTitle()).andReturn(this.projectName);
		EasyMock.replay(this.project);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.projectName=null;
		this.projectID=null;
		this.modelName=null;
		this.project=null;
	}

	
	@Test
	public void testCreateModel () {
		Model model = new SafeModelFactory().createModel(this.modelName,  this.project);
		assertEquals((long) this.projectID, (long) model.getOwner().getId());
		assertEquals(this.modelName, model.getTitle());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testCreateModelExceptions () {
		SafeModelFactory factory = new SafeModelFactory();
		factory.createModel("",  this.project);
		factory.createModel(null,  this.project);
		factory.createModel(modelName,  null);
	}
	
}
