package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="vehicle_registration")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleRegistration extends BaseEntity{
	@Column(length = 20, unique = true)
	private String registrationNo;
	@Column(length=30, nullable = false)
	private String vehicleType;
	
	@Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp dateOfAppl=Timestamp.valueOf(LocalDateTime.now());
	
	@Column(nullable = false)
	private LocalDate purchaseDate;
	
	@Column(length=50,nullable = false)
	private String VehicalCompany;
	
	@Column(length=50,unique = true)
	private String numberPlate;
	
	@Column(length=50,nullable = false)
	private String VehicalModel;
	
	@Column(length = 20, unique = true,name="new_registration_no")
	private String newRegistrationNo;

	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
//	public void setUser(Object attribute) {
//		this.user=(User) attribute;
//		
//	}
	
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setDateOfAppl(Timestamp dateOfAppl) {
		this.dateOfAppl = dateOfAppl;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public void setVehicalCompany(String vehicalCompany) {
		VehicalCompany = vehicalCompany;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public void setVehicalModel(String vehicalModel) {
		VehicalModel = vehicalModel;
	}
	public void setNewRegistrationNo(String newRegistrationNo) {
		System.out.println("inside setNewRegistrationNo");
		this.newRegistrationNo = newRegistrationNo;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
