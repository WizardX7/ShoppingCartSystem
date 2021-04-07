package com.capgemini.shoppingCartSystem.orderservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingCartSystem.orderservice.model.Order;

@Repository
public interface OrderDAO extends MongoRepository<Order, Integer>{
	/*public Order getOrdersForUser(int userId);
	public Order cancelOrder(int orderId);
	public void changeOrderStatus();
	*/
    public List<Order> findAllByUserId(String userId);

}
