package com.greatlearning.H2SecureEmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.H2SecureEmployeeManagement.model.Role;

// JPA Repository to store Role database
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
