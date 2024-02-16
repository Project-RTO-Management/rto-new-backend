package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
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
public class PermanentLicenseRegister extends BaseEntity{

	@Column(nullable = false)
	private String learningLicNo;
	@Column(nullable = false)
	private String resultStatus;
	
	@Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp dateOfAppl=Timestamp.valueOf(LocalDateTime.now());
	
	@OneToOne
	@JoinColumn(name="learningLicenseRegister_id")
	private LearningLicenseRegister learn;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
}
