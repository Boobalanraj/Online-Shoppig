package com.springboot.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="product_owner")
public class ProductOwner {

	@Id
	private Long id;
	private String name;  
	private String email;
	
	@OneToMany(mappedBy = "productOwner")
	private List<Products>  products;
	
	@Override
	public String toString() {
		return "ProductOwner [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
