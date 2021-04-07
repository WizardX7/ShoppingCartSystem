package com.capgemini.shoppingCartSystem.orderservice.service;

import java.util.List;

import com.capgemini.shoppingCartSystem.orderservice.model.Order;

public interface OrderService {
	String deleteOrder(int OrderId);

	Iterable<Order> displayAllOrder();

	public String placeOrder(int[] productsIDs, int[] quantities);
	
	 public List<Order> getAllOrdersByUserId(String name);

	

}
