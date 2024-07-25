package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payment")
public class PaymentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	
	private String transcationRef;
	private String date;
	private Long amount;
	private String remarks;
	private Float discount;
	private String discountRef;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	patientEntity patient;
	
	

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getTranscationRef() {
		return transcationRef;
	}

	public void setTranscationRef(String transcationRef) {
		this.transcationRef = transcationRef;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public String getDiscountRef() {
		return discountRef;
	}

	public void setDiscountRef(String discountRef) {
		this.discountRef = discountRef;
	}

	public patientEntity getPatient() {
		return patient;
	}

	public void setPatient(patientEntity patient) {
		this.patient = patient;
	}
	
	
	
}
