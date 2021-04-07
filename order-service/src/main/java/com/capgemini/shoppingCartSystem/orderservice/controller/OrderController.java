package com.capgemini.shoppingCartSystem.orderservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.shoppingCartSystem.orderservice.exception.RecordAlreadyPresentException;
import com.capgemini.shoppingCartSystem.orderservice.exception.RecordNotFoundException;
import com.capgemini.shoppingCartSystem.orderservice.model.Order;
import com.capgemini.shoppingCartSystem.orderservice.model.OrderDetails;
import com.capgemini.shoppingCartSystem.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/placeOrder")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public String addOrder(@RequestBody OrderDetails order) {

		return orderService.placeOrder(order.getProductIDs(),order.getQuantities());
	}

	@GetMapping("/readAllOrders")
	public Iterable<Order> readAllOrders() {

		return orderService.displayAllOrder();
	}
	
	@GetMapping("/orderByUser/{id}")
	public List<Order> searchUserByID(@PathVariable("id") String userId) {

		return orderService.getAllOrdersByUserId(userId);
	}
  
/*
	@PutMapping("/updateOrder")
	@ExceptionHandler(RecordNotFoundException.class)
	public void updateOrder(@RequestBody Order updateOrder) {

		orderService.updateOrder(updateOrder);
	}

	@GetMapping("/searchOrder/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchOrderByID(@PathVariable("id") int orderId) {

		return orderService.findOrderById(orderId);
	}
*/
	@DeleteMapping("/deleteOrder/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") int orderId) {

		orderService.deleteOrder(orderId);
	}
}
