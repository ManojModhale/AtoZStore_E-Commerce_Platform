package com.store.app.bean;

public class TransactionDetails {
private String orderId;
private String currency;
private Integer amount;
private String key;
public TransactionDetails() {
	super();
	// TODO Auto-generated constructor stub
}

public TransactionDetails(String orderId, String currency, Integer amount, String key) {
	super();
	this.orderId = orderId;
	this.currency = currency;
	this.amount = amount;
	this.key = key;
}

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}

@Override
public String toString() {
	return "TransactionDetails [orderId=" + orderId + ", currency=" + currency + ", amount=" + amount + ", key=" + key
			+ "]";
}

}

