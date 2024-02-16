package com.app.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class User extends BaseEntity{
	@Column(length = 20,nullable = false)
	private String userName;	
	@Column(length = 20,nullable = false)
	private String s_d_w;
	@Column(length=30,nullable = false)
	private String email;
	@Column(length=30,nullable = false)
	private String password;
	@Column(length = 20,nullable = false)
	private String phoneNo;
	@Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20) default 'APPLICANT'")
	private Role role;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(nullable = false)
	private LocalDate birthDate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="permant_address")
	private Address permanentAddress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="coressp_add")
	private Address correspondAdd;
	

	@Transient
	@OneToOne
	@JoinColumn(name="exam_appl_id")
	private examApplication examApp;
	@Transient
	@OneToMany(mappedBy = "user")
	private Set<VehicleRegistration> vehReg = new HashSet<VehicleRegistration>();
	@Transient
	@OneToMany(mappedBy = "user")
	private Set<Fine> fine= new HashSet<Fine>();
	@Transient
	@OneToMany(mappedBy = "user")
	private Set<License> license = new HashSet<License>();
	@Transient
	@OneToMany(mappedBy = "user")
	private Set<LearningLicenseRegister> learnLicReg = new HashSet<LearningLicenseRegister>();
	
	
	public User(String userName, String s_d_w, String email, String password, String phoneNo, Role role, Gender gender,
			LocalDate birthDate) {
		this.userName = userName;
		this.s_d_w = s_d_w;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.role = role;
		this.gender = gender;
		this.birthDate = birthDate;
		this.permanentAddress = permanentAddress;
		this.correspondAdd = correspondAdd;
	}
	
	
}


