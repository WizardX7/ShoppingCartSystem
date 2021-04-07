package com.capgemini.shoppingCartSystem.userservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.shoppingCartSystem.userservice.model.RegisteredUser;
import com.capgemini.shoppingCartSystem.userservice.repository.UserRepository;

 

@SpringBootTest(classes = UserServiceApplication.class)
class UserTest {

 

    @Autowired
    UserRepository repo;
    
    @Test
    void testUserExistById(){
        Optional<RegisteredUser> user = repo.findById("shu124");
        assertNotNull(user);
    }

 

  
 

}