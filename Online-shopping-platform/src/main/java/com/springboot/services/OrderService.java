package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Order;
import com.springboot.entity.OrderTracking;
import com.springboot.repository.OrderRepository;
import com.springboot.repository.OrderTrackingRepository;

@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderTrackingRepository orderTrackingRepo;

    public List<Order> getOrderHistory() {
        return orderRepo.findAll();
    }

    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }
    
    public Order trackOrder(Long orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void updateOrderStatus(Long orderId, Long statusId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderTracking status = orderTrackingRepo.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Order status not found"));

        order.setStatus(status);
        orderRepo.save(order);
    }
	
}
