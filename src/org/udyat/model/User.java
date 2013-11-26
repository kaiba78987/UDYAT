package org.udyat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: User.
 * This class represents a system user.
 * @Author Estrada Martínez, F.J.
 */
@Entity
@Table(name="udyat_user")

public class User implements Serializable {

	   
	@Id
	private String name;
	@Basic (optional=false)
	private String email;
	@Basic (optional=false)
	private String password;
	@Basic (optional=false)
	@Temporal (TemporalType.TIMESTAMP)
	private Date registered;
	@Basic (optional=false)
	@Temporal (TemporalType.TIMESTAMP)
	private Date lastEntrance;
	@OneToMany (mappedBy = "creator", cascade = CascadeType.REMOVE)
	@OrderBy ("name asc")
	private List<Project> ownProjects;
	@ManyToMany (mappedBy="participants")
	@OrderBy ("name asc")
	private List<Project> participatedProjects;
	@ManyToMany (mappedBy="contributors")
	@OrderBy ("name asc")
	private List<Project> contributedProjects;
	@ManyToMany (mappedBy="administrators")
	@OrderBy ("name asc")
	private List<Project> managedProjects;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an empty user.
	 */
	public User() {
		super();
		this.name=null;
		this.email=null;
		this.password=null;
		this.registered=Calendar.getInstance().getTime();
		this.lastEntrance=Calendar.getInstance().getTime();
		this.ownProjects=new ArrayList<Project>();
		this.managedProjects=new ArrayList<Project>();
		this.contributedProjects=new ArrayList<Project>();
		this.participatedProjects=new ArrayList<Project>();
	}
	
	/** Creates an initialized user with the specified data.
	 * @param name The user's name.
	 * @param email The user's email.
	 * @param password The password.
	 */
	public User(String name, String password, String email) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.registered=Calendar.getInstance().getTime();
		this.lastEntrance=Calendar.getInstance().getTime();
		this.ownProjects=new ArrayList<Project>();
		this.managedProjects=new ArrayList<Project>();
		this.contributedProjects=new ArrayList<Project>();
		this.participatedProjects=new ArrayList<Project>();
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the registered
	 */
	public Date getRegistered() {
		return registered;
	}

	/**
	 * @param registered the registered to set
	 */
	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	/**
	 * @return the lastEntrance
	 */
	public Date getLastEntrance() {
		return lastEntrance;
	}

	/**
	 * @param lastEntrance the lastEntrance to set
	 */
	public void setLastEntrance(Date lastEntrance) {
		this.lastEntrance = lastEntrance;
	}

	/**
	 * @return the ownProjects
	 */
	public List<Project> getOwnProjects() {
		return ownProjects;
	}

	/**
	 * @param ownProjects the ownProjects to set
	 */
	public void setOwnProjects(List<Project> ownProjects) {
		this.ownProjects = ownProjects;
	}

	/**
	 * @return the participatedProjects
	 */
	public List<Project> getParticipatedProjects() {
		return participatedProjects;
	}

	/**
	 * @param participatedProjects the participatedProjects to set
	 */
	public void setParticipatedProjects(List<Project> participatedProjects) {
		this.participatedProjects = participatedProjects;
	}

	/**
	 * @return the contributedProjects
	 */
	public List<Project> getContributedProjects() {
		return contributedProjects;
	}

	/**
	 * @param contributedProjects the contributedProjects to set
	 */
	public void setContributedProjects(List<Project> contributedProjects) {
		this.contributedProjects = contributedProjects;
	}

	/**
	 * @return the managedProjects
	 */
	public List<Project> getManagedProjects() {
		return managedProjects;
	}

	/**
	 * @param managedProjects the managedProjects to set
	 */
	public void setManagedProjects(List<Project> managedProjects) {
		this.managedProjects = managedProjects;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password="
				+ password + ", registered=" + registered + ", lastEntrance="
				+ lastEntrance + "]";
	}
   
}
