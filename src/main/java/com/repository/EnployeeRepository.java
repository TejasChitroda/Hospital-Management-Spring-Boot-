package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.EmployeeEntity;
import java.util.List;


public interface EnployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	
	EmployeeEntity findByEmail(String email);
	

}
