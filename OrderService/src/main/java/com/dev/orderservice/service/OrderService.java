package com.dev.orderservice.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import com.dev.orderservice.entity.Order;
import com.dev.orderservice.request.OrderRequest;

public interface OrderService {

	public Order createOrder(OrderRequest orderRequest) throws ParseException;

	public void deleteOrder(int id);

	public Order updateOrder(int id, OrderRequest orderRequest) throws ParseException;
	
	public List<Order> findAll();
	
	public Optional<Order> findById(int id);
}
