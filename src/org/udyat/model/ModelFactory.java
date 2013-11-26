/**
 * 
 */
package org.udyat.model;

/** This interface defines a method to create model instances.
 * @author Estrada Martínez, F.J.
 *
 */
public interface ModelFactory {

	/**
	 * This method creates a new model instance.
	 * @param name The name of model.
	 * @param owner The owner project.
	 * @return A model.
	 * @throws IllegalArgumentException if name is empty or project is null.
	 */
	public Model createModel (String name, Project owner) throws IllegalArgumentException;
	
}
