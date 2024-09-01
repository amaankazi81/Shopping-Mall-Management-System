package com.shoppingmallmanagementgrp4.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import com.shoppingmallmanagementgrp4.entities.ShopOwner;

@Entity
@Table(name = "shopowners")
public class ShopOwner {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    private String name;
    private String contactInfo;
    private String email;
	
    @OneToOne
    @JoinColumn(name = "shop_id")  // This specifies the foreign key column
    @JsonBackReference
    private Shop shop;
    
    public ShopOwner() {
		super();
	}

	public Shop getShop() {
		return shop;
	}



	public void setShop(Shop shop) {
		this.shop = shop;
	}



	public ShopOwner( String name, String contactInfo, String email) {
		super();
		this.name = name;
		this.contactInfo = contactInfo;
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



	public String getContactInfo() {
		return contactInfo;
	}



	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "ShopOwner [id=" + id + ", name=" + name + ", contactInfo=" + contactInfo + ", email=" + email
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getContactInfo()=" + getContactInfo()
				+ ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
    
    
}
