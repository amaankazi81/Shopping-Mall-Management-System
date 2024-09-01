package com.shoppingmallmanagementgrp4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmallmanagementgrp4.entities.MallAdmin;
import com.shoppingmallmanagementgrp4.repository.MallAdminRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MallAdminService {

    @Autowired
    private MallAdminRepository mallAdminRepository;

    public List<MallAdmin> getAllMallAdmins() {
        return mallAdminRepository.findAll();
    }

    public Optional<MallAdmin> getMallAdminById(Integer id) {
        return mallAdminRepository.findById(id);
    }

    public MallAdmin createMallAdmin(MallAdmin mallAdmin) {
        return mallAdminRepository.save(mallAdmin);
    }

    public MallAdmin updateMallAdmin(Integer id, MallAdmin mallAdmin) {
        if (mallAdminRepository.existsById(id)) {
            mallAdmin.setId(id);
            return mallAdminRepository.save(mallAdmin);
        } else {
            return null; // or throw an exception if you prefer
        }
    }

    public void deleteMallAdmin(Integer id) {
        mallAdminRepository.deleteById(id);
    }
}
