package com.navaera.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navaera.assignment.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{
	
	}
