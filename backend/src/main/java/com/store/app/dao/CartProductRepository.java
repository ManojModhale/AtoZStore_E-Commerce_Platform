package com.store.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.app.bean.CartImageFile;
import com.store.app.bean.CartProduct;
import com.store.app.bean.Customer;


import jakarta.transaction.Transactional;
@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
   
List<CartProduct> findByCustomer(Customer customer);

@Modifying
@Transactional
void deleteByCustomerUsernameAndCartproductId(String username, int cartproductId);


void deleteAllByCartproductIdIn(List<Integer> cartproductIds);

List<CartProduct> findByCartimageFile(CartImageFile cartImageFile);

}

