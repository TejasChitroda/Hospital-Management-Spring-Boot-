package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.RateTypeEntity;

public interface RateTypeRepository extends JpaRepository<RateTypeEntity, Integer> {

}
