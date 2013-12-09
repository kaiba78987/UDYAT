/** 
 * 
 */
package org.udyat.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** This class is used to identify model versions.
 * @author Estrada Martínez, F.J.
 *
 */
@Embeddable
public class ModelVersionID implements Serializable, Comparable<ModelVersionID> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(insertable=false, updatable=false)
	private Long modelid;
	@Temporal (TemporalType.TIMESTAMP)
	private Date version;
	
	/**
	 * Constructs an empty model version ID.
	 */
	public ModelVersionID () {
		modelid=null;
		version=null;
	}
	
	/** Constructs a model version ID using the especified identifiers.
	 * @param projectID The owner project ID.
	 */
	public ModelVersionID(long modelid) {
		this.modelid = modelid;
		this.version = Calendar.getInstance().getTime();
	}
	
	/**
	 * @return the modelID
	 */
	public long getModelid() {
		return modelid;
	}
	
	/**
	 * @param modelid the modelID to set
	 */
	public void setModelid(long modelid) {
		this.modelid = modelid;
	}

	/**
	 * @return the version
	 */
	public Date getVersion() {
		return version;
	}

	/**
	 * @param version the version date to set
	 */
	public void setVersion(Date version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelid == null) ? 0 : modelid.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		ModelVersionID other = (ModelVersionID) obj;
		if (modelid == null) {
			if (other.modelid != null)
				return false;
		} else if (!modelid.equals(other.modelid))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ModelVersionID other) {
		if (this.modelid.equals(other.getModelid())) return this.version.compareTo(other.getVersion());
		else return this.modelid.compareTo(other.getModelid());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ModelVersionID [modelid=" + modelid + ", version=" + version
				+ "]";
	}

}
