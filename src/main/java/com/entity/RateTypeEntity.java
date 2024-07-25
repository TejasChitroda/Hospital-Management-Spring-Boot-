package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rateType")
public class RateTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rateTypeId;
	private String rateType;
	
	public Integer getRateTypeId() {
		return rateTypeId;
	}
	public void setRateTypeId(Integer rateTypeId) {
		this.rateTypeId = rateTypeId;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	
	
}
