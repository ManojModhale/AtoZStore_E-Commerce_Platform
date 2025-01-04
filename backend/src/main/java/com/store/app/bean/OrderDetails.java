package com.store.app.bean;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="OrderDetails")
public class OrderDetails 
{
	@Id
	private String orderid;
	private boolean availability;
	private String payment_id;
	private String payment_signature;
	private double amount;
	
	private String username;
	private String firstname;
	private String lastname;
	private String gender;
	private String email;
	private long contactno;
	
	private String date;
	private String time;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "orderDetails", cascade = CascadeType.ALL,fetch=FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
	private List<OrderedProduct> productsList;
	
	
	
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(String orderid, boolean availability, String payment_id, String payment_signature,
			double amount, String username, String firstname, String lastname, String gender, String email,
			long contactno, String date, String time, Address address, List<OrderedProduct> productsList) {
		super();
		this.orderid = orderid;
		this.availability = availability;
		this.payment_id = payment_id;
		this.payment_signature = payment_signature;
		this.amount = amount;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.email = email;
		this.contactno = contactno;
		this.date = date;
		this.time = time;
		this.address = address;
		this.productsList = productsList;
	}

	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public List<OrderedProduct> getProductsList() {
		return productsList;
	}
	public void setProductsList(List<OrderedProduct> productsList) {
		this.productsList = productsList;
	}
	public String getPayment_signature() {
		return payment_signature;
	}

	public void setPayment_signature(String payment_signature) {
		this.payment_signature = payment_signature;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderid=" + orderid + ", availability=" + availability + ", payment_id=" + payment_id
				+ ", payment_signature=" + payment_signature + ",\n amount=" + amount + ", username=" + username
				+ ", firstname=" + firstname + ", lastname=" + lastname + ",\n gender=" + gender + ", email=" + email
				+ ", contactno=" + contactno + ", date=" + date + ", time=" + time + ",\n address=" + address
				+ ",\n productsList=" + productsList + "]";
	}

}
