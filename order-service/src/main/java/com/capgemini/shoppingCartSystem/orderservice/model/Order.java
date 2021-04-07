package com.capgemini.shoppingCartSystem.orderservice.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
	private List<Product> products;
	private int totalAmount;
	private String orderStatus;
	private LocalDate date;
	private String userId;
	
	public Order(List<Product> products, int totalAmount, String userId) {
		this.products=products;
		this.totalAmount=totalAmount;
		this.orderStatus="Pending";
		this.date=(java.time.LocalDate.now());
		this.userId=userId;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	 
	public int getTotal() {
		return totalAmount;
	}

	public void setTotal(int total) {
		this.totalAmount = total;
	}


	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
