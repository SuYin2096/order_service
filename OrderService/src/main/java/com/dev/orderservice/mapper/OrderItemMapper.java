package com.dev.orderservice.mapper;

import com.dev.orderservice.entity.OrderItem;
import com.dev.orderservice.response.OrderItemResponse;

public interface OrderItemMapper {

	public OrderItemResponse map(OrderItem orderItem);
}
