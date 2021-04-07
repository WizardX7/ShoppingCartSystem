package com.capgemini.shoppingCartSystem.loginservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.shoppingCartSystem.loginservice.config.LogOutThread;
import com.capgemini.shoppingCartSystem.loginservice.exception.RecordNotFoundException;
import com.capgemini.shoppingCartSystem.loginservice.model.CurrentUser;
import com.capgemini.shoppingCartSystem.loginservice.model.RegisteredUser;
import com.capgemini.shoppingCartSystem.loginservice.repository.CurrentUserRepository;
import com.capgemini.shoppingCartSystem.loginservice.repository.UserRepository;

@Service
public class CurrentUserServiceImpl implements CurrentUserService{
	
	@Autowired
	CurrentUserRepository currentuserDao;
	
	@Autowired
	UserRepository userDao;
	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		Optional<RegisteredUser> findById = userDao.findById(username);
		try {
			if (findById.isPresent()) {
				RegisteredUser findUser = findById.get();
				if(password.equals(findUser.getPassword())) {
					CurrentUser newUser=new CurrentUser(username, findUser.getRole());
					currentuserDao.insert(newUser);
				}
				//LogOutThread t=new LogOutThread();
				//t.start();
				return "Welcome "+findUser.getName();
				
			} else
				throw new RecordNotFoundException("No record found with ID " + username);
		} catch (RecordNotFoundException e) {
			
		}
		return "Something went wrong!!Try Again!!";
	}

	@Override
	public ResponseEntity<?> findUser() {
		// TODO Auto-generated method stub
		try {
			List<CurrentUser> currentuser=currentuserDao.findAll();
			if (!currentuser.isEmpty()) {
				return new ResponseEntity<CurrentUser>((CurrentUser) currentuser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No logged in record found");
		} catch (RecordNotFoundException e) {
			ResponseEntity responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
			return responseEntity;
		}

	}

	@Override
	public String logout() {
		// TODO Auto-generated method stub
		currentuserDao.deleteAll();
		return "Logged Out!!!";
	}

}
