package com.springboot.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="order")
public class Order {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    private LocalDateTime orderDate;

	    @ManyToOne
	    @JoinColumn(name = "customer_id", referencedColumnName = "id")
	    private Customer customer;
	    
	    @ManyToOne
	    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
	    private OrderTracking status;

		@Override
		public String toString() {
			return "Order [id=" + id + ", orderDate=" + orderDate + ", status=" + status + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
		}

		public OrderTracking getStatus() {
			return status;
		}

		public void setStatus(OrderTracking status) {
			this.status = status;
		}

	
}
