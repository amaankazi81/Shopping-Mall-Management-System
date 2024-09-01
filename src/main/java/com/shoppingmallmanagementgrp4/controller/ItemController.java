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

import com.shoppingmallmanagementgrp4.entities.Item;
import com.shoppingmallmanagementgrp4.entities.Shop;
import com.shoppingmallmanagementgrp4.notfound.NotFound;
import com.shoppingmallmanagementgrp4.service.ItemService;
import com.shoppingmallmanagementgrp4.service.ShopService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@Autowired
	private ShopService shopservice;
	
	//Retrieval Operation
	@GetMapping("/items")
	public List<Item> list(){
		return service.listAll();
		
	}
	//Retrieve By Id
	@GetMapping("/items/{id}")
	public ResponseEntity <Item> get(@PathVariable Integer id) {
		try {
			Item item = service.get(id);
			return new ResponseEntity<Item>(item,HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping("/itemsofshop/{shop_id}")
	public ResponseEntity<?> getItemsForShop(@PathVariable Integer shop_id){
		try {
			Shop existShop = shopservice.get(shop_id);
			return ResponseEntity.ok(existShop.getItems());
		}
		catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Create
	@PostMapping("/itemsforshop/{shop_id}")
	public ResponseEntity<?> add(@RequestBody Item item, @PathVariable Integer shop_id) {
		try {
			Shop existShop = shopservice.get(shop_id);
			item.setShop(existShop);
			service.save(item);
			return ResponseEntity.ok().build();
		} 
		catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Update
	@PutMapping("/items/{id}")
	public ResponseEntity<?> update(@RequestBody Item item,@PathVariable Integer id){
		try {
			Item existItem = service.get(id);
			existItem.setCategory(item.getCategory());
			existItem.setPrice(item.getPrice());
			existItem.setName(item.getName());
			service.save(existItem);
			return new ResponseEntity <> (HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//Delete
	@DeleteMapping("/items/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			Item existingItem = service.get(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>( NotFound.notFound(id, "Item"), HttpStatus.NOT_FOUND);
		}
	}

}
