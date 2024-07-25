package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AppointmentStatusEntity;

public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatusEntity, Integer> {

}
