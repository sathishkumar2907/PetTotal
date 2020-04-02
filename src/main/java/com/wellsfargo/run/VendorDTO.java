package com.wellsfargo.run;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vendor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VendorDTO {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "venorId")
	private Long venorId;
	
	@Column(name = "storeName")
	private String storeName;
	
	@Column(name = "storeContact")
	private String storeContact;
	
	@Column(name = "ownerName")
	private String ownerName;
	
	@Column(name = "ownerContact")
	private String ownerContact;
	
	@Column(name = "location")
	private String location;
	
	@OneToMany(mappedBy="vendorProduct")
	private List<ProductDTO> products = new ArrayList<>();


	public VendorDTO() {
		super();
	}

	public VendorDTO(Long venorId, String storeName, String storeContact, String ownerName, String ownerContact,
			String location) {
		super();
		this.venorId = venorId;
		this.storeName = storeName;
		this.storeContact = storeContact;
		this.ownerName = ownerName;
		this.ownerContact = ownerContact;
		this.location = location;
	}

	public Long getVenorId() {
		return venorId;
	}

	public void setVenorId(Long venorId) {
		this.venorId = venorId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreContact() {
		return storeContact;
	}

	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/*public List<ProductDTO> getProducts() {
		return products;
	}*/

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	/*@Override
	public String toString() {
		return "VendorDTO [venorId=" + venorId + ", storeName=" + storeName + ", storeContact=" + storeContact
				+ ", ownerName=" + ownerName + ", ownerContact=" + ownerContact + ", location=" + location
				+ ", products=" + products + "]";
	}*/

	
}
