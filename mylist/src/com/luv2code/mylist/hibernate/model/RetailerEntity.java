package com.luv2code.mylist.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="retailer")
public class RetailerEntity {
	
	public RetailerEntity() {
		
	}
	
	public RetailerEntity(String name, AddressEntity address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Embedded
	private AddressEntity address;

	@Column(name="phone_number")
	private String phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return name + ", " + address.getLine1() + ", " + address.getLine2() + ", " + address.getTown();
//		return "Retailer [name=" + name + 
//				", address.line1=" + address.getLine1() + 
//				", address.line2=" + address.getLine2() + 
//				", address.town=" + address.getTown() + 
//				", address.city=" + address.getCity() + 
//				", address.postalCode=" + address.getPostalCode() + 
//				", phoneNumber=" + phoneNumber + "]";
	}

}
