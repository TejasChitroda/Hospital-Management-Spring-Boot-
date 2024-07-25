package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.MaterialEntity;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Integer> {

}
