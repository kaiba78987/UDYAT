/**
 * 
 */
package org.udyat.model;


/** This class works as a administrator role setter.
 * @author Estrada Martínez, F.J.
 *
 */
public class AdministratorRoleSetter extends ContributorRoleSetter {

	/* (non-Javadoc)
	 * @see org.udyat.model.handlers.ContributorRoleSetter#setRole(org.udyat.model.User, org.udyat.model.Project)
	 */
	@Override
	public void setRole(User user, Project project) {
		super.setRole(user,  project);
		user.getManagedProjects().add(project);
		project.getAdministrators().add(user);
	}

}
