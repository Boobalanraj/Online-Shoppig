package com.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.ProductOwner;
import com.springboot.repository.ProductOwnerRepository;

@Service
public class ProductOwnerServices {
	
	@Autowired
	private ProductOwnerRepository ProductOwnerRepo;
	
	public List<ProductOwner> getAllProductOwners() {
        return ProductOwnerRepo.findAll();
    }
	
	public Optional<ProductOwner> getProductOwnerById(Long id) {
        return ProductOwnerRepo.findById(id);
    }
	
	public ProductOwner createProductOwner(ProductOwner productOwner) {
		return ProductOwnerRepo.save(productOwner);
	}
	
	public ProductOwner updateProductOwner(Long id, ProductOwner productOwner) {
        productOwner.setId(id);
        return ProductOwnerRepo.save(productOwner);
    }
	
	public void deleteProductOwner(Long id) {
        ProductOwnerRepo.deleteById(id);
    }
	
}
