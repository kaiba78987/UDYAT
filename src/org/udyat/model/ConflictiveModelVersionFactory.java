/**
 * 
 */
package org.udyat.model;

/** This class provides method to create model versions from previous and mark as conflictive if they are.
 * @author Estrada Martínez, F.J.
 *
 */
public class ConflictiveModelVersionFactory implements ModelVersionFactory {

	/* (non-Javadoc)
	 * @see org.udyat.model.ModelVersionFactory#createVersion(org.udyat.model.ModelVersion, org.udyat.model.User)
	 */
	@Override
	public ModelVersion createVersion(ModelVersion previous, User modifier)
			throws IllegalArgumentException {
		if ((modifier==null) | (previous==null)) throw new IllegalArgumentException ("Arguments musn't be null.");
		ModelVersion version = new ModelVersion(previous.getModel(), modifier);
		if (version.getModel().getVersions().indexOf(previous)!=0) version.setConflictive(true);;
		return version;
	}

}
