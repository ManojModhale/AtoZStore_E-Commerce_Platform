package com.store.app.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.bean.CartImageFile;
import com.store.app.bean.CartProduct;
import com.store.app.bean.Customer;
import com.store.app.dao.CartImageFileRepository;
import com.store.app.dao.CartProductRepository;


import com.store.app.dao.CartProductRepository;
import com.store.app.dao.CustomerRepository;

import jakarta.transaction.Transactional;


@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartProductRepository cartProductRepository;
    
     @Autowired
     private CustomerRepository customerRepository;
  
     @Autowired
     private CartImageFileRepository cartImageRepository;


    
   
 
	@Override
	public CartProduct addToCart(CartProduct cartProduct,String username) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findByUsername(username);

		
		if(customer!=null) {

			cartProduct.setCustomer(customer);
			cartProduct.setQuantity(1);
			
		return	cartProductRepository.save(cartProduct);
			
		}
		
		return null;
	}
	@Override
	public List<CartProduct> getCartProducts(String username) {
		// TODO Auto-generated method stub

		Customer customer=customerRepository.findByUsername(username);


		
		return cartProductRepository.findByCustomer(customer);
	}
	
	@Override
	public void deleteFromCart(String username, int cartproductid) {
		// TODO Auto-generated method stub
		
//	     cartProductRepository.deleteByCustomerUsernameAndCartproductId(username,cartproductid);
		 cartProductRepository.deleteById(cartproductid);
		
	}
//	@Override
	public boolean checkInCart(int cartProduct, String username) {
		// TODO Auto-generated method stub

		
		Customer user=customerRepository.findByUsername(username);

//		if(user!=null) {
//			List<CartProduct> cartProducts=user.getCproducts();
//			for(CartProduct c:cartProducts) {
//				if(c.getProductid()==cartProduct) {
//					return true;
//				}
//			}
//		}
		return false;
	}
	@Override
	public boolean updateProductQuantity(String updateaction,String username, int cartproductId) {
		// TODO Auto-generated method stub
		

			System.out.println("in add"+cartproductId);
			Optional<CartProduct> cartProduct=cartProductRepository.findById(cartproductId);

			if(cartProduct.isPresent()) {
				CartProduct c=cartProduct.get();
				System.out.println("in update if");
				if(updateaction.equalsIgnoreCase("add")) {
				c.setQuantity(c.getQuantity()+1);
				System.out.println(c.getQuantity());}
				else if(updateaction.equalsIgnoreCase("subtract")) {
					c.setQuantity(c.getQuantity()-1);
					
			}
				cartProductRepository.save(c);
				return true;
		}
//			System.out.println("in add");
//			User user=repository.findByUsername(username);
//			if(user!=null) {
////				List<CartProduct> cartProducts=user.getCproducts();
//				for(CartProduct c:cartProducts) {
//					if(c.getProductid()==cartproductId) {
//						System.out.println("in update if");
//						if(updateaction.equalsIgnoreCase("add")) {
//						c.setQuantity(c.getQuantity()+1);
//						System.out.println(c.getQuantity());}
//						else if(updateaction.equalsIgnoreCase("subtract")) {
//							c.setQuantity(c.getQuantity()-1);
//					}
//				}
////				user.setCproducts(cartProducts);
////				repository.save(user);
//			}
//		}

	
			
		
		return false;

	}
	
	@Override
	public void makeCartEmpty(List<Integer> cartproductIds) 
	{
		// TODO Auto-generated method stub
		System.out.println(cartproductIds);
		//cartProductRepository.deleteAllByCartproductIdIn(cartproductIds);
		/*for (Integer ids : cartproductIds) {
			System.out.println(ids);
			cartProductRepository.deleteById(ids);
		}*/
		
		/*for (Integer cartProductId : cartproductIds) {
        Optional<CartProduct> cartProductOptional = cartProductRepository.findById(cartProductId);
        cartProductOptional.ifPresent(cartProductRepository::delete);
    	}*/
		
		/*
		for (Integer cartProductId : cartproductIds) 
		{		Optional<CartProduct> cartProdOptional=cartProductRepository.findById(cartProductId);
				if(cartProdOptional.isPresent())
				{
					CartProduct cartProduct=cartProdOptional.get();
					CartImageFile cartImageFile=cartProduct.getCartimageFile();
					List<CartProduct> cartProducts = cartProductRepository.findByCartimageFile(cartImageFile);
					cartProductRepository.deleteAll(cartProducts);
					cartImageRepository.delete(cartImageFile);
		        
		    } else {
	            // Handle case when cart product does not exist
		    	System.out.println("Cart product with ID {} does not exist"+ cartProductId);
	            // Depending on the requirement, you might want to throw an exception or log the error
	        }
	    }*/
		
		for (Integer cartProductId : cartproductIds) 
		{
			Optional<CartProduct> cartProdOptional=cartProductRepository.findById(cartProductId);
			if(cartProdOptional.isPresent())
			{
				CartProduct cartProduct=cartProdOptional.get();
				//cartProductRepository.deleteById(cartProduct.getCartproductId());
				long idd=cartProduct.getCartimageFile().getId();
				cartImageRepository.deleteById(idd);
				cartProductRepository.deleteById(cartProduct.getCartproductId());
			}
			else {
				System.out.println("Cart product with ID {} does not exist"+ cartProductId);
			}
		}
		
		System.out.println("Completed emptying cart"); 
	}

}

	



