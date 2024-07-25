package com.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Item")
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
	private String materialGroupName;
    private String materialName;
    private String itemCode;
    private String itemName;
    private String alternateName;
    private String shortName;
    private Integer gstRate;
    private String hsnCode;
    private Integer price;
    
    
    
    @ManyToOne
	@JoinColumn(name="materialId")
	MaterialEntity material;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "items")
	List<PackageEntity> packages;
    
	
	
	public MaterialEntity getMaterial() {
		return material;
	}
	public void setMaterial(MaterialEntity material) {
		this.material = material;
	}
	public List<PackageEntity> getPackages() {
		return packages;
	}
	public void setPackages(List<PackageEntity> packages) {
		this.packages = packages;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getMaterialGroupName() {
		return materialGroupName;
	}
	public void setMaterialGroupName(String materialGroupName) {
		this.materialGroupName = materialGroupName;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getAlternateName() {
		return alternateName;
	}
	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Integer getGstRate() {
		return gstRate;
	}
	public void setGstRate(Integer gstRate) {
		this.gstRate = gstRate;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
    
    
    
}
