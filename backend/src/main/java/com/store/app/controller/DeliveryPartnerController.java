package com.store.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.DeliveryPartner;
import com.store.app.bean.OrderDetails;
import com.store.app.bean.Vendor;
import com.store.app.service.DeliveryPartnerService;
import com.store.app.service.OrderDetailsService;

@RestController
@RequestMapping("/delivery")
@CrossOrigin( "http://localhost:4200")
public class DeliveryPartnerController {
	
	@Autowired
	DeliveryPartnerService deliveryPartnerService;
	@Autowired
	OrderDetailsService orderDetailsService;
	
    @PostMapping("/register")
	public void registerDeliveryPartner(@RequestBody DeliveryPartner deliveryPartner) {
    	System.out.println(deliveryPartner);
		deliveryPartnerService.registerDeliveryPartner(deliveryPartner);
	}
    @PostMapping("deliverylogin")
	public DeliveryPartner loginAuthenticate(@RequestBody DeliveryPartner user)
	{
		System.out.println("inside login "+user.getUsername()+","+user.getPassword());
//		System.out.println(deliveryPartnerService.login(user.getUsername(), user.getPassword()));

		return deliveryPartnerService.Login(user.getUsername(), user.getPassword());
	}
    @GetMapping("/getuser/{username}")
    public DeliveryPartner getUser(@PathVariable String username) {
    	return deliveryPartnerService.getUserByUsername(username);
    }
    
    @PostMapping("/update")
    public int update(@RequestBody DeliveryPartner deliveryPartner) {
    		return deliveryPartnerService.update(deliveryPartner);
    	}
    
	@PostMapping("/forgotpass")
	public int forgotpassword(@RequestParam String username, @RequestParam String email)
	{
		return deliveryPartnerService.getByEmail(username, email);
	}
	@PostMapping("/changepass")
	public boolean changePassword(@RequestParam String username, @RequestParam String password)
	{
		return deliveryPartnerService.changePassword(username, password);
	}
	
	@GetMapping("/getAllOrders")
	public List<OrderDetails> getOrders(){
		return orderDetailsService.getAllOrders();
	}
	
	@GetMapping("/getDeliveryPartners")
	public List<DeliveryPartner> getAllPartners()
	{
		return deliveryPartnerService.getAllDeliveryPartners();
	}
}
