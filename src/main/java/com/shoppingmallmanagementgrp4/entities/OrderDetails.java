package com.shoppingmallmanagementgrp4.entities;

import java.time.LocalDate;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

// POJO class
@Entity
@Table(name = "orderdetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String item;
	private Float price;
	private Integer quantity;
	private LocalDate date_of_purchase = LocalDate.now().minusYears((int)(Math.random() * 3) + 1);
	private String payment_mode;
	private int shop_id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id") //This annotation specifies the foreign key column in the OrderDetails table
	@JsonBackReference
	private Customer customer;
	
	@Transient // not mapped to the database
	private Integer customerId;
	
	@PostLoad // this method is called after orderdetails(entity) is loaded from the database
	private void setCustomerId() {
		if(this.customer != null) {
			this.customerId = this.customer.getId();
		}
	}
	
	public OrderDetails() {
		super();
	}
	
	public OrderDetails(Integer id, String item, Float price, Integer quantity, String payment_mode, Integer shop_id) {
        super();
		this.id = id;
		this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.payment_mode = payment_mode;
        this.shop_id = shop_id;
    }


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDate_of_purchase() {
		return date_of_purchase;
	}

	public void setDate_of_purchase(LocalDate date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", item=" + item + ", price=" + price + ", quantity=" + quantity
				+ ", date_of_purchase=" + date_of_purchase + ", payment_mode=" + payment_mode + ", shop_id=" + shop_id
				+ ", customer=" + customer + ", customerId="+  customerId + "]";
	}
	
}
