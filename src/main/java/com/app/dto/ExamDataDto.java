package com.app.dto;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.app.entities.Answer;
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
public class ExamDataDto {
	@JsonProperty(access=Access.READ_ONLY)
	private Long id;
	
	private String questions;
	private String optA;
	private String optB;
	private String optC;
	private String optD;
	
	@Hidden
	@JsonProperty(access =Access.WRITE_ONLY)
	private Answer correctAns;
}
