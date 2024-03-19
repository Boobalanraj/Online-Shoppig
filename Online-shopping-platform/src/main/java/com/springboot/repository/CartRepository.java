package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.CartItems;

@Repository
public interface CartRepository extends JpaRepository<CartItems,Integer> {

}
