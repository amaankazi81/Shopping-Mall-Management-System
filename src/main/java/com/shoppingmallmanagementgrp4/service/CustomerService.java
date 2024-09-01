package com.shoppingmallmanagementgrp4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmallmanagementgrp4.entities.Customer;
import com.shoppingmallmanagementgrp4.repository.CustomerRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerrepository;
	
	public List<Customer> listAll(){
		return customerrepository.findAll();
	}
	
	public Customer getCustomerById(Integer id) {
		return customerrepository.findById(id).get();
	}
	
	public void saveCustomer(Customer customer) {
		customerrepository.save(customer);
	}
	
	public void deleteCustomer(Integer id) {
		customerrepository.deleteById(id);
	}
	
}

