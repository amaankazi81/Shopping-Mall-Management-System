//package com.shoppingmallmanagement.malladmin;
//
//public class MallAdminController {
//
//}
package com.shoppingmallmanagementgrp4.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmallmanagementgrp4.entities.MallAdmin;
import com.shoppingmallmanagementgrp4.service.MallAdminService;

import jakarta.transaction.Transactional;

@RestController
@Transactional
@RequestMapping("/mall-admins")
public class MallAdminController {

    @Autowired
    private MallAdminService mallAdminService;

    @GetMapping
    public List<MallAdmin> getAllMallAdmins() {
        return mallAdminService.getAllMallAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MallAdmin> getMallAdminById(@PathVariable Integer id) {
        Optional<MallAdmin> mallAdmin = mallAdminService.getMallAdminById(id);
        return mallAdmin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MallAdmin createMallAdmin(@RequestBody MallAdmin mallAdmin) {
        return mallAdminService.createMallAdmin(mallAdmin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MallAdmin> updateMallAdmin(@PathVariable Integer id, @RequestBody MallAdmin mallAdmin) {
        MallAdmin updatedMallAdmin = mallAdminService.updateMallAdmin(id, mallAdmin);
        if (updatedMallAdmin != null) {
            return ResponseEntity.ok(updatedMallAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMallAdmin(@PathVariable Integer id) {
    	Optional<MallAdmin> existingAdmin = mallAdminService.getMallAdminById(id);
    	
    	if(existingAdmin.isPresent()) {
    		mallAdminService.deleteMallAdmin(id);
    		return ResponseEntity.ok().build();
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
}
