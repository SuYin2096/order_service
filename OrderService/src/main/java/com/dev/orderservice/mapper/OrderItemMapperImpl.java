package com.dev.orderservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.orderservice.entity.OrderItem;
import com.dev.orderservice.response.OrderItemResponse;

@Component
public class OrderItemMapperImpl implements OrderItemMapper {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public OrderItemResponse map(OrderItem orderItem) {
		
		if(orderItem == null)
			return null;
		
		OrderItemResponse orderItemResponse = new OrderItemResponse();
		orderItemResponse.setId(orderItem.getId());
		orderItemResponse.setProduct(productMapper.map(orderItem.getProduct()));
		orderItemResponse.setQuantity(orderItem.getQuantity());
		orderItemResponse.setTotal(orderItem.getTotal());
		
		return orderItemResponse;
	}
}
