package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.PackageEntity;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer> {

}
