package com.shoppingmallmanagementgrp4.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String phn_number;
	private String email;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonManagedReference
	List<OrderDetails> orders;
	
	// no argument constructor is required by jpa when retriveing entity from database
	public Customer() {
		super();
	}
	
	public Customer(String name, String phn_number, String email) {
		super();
		this.name = name;
		this.phn_number = phn_number;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhn_number() {
		return phn_number;
	}
	
	public void setPhn_number(String phn_number) {
		this.phn_number = phn_number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public List<OrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phn_number=" + phn_number + ", email=" + email + "]";
	}
	
}
