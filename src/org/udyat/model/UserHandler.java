/**
 * 
 */
package org.udyat.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/** This class provides methods to manage users' relationships easily.
 * @author Estrada Martínez, F.J
 *
 */
public class UserHandler {

	private UserRoleSetter setter;
	private final String msgRole = "Creator role cannot be changed";
	private final String msgPersistence = "There is an entity not persisted yet";
	
	/**
	 * Constructs a new initialized handler.
	 * @Param setter The role setter.
	 */
	private UserHandler (UserRoleSetter setter) {
		this.setter=setter;
		}
	
	/**
	 * This method creates a new UserHandler initialized to set the especified role.
	 * @param role The role to set.
	 * @return An initialized UserHandler.
	 */
	public static UserHandler createHandler (UserRole role) {
		UserRoleSetter setter=null;
		if (role==UserRole.PARTICIPANT)setter=new ParticipantRoleSetter();
		else if (role==UserRole.CONTRIBUTOR) setter=new ContributorRoleSetter();
		else if (role==UserRole.ADMINISTRATOR)setter=new AdministratorRoleSetter();
		else if (role==UserRole.CREATOR) setter=new CreatorRoleSetter();
		return new UserHandler(setter);
	}
	
	/**
	 * This method sets the selected role to the user.
	 * @param user The user.
	 * @param project The project.
	 * @throws UserRoleException if the role setted is invalid for the user.
	 * @throws IllegalArgumentException if any entity is not persisted yet.
	 */
	public void setRole (User user, Project project) throws UserRoleException, IllegalArgumentException {
		// Creator cannot be role setted.
		if (user.equals(project.getCreator())) throw new UserRoleException (this.msgRole);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("UDYAT DB");
		EntityManager em=emf.createEntityManager(); 
		EntityTransaction transaction=em.getTransaction();
		
		// Check both entities are persisted.
		if (!((em.contains(user))) | (em.contains(project))) throw new IllegalArgumentException (msgPersistence);
		// Start the transaction.
		transaction.begin();try {
			setter.setRole(user,  project);
			transaction.commit();
		} catch (RollbackException | IllegalArgumentException ex) {
			transaction.rollback();
		}
	}
	
}
