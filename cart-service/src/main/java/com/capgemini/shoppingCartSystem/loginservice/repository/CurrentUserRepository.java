package com.capgemini.shoppingCartSystem.loginservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingCartSystem.loginservice.model.CurrentUser;

@Repository
public interface CurrentUserRepository extends MongoRepository<CurrentUser, String>{

}
