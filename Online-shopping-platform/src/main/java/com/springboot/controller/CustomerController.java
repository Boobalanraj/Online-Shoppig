package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Customer;
import com.springboot.services.CustomersService;

@RestController
@RequestMapping("onlineShopping")
public class CustomerController {

	@Autowired
	private CustomersService customersService;
	
	@PostMapping(value="/createCustomer",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customersService.createCustomer(customer);
    }
	
	@GetMapping(value="/allCustomers",consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomers() {
	        return customersService.getAllCustomers();
	}

	@PutMapping(value="/updateCustomer/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customersService.updateCustomer(id, customer);
    }
	
	@DeleteMapping(value="/deleteCustomer/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
    public void deleteCustomer(@PathVariable Long id) {
        customersService.deleteCustomer(id);
    }
	
	
}
