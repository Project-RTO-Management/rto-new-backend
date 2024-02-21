package com.app.dto;
import java.security.Timestamp;

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

public class PermanentLicenseDTO {
	@JsonProperty(access=Access.READ_ONLY)
	private Long id;
	
	@NotNull
	private String learningLicNo;
//	@NotNull
//	private String resultStatus;
	
	   @Hidden
	   @JsonFormat(pattern = "yyyy-MM-dd",timezone = "UTC")
		  private Timestamp dateOfAppl;
		 
}
