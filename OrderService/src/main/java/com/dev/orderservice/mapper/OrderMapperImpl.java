package com.dev.orderservice.mapper;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.orderservice.entity.Order;
import com.dev.orderservice.entity.OrderItem;
import com.dev.orderservice.response.OrderResponse;
import com.dev.orderservice.service.OrderItemService;

@Component
public class OrderMapperImpl implements OrderMapper {

	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public OrderResponse map(Order order) {
		
		if(order == null)
			return null;
		
		Set<OrderItem> orderItems = orderItemService.findByOrderId(order.getId());
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setCustomer(customerMapper.map(order.getCustomer()));
		orderResponse.setOrderDate(order.getOrderDate());
		orderResponse.setOrderNo(order.getOrderNo());
		orderResponse.setStatus(order.getStatus());
		orderResponse.setOrderItems(orderItems);
		
		return orderResponse;
	}

}
