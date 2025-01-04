package com.store.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.app.bean.CartProduct;
import com.store.app.bean.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> 
{
	public OrderDetails findByOrderid(String orderid);
	
	@Query("SELECT o.productsList FROM OrderDetails o WHERE o.orderid = :orderid")
	public List<CartProduct> findProductsListByOrderid(@Param("orderid") String orderid);
	
	public List<OrderDetails> findByUsername(String username);
	
}
