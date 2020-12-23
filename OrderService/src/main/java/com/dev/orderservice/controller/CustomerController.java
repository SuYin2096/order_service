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

import com.dev.orderservice.entity.Customer;
import com.dev.orderservice.mapper.CustomerMapper;
import com.dev.orderservice.request.CustomerRequest;
import com.dev.orderservice.response.CustomerResponse;
import com.dev.orderservice.service.CustomerService;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerMapper customerMapper;

	@PostMapping
	public CustomerResponse createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {

		Customer customer = customerService.createCustomer(customerRequest);
		
		CustomerResponse customerResponse = customerMapper.map(customer);

		return customerResponse;

	}

	@GetMapping
	public List<CustomerResponse> getAll() {
		
		List<Customer> customers = customerService.findAll();
		
		List<CustomerResponse> customerResponses = new ArrayList<CustomerResponse>();
		
		for(Customer customer : customers) {
			CustomerResponse customerResponse = customerMapper.map(customer);
			customerResponses.add(customerResponse);
		}
		
		return customerResponses;
	}

	@PutMapping("/{id}")
	public CustomerResponse updateCustomer(@Valid @RequestBody CustomerRequest customerRequest,
			@PathVariable int id) {

		Customer customer = customerService.updateCustomer(id, customerRequest);

		CustomerResponse customerResponse = customerMapper.map(customer);
		
		return customerResponse;

	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@Valid @PathVariable int id) {

		customerService.deleteCustomer(id);

	}

}
