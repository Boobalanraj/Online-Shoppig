package com.springboot.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	private String productName;
	private String product_description;
	private double price;
	

    @ManyToOne
    @JoinColumn(name = "product_owner_id", referencedColumnName = "id")
    private ProductOwner productOwner;
    
    @OneToMany(mappedBy = "product")
    private List<OrderTracking> trackOrders;
	
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + productName + ", product_description="
				+ product_description + ", price=" + price + "]";
	}
	
	
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return productName;
	}
	public void setProduct_name(String productName) {
		this.productName = productName;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
