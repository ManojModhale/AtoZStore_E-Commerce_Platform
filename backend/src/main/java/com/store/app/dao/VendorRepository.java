package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.store.app.bean.Customer;
import com.store.app.bean.DeliveryPartner;
import com.store.app.bean.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, String>{

		public Vendor findByUsernameAndPassword(String username, String password);

		public Vendor findByUsername(String username);

		public Vendor findByUsernameAndEmail(String username, String email);
	

}
