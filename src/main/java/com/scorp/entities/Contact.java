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
	
}