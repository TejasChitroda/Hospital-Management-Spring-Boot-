package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RateList")
public class RateListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rateListId;
	private String name;
	private Integer amount;
	
	
	@OneToOne
	@JoinColumn(name = "rateType")
	private RateTypeEntity rateType;
	
	@ManyToOne
	@JoinColumn(name = "departmentId")
	private DepartmentEntity department;

	public Integer getRateListId() {
		return rateListId;
	}

	public void setRateListId(Integer rateListId) {
		this.rateListId = rateListId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public RateTypeEntity getRateType() {
		return rateType;
	}

	public void setRateType(RateTypeEntity rateType) {
		this.rateType = rateType;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	
	
	
	
	
	
}
