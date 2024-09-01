package com.shoppingmallmanagementgrp4.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String category;
	private String name;
	private String customers;
	private String status;
	private String lstatus;
	
	// serializable
	@OneToOne(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonManagedReference
	private ShopOwner shopowner;
	
	@OneToMany(mappedBy = "shopitem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Item> items;
	
	public Shop() {
		super();
	}
	

	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public ShopOwner getShopowner() {
		return shopowner;
	}

	public void setShopowner(ShopOwner shopowner) {
		this.shopowner = shopowner;
	}

	public Shop(String category, String name, String customers, String status, String lstatus) {
		super();
		this.category = category;
		this.name = name;
		this.customers = customers;
		this.status = status;
		this.lstatus = lstatus;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCustomers() {
		return customers;
	}


	public void setCustomers(String customers) {
		this.customers = customers;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getLstatus() {
		return lstatus;
	}


	public void setLstatus(String lstatus) {
		this.lstatus = lstatus;
	}


	@Override
	public String toString() {
		return "Shop [id=" + id + ", category=" + category + ", name=" + name + ", customers=" + customers + ", status="
				+ status + ", lstatus=" + lstatus + ", getId()=" + getId() + ", getCategory()=" + getCategory()
				+ ", getName()=" + getName() + ", getCustomers()=" + getCustomers() + ", getStatus()=" + getStatus()
				+ ", getLstatus()=" + getLstatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
