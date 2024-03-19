package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Products;
import com.springboot.services.CartService;

@RestController
@RequestMapping("onlineShopping")
public class CartController {

	@Autowired
    private CartService cartService;

    @PutMapping("/{cart_id}/add-product")
    public void addProductToCart(@PathVariable int cart_id, @RequestBody Products product) {
        cartService.addToCart(cart_id, product);
    }

    @PutMapping("/{cartId}/remove-product")
    public void removeProductFromCart(@PathVariable int cart_id, @RequestBody Products product) {
        cartService.removeFromCart(cart_id, product);
    }
	
}
