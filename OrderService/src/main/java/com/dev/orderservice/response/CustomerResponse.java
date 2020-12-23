package com.dev.orderservice.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {

	private int id;
	
	private String name;

	private String email;

	private String address;

}
