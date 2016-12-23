package com.untitled.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_details")
public class ContactDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	public String address = "cccc";

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
