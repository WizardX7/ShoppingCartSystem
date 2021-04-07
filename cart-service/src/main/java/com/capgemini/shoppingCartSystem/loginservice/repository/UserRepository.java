package com.capgemini.shoppingCartSystem.loginservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingCartSystem.loginservice.model.RegisteredUser;

@Repository
public interface UserRepository extends MongoRepository<RegisteredUser, String>{
	/*public String getUserPassword(String userName);
	public RegisteredUser getUserDetails(String userName);
	//public void addToCart(Product product);
	public void removeFromCart(int productId);
	public RegisteredUser registerNewUser(RegisteredUser user);
	public RegisteredUser addToCart(int id, Product product);
	
*/
}
