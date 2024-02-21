package com.app.dto;


import com.app.entities.Answer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	
	
	@JsonProperty(access =Access.READ_ONLY)
	private Answer correctAns;
}
