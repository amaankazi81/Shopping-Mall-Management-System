package com.shoppingmallmanagementgrp4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmallmanagementgrp4.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
}
