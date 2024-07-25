package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.patientEntity;

public interface patientRepository extends JpaRepository<patientEntity, Integer> {
	patientEntity findByEmail(String email);
}
