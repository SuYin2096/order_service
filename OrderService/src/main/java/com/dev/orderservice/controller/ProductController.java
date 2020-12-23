package com.dev.orderservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.orderservice.entity.Product;
import com.dev.orderservice.mapper.ProductMapper;
import com.dev.orderservice.request.ProductRequest;
import com.dev.orderservice.response.ProductResponse;
import com.dev.orderservice.service.ProductService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductMapper productMapper;

	@PostMapping
	public ProductResponse createProduct(@Valid @RequestBody ProductRequest productRequest) {

		Product product = productService.createProduct(productRequest);
		
		ProductResponse productResponse = productMapper.map(product);

		return productResponse;

	}

	@GetMapping
	public List<ProductResponse> getAll() {
		
		List<Product> products = productService.findAll();
		
		List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
		
		for(Product product : products) {
			ProductResponse productResponse = productMapper.map(product);
			productResponses.add(productResponse);
		}
		
		return productResponses;
	}

	@PutMapping("/{id}")
	public ProductResponse updateProduct(@Valid @RequestBody ProductRequest productRequest,
			@PathVariable int id) {

		Product product = productService.updateProduct(id, productRequest);

		ProductResponse productResponse = productMapper.map(product);
		
		return productResponse;

	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@Valid @PathVariable int id) {

		productService.deleteProduct(id);

	}

}
