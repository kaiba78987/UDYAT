package org.udyat.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ModelVersion
 * This class represents a version from a model.
 * @author Estrada Martínez, F.J.
 */
@Entity
@Table(name="model_version")

public class ModelVersion implements Serializable, Comparable<ModelVersion> {

	
	@EmbeddedId
	private ModelVersionID id;
	@ManyToOne
	@JoinColumn (name="modelid")
	private Model model;
	@Basic (optional=false, fetch=FetchType.LAZY)
	private String xmi;
	@OneToOne
	private User modifier;
	@Basic (optional=false)
	private Boolean conflictive;
	private static final long serialVersionUID = 1L;

	public ModelVersion() {
		super();
		this.id=null;
		this.model=null;
		this.xmi=null;
		this.modifier=null;
		this.conflictive=false;
	}

	/**
	 * Constructs an initialized model version.
	 * @param model The model owner.
	 * @param modifier The user who modified the model.
	 */
	public ModelVersion(Model model, User modifier) {
		super();
		this.id=new ModelVersionID(model.getId());
		this.model = model;
		this.xmi="";
		this.modifier = modifier;
		this.conflictive=false;
	}

	/**
	 * @return the id
	 */
	public ModelVersionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ModelVersionID id) {
		this.id = id;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
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
	 * @return the modifier
	 */
	public User getModifier() {
		return modifier;
	}

	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(User modifier) {
		this.modifier = modifier;
	}

	/**
	 * @return the conflictive
	 */
	public Boolean getConflictive() {
		return conflictive;
	}

	/**
	 * @param conflictive the conflictive to set
	 */
	public void setConflictive(Boolean conflictive) {
		this.conflictive = conflictive;
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
		ModelVersion other = (ModelVersion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ModelVersion other) {
		return this.id.compareTo(other.getId());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ModelVersion [id=" + id + "]";
	}
	   
}
