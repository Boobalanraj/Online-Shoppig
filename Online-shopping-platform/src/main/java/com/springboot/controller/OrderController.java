package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Order;
import com.springboot.services.OrderService;

@RestController
@RequestMapping(name="onlineShopping")
public class OrderController {

	@Autowired
    private OrderService orderService;

    @GetMapping("/history")
    public List<Order> getOrderHistory() {
        return orderService.getOrderHistory();
    }
    

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }

    @GetMapping("/{orderId}")
    public Order trackOrder(@PathVariable Long orderId) {
        return orderService.trackOrder(orderId);
    }

    @PutMapping("/{orderId}/status/{statusId}")
    public void updateOrderStatus(@PathVariable Long orderId, @PathVariable Long statusId) {
        orderService.updateOrderStatus(orderId, statusId);
    }
	
}
