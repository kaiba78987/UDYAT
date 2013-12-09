/**
 * 
 */
package org.udyat.model;

/** This interface defines method to create model versions instances.
 * @author Estrada Martínez, F.J.
 *
 */
public interface ModelVersionFactory {

	/**
	 * This method returns a new instance of a model version based on the previous version.
	 * @param previous The previous version.
	 * @param modifier The user who modified the model.
	 * @return A model version instance.
	 * @throws IllegalArgumentException If previous or modifier is null.
	 */
	public ModelVersion createVersion (ModelVersion previous, User modifier) throws IllegalArgumentException;
	
}
