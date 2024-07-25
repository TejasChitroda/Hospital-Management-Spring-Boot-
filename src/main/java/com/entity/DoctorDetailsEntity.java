package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DoctorDetails")
public class DoctorDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorDetailsId;
	private String firstName;	
	private String lastName;	
	private String doctorTitleName;	
	private String qualification;	
	private String specialization;	
	private String email;	
	private String password;	
	private Long contactNum;	
	private String gender;	
	private boolean activeInd;
	private String JoiningDate;	
	
	@ManyToOne
	@JoinColumn(name="serviceTypeId")
	private ServiceTypeEntity serviceType;

	public Integer getDoctorDetailsId() {
		return doctorDetailsId;
	}

	public void setDoctorDetailsId(Integer doctorDetailsId) {
		this.doctorDetailsId = doctorDetailsId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDoctorTitleName() {
		return doctorTitleName;
	}

	public void setDoctorTitleName(String doctorTitleName) {
		this.doctorTitleName = doctorTitleName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContactNum() {
		return contactNum;
	}

	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isActiveInd() {
		return activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}

	public String getJoiningDate() {
		return JoiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		JoiningDate = joiningDate;
	}

	public ServiceTypeEntity getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceTypeEntity serviceType) {
		this.serviceType = serviceType;
	}
	
	

}
