package com.capgemini.shoppingCartSystem.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.shoppingCartSystem.productservice.exception.RecordAlreadyPresentException;
import com.capgemini.shoppingCartSystem.productservice.exception.RecordNotFoundException;
import com.capgemini.shoppingCartSystem.productservice.model.Product;
import com.capgemini.shoppingCartSystem.productservice.repository.ProductDAO;


@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO productDao;


	@Override
	public ResponseEntity<?> createProduct(Product newProduct) {
		// TODO Auto-generated method stub
		Optional<Product> findProductById = productDao.findById(newProduct.getProductId());
		try {
			if (!findProductById.isPresent()) {
				productDao.save(newProduct);
				return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Product with Id: " + newProduct.getProductId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@Override
	public Product updateProduct(Product newProduct) {
		// TODO Auto-generated method stub
		Optional<Product> findProductById = productDao.findById(newProduct.getProductId());
		if (findProductById.isPresent()) {
			productDao.save(newProduct);
		} else
			throw new RecordNotFoundException(
					"Product with Id: " + newProduct.getProductId() + " not exists!!");
		return newProduct;
	}

	
	@Override
	public String deleteProduct(int ProductId) {
		// TODO Auto-generated method stub
		Optional<Product> findBookingById = productDao.findById(ProductId);
		if (findBookingById.isPresent()) {
			productDao.deleteById(ProductId);
			return "Product Deleted!!";
		} else
			throw new RecordNotFoundException("Product not found for the entered ProductID");
	}

	@Override
	public Iterable<Product> displayAllProduct() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public ResponseEntity<?> findProductById(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> findById = productDao.findById(productId);
		try {
			if (findById.isPresent()) {
				Product findProduct = findById.get();
				return new ResponseEntity<Product>(findProduct, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + productId);
		} catch (RecordNotFoundException e) {
			ResponseEntity responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}


	@Override
	public List<Product> getAllByProductName(String name) {
		// TODO Auto-generated method stub
		return productDao.findAllByProductName(name);
	}
	
}
