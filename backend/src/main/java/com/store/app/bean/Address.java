package com.store.app.bean;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address 
{
	private String street;
	private String city;
	private String state;
	private String landMark;
	private String country;
	private String pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String street, String city, String state, String landMark, String country, String pincode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.landMark = landMark;
		this.country = country;
		this.pincode = pincode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", landMark=" + landMark
				+ ", country=" + country + ", pincode=" + pincode + "]";
	}
}
