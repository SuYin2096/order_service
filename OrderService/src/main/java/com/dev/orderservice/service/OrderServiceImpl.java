package com.dev.orderservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.orderservice.entity.Customer;
import com.dev.orderservice.entity.Order;
import com.dev.orderservice.entity.OrderItem;
import com.dev.orderservice.exception.ResourceNotFoundException;
import com.dev.orderservice.repository.CustomerRepo;
import com.dev.orderservice.repository.OrderRepo;
import com.dev.orderservice.request.OrderItemRequest;
import com.dev.orderservice.request.OrderRequest;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderItemService orderitemService;

	@Override
	public Order createOrder(OrderRequest orderRequest) throws ParseException {

		Optional<Customer> optCustomer = customerRepo.findById(orderRequest.getCustomerId());

		if (!optCustomer.isPresent())
			throw new ResourceNotFoundException("Customer", "ID", orderRequest.getCustomerId());

		String orderDateReq = orderRequest.getOrderDate();
		Date orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(orderDateReq);

		Order order = new Order();
		order.setCustomer(optCustomer.get());
		order.setOrderDate(orderDate);
		order.setOrderNo(orderRequest.getOrderNo());
		order.setStatus(orderRequest.getStatus());

		Order savedOrder = orderRepo.save(order);

		Set<OrderItem> orderItems = new HashSet<OrderItem>();

		for (OrderItemRequest orderItemRequest : orderRequest.getOrderItemRequests()) {
			OrderItem orderItem = orderitemService.createOrderItem(savedOrder.getId(), orderItemRequest);
			orderItems.add(orderItem);
		}

		return savedOrder;
	}

	@Override
	public void deleteOrder(int id) {

		Optional<Order> optOrder = orderRepo.findById(id);

		if (!optOrder.isPresent())
			throw new ResourceNotFoundException("Order", "ID", id);

		orderRepo.deleteById(id);

	}

	@Override
	public Order updateOrder(int id, OrderRequest orderRequest) throws ParseException {

		Optional<Order> optOrder = orderRepo.findById(id);

		if (!optOrder.isPresent())
			throw new ResourceNotFoundException("Order", "ID", id);

		Optional<Customer> optCustomer = customerRepo.findById(orderRequest.getCustomerId());

		if (!optCustomer.isPresent())
			throw new ResourceNotFoundException("Customer", "ID", orderRequest.getCustomerId());

		String orderDateReq = orderRequest.getOrderDate();
		Date orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(orderDateReq);

		Order order = optOrder.get();
		order.setCustomer(optCustomer.get());
		order.setOrderDate(orderDate);
		order.setOrderNo(orderRequest.getOrderNo());
		order.setStatus(orderRequest.getStatus());

		return orderRepo.save(order);
	}

	@Override
	public List<Order> findAll() {

		return orderRepo.findAll();
	}

	@Override
	public Optional<Order> findById(int id) {

		Optional<Order> optOrder = orderRepo.findById(id);

		if (!optOrder.isPresent())
			throw new ResourceNotFoundException("Order", "ID", id);

		return optOrder;
	}

}
