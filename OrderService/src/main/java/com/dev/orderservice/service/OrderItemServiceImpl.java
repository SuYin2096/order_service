package com.dev.orderservice.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.orderservice.entity.Order;
import com.dev.orderservice.entity.OrderItem;
import com.dev.orderservice.entity.Product;
import com.dev.orderservice.exception.ResourceNotFoundException;
import com.dev.orderservice.repository.OrderItemRepo;
import com.dev.orderservice.repository.OrderRepo;
import com.dev.orderservice.repository.ProductRepo;
import com.dev.orderservice.request.OrderItemRequest;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepo orderItemRepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Override
	public OrderItem createOrderItem(int orderId, OrderItemRequest orderItemRequest) {

		Optional<Product> optProduct = productRepo.findById(orderItemRequest.getProductId());

		if (!optProduct.isPresent())
			throw new ResourceNotFoundException("Product", "ID", orderItemRequest.getProductId());

		Optional<Order> optOrder = orderRepo.findById(orderId);

		if (!optOrder.isPresent())
			throw new ResourceNotFoundException("Order", "ID", orderId);

		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(optProduct.get());
		orderItem.setOrder(optOrder.get());
		orderItem.setQuantity(orderItemRequest.getQuantity());
		orderItem.setTotal(orderItemRequest.getTotal());

		return orderItemRepo.save(orderItem);
	}

	@Override
	public void deleteOrderItem(int id) {

		Optional<OrderItem> optOrderItem = orderItemRepo.findById(id);

		if (optOrderItem.isPresent())
			throw new ResourceNotFoundException("Order Item", "ID", id);

		orderItemRepo.deleteById(id);
	}

	@Override
	public OrderItem updateOrderItem(int id, OrderItemRequest orderItemRequest) {

		Optional<OrderItem> optOrderItem = orderItemRepo.findById(id);

		if (!optOrderItem.isPresent())
			throw new ResourceNotFoundException("Order Item", "ID", id);

		Optional<Product> optProduct = productRepo.findById(orderItemRequest.getProductId());

		if (!optProduct.isPresent())
			throw new ResourceNotFoundException("Product", "ID", orderItemRequest.getProductId());
		
		OrderItem orderItem = optOrderItem.get();
		orderItem.setProduct(optProduct.get());
		orderItem.setQuantity(orderItemRequest.getQuantity());
		orderItem.setTotal(orderItemRequest.getTotal());

		return orderItemRepo.save(orderItem);
	}

	@Override
	public List<OrderItem> findAll() {

		return orderItemRepo.findAll();
	}

	@Override
	public Optional<OrderItem> findById(int id) {

		Optional<OrderItem> optOrderItem = orderItemRepo.findById(id);

		if (optOrderItem.isPresent())
			throw new ResourceNotFoundException("Order Item", "ID", id);

		return optOrderItem;
	}

	@Override
	public Set<OrderItem> findByOrderId(int id) {
		
		return orderItemRepo.findByOrderId(id);
	}

}
