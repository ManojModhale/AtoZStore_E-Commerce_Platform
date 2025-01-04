package com.store.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.app.bean.CartProduct;
import com.store.app.bean.Customer;



import jakarta.websocket.server.ServerEndpoint;


@Service
public interface CartService {
    public CartProduct addToCart(CartProduct cartProduct,String username);

	public List<CartProduct> getCartProducts(String username);

	public void deleteFromCart(String username, int cartproductid);

	public boolean checkInCart(int producid, String username);

	public boolean updateProductQuantity(String updateaction,String username, int cartproductId);

	
	public void makeCartEmpty(List<Integer> cartproductIds);
	
}

