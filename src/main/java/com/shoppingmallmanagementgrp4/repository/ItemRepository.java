package com.shoppingmallmanagementgrp4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmallmanagementgrp4.entities.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

}
