package com.store.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.store.app.bean.Address;
import com.store.app.bean.CartProduct;
import com.store.app.bean.OrderDetails;
import com.store.app.bean.OrderedProduct;
import com.store.app.bean.Products;
import com.store.app.bean.TransactionDetails;

public interface OrderDetailsService 
{
	public TransactionDetails createTransaction(Double amount);
	
	public void createOrder(OrderDetails orderDetails,List<CartProduct> cproducts);
	
	public List<OrderDetails> getAllOrders();
	
	public List<CartProduct> getProductsListByOrderid(String orderid);
	
	public void deleteOrder(String orderid);
	
	public List<OrderDetails> getOrdersByUsername(String username);
}
