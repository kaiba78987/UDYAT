/** 
 * 
 */
package org.udyat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** This class is used to identify model entities.
 * @author Estrada Martínez, F.J.
 *
 */
@Embeddable
public class ModelID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(insertable=false, updatable=false)
	private Long projectid;
	private String name;
	
	/**
	 * Constructs an empty model ID.
	 */
	public ModelID () {
		projectid=null;
		name=null;
	}
	
	/** Constructs a model ID using the especified identifiers.
	 * @param projectID The owner project's ID.
	 * @param name The model's name.
	 */
	public ModelID(long projectID, String name) {
		this.projectid = projectID;
		this.name = name;
	}
	
	/**
	 * @return the projectID
	 */
	public long getProjectid() {
		return projectid;
	}
	
	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectid(long projectid) {
		this.projectid = projectid;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((projectid == null) ? 0 : projectid.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelID other = (ModelID) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectid == null) {
			if (other.projectid != null)
				return false;
		} else if (!projectid.equals(other.projectid))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ModelID [projectid=" + projectid + ", name=" + name + "]";
	}
	
}
