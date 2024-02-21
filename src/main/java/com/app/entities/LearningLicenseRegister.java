package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.app.dto.ResultDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LearningLicenseRegister extends BaseEntity{
	@Column(length = 12, nullable = false,unique = true)
	@Min(value = 000000000001L, message = "Adharcard number must be equal to 12")
	@Max(value = 999999999999L, message = "Adharcard number must be equal to 12")
	private Long adharcardNumber;	
	@Column(nullable = false)
	@Min(value = 18)
	@Max(value = 60)
	private int age;
	@Column(length = 50)
	private String birthPlace;
	@Column(length = 50)
	private String education;
	@Column(length = 150)
	private String birthMark;
	@Column(length=30,nullable = false)
	private String vehicleType;
	@Column(length=50,nullable = false)
	private String rtoLocation;
	@Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp dateOfAppl=Timestamp.valueOf(LocalDateTime.now());
	@Column(length = 50,unique = true)
	private String learningLicenseNo;
	@Column(length = 20)
	private String result;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;

}
