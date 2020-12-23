package com.dev.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.orderservice.entity.Customer;
import com.dev.orderservice.exception.BadRequestException;
import com.dev.orderservice.exception.ResourceNotFoundException;
import com.dev.orderservice.mapper.CustomerMapper;
import com.dev.orderservice.repository.CustomerRepo;
import com.dev.orderservice.request.CustomerRequest;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer createCustomer(CustomerRequest customerRequest) {

		Optional<Customer> optCustomer = customerRepo.findByEmail(customerRequest.getEmail());

		if (optCustomer.isPresent())
			throw new BadRequestException("Customer already exist.");

		Customer customer = customerMapper.map(customerRequest);

		return customerRepo.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {

		Optional<Customer> optCustomer = customerRepo.findById(id);

		if (!optCustomer.isPresent())
			throw new ResourceNotFoundException("Customer", "ID", id);

		customerRepo.deleteById(id);
	}

	@Override
	public Customer updateCustomer(int id, CustomerRequest customerRequest) {

		Optional<Customer> optCustomer = customerRepo.findById(id);

		if (!optCustomer.isPresent())
			throw new ResourceNotFoundException("Customer", "ID", id);

		Optional<Customer> existedCustomer = customerRepo.findByIdNotAndEmail(id, customerRequest.getEmail());

		if (existedCustomer.isPresent())
			throw new BadRequestException("Mail already taken.");

		Customer customer = optCustomer.get();
		customer.setAddress(customerRequest.getAddress());
		customer.setEmail(customerRequest.getEmail());
		customer.setName(customerRequest.getName());

		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> findAll() {

		return customerRepo.findAll();
	}

	@Override
	public Optional<Customer> findById(int id) {

		Optional<Customer> optCustomer = customerRepo.findById(id);

		if (!optCustomer.isPresent())
			throw new ResourceNotFoundException("Customer", "ID", id);

		return optCustomer;
	}

}
