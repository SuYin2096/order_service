package com.dev.orderservice.mapper;

import com.dev.orderservice.entity.Order;
import com.dev.orderservice.response.OrderResponse;

public interface OrderMapper {

	public OrderResponse map(Order order);
}
