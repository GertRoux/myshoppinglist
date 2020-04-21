package com.luv2code.mylist.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressEntity {

	@Column(name="address_line_1")
	private String line1;
	
	@Column(name="address_line_2")
    private String line2;
	
	@Column(name="town")
    private String town;
	
	@Column(name="address_city")
    private String city;
	
	@Column(name="address_postal_code")
    private String postalCode;
		
	public AddressEntity() {
		
	}

	public AddressEntity(String line1, String line2, String town, String city, String postalCode) {
		this.line1 = line1;
		this.line2 = line2;
		this.town = town;
		this.city = city;
		this.postalCode = postalCode;
	}
	
	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddressString() {
		return toString();
	}

	@Override
	public String toString() {
		StringBuffer theAddress = new StringBuffer();
		theAddress.append(line1);
		if(line2 != null) {
			theAddress.append(", " + line2);
		}
		theAddress.append(", " + town);
		theAddress.append(", " + city);
		theAddress.append(", " + postalCode);
		
		return theAddress.toString();
	}
	
}
