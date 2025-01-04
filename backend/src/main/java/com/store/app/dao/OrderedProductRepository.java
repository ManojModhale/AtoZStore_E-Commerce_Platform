package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.bean.OrderedProduct;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> 
{
	
}
