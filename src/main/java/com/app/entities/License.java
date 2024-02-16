package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Column(length = 20, unique = true, nullable = false)
private String licenseNo;
@Column(length=30, nullable = false)
private String licenseType;
@Column(length=30, nullable = false)
private String vehicleType;
@Column(nullable = false)
private LocalDate dateOfIssue;
@Column(nullable = false)
private LocalDate validTill;

@ManyToOne
@JoinColumn(name="user_id",nullable = false)
private User user;

}

