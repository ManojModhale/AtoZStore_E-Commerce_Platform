package com.store.app.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="CartProducts")

public class CartProduct {
	
	@Id
	@GeneratedValue
   private int cartproductId;
	private int productid;
	  private String productname;
	  private String category;
	  private double price;
	  
	    private String description;
	    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "image_file_id")
	    private CartImageFile cartimageFile;
	    private String offer;
	    
	    private String size;
	    private String color;
	    private int quantity;
	    @ManyToOne
	    @JoinColumn(name="customerid")
	    @JsonBackReference
	    private Customer customer;
	    
	

	
		
		
		public CartProduct() {
			super();
			// TODO Auto-generated constructor stub
		}






		public CartProduct(int cartproductId, int productid, String productname, String category, double price,
				String description, CartImageFile cartimageFile, String offer, String size, String color, int quantity,
				Customer customer) {
			super();
			this.cartproductId = cartproductId;
			this.productid = productid;
			this.productname = productname;
			this.category = category;
			this.price = price;
			this.description = description;
			this.cartimageFile = cartimageFile;
			this.offer = offer;
			this.size = size;
			this.color = color;
			this.quantity = quantity;
			this.customer = customer;
		}



	
		
	
		public int getCartproductId() {
			return cartproductId;
		}






		public void setCartproductId(int cartproductId) {
			this.cartproductId = cartproductId;
		}






		public int getProductid() {
			return productid;
		}






		public void setProductid(int productid) {
			this.productid = productid;
		}






		public String getProductname() {
			return productname;
		}






		public void setProductname(String productname) {
			this.productname = productname;
		}






		public String getCategory() {
			return category;
		}






		public void setCategory(String category) {
			this.category = category;
		}






		public double getPrice() {
			return price;
		}






		public void setPrice(double price) {
			this.price = price;
		}






		public String getDescription() {
			return description;
		}






		public void setDescription(String description) {
			this.description = description;
		}






		public CartImageFile getCartimageFile() {
			return cartimageFile;
		}






		public void setCartimageFile(CartImageFile cartimageFile) {
			this.cartimageFile = cartimageFile;
		}






		public String getOffer() {
			return offer;
		}






		public void setOffer(String offer) {
			this.offer = offer;
		}






		public String getSize() {
			return size;
		}






		public void setSize(String size) {
			this.size = size;
		}






		public String getColor() {
			return color;
		}






		public void setColor(String color) {
			this.color = color;
		}






		public int getQuantity() {
			return quantity;
		}






		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}






		public Customer getCustomer() {
			return customer;
		}






		public void setCustomer(Customer customer) {
			this.customer = customer;
		}






		@Override
		public String toString() {
			return "CartProduct [cartproductId=" + cartproductId + ", productid=" + productid + ", productname="
					+ productname + ", category=" + category + ", price=" + price + ", description=" + description
					+ ", cartimageFile=" + cartimageFile + ", offer=" + offer + ", size=" + size + ", color=" + color
					+ "]";
		}
	    
	    
	   
	
	
}