package com.shoppingmallmanagementgrp4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmallmanagementgrp4.entities.Customer;
import com.shoppingmallmanagementgrp4.notfound.NotFound;
import com.shoppingmallmanagementgrp4.service.CustomerService;

@RestController	
public class CustomerController {
	
	// from here we will go in Service layer
	@Autowired
	private CustomerService customerservice;
	
	// Retrival
	@GetMapping("/customer")
	public List<Customer> retriveAll(){
		return customerservice.listAll();
	}
	
	// Retrieving customer by id
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> retriveById(@PathVariable Integer id) {
		try {
			Customer customer = customerservice.getCustomerById(id);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>( NotFound.notFound(id, "Customer") ,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ordersforcustomer/{cust_id}")
	public ResponseEntity<?> getOrdersForCustomer(@PathVariable Integer cust_id){
		try {
			Customer existCustomer = customerservice.getCustomerById(cust_id);
			return ResponseEntity.ok(existCustomer.getOrders());
		}
		catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/customer")
	public void add(@RequestBody Customer customer) {
		customerservice.saveCustomer(customer);
	}
	
	// update a customer where id = ?
	@PutMapping("/customer/{id}")
	public ResponseEntity<?> update(@RequestBody Customer updatedCustomer ,@PathVariable Integer id) {
		try {
			Customer existingCustomer = customerservice.getCustomerById(id);
			if(updatedCustomer.getName() != null) {
				existingCustomer.setName(updatedCustomer.getName());
			}
			if(updatedCustomer.getPhn_number() != null) {
				existingCustomer.setPhn_number(updatedCustomer.getPhn_number());
			}
			if(updatedCustomer.getEmail() != null) {
				existingCustomer.setEmail(updatedCustomer.getEmail());
			}
			customerservice.saveCustomer(existingCustomer);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(NotFound.notFound(id, "Customer"), HttpStatus.NOT_FOUND);
		}
	}
	
	// deleting a customer
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> remove(@PathVariable Integer id) {
		try {
			Customer isExisting = customerservice.getCustomerById(id); 
			customerservice.deleteCustomer(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(NotFound.notFound(id, "Customer") , HttpStatus.NOT_FOUND);
		}
	}
	
}
