package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Products;
import com.springboot.services.ProductsService;

@RestController
@RequestMapping("onlineShopping")
public class ProductsController {

	@Autowired
	private ProductsService productsService;
	
	
	@GetMapping(value="/allProducts",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Products> getAllProducts(){
		return productsService.getAllProducts();
	}
	
	
	@GetMapping(value="/product/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> getProductById(@PathVariable Long id){
		Products product = productsService.getProductById(id);
		return ResponseEntity.ok(product);
	}
	
	 @GetMapping("/search")
	    public List<Products> searchProducts(@RequestParam String keyword) {
	        return productsService.searchProducts(keyword);
	  }
	
	@PostMapping(value="/createProducts",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> createProducts(@RequestBody Products products){
		Products createdProduct = productsService.createProducts(products);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
	
	@PutMapping(value="/updateProduct/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products product) {
	        Products updatedProduct = productsService.updateProduct(id, product);
	        if (updatedProduct == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping(value="/deleteProduct/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	        productsService.deleteProduct(id);
	        return ResponseEntity.noContent().build();
	}
}
