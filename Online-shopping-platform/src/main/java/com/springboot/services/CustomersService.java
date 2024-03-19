package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Customer;
import com.springboot.repository.CustomerRepository;

@Service
public class CustomersService {

	@Autowired
	private CustomerRepository CustomerRepo;
	
	 public Customer createCustomer(Customer customer) {
	        return CustomerRepo.save(customer);
	 }
	 
	 public List<Customer> getAllCustomers() {
	        return CustomerRepo.findAll();
	 }
	 
	 public Customer updateCustomer(Long id, Customer customer) {
	        if (CustomerRepo.existsById(id)) {
	            customer.setId(id);
	            return CustomerRepo.save(customer);
	        }
	        return null;
	 }
	 
	 public void deleteCustomer(Long id) {
	        CustomerRepo.deleteById(id);
	 }
	
}
