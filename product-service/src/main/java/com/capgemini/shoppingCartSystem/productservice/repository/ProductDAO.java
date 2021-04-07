package com.capgemini.shoppingCartSystem.productservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingCartSystem.productservice.model.Product;

@Repository
public interface ProductDAO extends MongoRepository<Product, Integer>{
	/*public List<Product> getProducts();
	public List<Product> findById(int id);
	public List<Product> findByName(String name);
	public void addProduct(Product product);
	public void deleteProductById(int id);
	public List<Product> findByCategory(String category);
	*/
	 public List<Product> findAllByProductName(String productName);

}
