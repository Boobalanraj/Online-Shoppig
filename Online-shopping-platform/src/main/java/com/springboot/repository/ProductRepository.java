package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {

	 List<Products> findByNameContaining(String keyword);
	
}
