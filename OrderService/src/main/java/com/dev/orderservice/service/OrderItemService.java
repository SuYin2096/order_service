package com.dev.orderservice.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.dev.orderservice.entity.OrderItem;
import com.dev.orderservice.request.OrderItemRequest;

public interface OrderItemService {

	public OrderItem createOrderItem(int orderId, OrderItemRequest orderItemRequest);

	public void deleteOrderItem(int id);

	public OrderItem updateOrderItem(int id, OrderItemRequest orderItemRequest);
	
	public List<OrderItem> findAll();
	
	public Optional<OrderItem> findById(int id);
	
	public Set<OrderItem> findByOrderId(int id);
}
