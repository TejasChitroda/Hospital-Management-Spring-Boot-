package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AppointmentEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {

}
