package com.dev.orderservice.mapper;

import org.springframework.stereotype.Component;

import com.dev.orderservice.entity.Product;
import com.dev.orderservice.request.ProductRequest;
import com.dev.orderservice.response.ProductResponse;

@Component
public class ProductMapperImpl implements ProductMapper {

	@Override
	public Product map(ProductRequest productRequest) {

		if (productRequest == null)
			return null;

		Product product = new Product();
		product.setName(productRequest.getName());
		product.setUnitPrice(productRequest.getUnitPrice());

		return product;
	}

	@Override
	public ProductResponse map(Product product) {
		
		if(product == null)
			return null;
		
		ProductResponse productResponse = new ProductResponse();
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setUnitPrice(product.getUnitPrice());
		
		return productResponse;
	}

}
