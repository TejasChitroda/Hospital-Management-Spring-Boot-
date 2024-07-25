package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class patientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	private Integer MRDNO;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String gender;
    private String maritalStatus;
    private String address;
    private String referredBy;
    private String country;
    private String state;
    private String city;
    private Integer pincode;
    private Integer rateList;
    private String eyeCard;
    private Integer alternatievNo;
    private String email;
    private String occupation;
    private String diseases;
    private String bloodGroup;
    private String registrationType;
    
    
    @ManyToOne
    @JoinColumn(name = "roleId" , referencedColumnName = "roleId")
    private RoleEntity role;
    
    
    
	public RoleEntity getRoleId() {
		return role;
	}
	public void setRoleId(RoleEntity roleId) {
		this.role = roleId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getMRDNO() {
		return MRDNO;
	}
	public void setMRDNO(Integer mRDNO) {
		this.MRDNO = mRDNO;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReferredBy() {
		return referredBy;
	}
	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Integer getRateList() {
		return rateList;
	}
	public void setRateList(Integer rateList) {
		this.rateList = rateList;
	}
	public String getEyeCard() {
		return eyeCard;
	}
	public void setEyeCard(String eyeCard) {
		this.eyeCard = eyeCard;
	}
	public Integer getAlternatievNo() {
		return alternatievNo;
	}
	public void setAlternatievNo(Integer alternatievNo) {
		this.alternatievNo = alternatievNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getDiseases() {
		return diseases;
	}
	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getRegistrationType() {
		return registrationType;
	}
	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}
	
}
