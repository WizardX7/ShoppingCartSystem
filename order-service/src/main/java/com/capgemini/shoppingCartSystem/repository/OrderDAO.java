package com.capgemini.shoppingCartSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingCartSystem.model.Order;

@Repository
public interface OrderDAO extends MongoRepository<Order, Integer>{
	/*public Order getOrdersForUser(int userId);
	public Order cancelOrder(int orderId);
	public void changeOrderStatus();
	*/

}
