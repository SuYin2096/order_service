package com.dev.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.dev.orderservice.entity.Customer;
import com.dev.orderservice.request.CustomerRequest;

public interface CustomerService {

	public Customer createCustomer(CustomerRequest customerRequest);

	public void deleteCustomer(int id);

	public Customer updateCustomer(int id, CustomerRequest customerRequest);
	
	public List<Customer> findAll();
	
	public Optional<Customer> findById(int id);
}
