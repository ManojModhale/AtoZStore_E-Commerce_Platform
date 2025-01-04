package com.store.app.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderedProducts")
public class OrderedProduct 
{
	@Id
	private int cartproductId;
	private int productid;
	private String productname;
	private String category;
	private double price;

	private String offer;

	private String size;
	private String color;
	private int quantity;
	
    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonBackReference
    private OrderDetails orderDetails;

	public OrderedProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderedProduct(int cartproductId, int productid, String productname, String category, double price,
			String offer, String size, String color, int quantity, OrderDetails orderDetails) {
		super();
		this.cartproductId = cartproductId;
		this.productid = productid;
		this.productname = productname;
		this.category = category;
		this.price = price;
		this.offer = offer;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
		this.orderDetails = orderDetails;
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

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public int getCartproductId() {
		return cartproductId;
	}



	public void setCartproductId(int cartproductId) {
		this.cartproductId = cartproductId;
	}



	@Override
	public String toString() {
		return "OrderedProduct [cartproductId=" + cartproductId + ", productid=" + productid + ", productname="
				+ productname + ", category=" + category + ", price=" + price + ", offer=" + offer + ", size=" + size
				+ ", color=" + color + ", quantity=" + quantity + ", orderDetails=" + orderDetails + "]";
	}
	
}
