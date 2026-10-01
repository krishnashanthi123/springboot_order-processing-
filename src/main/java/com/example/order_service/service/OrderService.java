package com.example.order_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.order_service.dto.OrderItemRequestDto;
import com.example.order_service.dto.OrderItemResponseDto;
import com.example.order_service.dto.OrderRequestDto;
import com.example.order_service.dto.OrderResponseDto;
import com.example.order_service.entity.Order;
import com.example.order_service.entity.OrderItem;
import com.example.order_service.enums.OrderStatus;
import com.example.order_service.enums.PaymentStatus;
import com.example.order_service.repository.OrderItemRepository;
import com.example.order_service.repository.OrderRepository;

@Service

public class OrderService {
	
	private final OrderRepository orderRepository;
	
	private final OrderItemRepository orderItemRepository;
	
	public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository)
	{
		this.orderRepository=orderRepository;
		this.orderItemRepository=orderItemRepository;
		
	}
	
	public OrderResponseDto createOrder(OrderRequestDto request) {
		
		//1. creaAZte order entity
		
		Order order =new Order();
		
		order.setCustomerId(request.getCustomerId());
		order.setShippingAddress(request.getShippingAddres());
		
		order.setOrderStatus(OrderStatus.PENDING);
		order.setPaymentStatus(PaymentStatus.PENDING);
		
		order.setCreatedAt(LocalDateTime.now());
		order.setUpdatedAt(LocalDateTime.now());
		
		//2. Calculate total amout
		
		BigDecimal totalAmount =BigDecimal.ZERO;
		
		for(OrderItemRequestDto item: request.getItems()) {
			
			BigDecimal itemTotal=
					   item.getPrice()
					   .multiply(BigDecimal.valueOf(item.getQuantity()));
			
			totalAmount =totalAmount.add(itemTotal);
			
		}
		
		order.setTotalAmount(totalAmount);
		
		//3.save Order
		
		Order savedOrder =orderRepository.save(order);
		
		//4. Create and save OrderItems
		
		List<OrderItemResponseDto> itemResponse= new Arraylist<>();
		
		for(OrderItemRequestDto itemRequest : request.getItems()) {
		
		OrderItem orderItem =new OrderItem();
		
		orderItem.setOrderId(savedOrder.getOrderId());
		orderItem.setProductId(itemRequest.getProductId());
		orderItem.setQuantity(itemRequest.getQuantity());
		orderItem.setPrice(itemRequest.getPrice());
		
		
		OrderItem savedItem = orderItemRepository.save(orderItem);
	
		//5.Create OrderItem Response DTO
		
		//OrderItemResponseDto itemResponse = new OrderItemResponseDto();
		
		((OrderItemResponseDto) itemResponse).setOrderItemId(savedItem.getProductId());
		
		
		
		
		
	}
	

	}}
