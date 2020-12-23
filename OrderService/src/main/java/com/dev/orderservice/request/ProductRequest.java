package com.dev.orderservice.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
	
	@NotBlank(message = "Name required.")
	private String name;
	
	@NotNull
	private double unitPrice;
}
