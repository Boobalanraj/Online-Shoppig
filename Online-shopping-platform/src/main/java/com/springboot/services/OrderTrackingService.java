package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.entity.OrderTracking;
import com.springboot.repository.OrderTrackingRepository;

public class OrderTrackingService {

	@Autowired
	private OrderTrackingRepository OrderTrackingRepo;
	
	public List<OrderTracking> getAllOrders() {
        return OrderTrackingRepo.findAll();
    }
	
	public void updateOrderStatus(Long orderId, String newStatus) {
        OrderTracking order = OrderTrackingRepo.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(newStatus);
        OrderTrackingRepo.save(order);
    }
}
