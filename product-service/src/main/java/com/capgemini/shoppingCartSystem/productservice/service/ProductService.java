package com.capgemini.shoppingCartSystem.productservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.shoppingCartSystem.productservice.model.Product;

public interface ProductService {

	ResponseEntity<?> createProduct(Product newProduct);

	Product updateProduct(Product newProduct);

	String deleteProduct(int ProductId);

	Iterable<Product> displayAllProduct();

	ResponseEntity<?> findProductById(int productId);
	
	 public List<Product> getAllByProductName(String name);

}
