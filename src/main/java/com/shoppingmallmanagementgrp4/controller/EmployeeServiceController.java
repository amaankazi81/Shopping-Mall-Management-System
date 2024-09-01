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

import com.shoppingmallmanagementgrp4.entities.EmployeeService;
import com.shoppingmallmanagementgrp4.service.EmployeeService_Service;

@RestController
public class EmployeeServiceController {

	@Autowired
	private EmployeeService_Service service;
	
	// Retrieval
	@GetMapping("/es")
	public ResponseEntity<?> list() {
	    try {
	        // Fetching the list from the service
	        List<EmployeeService> employees = service.listAll();
	        return ResponseEntity.ok(employees); // Return 200 OK with the list
	    } catch (Exception e) {
	        // Log the error for debugging purposes
	        e.printStackTrace();
	        
	        // Return a 500 Internal Server Error response with a custom error message
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("An error occurred while fetching the employee list. Please try again later.");
	    }
	}
	
	//Retrieval by Id
	@GetMapping("/es/{id}")
	public ResponseEntity <EmployeeService> get(@PathVariable Integer id){
		try {
			EmployeeService employeeservice = service.get(id);
			return new ResponseEntity<EmployeeService>(employeeservice,HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<EmployeeService>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Retrieval by shop_id
	
//	@GetMapping("/employees/shop/{id}")
//    public ResponseEntity<List<EmployeeService>> getEmployeesByShopId(@PathVariable int id) {
//        List<EmployeeService> employees = service.getEmployeesByShopId(id);
//        return ResponseEntity.ok(employees);
//    }
	
	// create
	@PostMapping("/es")
	public void add(@RequestBody EmployeeService employeeservice) {
		service.save(employeeservice);
		
	}
	
	//Update
	@PutMapping("/es/{id}")
	public ResponseEntity<?> update(@RequestBody EmployeeService employeeservice,@PathVariable Integer id) {
	
		try {
			EmployeeService existingEmployee = service.get(id);
			existingEmployee.setAddress(employeeservice.getAddress());
			existingEmployee.setName(employeeservice.getName());
			existingEmployee.setDob(employeeservice.getDob());
			existingEmployee.setSalary(employeeservice.getSalary());
			existingEmployee.setDesignation(employeeservice.getDesignation());
			service.save(existingEmployee);
			return new ResponseEntity <> (HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/es/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			EmployeeService existingEmployee = service.get(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	
}
