package com.springboot.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class CartItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
    private int quantity;
    
    @ManyToMany
    @JoinTable(
        name = "cart_product",
        joinColumns = @JoinColumn(name = "cart_id"),inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Products> products;
    
	@Override
	public String toString() {
		return "CartItems [cart_id=" + cart_id + ", quantity=" + quantity + "]";
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	 public void addProduct(Products product) {
	        products.add(product);
	    }

	    public void removeProduct(Products product) {
	        products.remove(product);
	    }

	    public List<Products> getProducts() {
	        return products;
	    }

}
