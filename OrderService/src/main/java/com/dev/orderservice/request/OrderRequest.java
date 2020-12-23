package com.dev.orderservice.request;

import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

	@NotNull
	private int customerId;

	@NotNull
	private Long orderNo;

	@NotNull
	private String orderDate;

	@NotNull
	private String status;

	@NotNull
	private Set<OrderItemRequest> orderItemRequests;
}
