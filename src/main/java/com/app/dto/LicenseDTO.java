package com.app.dto;

import java.security.Timestamp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
public class LicenseDTO {
	@JsonProperty(access=Access.READ_ONLY)
	private Long id;
	  @Hidden
	  private String learningLicenseNo;
	  
	//  @Size(min = 18,max = 60, message = "Age for application must be between 18 to 60")
	  @Min(value = 18,message = "Age must be >18")
	  @Max(value = 60, message = "Age must be <60")
	  private int age;
	  
	  //	@Size(max = 12,min = 12, message = "Adhar no. must be 12 digit")
		@Min(value = 000000000001L,message = "Adhar no. must be 12 digit")
		@Max(value = 999999999999L, message = "Adhar no. must be 12 digit")
		@NotNull
	    private Long adharcardNumber;	
		
		private String vehicleType;
		private String rtoLocation;
		private String birthPlace;
		private String birthMark;
		private String education;
	
	   @Hidden
	   @JsonFormat(pattern = "yyyy-MM-dd",timezone = "UTC")
		  private Timestamp dateOfAppl;
		 
		
//	@Hidden
//	 private User user;
}
