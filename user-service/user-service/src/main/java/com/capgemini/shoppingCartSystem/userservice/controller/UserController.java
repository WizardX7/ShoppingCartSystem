package com.capgemini.shoppingCartSystem.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.shoppingCartSystem.userservice.model.Product;
import com.capgemini.shoppingCartSystem.userservice.model.RegisteredUser;
import com.capgemini.shoppingCartSystem.userservice.model.TempCartDetails;
import com.capgemini.shoppingCartSystem.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<?> addUser(@RequestBody RegisteredUser newUser) {

		return userService.createUser(newUser);
	}

	@GetMapping("/readAllUsers")
	public Iterable<RegisteredUser> readAllUsers() {

		return userService.displayAllUser();
	}

	@PutMapping("/updateUser")
	public void updateUser(@RequestBody RegisteredUser updateUser) {

		userService.updateUser(updateUser);
	}

	@GetMapping("/searchUser/{id}")
	public ResponseEntity<?> searchUserByID(@PathVariable("id") String userId) {

		return userService.findUserById(userId);
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUserByID(@PathVariable("id") String userId) {

		userService.deleteUser(userId);
		return "User deleted successfully";
	}
	
	@PostMapping("/addToCart")
	public String addToCart(@RequestBody TempCartDetails cart) {

		return userService.addToCart(cart.getProductIDs(),cart.getQuantities());
	}
	
	@GetMapping("/getCart")
	public List<Product> getCart() {

		return userService.getCart();
	}

}
