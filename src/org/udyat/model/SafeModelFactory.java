/**
 * 
 */
package org.udyat.model;

/** This class implements a safe way to create model instances.
 * @author Estrada Martínez, F.J.
 *
 */
public class SafeModelFactory implements ModelFactory {

	private final String msg = "Some argument is empty or null.";
	
	/* (non-Javadoc)
	 * @see org.udyat.model.ModelFactory#createModel(java.lang.String, org.udyat.model.Project)
	 */
	@Override
	public Model createModel(String name, Project owner)
			throws IllegalArgumentException {
		if ((name.equals("")) | (name==null) | (owner==null)) throw new IllegalArgumentException(msg);
		return new Model (owner, name);
	}

}
