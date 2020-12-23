package com.dev.orderservice.response;

import java.util.Date;
import java.util.Set;

import com.dev.orderservice.entity.OrderItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {

	private int id;

	private CustomerResponse customer;

	private Long orderNo;

	private Date orderDate;

	private String status;

	private Set<OrderItem> orderItems;
}
