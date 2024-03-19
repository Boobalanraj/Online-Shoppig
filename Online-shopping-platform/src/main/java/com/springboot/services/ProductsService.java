package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Products;
import com.springboot.repository.ProductRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductRepository ProductRepo; 
	
	public List<Products> getAllProducts(){
		return ProductRepo.findAll();
	}
	
	public Products getProductById(Long Id) {
		return ProductRepo.findById(Id).orElse(null);
	}
	
	public List<Products> searchProducts(String keyword) {
        return ProductRepo.findByNameContaining(keyword);
    }
	
	public Products createProducts(Products products) {
		return ProductRepo.save(products);
	}
	
	public Products updateProduct(Long id, Products product) {
        if (!ProductRepo.existsById(id)) {
            return null;
        }
        product.setProduct_id(id);
        return ProductRepo.save(product);
    }
	
	public void deleteProduct(Long id) {
        ProductRepo.deleteById(id);
    }
}
