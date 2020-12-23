package com.dev.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.orderservice.entity.Product;
import com.dev.orderservice.exception.BadRequestException;
import com.dev.orderservice.exception.ResourceNotFoundException;
import com.dev.orderservice.mapper.ProductMapper;
import com.dev.orderservice.repository.ProductRepo;
import com.dev.orderservice.request.ProductRequest;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product createProduct(ProductRequest productRequest) {

		Product product = productMapper.map(productRequest);

		return productRepo.save(product);
	}

	@Override
	public void deleteProduct(int id) {

		Optional<Product> optProduct = productRepo.findById(id);

		if (!optProduct.isPresent())
			throw new ResourceNotFoundException("Product", "ID", id);

		productRepo.deleteById(id);
	}

	@Override
	public Product updateProduct(int id, ProductRequest productRequest) {

		Optional<Product> optProduct = productRepo.findById(id);

		if (!optProduct.isPresent())
			throw new ResourceNotFoundException("Product", "ID", id);

		Optional<Product> existedProduct = productRepo.findByIdNotAndName(id, productRequest.getName());

		if (existedProduct.isPresent())
			throw new BadRequestException("Product name already taken.");

		Product product = optProduct.get();
		product.setName(productRequest.getName());
		product.setUnitPrice(productRequest.getUnitPrice());

		return productRepo.save(product);
	}

	@Override
	public List<Product> findAll() {

		return productRepo.findAll();
	}

	@Override
	public Optional<Product> findById(int id) {

		Optional<Product> optProduct = productRepo.findById(id);

		if (!optProduct.isPresent())
			throw new ResourceNotFoundException("Product", "ID", id);

		return optProduct;
	}

}
