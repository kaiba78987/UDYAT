/**
 * 
 */
package org.udyat.model;


/** This interface is used as part of strategy patern for add users to projects.
 * @author Estrada Martínez, F.J.
 *
 */
public interface UserRoleSetter {

	/**
	 * This method allows to add users to a project by an easy way.
	 * @param user The user to add.
	 * @param project The project to add to.
	 * @Throw UserRoleException if the role setted is invalid.
	 */
	public void setRole (User user, Project project) throws UserRoleException;
	
}
