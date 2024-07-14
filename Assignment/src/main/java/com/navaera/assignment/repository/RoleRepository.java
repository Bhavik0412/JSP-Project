package com.navaera.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navaera.assignment.entity.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{

}
