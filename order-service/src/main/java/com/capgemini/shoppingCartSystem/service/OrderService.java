package com.capgemini.shoppingCartSystem.service;

import com.capgemini.shoppingCartSystem.model.Order;

public interface OrderService {
	String deleteOrder(int OrderId);

	Iterable<Order> displayAllOrder();

	public String placeOrder(int[] productsIDs, int[] quantities, String userId);

	

}
