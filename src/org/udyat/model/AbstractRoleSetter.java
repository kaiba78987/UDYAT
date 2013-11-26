/**
 * 
 */
package org.udyat.model;


/** This is an abstract role setter that implements basic operations for all setters.
 * @author Estrada Martínez, F.J.
 *
 */
public abstract class AbstractRoleSetter implements UserRoleSetter {

	/* (non-Javadoc)
	 * @see org.udyat.model.handlers.UserRoleSetter#setRole(org.udyat.model.User, org.udyat.model.Project)
	 */
	@Override
	public void setRole(User user, Project project) {
		// To remove all roles setted previously.
			user.getManagedProjects().remove(project);
			user.getContributedProjects().remove(project);
			user.getParticipatedProjects().remove(project);
			project.getAdministrators().remove(user);
			project.getContributors().remove(user);
			project.getParticipants().remove(user);
	}

}
