package com.dev.orderservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.orderservice.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByEmail(String email);
	
	Optional<Customer> findByIdNotAndEmail(int id, String email);
}
