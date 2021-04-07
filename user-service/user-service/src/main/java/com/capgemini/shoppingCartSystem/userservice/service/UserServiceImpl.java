package com.capgemini.shoppingCartSystem.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.shoppingCartSystem.userservice.exception.NotAuthenticatedException;
import com.capgemini.shoppingCartSystem.userservice.exception.RecordAlreadyPresentException;
import com.capgemini.shoppingCartSystem.userservice.exception.RecordNotFoundException;
import com.capgemini.shoppingCartSystem.userservice.model.CurrentUser;
import com.capgemini.shoppingCartSystem.userservice.model.Product;
import com.capgemini.shoppingCartSystem.userservice.model.RegisteredUser;
import com.capgemini.shoppingCartSystem.userservice.repository.CurrentUserRepository;
import com.capgemini.shoppingCartSystem.userservice.repository.ProductDAO;
import com.capgemini.shoppingCartSystem.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	CurrentUserRepository currentuserDao;

	
	@Override
	public ResponseEntity<?> createUser(RegisteredUser newUser) {
		// TODO Auto-generated method stub
		Optional<RegisteredUser> findUserById = userDao.findById(newUser.getUsername());
		try {
			if (!findUserById.isPresent()) {
				userDao.insert(newUser);
				return new ResponseEntity<RegisteredUser>(newUser, HttpStatus.OK);
		} else
				throw new RecordAlreadyPresentException(
						"User with Id: " + newUser.getUsername() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public RegisteredUser updateUser(RegisteredUser newUser) {
		// TODO Auto-generated method stub
		Optional<RegisteredUser> findUserById = userDao.findById(newUser.getUsername());
		if (findUserById.isPresent()) {
			userDao.save(newUser);
		} else
			throw new RecordNotFoundException(
					"User with Id: " + newUser.getUsername() + " not exists!!");
		return newUser;
	}

	@Override
	public String deleteUser(String UserId) {
		// TODO Auto-generated method stub
		Optional<RegisteredUser> findBookingById = userDao.findById(UserId);
		List<CurrentUser> currentuser=currentuserDao.findAll();
		if(currentuser.isEmpty()||(!currentuser.get(0).getRole().equalsIgnoreCase("ADMIN")))
			throw new NotAuthenticatedException("Not recognise for this task");
		if (findBookingById.isPresent()) {
			userDao.deleteById(UserId);
			return "User Deleted!!";
		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	@Override
	public Iterable<RegisteredUser> displayAllUser() {
		// TODO Auto-generated method stub
		List<CurrentUser> currentuser=currentuserDao.findAll();
		if(currentuser.isEmpty()||(!currentuser.get(0).getRole().equalsIgnoreCase("ADMIN")))
			throw new NotAuthenticatedException("Not recognise for this task");
		return userDao.findAll();
	}

	@Override
	public ResponseEntity<?> findUserById(String userId) {
		// TODO Auto-generated method stub
		Optional<RegisteredUser> findById = userDao.findById(userId);
		try {
			if (findById.isPresent()) {
				RegisteredUser findUser = findById.get();
				return new ResponseEntity<RegisteredUser>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} catch (RecordNotFoundException e) {
			ResponseEntity responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}

	@Override
	public String addToCart(int[] productIDs, int[] quantities) {
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<Product>();
		List<CurrentUser> currentuser=currentuserDao.findAll();
		String userId=currentuser.get(0).getUserName();
		Optional<RegisteredUser> findById = userDao.findById(userId);
		RegisteredUser user=findById.get();
		List<Product> cartProducts=user.getCart();
		for(int i=0;i<productIDs.length;i++) {
			Optional<Product> findProductById = productDao.findById(productIDs[i]);
			Product product = findProductById.get();
			cartProducts.add(product);
		}
		user.setCart(cartProducts);
		userDao.save(user);
		
	return "Products Added Successfully!!!!";
	}

	@Override
	public List<Product> getCart() {
		// TODO Auto-generated method stub
		List<CurrentUser> currentuser=currentuserDao.findAll();
		String userId=currentuser.get(0).getUserName();
		Optional<RegisteredUser> findById = userDao.findById(userId);
			if (findById.isPresent()) {
				RegisteredUser findUser = findById.get();
				return findUser.getCart();
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} 
	}

	


