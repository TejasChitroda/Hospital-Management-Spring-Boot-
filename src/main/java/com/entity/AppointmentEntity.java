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
@Table(name = "Appointment")
public class AppointmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointmentId;
	
	@ManyToOne
	@JoinColumn(name="doctorDetailsId")
	DoctorDetailsEntity doctor;
	
	@OneToOne
	@JoinColumn(name="patientId")
	patientEntity patient;
	
	@ManyToOne
	@JoinColumn(name="rateListId")
	RateListEntity rateList;
	
	private String appointmentDate;
	private String createdDate;
	
	@ManyToOne
	@JoinColumn(name="employeeId")
	EmployeeEntity createdBy;
	
	@ManyToOne
	@JoinColumn(name="apoointmentStatusId")
	AppointmentStatusEntity appointmentStatus;

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public DoctorDetailsEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDetailsEntity doctor) {
		this.doctor = doctor;
	}

	public patientEntity getPatient() {
		return patient;
	}

	public void setPatient(patientEntity patient) {
		this.patient = patient;
	}

	public RateListEntity getRateList() {
		return rateList;
	}

	public void setRateList(RateListEntity rateList) {
		this.rateList = rateList;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public EmployeeEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(EmployeeEntity createdBy) {
		this.createdBy = createdBy;
	}

	public AppointmentStatusEntity getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatusEntity appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	
	
}
