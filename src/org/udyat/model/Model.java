package org.udyat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Model.
 * This class represents an UML model's datas.
 * @Author Estrada Martínez, F.J.
 */
@Entity
@Table(name="model")

public class Model implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Basic (optional=false)
	private String title;
	@ManyToOne (optional=false)
	private Project owner;
	@OneToMany (mappedBy="model", cascade=CascadeType.REMOVE)
	@OrderBy ("id desc")
	private List<ModelVersion> versions;
	@Basic (optional=false)
	@Temporal (TemporalType.TIMESTAMP)
	private Date created;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an empty model instance.
	 */
	public Model() {
		super();
		this.owner=null;
		this.id=null;
		this.title=null;
		this.created=Calendar.getInstance().getTime();
		this.versions=new ArrayList<ModelVersion>();
	}
	
	/** Constructs a model with the especified identifiers.
	 * @param owner The owner project.
	 * @param title The  title of model.
	 */
	public Model(Project owner, String title) {
		super();
		this.owner = owner;
		this.id=null;
		this.title=title;
		this.created=Calendar.getInstance().getTime();
		this.versions=new ArrayList<ModelVersion> ();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the versions
	 */
	public List<ModelVersion> getVersions() {
		return versions;
	}

	/**
	 * @param versions the versions to set
	 */
	public void setVersions(List<ModelVersion> versions) {
		this.versions = versions;
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
		return "Model [id=" + id + ", title=" + title + ", owner=" + owner
				+ ", created=" + created + "]";
	}

}
