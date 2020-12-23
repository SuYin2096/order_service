package com.dev.orderservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.orderservice.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	Optional<Product> findByIdNotAndName(int id, String name);
}
