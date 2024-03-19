package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.OrderTracking;
import com.springboot.services.OrderTrackingService;

@RestController
@RequestMapping("onlineShopping")
public class OrderTrackingController {

	@Autowired
	private OrderTrackingService orderTrackingService;
	
	@GetMapping(value="/allOrders",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderTracking> getAllOrders() {
        return orderTrackingService.getAllOrders();
    }
	
	@PutMapping(value="/updateOrder/{orderId}/status",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrderStatus(@PathVariable Long orderId, @RequestBody String newStatus) {
        orderTrackingService.updateOrderStatus(orderId, newStatus);
    }
	
}
