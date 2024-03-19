package com.springboot.controller;

import java.util.List;
import java.util.Optional;

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

import com.springboot.entity.ProductOwner;
import com.springboot.services.ProductOwnerServices;

@RestController
@RequestMapping("onlineShopping")
public class ProductOwnerController {

	@Autowired
	private ProductOwnerServices productOwnerServices;
	
	@GetMapping(value="/allProductOwners",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductOwner> getAllProductOwners() {
        return productOwnerServices.getAllProductOwners();
    }
	
	 @GetMapping(value="/productOwner/{id}")
	    public Optional<ProductOwner> getProductOwnerById(@PathVariable Long id) {
	        return productOwnerServices.getProductOwnerById(id);
	  }
	
	@PostMapping(value="/createProductOwner",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductOwner createProductOwner(@RequestBody ProductOwner productOwner) {
		System.out.println(productOwner);
		return productOwnerServices.createProductOwner(productOwner);
	}
	
	@PutMapping(value="/updateProductOwner/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductOwner updateProductOwner(@PathVariable Long id, @RequestBody ProductOwner productOwner) {
        return productOwnerServices.updateProductOwner(id, productOwner);
    }
	
	@DeleteMapping(value="/deleteProductOwner/{id}",consumes= MediaType.APPLICATION_JSON_VALUE)
    public void deleteProductOwner(@PathVariable Long id) {
        productOwnerServices.deleteProductOwner(id);
    }
	
	@GetMapping({"/forAdmin"})
	public String forAdmin() {
		return "this url for admin";
	}
	
	@GetMapping({"/forUser"})
	public String forUser() {
		return "this url for user";
	}
	
	
}
