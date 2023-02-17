package com.hostmdy.lawfirm.domain;

import java.time.LocalDate;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Description must be filled in the contract")
	private String conDescription;

	//one contract has one case (one case is created for one contract)
	private LocalDate contractDate;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="appointment_id",nullable = true)
	@JsonIgnore
	private Appointment appointment;
	
	//one contract has one case (want case id in contract table)
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "case_id",nullable = true)
	@JsonIgnore
	private Cases cases;
	
	
  

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "appointment_id")
//	@JsonIgnore
//	private Appointment appointment;
	
	
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "appointment_id")
//	private Appointment appointment;
	

//	
//	@OneToOne()
//	@JsonIgnore
//	private PaymentForm paymentForm;
//
//	@PrePersist
//	void OnCreate() {
//		this.contractDate = LocalDate.now();
//	}
//
//	@PreUpdate
//	void OnUpdate() {
//		this.contractDate = LocalDate.now();
//
//	}

}