package com.capgemini.shoppingCartSystem.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.shoppingCartSystem.model.Product;

public interface ProductService {

	ResponseEntity<?> createProduct(Product newProduct);

	Product updateProduct(Product newProduct);

	String deleteProduct(int ProductId);

	Iterable<Product> displayAllProduct();

	ResponseEntity<?> findProductById(int productId);

}
