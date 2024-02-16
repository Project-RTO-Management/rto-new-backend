package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.entities.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class UserShowDto {
	@JsonProperty(access = Access.READ_ONLY) // used during serialization ->skip it in deserial
	private Long id;	
	private String userName;
	private String s_d_w;
	@Email(message = "invalid email")
	@Size(min = 5, max = 20, message = "invalid email length")
	private String email;
	@JsonProperty(access =Access.WRITE_ONLY )//used during de-ser, not in serial
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid Pattern of password")
	private String password;
	@Past(message = "Must be Past Date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate birthDate;
	private Gender gender;
	@Size(min = 10, max = 10, message = "Invalid Phone length - must be 10 Digit")
	private String phoneNo;
	///private Address permanentAddress;
	private String permanentAddressStreet;
	private String permanentAddressCity;
	private String permanentAddressState;
	private String permanentAddressCountry;
	private String permanentAddressZipCode;
	
	
	//private Address correspondAdd;
	private String correspondAddStreet;
	private String correspondAddCity;
	private String correspondAddState;
	private String correspondAddCountry;
	private String correspondAddZipCode;
}
