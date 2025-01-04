package com.store.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.Admin;
import com.store.app.bean.DeliveryPartner;
import com.store.app.bean.Vendor;
import com.store.app.service.DeliveryPartnerService;
import com.store.app.service.VendorService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController 
{
	@Value("${usernm}")
	private String adUsername;
	
	@Value("${userpsd}")
	private String adPassword;
	
	@Autowired
	private DeliveryPartnerService deliveryPartnerService;
	
	@Autowired
	private VendorService vendorService;

	  @PostMapping("/adminAuthentication")
	   public ResponseEntity<?> adminLogin(@RequestBody Admin admin)  
	  {
	        System.out.println(admin);
	        System.out.println(adUsername+" :&: "+adPassword);
	        // Perform authentication logic here
	        if (adUsername.equals(admin.getUsername()) && adPassword.equals(admin.getPassword())) {
	            return ResponseEntity.ok().body("{\"success\": true}");
	        } else {
	            return ResponseEntity.ok().body("{\"success\": false}");
	        }
	   
	  }
	  
	  @PostMapping("/deliveryStatus")
	  public boolean changeDeliveryStatus(@RequestBody DeliveryPartner deliveryPartner)
	  {
		  System.out.println(deliveryPartner);
		  return deliveryPartnerService.changeStatus(deliveryPartner.getUsername(), deliveryPartner.getStatus());
	  }
	  
	  @PostMapping("/vendorStatus")
	  public boolean changeVendorStatus(@RequestBody Vendor vendor)
	  {
		  System.out.println(vendor);
		  return vendorService.changeStatus(vendor.getUsername(), vendor.getStatus());
	  }
	  
}
