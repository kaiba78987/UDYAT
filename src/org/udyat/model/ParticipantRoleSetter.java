/**
 * 
 */
package org.udyat.model;


/** This class works as participant setter.
 * @author Estrada Martínez, F.J.
 *
 */
public class ParticipantRoleSetter extends AbstractRoleSetter {

	/* (non-Javadoc)
	 * @see org.udyat.model.handlers.AbstractRoleSetter#setRole(org.udyat.model.User, org.udyat.model.Project)
	 */
	@Override
	public void setRole(User user, Project project) {
		super.setRole(user,  project);
		user.getParticipatedProjects().add(project);
		project.getParticipants().add(user);
	}

}
