package com.capgemini.shoppingCartSystem.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingCartSystem.userservice.model.CurrentUser;

@Repository
public interface CurrentUserRepository extends MongoRepository<CurrentUser, String>{

}
