package com.wellsfargo.run;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contactus")
public class ContactusDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contactsid")
	private Long contactsid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contactNumber")
	private String contactNumber;

	@Column(name = "contactEmail")
	private String contactEmail;

	@Column(name = "contactMessage")
	private String contactMessage;

	public ContactusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactusDTO(Long contactsid, String name, String contactNumber, String contactEmail,
			String contactMessage) {
		super();
		this.contactsid = contactsid;
		this.name = name;
		this.contactNumber = contactNumber;
		this.contactEmail = contactEmail;
		this.contactMessage = contactMessage;
	}

	public Long getContactsid() {
		return contactsid;
	}

	public void setContactsid(Long contactsid) {
		this.contactsid = contactsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactMessage() {
		return contactMessage;
	}

	public void setContactMessage(String contactMessage) {
		this.contactMessage = contactMessage;
	}

	@Override
	public String toString() {
		return "ContactusDTO [contactsid=" + contactsid + ", name=" + name + ", contactNumber=" + contactNumber
				+ ", contactEmail=" + contactEmail + ", contactMessage=" + contactMessage + "]";
	}

	
}
