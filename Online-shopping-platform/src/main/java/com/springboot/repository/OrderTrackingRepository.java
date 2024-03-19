package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.OrderTracking;

@Repository
public interface OrderTrackingRepository extends JpaRepository<OrderTracking,Long>{

}
