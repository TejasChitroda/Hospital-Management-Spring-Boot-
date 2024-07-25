package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.PackageItemEntity;

public interface PackageItemRepository extends JpaRepository<PackageItemEntity, Integer>{

}
