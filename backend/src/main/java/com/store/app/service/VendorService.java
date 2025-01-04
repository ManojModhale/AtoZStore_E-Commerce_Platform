package com.store.app.service;

import java.util.List;

import com.store.app.bean.Customer;
import com.store.app.bean.Products;
import com.store.app.bean.Vendor;

public interface VendorService {
   public Vendor vendorLogin(String username,String password);

public Vendor addVendor(Vendor vendor);

public Vendor getUserByUsername(String username);

public int update(Vendor vendor);

public int getByEmail(String username, String email);

public boolean changePassword(String username, String password);

public List<Products> getVendorProducts(String username);

public List<Vendor> getAllVendors();

public boolean changeStatus(String username,String status);

}
