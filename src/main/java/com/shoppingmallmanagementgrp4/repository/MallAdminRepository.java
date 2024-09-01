//package com.shoppingmallmanagement.malladmin;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface MallAdminRepository extends JpaRepository<MallAdmin, Integer> {
//
//}
//

package com.shoppingmallmanagementgrp4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingmallmanagementgrp4.entities.MallAdmin;

@Repository
public interface MallAdminRepository extends JpaRepository<MallAdmin, Integer> {
    // Custom query methods can be added here if needed
}
