package com.scorp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Contact")
@NamedQuery(name="deleteAllContacts", query="delete from Contact")
public class Contact {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private PhoneBook phonebook;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
    private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATING_DATE")
    private Date updatingDate;
	
	@Column(name = "NAME",length = 250, nullable = false)
	private String name;
	
	@Column(name = "AGE", nullable = false)
	private Integer age;
	
	@Column(name = "PHONE_NUMBER", nullable = false)
	private Integer phoneNumber;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdatingDate() {
		return updatingDate;
	}

	public void setUpdatingDate(Date updatingDate) {
		this.updatingDate = updatingDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneBook getPhonebook() {
		return phonebook;
	}

	public void setPhonebook(PhoneBook phonebook) {
		this.phonebook = phonebook;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((phonebook == null) ? 0 : phonebook.hashCode());
		result = prime * result + ((updatingDate == null) ? 0 : updatingDate.hashCode());
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
		Contact other = (Contact) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
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
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (phonebook == null) {
			if (other.phonebook != null)
				return false;
		} else if (!phonebook.equals(other.phonebook))
			return false;
		if (updatingDate == null) {
			if (other.updatingDate != null)
				return false;
		} else if (!updatingDate.equals(other.updatingDate))
			return false;
		return true;
	}
	
	
	
}
