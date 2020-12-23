package com.dev.orderservice.mapper;

import org.springframework.stereotype.Component;

import com.dev.orderservice.entity.Customer;
import com.dev.orderservice.request.CustomerRequest;
import com.dev.orderservice.response.CustomerResponse;

@Component
public class CustomerMapperImpl implements CustomerMapper {

	@Override
	public Customer map(CustomerRequest customerRequest) {

		if (customerRequest == null)
			return null;

		Customer customer = new Customer();
		customer.setName(customerRequest.getName());
		customer.setEmail(customerRequest.getEmail());
		customer.setAddress(customerRequest.getAddress());

		return customer;
	}

	@Override
	public CustomerResponse map(Customer customer) {

		if (customer == null)
			return null;

		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setId(customer.getId());
		customerResponse.setName(customer.getName());
		customerResponse.setAddress(customer.getAddress());
		customerResponse.setEmail(customer.getEmail());

		return customerResponse;
	}
}
