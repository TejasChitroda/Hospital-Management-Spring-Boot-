package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.DoctorDetailsEntity;
import java.util.List;


public interface DoctorDetailsRepository  extends JpaRepository<DoctorDetailsEntity, Integer>{
	
	DoctorDetailsEntity findByEmail(String email);
}
