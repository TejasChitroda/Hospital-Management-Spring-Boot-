package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	private String firstName;	
	private String lastName;	
	private String employeeTitleName;	
	private String gender;	
	private String email;	
	private String password;	
	private String dateOfJoining;	
	private String qualification;	
	private String aadharCardPath;	
	private String panCardPath;	
	private String qualificationDocPath;	
	private boolean activeInd;
	private Long contactNum;
	
	@ManyToOne
	@JoinColumn(name="roleId")
	RoleEntity role;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	public String getEmployeeTitleName() {
		return employeeTitleName;
	}

	public void setEmployeeTitleName(String employeeTitleName) {
		this.employeeTitleName = employeeTitleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAadharCardPath() {
		return aadharCardPath;
	}

	public void setAadharCardPath(String aadharCardPath) {
		this.aadharCardPath = aadharCardPath;
	}

	public String getPanCardPath() {
		return panCardPath;
	}

	public void setPanCardPath(String panCardPath) {
		this.panCardPath = panCardPath;
	}

	public String getQualificationDocPath() {
		return qualificationDocPath;
	}

	public void setQualificationDocPath(String qualificationDocPath) {
		this.qualificationDocPath = qualificationDocPath;
	}

	public boolean isActiveInd() {
		return activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}

	public Long getContactNum() {
		return contactNum;
	}

	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
	
}
