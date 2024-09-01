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
import com.shoppingmallmanagementgrp4.entities.OrderDetails;
import com.shoppingmallmanagementgrp4.notfound.NotFound;
import com.shoppingmallmanagementgrp4.service.CustomerService;
import com.shoppingmallmanagementgrp4.service.OrderDetailsService;



@RestController
public class OrderDetailsContoller {
	
	@Autowired
	private OrderDetailsService ordservice;
	
	@Autowired
	private CustomerService customerservice;

	// retrive all orders
	@GetMapping("/order")
	public List<OrderDetails> retrieveAllOrders(){
		return ordservice.getOrders();
	}
	
	// get order by id
	@GetMapping("/order/{id}")
	public ResponseEntity<?> retriveOrderById(@PathVariable Integer id) {
		try {
			OrderDetails order = ordservice.getOrderById(id);
			return new ResponseEntity<>(order, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(NotFound.notFound(id, "Order") ,HttpStatus.NOT_FOUND);
		}
	}
	
	// posting an order for a given customer id
	@PostMapping("/orderforcustomer/{cust_id}")
	public ResponseEntity<?> addOrder(@RequestBody OrderDetails neworderdetails ,@PathVariable Integer cust_id) {
		try {
			Customer existingCustomer = customerservice.getCustomerById(cust_id);
			neworderdetails.setCustomer(existingCustomer);
			ordservice.addOrder(neworderdetails);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(NotFound.notFound(cust_id, "Customer") ,HttpStatus.NOT_FOUND);
		}
	}
	
	// updating an order details for given order id
	@PutMapping("/order/{order_id}")
	public ResponseEntity<?> updateOrder(@PathVariable Integer order_id, @RequestBody OrderDetails newOrderdetails){
		try {
			OrderDetails existingOrder = ordservice.getOrderById(order_id);
			if(newOrderdetails.getItem() != null) {
				existingOrder.setItem(newOrderdetails.getItem());
			}
			if(newOrderdetails.getPrice() != null) {
				existingOrder.setPrice(newOrderdetails.getPrice());
			}
			if(newOrderdetails.getQuantity() != null) {
				existingOrder.setQuantity(newOrderdetails.getQuantity());
			}
			// payment mode and shop id will not change
			ordservice.addOrder(existingOrder);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(NotFound.notFound(order_id, "Order"), HttpStatus.NOT_FOUND);
		}
	}
	
	// now deleting an oder for given order id
	@DeleteMapping("/order/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer id){
		try {
			OrderDetails existingOrder = ordservice.getOrderById(id);
			ordservice.deleteOrder(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(NotFound.notFound(id, "Order") ,HttpStatus.NOT_FOUND);
		}
	}
	
}
