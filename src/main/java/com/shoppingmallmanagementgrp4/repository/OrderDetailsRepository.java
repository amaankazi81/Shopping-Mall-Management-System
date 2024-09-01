package com.shoppingmallmanagementgrp4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmallmanagementgrp4.entities.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

	
}
