package com.dev.orderservice.mapper;

import com.dev.orderservice.entity.Product;
import com.dev.orderservice.request.ProductRequest;
import com.dev.orderservice.response.ProductResponse;

public interface ProductMapper {

	public Product map(ProductRequest productRequest);
	
	public ProductResponse map(Product product);
	
}
