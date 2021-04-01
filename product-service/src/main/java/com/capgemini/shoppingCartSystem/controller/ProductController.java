package com.capgemini.shoppingCartSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.shoppingCartSystem.model.Product;
import com.capgemini.shoppingCartSystem.service.ProductService;


@RequestMapping("/product")
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("/createProduct")
	public void addProduct(@RequestBody Product newProduct) {
		productService.createProduct(newProduct);
	}

	@GetMapping("/readAllProducts")
	public Iterable<Product> readAllProducts() {
		return productService.displayAllProduct();
	}

	@PutMapping("/updateProduct")
	public void updateProduct(@RequestBody Product updateProduct) {
		productService.updateProduct(updateProduct);
	}

	@GetMapping("/searchProduct/{id}")
	public ResponseEntity<?> searchProductByID(@PathVariable("id") int productId) {
		return productService.findProductById(productId);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public void deleteBookingByID(@PathVariable("id") int productId) {
		productService.deleteProduct(productId);
	}
}
