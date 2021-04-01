package com.capgemini.shoppingCartSystem.userservice.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.shoppingCartSystem.userservice.model.RegisteredUser;

public interface UserService {
	public ResponseEntity<?> createUser(RegisteredUser newUser);

	public RegisteredUser updateUser(RegisteredUser newUser);

	public String deleteUser(String UserId);

	public Iterable<RegisteredUser> displayAllUser();

	public ResponseEntity<?> findUserById(String userId);

}
