package com.dev.orderservice.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

	@NotBlank(message = "Name required.")
	private String name;

	@NotBlank(message = "Email required.")
	private String email;

	@NotBlank(message = "Address required.")
	private String address;
}
