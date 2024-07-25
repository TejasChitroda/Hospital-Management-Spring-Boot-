package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctorDocument")
public class DoctorDocumentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorDocumentId;
	private String doctorDocumentName;
	private String doctorDocumentPath;
	
	@ManyToOne
	@JoinColumn(name="doctorDetailsId")
	DoctorDetailsEntity doctor;

	public Integer getDoctorDocumentId() {
		return doctorDocumentId;
	}

	public void setDoctorDocumentId(Integer doctorDocumentId) {
		this.doctorDocumentId = doctorDocumentId;
	}

	public String getDoctorDocumentName() {
		return doctorDocumentName;
	}

	public void setDoctorDocumentName(String doctorDocumentName) {
		this.doctorDocumentName = doctorDocumentName;
	}

	public String getDoctorDocumentPath() {
		return doctorDocumentPath;
	}

	public void setDoctorDocumentPath(String doctorDocumentPath) {
		this.doctorDocumentPath = doctorDocumentPath;
	}

	public DoctorDetailsEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDetailsEntity doctor) {
		this.doctor = doctor;
	}
	

}
