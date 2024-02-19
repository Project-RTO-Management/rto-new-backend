package com.app.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Past;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
//@ToString
@Component
public class licenseAdminDTO {
	@JsonProperty(access = Access.READ_ONLY) // used during serialization ->skip it in deserial
	private Long id;
	private String LicenseHolder;
	private String licenseNo;
	private String licenseType;
	private String vehicleType;
	private String examstatus;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "UTC")
	private Timestamp dateOfIssue=Timestamp.valueOf(LocalDateTime.now());
	@Past(message = "Must be Past Date")
	private Timestamp dateOfApply;
	private String approve;

}
