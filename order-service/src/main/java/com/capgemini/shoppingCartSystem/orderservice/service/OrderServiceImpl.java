package com.capgemini.shoppingCartSystem.orderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.shoppingCartSystem.orderservice.exception.RecordNotFoundException;
import com.capgemini.shoppingCartSystem.orderservice.model.CurrentUser;
import com.capgemini.shoppingCartSystem.orderservice.model.Order;
import com.capgemini.shoppingCartSystem.orderservice.model.Product;
import com.capgemini.shoppingCartSystem.orderservice.repository.CurrentUserRepository;
import com.capgemini.shoppingCartSystem.orderservice.repository.OrderDAO;
import com.capgemini.shoppingCartSystem.orderservice.repository.ProductDAO;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	CurrentUserRepository currentuserDao;
	@Autowired
	ProductDAO productDao;
	
	@Override
	public String placeOrder(int[] productIDs,int[] quantities) {
		// TODO Auto-generated method stub
		int totalAmount=0;
		List<Product> products=new ArrayList<Product>();
		for(int i=0;i<productIDs.length;i++) {
			Optional<Product> findById = productDao.findById(productIDs[i]);
			Product product = findById.get();
			products.add(product);
			totalAmount=totalAmount+(product.getPrice()*quantities[i]);
			product.setQuantity(product.getQuantity()-quantities[i]);
			productDao.save(product);
		}
		List<CurrentUser> currentuser=currentuserDao.findAll();
		String userId=currentuser.get(0).getUserName();
		Order currentOrder=new Order(products,totalAmount,userId);
		orderDAO.insert(currentOrder);
		return "Order Placed!!";
		
	}
	

	
	@Override
	public String deleteOrder(int OrderId) {
		// TODO Auto-generated method stub
		Optional<Order> findBookingById = orderDAO.findById(OrderId);
		if (findBookingById.isPresent()) {
			orderDAO.deleteById(OrderId);
			return "Order Deleted!!";
		} else
			throw new RecordNotFoundException("Order not found for the entered OrderID");
	}

	@Override
	public Iterable<Order> displayAllOrder() {
		// TODO Auto-generated method stub
		return orderDAO.findAll();
	}



	@Override
	public List<Order> getAllOrdersByUserId(String name) {
		// TODO Auto-generated method stub

        return orderDAO.findAllByUserId(name);
	}


}
