package com.dev.orderservice.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {

	@NotNull
	private int productId;
	
	@NotNull
	private int quantity;

	@NotNull
	private double total;
}
