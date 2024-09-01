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

import com.shoppingmallmanagementgrp4.entities.Shop;
import com.shoppingmallmanagementgrp4.entities.ShopOwner;
import com.shoppingmallmanagementgrp4.notfound.NotFound;
import com.shoppingmallmanagementgrp4.service.ShopOwnerService;
import com.shoppingmallmanagementgrp4.service.ShopService;

@RestController
public class ShopOwnerController {

	@Autowired
	private ShopOwnerService service;
	
	@Autowired
	private ShopService shopservice;
	
	//Retrieval
	@GetMapping("/so")
	public List<ShopOwner> list(){
		return service.listAll();
	}
	
	//Retrieve By Id
	@GetMapping("/so/{id}")
	public ResponseEntity <ShopOwner> get(@PathVariable Integer id){
		try {
			ShopOwner shopowner = service.get(id);
			return new ResponseEntity<ShopOwner>(shopowner,HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<ShopOwner>(HttpStatus.NOT_FOUND);
		}
	}

	
	@PostMapping("/shopownerhavingshop/{shop_id}")
	public ResponseEntity<?> addOrder(@RequestBody ShopOwner shopowner ,@PathVariable Integer shop_id) {
		try {
			Shop existingShop = shopservice.get(shop_id);
			shopowner.setShop(existingShop);
			service.save(shopowner);
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Update
	@PutMapping("/so/{id}")
	public ResponseEntity<?> update(@RequestBody ShopOwner shopowner, @PathVariable Integer id){
		try {
			ShopOwner existShopOwner = service.get(id);
			existShopOwner.setName(shopowner.getName());
			existShopOwner.setContactInfo(shopowner.getContactInfo());
			existShopOwner.setEmail(shopowner.getEmail());
			service.save(existShopOwner);
			return new ResponseEntity <> (HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/so/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			ShopOwner existingShop = service.get(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
