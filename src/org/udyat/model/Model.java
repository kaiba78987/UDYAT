package org.udyat.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Model.
 * This class represents an UML model's state.
 * @Author Estrada Martínez, F.J.
 */
@Entity
@Table(name="model")

public class Model implements Serializable {

	
	@EmbeddedId
	private ModelID id;
	@ManyToOne (optional=false)
	@JoinColumn(name="projectid")
	private Project owner;
	@Basic (fetch=FetchType.LAZY, optional=false)
	private String xmi;
	@Basic (optional=false)
	@Temporal (TemporalType.TIMESTAMP)
	private Date created;
	@Basic (optional=false)
	@Temporal (TemporalType.TIMESTAMP)
	private Date lastModified;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an empty model instance.
	 */
	public Model() {
		super();
		this.owner=null;
		this.id=null;
		this.xmi="";
		this.created=Calendar.getInstance().getTime();
		this.lastModified=Calendar.getInstance().getTime();
	}
	
	/** Constructs a model with the especified identifiers.
	 * @param owner The owner project.
	 * @param name The model's name.
	 */
	public Model(Project owner, String name) {
		super();
		this.owner = owner;
		this.id=new ModelID(owner.getId(), name);
		this.xmi="";
		this.created=Calendar.getInstance().getTime();
		this.lastModified=Calendar.getInstance().getTime();
	}

	/**
	 * @return the id
	 */
	public ModelID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ModelID id) {
		this.id = id;
	}

	/**
	 * @return the owner project
	 */
	public Project getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner project to set
	 */
	public void setOwner(Project owner) {
		this.owner = owner;
	}

	/**
	 * @return the xmi
	 */
	public String getXmi() {
		return xmi;
	}

	/**
	 * @param xmi the xmi to set
	 */
	public void setXmi(String xmi) {
		this.xmi = xmi;
	}

	/**
	 * @return the creation date
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the creation date to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the lastModified date.
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified date to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

		/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Model other = (Model) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Model [id=" + id.toString() + ", created=" + created + ", lastModified="
				+ lastModified + "]";
	}

}
