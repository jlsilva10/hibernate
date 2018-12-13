package com.scorp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
@NamedQuery(name="deleteAllPeople", query="delete from Person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private PhoneBook phonebook;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_project", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	Set<Project> projects = new HashSet<Project>();
	
	@Column(name = "NAME", length = 250, nullable = false)
	private String name;
	
	@Column(name = "GENDER", length = 1, columnDefinition="CHAR")
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String	 getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public PhoneBook getPhonebook() {
		return phonebook;
	}

	public void setPhonebook(PhoneBook phonebook) {
		this.phonebook = phonebook;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phonebook == null) ? 0 : phonebook.hashCode());
		result = prime * result + ((projects == null) ? 0 : projects.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phonebook == null) {
			if (other.phonebook != null)
				return false;
		} else if (!phonebook.equals(other.phonebook))
			return false;
		if (projects == null) {
			if (other.projects != null)
				return false;
		} else if (!projects.equals(other.projects))
			return false;
		return true;
	}

	
}
