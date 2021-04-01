package com.capgemini.shoppingCartSystem.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingCartSystem.userservice.model.RegisteredUser;

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
