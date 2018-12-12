package com.scorp.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHONEBOOK")
@NamedQuery(name="deleteAllPhoneBook", query="delete from PhoneBook")
public class PhoneBook {

	@Id
	@Column(name = "person_id")
	private Long id;
	
	@OneToOne
	@MapsId
	private Person person;
	
	@OneToMany(mappedBy = "phonebook")
	private Set<Contact> contacts;

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	
}
