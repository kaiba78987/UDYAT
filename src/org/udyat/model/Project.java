package org.udyat.model;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.udyat.model.User;

/**
 * Entity implementation class for Entity: Project.
 * This class represents a project.
 * @Author Estrada Martínez, F.J.
 */
@Entity
@Table(name="project")

public class Project implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	@Basic (optional=false)
	private String name;
	@Basic (optional=false)
	@Temporal (TemporalType.TIMESTAMP)
	private Date created;
	@ManyToOne (optional=false)
private User creator;
	@ManyToMany
	@JoinTable (name="managers")
	@OrderBy ("name asc")
	private List<User> administrators;
	@ManyToMany
	@JoinTable (name="participants")
	@OrderBy ("name asc")
	private List<User> participants;
	@ManyToMany
	@JoinTable (name="contributors")
	@OrderBy ("name asc")
	private List<User> contributors;
	@OneToMany (mappedBy="owner", cascade = CascadeType.REMOVE)
	@OrderBy ("name asc")
	private List<Model> models;
	@Basic (optional=false)
	private Boolean publicAccess;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an empty project.
	 */
	public Project() {
		super();
		this.name=null;
		this.created=Calendar.getInstance().getTime();
		this.creator=null;
		this.administrators=new ArrayList<User>();
		this.contributors=new ArrayList<User>();
		this.participants=new ArrayList<User>();
		this.publicAccess=false;
	}
	
	/** Constructs a new project using the especified identifier and creator.
	 * @param name The project's name.
	 * @param creator The creator user.
	 */
	public Project(String name, User creator) {
		super();
		this.name = name;
		this.created=Calendar.getInstance().getTime();
		this.creator=creator;
		this.administrators=new ArrayList<User>();
		this.administrators.add(creator);
		this.contributors=new ArrayList<User>();
		this.contributors.add(creator);
		this.participants=new ArrayList<User>();
		this.participants.add(creator);
		this.publicAccess=false;
	}

	/** Constructs a new project using the especified identifier, creator and access type.
	 * @param name The project's name.
	 * @param creator the creator user.
	 * @param publicAccess The access type.
	 */
	public Project(String name, User creator, Boolean publicAccess) {
		super();
		this.name = name;
		this.created=Calendar.getInstance().getTime();
		this.creator=creator;
		this.administrators=new ArrayList<User>();
		this.administrators.add(creator);
		this.contributors=new ArrayList<User>();
		this.contributors.add(creator);
		this.participants=new ArrayList<User>();
		this.participants.add(creator);
		this.publicAccess=publicAccess;
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

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}

	/**
	 * @return the administrators
	 */
	public List<User> getAdministrators() {
		return administrators;
	}

	/**
	 * @param administrators the administrators to set
	 */
	public void setAdministrators(List<User> administrators) {
		this.administrators = administrators;
	}

	/**
	 * @return the participants
	 */
	public List<User> getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	/**
	 * @return the contributors
	 */
	public List<User> getContributors() {
		return contributors;
	}

	/**
	 * @param contributors the contributors to set
	 */
	public void setContributors(List<User> contributors) {
		this.contributors = contributors;
	}

	/**
	 * @return the models
	 */
	public List<Model> getModels() {
		return models;
	}

	/**
	 * @param models the models to set
	 */
	public void setModels(List<Model> models) {
		this.models = models;
	}

	/**
	 * @return the publicAccess
	 */
	public Boolean getPublicAccess() {
		return publicAccess;
	}

	/**
	 * @param publicAccess the publicAccess to set
	 */
	public void setPublicAccess(Boolean publicAccess) {
		this.publicAccess = publicAccess;
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
		Project other = (Project) obj;
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
		return "Project [id=" + id + ", name=" + name + ", created=" + created
				+ "]";
	}
   
}
