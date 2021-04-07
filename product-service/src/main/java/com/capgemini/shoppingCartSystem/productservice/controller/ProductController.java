package com.capgemini.shoppingCartSystem.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.shoppingCartSystem.productservice.model.Product;
import com.capgemini.shoppingCartSystem.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	 @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
	public void addProduct(@RequestBody Product newProduct) {
		productService.createProduct(newProduct);
	}

    @RequestMapping(value = "/readAllProducts", method= RequestMethod.GET)
	public Iterable<Product> readAllProducts() {
		return productService.displayAllProduct();
	}
    
    @GetMapping("/readAllProductByName/{name}")
	public List<Product> searchUserByID(@PathVariable("name") String name) {

		return productService.getAllByProductName(name);
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
	public void updateProduct(@RequestBody Product updateProduct) {
		productService.updateProduct(updateProduct);
	}

    @RequestMapping(value = "/searchProduct/{id}", method= RequestMethod.GET)
	public ResponseEntity<?> searchProductByID(@PathVariable("id") int productId) {
		return productService.findProductById(productId);
	}

    @RequestMapping(value="/deleteProducts/{id}", method = RequestMethod.DELETE)
	public void deleteBookingByID(@PathVariable("id") int productId) {
		productService.deleteProduct(productId);
	}
}
