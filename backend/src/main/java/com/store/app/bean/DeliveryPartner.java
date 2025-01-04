package com.store.app.bean;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity

public class DeliveryPartner {
	@Id
	private String username;
	private String password;

	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private String status;

	private String email;
	private long contactno;
  private String vehicleType;
  private String vehicleRegNumber;
  @Embedded
	private Address shippingAddress;
public DeliveryPartner() {
	super();
	// TODO Auto-generated constructor stub
}

public DeliveryPartner(String username, String password, String firstname, String lastname, String gender, int age,
		String status, String email, long contactno, String vehicleType, String vehicleRegNumber,
		Address shippingAddress) {
	super();
	this.username = username;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	this.gender = gender;
	this.age = age;
	this.status = status;
	this.email = email;
	this.contactno = contactno;
	this.vehicleType = vehicleType;
	this.vehicleRegNumber = vehicleRegNumber;
	this.shippingAddress = shippingAddress;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getContactno() {
	return contactno;
}
public void setContactno(long contactno) {
	this.contactno = contactno;
}
public String getVehicleType() {
	return vehicleType;
}
public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}

public String getVehicleRegNumber() {
	return vehicleRegNumber;
}
public void setVehicleRegNumber(String vehicleRegNumber) {
	this.vehicleRegNumber = vehicleRegNumber;
}
public Address getShippingAddress() {
	return shippingAddress;
}
public void setShippingAddress(Address shippingAddress) {
	this.shippingAddress = shippingAddress;
}
public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "DeliveryPartner [username=" + username + ", password=" + password + ", firstname=" + firstname
			+ ", lastname=" + lastname + ", gender=" + gender + ", age=" + age + ", status=" + status + ", email="
			+ email + ", contactno=" + contactno + ", vehicleType=" + vehicleType + ", vehicleRegNumber="
			+ vehicleRegNumber + ", shippingAddress=" + shippingAddress + "]";
}


  
}
