package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

	 @Query(value = "SELECT * FROM orders WHERE customer_id = :customerId", nativeQuery = true)
	    List<Order> findByCustomerId(@Param("customerId") Long customerId);
	
}
