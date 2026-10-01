package com.example.order_service.dto;

import java.util.List;

public class OrderRequestDto {

	private Long customerId;
	
	private String shippingAddres;
	
	private List<OrderItemRequestDto> items;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getShippingAddres() {
		return shippingAddres;
	}

	public void setShippingAddres(String shippingAddres) {
		this.shippingAddres = shippingAddres;
	}

	public List<OrderItemRequestDto> getItems() {
		return items;
	}

	public void setItems(List<OrderItemRequestDto> items) {
		this.items = items;
	}
	
	
	
}
