package com.shoppingmallmanagementgrp4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmallmanagementgrp4.entities.EmployeeService;

public interface EmployeeServiceRepository extends JpaRepository<EmployeeService,Integer>{
//	List<EmployeeService> findByShopId(int shopId);
}
