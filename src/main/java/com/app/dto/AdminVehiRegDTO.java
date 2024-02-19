package com.app.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminVehiRegDTO {

	@JsonProperty(access=Access.READ_ONLY)
	private Long id;
	private String registrationNo;
	private String vehicleType;
	private Timestamp dateOfAppl;
	private LocalDate purchaseDate;
	private String VehicalCompany;
	private String numberPlate;
	private String VehicalModel;
	private String newRegistrationNo;
}
