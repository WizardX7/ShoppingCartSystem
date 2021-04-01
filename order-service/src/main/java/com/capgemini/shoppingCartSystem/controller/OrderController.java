package com.capgemini.shoppingCartSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.shoppingCartSystem.exception.RecordAlreadyPresentException;
import com.capgemini.shoppingCartSystem.exception.RecordNotFoundException;
import com.capgemini.shoppingCartSystem.model.Order;
import com.capgemini.shoppingCartSystem.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/placeOrder")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public String addOrder(@RequestBody int[] productIDs, int[] quantities, String userId) {

		return orderService.placeOrder(productIDs,quantities,userId);
	}

	@GetMapping("/readAllOrders")
	public Iterable<Order> readAllOrders() {

		return orderService.displayAllOrder();
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
