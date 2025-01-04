package com.store.app.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.store.app.bean.CartProduct;
import com.store.app.bean.OrderDetails;
import com.store.app.bean.OrderedProduct;
import com.store.app.bean.TransactionDetails;
import com.store.app.dao.CustomerRepository;
import com.store.app.dao.OrderDetailsRepository;
import com.store.app.dao.OrderedProductRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private OrderedProductRepository orderedProductRepository;

//	private static final String KEY = "rzp_test_dLv8Y6GGn4fWAF";
//	private static final String KEY_SECRET = "qUItcluFbyPfCKhEWHdrXivL";

	 private static final String KEY="rzp_test_dLv8Y6GGn4fWAF";
	 private static final String KEY_SECRET="qUItcluFbyPfCKhEWHdrXivL";
	private static final String currency = "INR";

	@Override
	public TransactionDetails createTransaction(Double amount) {
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", (amount * 100));
			jsonObject.put("currency", currency);
			RazorpayClient razorpayClient = new RazorpayClient(KEY, KEY_SECRET);
			Order order = razorpayClient.orders.create(jsonObject);
			System.out.println("order : " + order);
			return prepareTransactionDetails(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private TransactionDetails prepareTransactionDetails(Order order) {
		String orderid = order.get("id");
		String currency = order.get("currency");
		Integer amount = order.get("amount");
		TransactionDetails transactionDetails = new TransactionDetails(orderid, currency, amount, KEY);
		System.out.println("transactionDetails : " + transactionDetails);
		return transactionDetails;
	}

	@Override
	public void createOrder(OrderDetails orderDetails, List<CartProduct> cproducts) {
	    // Save the OrderDetails entity
	    OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);

	    List<OrderedProduct> products = new ArrayList<>();

	    // Associate each OrderedProduct with the saved OrderDetails entity
	    for (CartProduct cartProduct : cproducts) {
	        OrderedProduct orderedProduct = new OrderedProduct(cartProduct.getCartproductId(),
	                cartProduct.getProductid(), cartProduct.getProductname(), cartProduct.getCategory(),
	                cartProduct.getPrice(), cartProduct.getOffer(), cartProduct.getSize(), cartProduct.getColor(),
	                cartProduct.getQuantity(), savedOrderDetails); 
	        products.add(orderedProduct);
	    }

	    // Save the list of OrderedProduct entities
	    orderedProductRepository.saveAll(products);
	}

	@Override
	public List<OrderDetails> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDetailsRepository.findAll();
	}

	@Override
	public List<CartProduct> getProductsListByOrderid(String orderid) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.findProductsListByOrderid(orderid);
	}

	@Override
	public void deleteOrder(String orderid) 
	{
		// TODO Auto-generated method stub
		orderDetailsRepository.deleteById(orderid);
		
	}

	@Override
	public List<OrderDetails> getOrdersByUsername(String username) 
	{
		// TODO Auto-generated method stub
		System.out.println("in get order 2");
	
		return orderDetailsRepository.findByUsername(username);
	}

	

}
