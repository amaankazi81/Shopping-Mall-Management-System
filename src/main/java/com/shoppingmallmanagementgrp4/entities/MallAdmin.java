package com.shoppingmallmanagementgrp4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "malladmin")

public class MallAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String email;
    private String contact;
    private String address;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MallAdmin(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public MallAdmin() {
		super();
		}
	@Override
	public String toString() {
		return "MallAdmin [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", contact=" + contact + ", address=" + address + "]";
	}
	
    

  
}
