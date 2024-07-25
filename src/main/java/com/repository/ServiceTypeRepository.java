package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ServiceTypeEntity;

public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity, Integer> {

}
