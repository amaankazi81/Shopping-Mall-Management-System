package com.shoppingmallmanagementgrp4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmallmanagementgrp4.entities.OrderDetails;
import com.shoppingmallmanagementgrp4.repository.OrderDetailsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderDetailsService {

	@Autowired
	private OrderDetailsRepository ordrepository;
	
	public List<OrderDetails> getOrders(){
		return ordrepository.findAll();
	}

	public OrderDetails getOrderById(Integer id) {
		return ordrepository.findById(id).get();
	}
	
	// used for both creating and updating
	public void addOrder(OrderDetails orderdetails) {
		ordrepository.save(orderdetails);
	}
	
	public void deleteOrder(Integer id) {
		ordrepository.deleteById(id);
	}
	
}
