package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="licenseDetails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class License extends BaseEntity{
@Column(length = 100)
private String LicenseHolder;
@Column(length = 20, unique = true)
private String licenseNo;
@Column(length=30)
private String licenseType;
@Column(length=30)
private String vehicleType;
@Column(length=30)
private String examStatus;
@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
private Timestamp dateOfIssue=Timestamp.valueOf(LocalDateTime.now());
@Column()
private Timestamp dateOfApply;
@Column(columnDefinition = "varchar(20) default 'NO'")
private String approve;

@Column(columnDefinition = "varchar(20) default 'NO'")
private String RenewalApprove;



@ManyToOne
@JoinColumn(name="user_id")
private User user;

}

