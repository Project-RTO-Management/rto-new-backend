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
@Getter
@Setter
@AllArgsConstructor
public class VehRegRenewDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	private String registrationNo;

	@Hidden
	// @JsonProperty(access=Access.WRITE_ONLY)
	@Column(name="new_registration_no")
	private String newRegistrationNo;

	@Hidden
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private Timestamp newDateOfAppl;

}
