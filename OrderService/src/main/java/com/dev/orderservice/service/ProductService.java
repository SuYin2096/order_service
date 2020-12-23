package com.dev.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.dev.orderservice.entity.Product;
import com.dev.orderservice.request.ProductRequest;

public interface ProductService {

	public Product createProduct(ProductRequest productRequest);
	
	public void deleteProduct(int id);
	
	public Product updateProduct(int id, ProductRequest productRequest);
	
	public List<Product> findAll();
	
	public Optional<Product> findById(int id);
}
