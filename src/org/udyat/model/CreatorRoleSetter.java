/**
 * 
 */
package org.udyat.model;

/** This role setter is used to throw and exception to keep creator of project safe.
 * @author Estrada Martínez, F.J.
 *
 */
public class CreatorRoleSetter implements UserRoleSetter {

	private final String msg = "Creator cannot be changed";
	
	/* (non-Javadoc)
	 * @see org.udyat.model.UserRoleSetter#setRole(org.udyat.model.User, org.udyat.model.Project)
	 */
	@Override
	public void setRole(User user, Project project) throws UserRoleException {
		throw new UserRoleException(this.msg);
	}

}
