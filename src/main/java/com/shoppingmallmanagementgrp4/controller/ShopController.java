package com.shoppingmallmanagementgrp4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmallmanagementgrp4.entities.Shop;
import com.shoppingmallmanagementgrp4.service.ShopService;

@RestController
public class ShopController {

	@Autowired
	private ShopService service;
	
	
	//Retrival
	@GetMapping("/shops")
	public List<Shop> listAll(){
		return service.listAll();
	}
	
	//Retrive by Id
	@GetMapping("/shops/{id}")
	public ResponseEntity <Shop> get(@PathVariable Integer id){
		try {
			Shop shop =  service.get(id);
			return new ResponseEntity<Shop>(shop,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND);
		}
	}
		
		//Create
		@PostMapping("/shops")
		public void add(@RequestBody Shop shop) {
			service.save(shop);
		}
		//Update
		@PutMapping("/shops/{id}")
		public ResponseEntity<?> update(@RequestBody Shop shop, @PathVariable Integer id){
			try {
				Shop existShop = service.get(id);
				existShop.setCategory(shop.getCategory());
				existShop.setCustomers(shop.getCustomers());
				existShop.setLstatus(shop.getLstatus());
				existShop.setStatus(shop.getStatus());
				existShop.setName(shop.getName());
				service.save(existShop);
				return new ResponseEntity <> (HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity <> (HttpStatus.NOT_FOUND);
			}
		}
		
		//Delete
		@DeleteMapping("/shops/{id}")
		public ResponseEntity<?> delete(@PathVariable Integer id) {
			try {
				Shop existingShop = service.get(id);
				service.delete(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} 
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	
}
