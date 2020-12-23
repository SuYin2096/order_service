package com.dev.orderservice.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponse {

	private int id;
	
	private ProductResponse product;
	
	private int quantity;
	
	private double total;
	
}
