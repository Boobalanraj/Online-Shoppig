package com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.CartItems;
import com.springboot.entity.Products;
import com.springboot.repository.CartRepository;

@Service
public class CartService {
	
    @Autowired
    private CartRepository cartRepo;

	public void addToCart(int cart_id, Products product) {
        CartItems cart = cartRepo.findById(cart_id).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.addProduct(product);
        cartRepo.save(cart);
    }

    public void removeFromCart(int cart_id, Products product) {
        CartItems cart = cartRepo.findById(cart_id).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.removeProduct(product);
        cartRepo.save(cart);
    }
	
}
