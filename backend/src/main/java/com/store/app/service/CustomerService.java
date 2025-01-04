package com.store.app.service;


import java.util.List;
import com.store.app.bean.Address;
import com.store.app.bean.Customer;



public interface CustomerService 
{
	public Customer loginUser(String username, String password);
	
	public void registerUser(Customer user);
	
	public int getByEmail(String username, String email);
	
	public boolean changePassword(String username,String password);
	
	public Customer getUser(String username);
	
	public void updateUser(Customer user);

	public Customer getUserByUsername(String username);

	public void addAddress(String username, Address address);
	
	public List<Customer> getAllCustomers();
	
}
