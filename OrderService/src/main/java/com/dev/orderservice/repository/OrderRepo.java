package com.dev.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.orderservice.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
