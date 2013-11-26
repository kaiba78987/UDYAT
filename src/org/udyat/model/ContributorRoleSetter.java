/**
 * 
 */
package org.udyat.model;


/** This class works as a contributor role setter.
 * @author Estrada Martínez, F.J.
 *
 */
public class ContributorRoleSetter extends ParticipantRoleSetter {

	/* (non-Javadoc)
	 * @see org.udyat.model.handlers.ParticipantRoleSetter#setRole(org.udyat.model.User, org.udyat.model.Project)
	 */
	@Override
	public void setRole(User user, Project project) {
		super.setRole(user,  project);
		user.getContributedProjects().add(project);
		project.getContributors().add(user);
	}

}
