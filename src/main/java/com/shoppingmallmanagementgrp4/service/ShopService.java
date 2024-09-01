package com.shoppingmallmanagementgrp4.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmallmanagementgrp4.entities.Shop;
import com.shoppingmallmanagementgrp4.repository.ShopRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopService {
	
	@Autowired
	private ShopRepository repository;
	
	public List<Shop> listAll(){
	return repository.findAll();
	}
	
	public Shop get(Integer id) {
		return repository.findById(id).get();
	}
	
	public void save(Shop shop) {
		repository.save(shop);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
