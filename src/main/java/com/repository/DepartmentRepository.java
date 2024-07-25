package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

}
