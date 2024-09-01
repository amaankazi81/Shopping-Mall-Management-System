package com.shoppingmallmanagementgrp4.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity //Annotation
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private LocalDate manufacturing;
	private LocalDate expiry;
	private float price;
	private String category;
	
	@ManyToOne
	@JoinColumn(name = "shop_id")
	@JsonIgnore
	private Shop shopitem;
	
	public Item() {
		super();
	}
	

	public Shop getShop() {
		return shopitem;
	}


	public void setShop(Shop shopitem) {
		this.shopitem = shopitem;
	}


	public Item(Integer id, String name, float price, String category, LocalDate manufacturing
			, LocalDate expiry) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturing = manufacturing;
		this.expiry = expiry;
		this.price = price;
		this.category = category;
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


	public LocalDate getManufacturing() {
		return manufacturing;
	}


	public void setManufacturing(LocalDate manufacturing) {
		this.manufacturing = manufacturing;
	}


	public LocalDate getExpiry() {
		return expiry;
	}


	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", manufacturing=" + manufacturing + ", expiry=" + expiry
				+ ", price=" + price + ", category=" + category + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getManufacturing()=" + getManufacturing() + ", getExpiry()=" + getExpiry() + ", getPrice()="
				+ getPrice() + ", getCategory()=" + getCategory() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
