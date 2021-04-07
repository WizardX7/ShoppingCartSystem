package com.capgemini.shoppingCartSystem.loginservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "currentuser")
public class CurrentUser {
	@Id
	private String username;
	private String role;
	public CurrentUser(String username,String role) {
		this.username=username;
		this.role=role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
