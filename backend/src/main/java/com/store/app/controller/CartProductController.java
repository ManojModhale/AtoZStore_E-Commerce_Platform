package com.store.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.CartProduct;
import com.store.app.bean.Customer;


import com.store.app.service.CartService;

@RestController
@RequestMapping("cart")
@CrossOrigin( "http://localhost:4200")
public class CartProductController {
	  
	@Autowired
	CartService cartService;
	
	@PostMapping("addToCart/{username}")
	public CartProduct addToCart(@PathVariable String username, @RequestBody CartProduct cartProduct) {
		System.out.println(username);
		System.out.println(cartProduct.toString());
		return cartService.addToCart(cartProduct,username);
	}
	@PostMapping("checkInCart/{username}")
	public boolean checkInCart(@PathVariable String username, @RequestBody  int producid) {
		System.out.println(username);
		
		return cartService.checkInCart(producid,username);
	}
	@PostMapping("/productquantity/{updateaction}/{username}")
	public boolean updateProQuantity(@PathVariable String updateaction,@PathVariable String username, @RequestBody  CartProduct cartProduct) {
		System.out.println(username);

		return cartService.updateProductQuantity(updateaction,username,cartProduct.getCartproductId());
		

	}
	@GetMapping("getcartproducts/{username}")
	public List<CartProduct> getfromcart(@PathVariable String username) {
		System.out.println(username);
		return cartService.getCartProducts(username);
	}
	@PostMapping("deleteFromCart")
	public void  deleteFromCart(@RequestParam String username,@RequestParam int cartproductid) {
	  System.out.println(username);
		 cartService.deleteFromCart(username,cartproductid);
	}
}