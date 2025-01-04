package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.bean.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> 
{
	/*
	@Query("from Customer u where u.username= :username AND u.password = :password")
	public Customer findByUsernameAndPassword(@Param(value = "username") String username,@Param(value = "password") String password);
	*/
	
	public Customer findByUsernameAndPassword(String username, String password);
	
	public Customer findByUsernameAndEmail(String username,String email);
	
	public Customer findByUsername(String username);
	
}
