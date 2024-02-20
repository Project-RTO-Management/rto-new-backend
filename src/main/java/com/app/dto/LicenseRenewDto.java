package com.app.dto;


import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
@Setter
@AllArgsConstructor

public class LicenseRenewDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	private String learningLicenseNo;

     @Hidden
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private Timestamp newDateOfAppl;

	public Long getId() {
		return id;
	}

	public String getLearningLicenseNo() {
		return learningLicenseNo;
	}

	public Timestamp getNewDateOfAppl() {
		return newDateOfAppl;
	}

     
}


