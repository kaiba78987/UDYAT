/**
 * 
 */
package org.udyat.model;

/** This class allows to create a project and ensures that arguments are correct.
 * @author Estrada Martínez, F.J.
 *
 */
public class SafeProjectFactory implements ProjectFactory {

	private final String msg = "Name is empty or creator is null.";
	
	/* (non-Javadoc)
	 * @see org.udyat.model.ProjectFactory#createProject(java.lang.String, org.udyat.model.User)
	 */
	@Override
	public Project createProject(String name, User creator)
			throws IllegalArgumentException {
		if ((name.equals("")) | (name==null) | (creator==null)) throw new IllegalArgumentException (this.msg);
		Project project = new Project(name, creator);
		return project;
	}

}
