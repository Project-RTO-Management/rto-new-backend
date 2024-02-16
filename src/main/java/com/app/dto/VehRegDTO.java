package com.app.dto;

import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Past;

import org.hibernate.Session;

import com.app.entities.BaseEntity;
import com.app.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

	public class VehRegDTO{
	@JsonProperty(access=Access.READ_ONLY)
	private Long id;
	  @Hidden
		private String registrationNo;
		@Hidden
		private String numberPlate;
		
		private String vehicleType;
		
		
		  @Hidden
		//  @JsonProperty(access=Access.WRITE_ONLY)
		   @JsonFormat(pattern = "yyyy-MM-dd",timezone = "UTC")
		  private Timestamp dateOfAppl;
		 
		 
		
		@Past(message="Purchase date must be in past")
		private LocalDate purchaseDate;
		
		
		private String VehicalCompany;
		

		
		private String VehicalModel;
		
//	@Hidden
//	 private User user;
//		 
	}



