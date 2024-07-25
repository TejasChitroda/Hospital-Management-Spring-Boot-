package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "package")
public class PackageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer packageID;
	private String name;
	private Integer amount;
	private String rateType;
	private String packageType;

	// one to many
	@ManyToOne
	@JoinColumn(name = "rateListId")
	RateListEntity rateList;

	@ManyToMany
	@JoinTable(name = "packages_items", joinColumns = @JoinColumn(name = "packageId"), inverseJoinColumns = @JoinColumn(name = "itemId"))
	List<ItemEntity> items;

	
	
	public RateListEntity getRateList() {
		return rateList;
	}

	public void setRateList(RateListEntity rateList) {
		this.rateList = rateList;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public Integer getPackageID() {
		return packageID;
	}

	public void setPackageID(Integer packageID) {
		this.packageID = packageID;
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

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

}
