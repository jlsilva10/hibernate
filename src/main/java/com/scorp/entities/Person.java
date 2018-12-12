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

}
