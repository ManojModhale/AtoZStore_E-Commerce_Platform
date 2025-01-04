package com.store.app.controller;



import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.Address;
import com.store.app.bean.CartProduct;
import com.store.app.bean.Customer;
import com.store.app.bean.OrderDetails;
import com.store.app.bean.OrderedProduct;
import com.store.app.bean.TransactionDetails;
import com.store.app.dao.CartProductRepository;
import com.store.app.dao.CustomerRepository;
import com.store.app.service.CartService;
import com.store.app.service.CustomerService;
import com.store.app.service.OrderDetailsService;

@RestController
@RequestMapping("/order")
@CrossOrigin( "http://localhost:4200")
public class OrderController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/createTransaction/{username}/{amount}")
	public TransactionDetails createTransaction(@PathVariable(name = "username") String username,
			@PathVariable(name="amount")  Double amount, @RequestBody Address address)
	{
		System.out.println("**************************************");
		System.out.println(username+" :: "+address);
		customerService.addAddress(username, address);
		
		System.out.println("amount = "+amount);
		return	orderDetailsService.createTransaction(amount);
	}
	
	/*
	@PostMapping("/generateOrder/{username}/{amount}")

	public String generateOrder(@PathVariable(name = "username") String username, 

	public boolean generateOrder(@PathVariable(name = "username") String username, 

			@PathVariable(name="amount")  double amount,
			@RequestParam String razorpay_order_id , @RequestParam String razorpay_payment_id ,
			@RequestParam String razorpay_signature, @RequestParam String date, @RequestParam String time
 )
	{
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("username : "+username);
		
		Customer orderUser=customerRepository.findByUsername(username);
		
		System.out.println(orderUser);
		
		System.out.println("amount : "+amount);
		
		System.out.println(razorpay_order_id +" [] "+razorpay_payment_id+" [] "+razorpay_signature);
		
		OrderDetails orderDetails=new OrderDetails();
		orderDetails.setOrderid(razorpay_order_id);
		orderDetails.setAvailability(true);
		orderDetails.setPayment_id(razorpay_payment_id);
		orderDetails.setPayment_signature(razorpay_signature);
		orderDetails.setAmount(amount);
		
		orderDetails.setUsername(orderUser.getUsername());
		orderDetails.setFirstname(orderUser.getFirstname());
		orderDetails.setLastname(orderUser.getLastname());
		orderDetails.setGender(orderUser.getGender());
		orderDetails.setEmail(orderUser.getEmail());
		orderDetails.setContactno(orderUser.getContactno());
		
		orderDetails.setDate(date);
		orderDetails.setTime(time);
		
		orderDetails.setAddress(orderUser.getAddress());
		
		orderDetails.setProductsList(orderUser.getCproducts());
		
		OrderDetails orderDetails=new OrderDetails(razorpay_order_id, true, razorpay_payment_id, razorpay_signature, amount,
				orderUser.getUsername(), orderUser.getFirstname(), orderUser.getLastname(), orderUser.getGender(), orderUser.getEmail(), orderUser.getContactno(),
				date, time ,orderUser.getAddress(),null);
		
		
		System.out.println(orderDetails);
		
		orderDetailsService.createOrder(orderDetails,orderUser.getCproducts());
		
		
		
		List<Integer> cartIds=new ArrayList<>();
		
		for (CartProduct cartid : orderUser.getCproducts()) {
			cartIds.add(cartid.getCartproductId());
		}
		System.out.println(cartIds);
		
//		cartService.deleteFromCart(username, cartIds.get(0));
		cartService.makeCartEmpty(cartIds);
		
		String successMessage = "Order has been placed successfully!";

	    return successMessage;
	

		System.out.println(successMessage);
		return true;
//	    return ResponseEntity.status(HttpStatus.OK).body(successMessage);
	}}*/

	
	@GetMapping("/getOrderById/{orderid}")
    public List<CartProduct> getProductsListByOrderid(@PathVariable("orderid") String orderid) {
        return orderDetailsService.getProductsListByOrderid(orderid);
    }
	
	@GetMapping("getAllOrders")
	public List<OrderDetails> getOrders()
	{
		return orderDetailsService.getAllOrders();
	}
	
	
	@DeleteMapping("/deleteOrderById/{orderid}")
	 public ResponseEntity<Void> deleteOrder(@PathVariable("orderid") String orderid) 
	 {
	    	orderDetailsService.deleteOrder(orderid);
	    	System.out.println("deleting Order");
	    	return ResponseEntity.noContent().build();
	 }
	
	 @GetMapping("/getOrdersByUsername/{username}")
	    public List<OrderDetails> getOrdersByUsername(@PathVariable("username") String username) {

		 System.out.println("$$$$$$$ In orders by username");

	        return orderDetailsService.getOrdersByUsername(username);
	    }


	    @PostMapping("/generateOrder/{username}/{amount}")
	    public ResponseEntity<String> generateOrder(@PathVariable(name = "username") String username,
	                                                 @PathVariable(name = "amount") double amount,
	                                                 @RequestParam String razorpay_order_id,
	                                                 @RequestParam String razorpay_payment_id,
	                                                 @RequestParam String razorpay_signature,
	                                                 @RequestParam String date,
	                                                 @RequestParam String time) 
	    {

	        Customer orderUser = customerRepository.findByUsername(username);
	        if (orderUser == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	        }

	        OrderDetails orderDetails = new OrderDetails(razorpay_order_id, true, razorpay_payment_id, razorpay_signature, amount,
	                orderUser.getUsername(), orderUser.getFirstname(), orderUser.getLastname(), orderUser.getGender(), orderUser.getEmail(), orderUser.getContactno(),
	                date, time, orderUser.getAddress(), null);

	        try {
	            orderDetailsService.createOrder(orderDetails, orderUser.getCproducts());
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create order");
	        }
	        /*
	        try {
	        	
	        	List<Integer> cartIds=new ArrayList<>();
	    		
	    		for (CartProduct cartid : orderUser.getCproducts()) {
	    			cartIds.add(cartid.getCartproductId());
	    		}
	        	cartService.makeCartEmpty(cartIds);
	            cartService.makeCartEmpty(orderUser.getCproducts().stream().map(CartProduct::getCartproductId).collect(Collectors.toList()));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to empty cart");
	        }*/
	        /*
	        try {
	        	List<Integer> cartIds=new ArrayList<>();
	    		
	    		for (CartProduct cartid : orderUser.getCproducts()) {
	    			cartIds.add(cartid.getCartproductId());
	    		}
	            cartService.makeCartEmpty(cartIds);
	            System.out.println("Cart products deleted successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to empty cart");
	        }*/

	     // Create a JSON object with the success message
	        JSONObject responseJson = new JSONObject();
	        responseJson.put("message", "Order has been placed successfully!");

	        // Return the JSON object with a 200 OK status
	        return ResponseEntity.ok(responseJson.toString());
	    }
}
