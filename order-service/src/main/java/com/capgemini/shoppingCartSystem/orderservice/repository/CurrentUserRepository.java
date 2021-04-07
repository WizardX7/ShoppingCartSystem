package com.capgemini.shoppingCartSystem.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingCartSystem.orderservice.model.CurrentUser;

@Repository
public interface CurrentUserRepository extends MongoRepository<CurrentUser, String>{

}
