package com.dev.orderservice.mapper;

import com.dev.orderservice.entity.Customer;
import com.dev.orderservice.request.CustomerRequest;
import com.dev.orderservice.response.CustomerResponse;

public interface CustomerMapper {

	public Customer map(CustomerRequest customerRequest);
	
	public CustomerResponse map(Customer customer);
	
}
