package com.shoppingmallmanagementgrp4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmallmanagementgrp4.entities.ShopOwner;
import com.shoppingmallmanagementgrp4.repository.ShopOwnerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopOwnerService {

	@Autowired
	private ShopOwnerRepository repository;
	
	public List<ShopOwner> listAll(){
		return repository.findAll();
	}
	
	public ShopOwner get(Integer id) {
		return repository.findById(id).get();
	}
	
	public void save(ShopOwner shopowner) {
		repository.save(shopowner);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	
	
	
}
