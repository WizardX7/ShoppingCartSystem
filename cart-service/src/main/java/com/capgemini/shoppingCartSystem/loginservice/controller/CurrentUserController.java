package com.capgemini.shoppingCartSystem.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.shoppingCartSystem.loginservice.service.CurrentUserService;

@RestController
@RequestMapping("/log")
public class CurrentUserController {
	
	@Autowired
	CurrentUserService currentuserService;


	@GetMapping("/login/{id}/{password}")
	public String logIn(@PathVariable("id") String userId, @PathVariable("password") String password) {

		return currentuserService.login(userId, password);
	}

	@DeleteMapping("/logout")
	public String logOut() {
		return currentuserService.logout();
		
	}

}
