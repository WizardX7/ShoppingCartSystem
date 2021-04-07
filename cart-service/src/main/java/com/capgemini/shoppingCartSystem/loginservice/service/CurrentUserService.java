package com.capgemini.shoppingCartSystem.loginservice.service;

import org.springframework.http.ResponseEntity;

public interface CurrentUserService {
	public String login(String username, String password);

	public String logout();
	ResponseEntity<?> findUser();

	
}
