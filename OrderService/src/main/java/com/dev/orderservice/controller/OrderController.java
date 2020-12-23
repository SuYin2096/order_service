package com.dev.orderservice.controller;

import java.text.ParseException;
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

import com.dev.orderservice.entity.Order;
import com.dev.orderservice.entity.OrderItem;
import com.dev.orderservice.mapper.OrderItemMapper;
import com.dev.orderservice.mapper.OrderMapper;
import com.dev.orderservice.request.OrderItemRequest;
import com.dev.orderservice.request.OrderRequest;
import com.dev.orderservice.response.OrderItemResponse;
import com.dev.orderservice.response.OrderResponse;
import com.dev.orderservice.service.OrderItemService;
import com.dev.orderservice.service.OrderService;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderItemMapper orderItemMapper;

	@Autowired
	private OrderItemService orderItemService;

	@PostMapping
	public OrderResponse createOrder(@Valid @RequestBody OrderRequest orderRequest) throws ParseException {

		Order order = orderService.createOrder(orderRequest);

		return orderMapper.map(order);

	}

	@GetMapping
	public List<OrderResponse> getAll() {
		
		List<Order> orderList = orderService.findAll();
		
		List<OrderResponse> orderResponses = new ArrayList<OrderResponse>();
		
		for(Order order : orderList) {
			
			OrderResponse orderResponse = orderMapper.map(order);
			orderResponses.add(orderResponse);
			
		}

		return orderResponses;
	}

	@PutMapping("/{id}")
	public OrderResponse updateOrder(@Valid @RequestBody OrderRequest orderRequest, @PathVariable int id)
			throws ParseException {

		Order order = orderService.updateOrder(id, orderRequest);

		OrderResponse orderResponse = orderMapper.map(order);
		
		return orderResponse;

	}

	@PutMapping("/orderItem/{id}")
	public OrderItemResponse updateOrderItem(@Valid @RequestBody OrderItemRequest orderItemRequest,
			@PathVariable int id) throws ParseException {

		OrderItem orderItem = orderItemService.updateOrderItem(id, orderItemRequest);

		OrderItemResponse orderItemResponse = orderItemMapper.map(orderItem);
	
		return orderItemResponse;

	}

	@DeleteMapping("/{id}")
	public void deleteOrder(@Valid @PathVariable int id) {

		orderService.deleteOrder(id);

	}

	@DeleteMapping("/orderItem/{id}")
	public void deleteOrderItem(@Valid @PathVariable int id) {

		orderItemService.deleteOrderItem(id);

	}

}
