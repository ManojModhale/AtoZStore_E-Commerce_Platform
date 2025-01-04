package com.store.app.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table(name="vendors")



public class Vendor {
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
  private String companyname;
  private String companytype;
  @Embedded
	private Address address;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "vendor")
    @JsonManagedReference
  
    private List<Products> products;
public Vendor() {
	super();
	// TODO Auto-generated constructor stub
}

public Vendor(String username, String password, String firstname, String lastname, String gender, int age,
		String status, String email, long contactno, String companyname, String companytype, Address address,
		List<Products> products) {
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
	this.companyname = companyname;
	this.companytype = companytype;
	this.address = address;
	this.products = products;
}


public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
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



public List<Products> getProducts() {
	return products;
}
public void setProducts(List<Products> products) {
	this.products = products;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getCompanytype() {
	return companytype;
}
public void setCompanytype(String companytype) {
	this.companytype = companytype;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Vendor [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
			+ lastname + ", gender=" + gender + ", age=" + age + ", status=" + status + ", email=" + email
			+ ", contactno=" + contactno + ", companyname=" + companyname + ", companytype=" + companytype
			+ ", address=" + address + ", products=" + products + "]";
} 
  
}
