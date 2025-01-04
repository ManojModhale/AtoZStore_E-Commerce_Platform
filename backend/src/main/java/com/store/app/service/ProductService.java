package com.store.app.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.razorpay.Product;
import com.store.app.bean.Products;
import com.store.app.bean.Vendor;

public interface ProductService 
{
	public ResponseEntity<Products> saveNewProduct(Products product, MultipartFile file,String vendorid) throws IOException;

//	public Vendor saveProduct(Vendor vendor) ;

	public Products saveProduct(Products product);

	public List<Products> getAllProducts();

	public Optional<Products> getProductById(int productId);

	public void deleteProduct(int productId);

	public List<String> getColorsByProductId(int productId);

	public List<String> getProductSizes(int productId);

	public List<Products> getCategorizedProducts(String category);

	public List<Products> getProductByName(String productname);

	public List<Products> getByPriceRange(double min, double max, String category);
	
	public ResponseEntity<Products> uploadImage(int productId,MultipartFile file) throws IOException;
	    
	public byte[] downloadImage(int productId) throws IOException;
	
	public void changeImagePath(String filePath,int productId);

	public List<Products> getOfferedProducts();

	public List<Products> getSearchProducts(String searchprod);
	    
}
