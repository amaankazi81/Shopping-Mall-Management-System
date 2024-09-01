package com.shoppingmallmanagementgrp4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmallmanagementgrp4.entities.EmployeeService;
import com.shoppingmallmanagementgrp4.repository.EmployeeServiceRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService_Service {

	@Autowired
    private EmployeeServiceRepository repository;

//    public List<EmployeeService> getEmployeesByShopId(int shopId) {
//        return repository.findByShopId(shopId);
//    }
	//Retrieval
	
	public List<EmployeeService> listAll(){
		return repository.findAll();
	}
	
	//RetrievalById
	
	public EmployeeService get(Integer id) {
		return repository.findById(id).get();
	}
	
	//Create
	
	public void save(EmployeeService employeeservice) {
		repository.save(employeeservice);
		}
	
	//Delete
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	
}
