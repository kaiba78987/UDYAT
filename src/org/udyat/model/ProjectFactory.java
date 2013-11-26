/**
 * 
 */
package org.udyat.model;

/** this interface defines a method to create project instances.
 * @author Estrada Martínez, F.J.
 *
 */
public interface ProjectFactory {

	/**
	 * This method returns a project instance.
	 * @param name The project name.
	 * @param creator The user who created it.
	 * @return The project.
	 * @throws IllegalArgumentException If name is empty or user is null.
	 */
	public Project createProject (String name, User creator) throws IllegalArgumentException;
	
}
